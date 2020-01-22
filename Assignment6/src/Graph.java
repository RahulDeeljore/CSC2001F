/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the edi*/;
//package Graphs;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.lang.Math;

// Used to signal violations of preconditions for
// various shortest path algorithms.
class GraphException extends RuntimeException
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GraphException( String name )
    {
        super( name );
    }
}

// Represents an edge in the graph.
class Edge
{
    public Vertex     dest;   // Second vertex in Edge
    public double     cost;   // Edge cost
    
    public Edge( Vertex d, double c )
    {
        dest = d;
        cost = c;
    }
}

// Represents an entry in the priority queue for Dijkstra's algorithm.
class Path implements Comparable<Path>
{
    public Vertex     dest;   // w
    public double     cost;   // d(w)
    
    public Path( Vertex d, double c )
    {
        dest = d;
        cost = c;
    }
    
    public int compareTo( Path rhs )
    {
        double otherCost = rhs.cost;
        
        return cost < otherCost ? -1 : cost > otherCost ? 1 : 0;
    }
}

// Represents a vertex in the graph.
class Vertex
{
    public String     name;   // Vertex name
    public List<Edge> adj;    // Adjacent vertices
    public double     dist;   // Cost
    public Vertex     prev;   // Previous vertex on shortest path
    public int        scratch;// Extra variable used in algorithm

    public Vertex( String nm )
      { name = nm; adj = new LinkedList<Edge>( ); reset( ); }

    public void reset( )
    //  { dist = Graph.INFINITY; prev = null; pos = null; scratch = 0; }    
    { dist = Graph.INFINITY; prev = null; scratch = 0; }
      
   // public PairingHeap.Position<Path> pos;  // Used for dijkstra2 (Chapter 23)
}

// Graph class: evaluate shortest paths.
//
// CONSTRUCTION: with no parameters.
//
// ******************PUBLIC OPERATIONS**********************
// void addEdge( String v, String w, double cvw )
//                              --> Add additional edge
// void printPath( String w )   --> Print path after alg is run
// void unweighted( String s )  --> Single-source unweighted
// void dijkstra( String s )    --> Single-source weighted
// void negative( String s )    --> Single-source negative weighted
// void acyclic( String s )     --> Single-source acyclic
// ******************ERRORS*********************************
// Some error checking is performed to make sure graph is ok,
// and to make sure graph satisfies properties needed by each
// algorithm.  Exceptions are thrown if errors are detected.

public class Graph
{
    public static Graph g = new Graph();
    public static Graph h = new Graph();
    public static final double INFINITY = Double.MAX_VALUE;
    public Map<String,Vertex> vertexMap = new HashMap<String,Vertex>( );
    public static double[] db = new double[10];
    public static double small = 100;

    /**
     * Add a new edge to the graph.
     */
    public void addEdge( String sourceName, String destName, double cost )
    {
        Vertex v = getVertex( sourceName );
        Vertex w = getVertex( destName );
        v.adj.add( new Edge( w, cost ) );
    }

    /**
     * Driver routine to handle unreachables and print total cost.
     * It calls recursive routine to print shortest path to
     * destNode after a shortest path algorithm has run.
     */
    public double printPath( String destName )
    {
        Vertex w = vertexMap.get( destName );
        if( w == null )
            throw new NoSuchElementException( "Destination vertex not found" );
        else if( w.dist == INFINITY )
            System.out.println( destName + " cannot be helped" );
        else
        {
         return(w.dist);
            //System.out.print( "(Cost is: " + w.dist + ") " );
            //printPath( w );
            //System.out.println( );
        }
    return 0;
    }


public void printpath( String destName )
    {
        Vertex w = vertexMap.get( destName );
        if( w == null )
            throw new NoSuchElementException( "Destination vertex not found" );
        else if( w.dist == INFINITY )
            System.out.println( destName + " cannot be helped" );
        else
        {
         //return(w.dist);
            //System.out.print( "(Cost is: " + w.dist + ") " );
            printpath( w );
            //System.out.println( );
        }
    //return 0;
    }

   //added method
   public double getcost(String start)
{
Vertex w = vertexMap.get(start);
return (w.dist);
}

