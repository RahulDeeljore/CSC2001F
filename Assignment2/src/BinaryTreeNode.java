// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

/** This class denotes the node of a BinaryTree and the instance variables it contains
*/

public class BinaryTreeNode<dataType>
{
   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   int height;


/** This is the constructor
*/   
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
      height = 0;
   }
/** @return the node at the left*/   
   BinaryTreeNode<dataType> getLeft () { return left; }

/** @return the node at the right*/
   BinaryTreeNode<dataType> getRight () { return right; }

/** toString method for the data which will be stored in the node*/
  public String toString()
{
   return (data.toString());
}


}
