import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/** This is the HashTable class 
* This class contains all the methods needed for the Hash Table to work for the assignment
*/
public class HashTable
{
public static String filename = "A3.csv"; // File that contains the data
private static int size = 211; // Size of Hash Table used
private static LinkedList<person>[] table = new LinkedList[211]; // Create the array of linked lists
private static ArrayList<Integer> comparelist = new ArrayList<Integer>(); // Arraylist that contains the value of comparisons when finding each ID
private static double[] averagec = new double[150];

/** This is the Hash function used
* The value of the ID % the size of the Hash table
*/
public static int hash(long val)
{
long hashval = val % size;
return (int)hashval;
}

/** This method is used to insert a person object in the Hashtable.
* The ID of the person is used to find the index.
* If the obtained index is empty, a new linked list is created and the person is added.
* If the index is not empty, the person is just added in the list.
*/
public static void insert(long val,person a)
{
int index = hash(val);
if (table[index] == null)
{
table[index] = new LinkedList<person>();
table[index].add(a);
}
else
{table[index].add(a);
}
}

/** This method is used to find a person in the Hash table using its ID number
* If the index found is empty, that means the person is not in the list and the user is told so.
* If the index is not empty, the person is searched across the linked list with each comparisons counted 
* If the person is found, the name is printed out
* If the person is not found, that means the person is not on the list and the user is told so.
*/
public static void find(long ID)
{
person temp = new person("",ID);
int index1 = hash(ID);
if (table[index1] == null)
{
System.out.println("This ID number does not match any name1");
}
else if(table[index1] != null)
{
int compare = 0;

for (int i=0;i<table[index1].size();i++)
{
  if(table[index1].get(i).equals(temp))
{
compare = compare + 1;
System.out.println(table[index1].get(i).getName()+" is on the list");
comparelist.add(compare);
}
  else
compare = compare + 1;
}
}
else
{
System.out.println("This ID number does not match any name2");
System.out.println(table[index1]);
}
}


/** This method is used to create an array of person objects using the data in the csv file
* The data is split and the data obtained is used to create a person object
*/
public static person[] makedata()
{
File file = new File(filename);
try
{
Scanner read = new Scanner(file);
int count =-1;
person[] allpersons = new person[150];

while (read.hasNext())
{
count = count + 1;
String data = read.nextLine();
String[] arr = data.split(",");
long ID = Long.parseLong(arr[0]);
allpersons[count] = new person(arr[1].trim(),ID);
}
return allpersons;
}
catch (FileNotFoundException e)
{
e.printStackTrace();
}
return null;
}

/** This method is used to insert every person object made from the list into the hash table*/
public static void insertP()
{
for (person p : makedata())
{
insert(p.getID(),p);
}
}


/** This method is used to test the hash table
* Every element of the hash table is searched using the find method of the class
* The number of comparisons and average number of comparisons is also shown after each search
*/
public static void trials()
{
int z = 1;
double total = 0;
makedata();
insertP();
for (int x =0;x < 150;x++)
{
System.out.println();
find(makedata()[x].getID());
System.out.println("Number of comparisons made before finding element was: " +comparelist.get(x));
System.out.println(makedata()[x].getID());
total = total + comparelist.get(x);
System.out.println("The current average comparisons is: "+total/z);
averagec[x] = total/z;
z++;
}
System.out.println();
System.out.println("The list of averages is:");
for(double t:averagec)
{
System.out.printf("%.3f%n",t);
}
}

/**Main method used to do some testing
*/
public static void main(String[] args)
{
makedata();
insertP();
Scanner k = new Scanner (System.in);
long s = k.nextLong();
find(s);
find(1837938960830l);
//trials();
}
}