    /**
     * If vertexName is not present, add it to vertexMap.
     * In either case, return the Vertex.
     */
    private Vertex getVertex( String vertexName )
    {
        Vertex v = vertexMap.get( vertexName );
        if( v == null )
        {
            v = new Vertex( vertexName );
            vertexMap.put( vertexName, v );
        }
        return v;
    }

    /**
     * Recursive routine to print shortest path to dest
     * after running shortest path algorithm. The path
     * is known to exist.
     */
    private void printpath( Vertex dest )
    {
        if( dest.prev != null )
        {
            printpath( dest.prev );
            System.out.print( " " );
        }
        System.out.print( dest.name );
    }
    
    /**
     * Initializes the vertex output info prior to running
     * any shortest path algorithm.
     */
    private void clearAll( )
    {
        for( Vertex v : vertexMap.values( ) )
            v.reset( );
    }

    /**
     * Single-source unweighted shortest-path algorithm.
     */
    public void unweighted( String startName )
    {
        clearAll( ); 

        Vertex start = vertexMap.get( startName );
        if( start == null )
            throw new NoSuchElementException( "Start vertex not found" );

        Queue<Vertex> q = new LinkedList<Vertex>( );
        q.add( start ); start.dist = 0;

        while( !q.isEmpty( ) )
        {
            Vertex v = q.remove( );

            for( Edge e : v.adj )
            {
                Vertex w = e.dest;
                if( w.dist == INFINITY )
                {
                    w.dist = v.dist + 1;
                    w.prev = v;
                    q.add( w );
                }
            }
        }
    }

    /**
     * Single-source weighted shortest-path algorithm. (Dijkstra) 
     * using priority queues based on the binary heap
     */
    public void dijkstra( String startName )
    {
        PriorityQueue<Path> pq = new PriorityQueue<Path>( );

        Vertex start = vertexMap.get( startName );
        if( start == null )
            throw new NoSuchElementException( "Start vertex not found" );

        clearAll( );
        pq.add( new Path( start, 0 ) ); start.dist = 0;
        
        int nodesSeen = 0;
        while( !pq.isEmpty( ) && nodesSeen < vertexMap.size( ) )
        {
            Path vrec = pq.remove( );
            Vertex v = vrec.dest;
            if( v.scratch != 0 )  // already processed v
                continue;
                
            v.scratch = 1;
            nodesSeen++;

            for( Edge e : v.adj )
            {
                //double small = 100;
                Vertex w = e.dest;
                double cvw = e.cost;
                
                if( cvw < 0 )
                    throw new GraphException( "Graph has negative edges" );
                    
                if( w.dist > v.dist + cvw )
                {
                    w.dist = v.dist +cvw;
                    w.prev = v;
                    pq.add( new Path( w, w.dist ) );
                   //System.out.println(w.dist);
                }
                else if(w.dist == v.dist +cvw)
               {small = w.dist;}
            
            }
            //System.out.println(small);
          //return(w.dist);
        }
//return 0;
    }

    /**
     * Single-source negative-weighted shortest-path algorithm.
     * Bellman-Ford Algorithm
     */
    public void negative( String startName )
    {
        clearAll( ); 

        Vertex start = vertexMap.get( startName );
        if( start == null )
            throw new NoSuchElementException( "Start vertex not found" );

        Queue<Vertex> q = new LinkedList<Vertex>( );
        q.add( start ); start.dist = 0; start.scratch++;

        while( !q.isEmpty( ) )
        {
            Vertex v = q.remove( );
            if( v.scratch++ > 2 * vertexMap.size( ) )
                throw new GraphException( "Negative cycle detected" );

            for( Edge e : v.adj )
            {
                Vertex w = e.dest;
                double cvw = e.cost;
                
                if( w.dist > v.dist + cvw )
                {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                      // Enqueue only if not already on the queue
                    if( w.scratch++ % 2 == 0 )
                        q.add( w );
                    else
                        w.scratch--;  // undo the enqueue increment    
                }
            }
        }
    }

