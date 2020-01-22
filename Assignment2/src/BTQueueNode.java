// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman


/** Class BTQueueNode
* Contains 2 instance variables
* a node as the data stored
* and a reference to another node
*/
public class BTQueueNode<dataType>
{
   BinaryTreeNode<dataType> node;
   BTQueueNode<dataType> next;
  
/** constructor*/ 
   public BTQueueNode ( BinaryTreeNode<dataType> n, BTQueueNode<dataType> nxt )
   {
      node = n;
      next = nxt;
   }
}
