/**
* This class will create a BinarySearchTree and put all the Dam objects in it.
*/
public class DamBSTApp
{

/**
* The main method will invoke the printall() method if no argument is given
* It will invoke the printDam method if an argument is given
*/
public static void main(String[] args)
{
if (args.length >0)
printDam(args[0]);
else
printall();
}

/**This method will create a Dam BinarySearchTree from  a Dam Array
* @return the BinarySearchTree created
*/
public static BinarySearchTree makeBST()
{
BinarySearchTree<Dam> Bst = new BinarySearchTree<Dam>();
Dam[] d = new DamArrayApp().makearray();
for ( Dam i: d)
{
Bst.insert(i);
}
return (Bst);
}

/** Print all Dam objects from Dam BinarySearchTree  
*
*/
public static void printall()
{
makeBST().preOrder();
}

/** print Dam object with name query
*   If no Dam found, tell user so.
*   Print the number of comparisons made before finding the Dam
*/
public static void printDam(String query)
{
Dam d1 = new Dam(query,"","");
if(makeBST().find(d1) == null)
{
System.out.println("Dam not found");
}
else
{
System.out.println(makeBST().find(d1));
System.out.println(makeBST().returnCount());
}
}

}