    /**
     * Single-source negative-weighted acyclic-graph shortest-path algorithm.
     */
    public void acyclic( String startName )
    {
        Vertex start = vertexMap.get( startName );
        if( start == null )
            throw new NoSuchElementException( "Start vertex not found" );

        clearAll( ); 
        Queue<Vertex> q = new LinkedList<Vertex>( );
        start.dist = 0;
        
          // Compute the indegrees
		Collection<Vertex> vertexSet = vertexMap.values( );
        for( Vertex v : vertexSet )
            for( Edge e : v.adj )
                e.dest.scratch++;
            
          // Enqueue vertices of indegree zero
        for( Vertex v : vertexSet )
            if( v.scratch == 0 )
                q.add( v );
       
        int iterations;
        for( iterations = 0; !q.isEmpty( ); iterations++ )
        {
            Vertex v = q.remove( );

            for( Edge e : v.adj )
            {
                Vertex w = e.dest;
                double cvw = e.cost;
                
                if( --w.scratch == 0 )
                    q.add( w );
                
                if( v.dist == INFINITY )
                    continue;    
                
                if( w.dist > v.dist + cvw )
                {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                }
            }
        }
        
        if( iterations != vertexMap.size( ) )
            throw new GraphException( "Graph has a cycle!" );
    }

    /**
     * Process a request; return false if end of file.
     */
    public static boolean processRequest( Scanner in, Graph g )
    {
        try
        {
            System.out.print( "Enter start node:" );
            String startName = in.nextLine( );

            System.out.print( "Enter destination node:" );
            String destName = in.nextLine( );

            System.out.print( "Enter algorithm (u, d, n, a ): " );
            String alg = in.nextLine( );
            
            if( alg.equals( "u" ) )
                g.unweighted( startName );
            else if( alg.equals( "d" ) )    
            {
                g.dijkstra( startName );
                //g.printPath( destName );
                //System.out.println(g.getcost(startName));
            }
            else if( alg.equals( "n" ) )
                g.negative( startName );
            else if( alg.equals( "a" ) )
                g.acyclic( startName );
                    
            g.printPath( destName );
        }
        catch( NoSuchElementException e )
          { return false; }
        catch( GraphException e )
          { System.err.println( e ); }
        return true;
    }

