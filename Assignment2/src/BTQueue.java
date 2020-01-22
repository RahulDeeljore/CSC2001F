// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

/** This contains the class BTQueue
* there are 2 instances of type BTQueueNode
*/

public class BTQueue<dataType>
{   
   BTQueueNode<dataType> head;
   BTQueueNode<dataType> tail;

/** No argument constructor for objects of the class*/      
   public BTQueue ()
   {
      head = null;
      tail = null;
   }
   
/** @returns null if the queue is empty
* @returns the head of the queue 
*/
   public BinaryTreeNode<dataType> getNext ()
   {
      if (head == null)
         return null;
      BTQueueNode<dataType> qnode = head;
      head = head.next;
      if ( head == null )
         tail = null;
      return qnode.node;
   }
 
/** adds a node as head if queue is empty
* adds the node at the end of the queue if not empty
*/
  
   public void enQueue ( BinaryTreeNode<dataType> node )
   {
      if (tail == null)
      {   
         tail = new BTQueueNode<dataType> (node, null);
         head = tail;
      }   
      else
      {
         tail.next = new BTQueueNode<dataType> (node, null);
         tail = tail.next;
      }   
   }   
}
