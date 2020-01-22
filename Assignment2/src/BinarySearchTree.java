// Hussein's Binary Search Tree
// 27 March 2017
// Hussein Suleman

/** BinarySearchTree uses BinaryTree class to implement a Binary Search Tree
* The instance variable "count" counts the number of comparisons done when finding a particular node
* The instance variable "insertCount" counts the number of comparisons done when inserting a particular node in the BinarySearchTree
*/
 
public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
public static int count =0;
public static int InsertCount = 0;


/** Insert the data as the root if tree is empty
* Compare the data and insert accordingly if tree is not empty
* Increase the value of InsertCount by 1 for each comparisons made
*/
   public void insert ( dataType d )
   {
      if (root == null)
         root = new BinaryTreeNode<dataType> (d, null, null);
      else
         insert (d, root);
   }
   public void insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (d.compareTo (node.data) <= 0)
      {  InsertCount +=1; 
         if (node.left == null)
            node.left = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         if (node.right == null)
            {InsertCount +=1;
            node.right = new BinaryTreeNode<dataType> (d, null, null);}
         else
            {InsertCount +=1;
            insert (d, node.right);}
      }
   }
   
/** This method is used to return the node if it is found
* @return null if the node is not found
* Search recursively through tree until node is found
* @return node if it is found
* Increase the value of count by 1 for each comparisons made when finding the data
*/
   public BinaryTreeNode<dataType> find ( dataType d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (d.compareTo (node.data) == 0) 
         {count = count+1;
         return node;}
      else if (d.compareTo (node.data) < 0)
         {count = count+1;
         return (node.left == null) ? null : find (d, node.left);}
      else
         {count = count+1;
         return (node.right == null) ? null : find (d, node.right);}
   }
  
/** This method is used to delete the node containing the "datatype d" 
* Search recursively through tree until node is found
* @return null if node is not found
* if node is found, delete it and put the minimum of right subtree in its place
*/
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }   
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else if (node.left != null && node.right != null )
      {
         node.data = findMin (node.right).data;
         node.right = removeMin (node.right);
      }
      else
         if (node.left != null)
            node = node.left;
         else
            node = node.right;
      return node;
   }
  
/** @return the node at the end of the ledt subtree
*/ 
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }

/** delete the node which has the lowest value in the tree
* Search in leftsubtree until node is found
* go to right subtree is there is no leftsubtree
*/
   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return null;
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }
/** @Return the value of the number of count comparisons when finding a particular node
*/
public int returnCount()
{
return (count);
} 

/** reset the value of count as 0
*/
public static void resetc()
{
count =0;
}
 
}