    /**
     * A main routine that:
     * 1. Reads a file containing edges (supplied as a command-line parameter);
     * 2. Forms the graph;
     * 3. Repeatedly prompts for two vertices and
     *    runs the shortest path algorithm.
     * The data file is a sequence of lines of the format
     *    source destination cost
     */
    public static void main( String [ ] args )
    {
       
        query();
        
        
  }






public static void query()
{

Scanner k = new Scanner(System.in);
//System.out.println("Enter the number of nodes");
String nodesStr = k.nextLine();
//String zero ="0";
int nodes = Integer.parseInt(nodesStr);
//int i = 0;
//System.out.println("Enter node number 1");
String dest; //= k.nextLine();
//rough(dest);
int i =0;
String zero ="0";
String one = "1";
while(i < nodes)
{
//System.out.println("Enter node number "+(i+1));
dest = k.nextLine();
rough(dest);
i++;
//g.dijkstra(zero);
//g.printPath(one);
}
String numberofShops = k.nextLine();
String shopnodes = k.nextLine();
String numberofclients = k.nextLine();
String clientnodes = k.nextLine();
if( Integer.parseInt(numberofShops) == 1 && Integer.parseInt(numberofclients) == 1 && nodes <=1)
{
System.out.println("client "+clientnodes);
System.out.println("cannot be helped");
}
else
{
//String[] c = shopnodes.split(" ");
//for (int l =0;l<numberofShops;l++)
//{
String[] shopnodesarr = shopnodes.split(" ");
String[] clientnodesarr = clientnodes.split(" ");
//}
//g.dijkstra(shopnodesarr[1]);
//System.out.println(g.printPath(clientnodesarr[1]));
for(int m =0;m<clientnodesarr.length;m++)
{
double min = 1000;
double mini = 1000;
int ncount = -1;
int ncountx = -1;
String[] arr = new String[10];
int arrcount = -1;
int counti = -1;
String[] arra = new String[10];
int arcount = -1;
for (int n = 0;n<shopnodesarr.length;n++)
{
h.dijkstra(clientnodesarr[m]);
if(h.printPath(shopnodesarr[n]) < mini)
{
//System.out.println("HEEERE" + h.printPath(shopnodesarr[n]));
mini = h.printPath(shopnodesarr[n]);
counti = n;
}
else if(h.printPath(shopnodesarr[n]) == mini)
{
//System.out.println("HERE");
//System.out.println(shopnodesarr[n]);
arcount = arcount +1;
arra[arcount] = shopnodesarr[n];
}
g.dijkstra(shopnodesarr[n]);
if(g.printPath(clientnodesarr[m]) < min)
{
min = g.printPath(clientnodesarr[m]);
ncountx = n;
//System.out.println(min);
}
else if(g.printPath(clientnodesarr[m]) == min)
{
//System.out.println("weee");
arrcount = arrcount + 1;
//System.out.println("arrcount" + arrcount);
arr[arrcount] = shopnodesarr[n];
//System.out.println(arr[0]);
}
ncount = ncount + 1;
} 
/*g.dijkstra("1");
System.out.println(g.printPath("0"));
g.dijkstra("1");
System.out.println(g.printPath("2"));
g.dijkstra("2");
System.out.println(g.printPath("0"));*/

System.out.println("client " + clientnodesarr[m]);
System.out.println("taxi "+ shopnodesarr[ncountx]);
g.dijkstra(shopnodesarr[ncountx]);
g.printpath(clientnodesarr[m]);
System.out.println();
for(int z= 0;z<arrcount+1;z++)
{
//System.out.println("HELLLO" +arr[z]);
//System.out.println("HEEEAAR"+shopnodesarr[ncountx]);
if(arr[z].equals(shopnodesarr[ncountx+1]))
{
System.out.println("taxi "+ arr[z]);
g.dijkstra(arr[z]);
g.printpath(clientnodesarr[m]);
System.out.println();
}
}

System.out.println("shop " + shopnodesarr[counti]);
//for (int u =0;u<arcount;u++)
//{
/*if (arra[u].equals(shopnodesarr[counti]))
{
System.out.print("Multiple solutions cost ");
h.dijkstra(clientnodesarr[m]);
h.printpath(shopnodesarr[counti]);
System.out.println();
}
else
{*/
h.dijkstra(clientnodesarr[m]);
if(small == h.printPath(shopnodesarr[counti]))
{
System.out.println("multiple solutions cost "+ Math.round(small));
}
else
{
h.printpath(shopnodesarr[counti]);
System.out.println();
}
//System.out.println();
//}

//}
//String zero ="0";
//g.dijkstra(shopnodes);
//System.out.println("thing is");
//System.out.println(g.printPath(clientnodes));
//System.out.println( g.vertexMap.size( ));
//}
}
//}
}
}















//System.out.println("BIATCH");

/*for(int ma =0;ma<clientnodesarr.length;ma++)
{
double mini = 1000;
int ncounts = -1;
for (int na = 0;na<shopnodesarr.length;na++)
{
g.dijkstra(clientnodesarr[ma]);
if(g.printPath(shopnodesarr[na]) < mini)
mini = g.printPath(shopnodesarr[na]);
ncounts = na;
} 

//System.out.println(shopnodesarr[ncounts]);
//System.out.println("Shop" + shopnodesarr[ncounts]);
//g.dijkstra(clientnodesarr[ma]);
//g.printpath(shopnodesarr[ncounts]); 
}
//String zero ="0";
//g.dijkstra(shopnodes);
//System.out.println("thing is");
//System.out.println(g.printPath(clientnodes));
//System.out.println( g.vertexMap.size( ));

}*/

public static void rough(String a)
{

String[] b = a.split(" ");
//System.out.println(Arrays.toString(b));
for(int j =1;j<b.length;j=j+2)
{
g.addEdge(b[0],b[j],Double.parseDouble(b[j+1]));
h.addEdge(b[0],b[j],Double.parseDouble(b[j+1]));

}

}

}
