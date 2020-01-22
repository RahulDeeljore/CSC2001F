/** This class will create an AVLTree and store the Dam objects in it
*  The main method will either print all the Dam objects or a particular Dam depending on the arguments given
*/

public class DamAVLApp
{

/** Print all Dam objects in AVLTree if no argument is given or print Dam if argument is given
*/
public static void main (String[] args)
{
if (args.length >0)
printDam(args[0]);
else
printall();
}

/** Create an AVLTree and Store the Dam objects in it
* Record and store the value of insertion comparisons as instance of particular Dam object
*/
public static AVLTree makeAVL()
{
AVLTree<Dam> avl = new AVLTree<Dam>();
Dam[] dams = new DamArrayApp().makearray();
for (Dam i :dams)
{
avl.insert(i);
i.insertcount = AVLTree.insertCount;
AVLTree.insertCount = 0;
}
return(avl);
}


/** Print all Dams in AVLTree
*/
public static void printall()
{
makeAVL().treeOrder();
}

/** Print Dam object with name "query" and print number of comparisons before finding said Dam
* Inform user if no Dam matching the query has been found
*/
public static void printDam(String query)
{
Dam d1 = new Dam(query,"","",0);
if(makeAVL().find(d1) == null)
{
System.out.println("Dam not found");
}
else
{
System.out.println(makeAVL().find(d1));
System.out.println("Search Counts:" + makeAVL().returnfindCount());
}
}

}
