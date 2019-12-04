/*
 * Queue.java
 * Programmer: Tiancheng Fu
 * CMPS 12B
 * Date: August 6th, 2018
 * Cruzid: tfu6
 * Programming Assignment 4
 * The Queue.java includes seven Queue ADT operations implemented by methods.
 * This file implement a Queue ADT in Java based on a linked list data structure.
 */
  public class Queue{
  
     private class Node {
      Object Job;
      Node next;

      Node(Object job){
         Job = job;
         next = null;
      }
   }
   // Fields for the IntegerList class
   private Node head;     // reference to first Node in List

   // constructor for the IntegerList class
   public Queue(){
      head = null;
   }
   
   // isEmpty()
   // pre: none
   // post: returns true if this Queue is empty, false otherwise
   public boolean isEmpty(){
    boolean empty = true;//Store the return value
    Node current = head;
    
    //If the Queue contain at least one pair, isEmpty() will return true, else it will return false
    while (current != null){
       empty = false;
       current = current.next;
    }
    return empty;
   }
   
   // length()
   // pre: none
   // post: returns the length of this Queue.
   public int length(){
    Node current = head;
    int length = 0;//Store the return length
    
    //Add one to int variable size for every pair in the Queue until all pairs in the Queue are checked
    while (current != null){
      length++;
      current=current.next;
    }
    return length;
   }
   
   // enqueue()
   // adds newItem to back of this Queue
   // pre: none
   // post: !isEmpty()
   public void enqueue (Object newItem){
     Node current;
     
      if(head == null){// If Queue was initially empty then insert the pair to the head position
        head = new Node(newItem);
      }else{
      current = head;
      //Insert the pair into the last position in the Queue
      while(current.next != null){
        current=current.next;
      }
      current.next=new Node(newItem);
     } 
    //If a pair in the Queue whose key matches the argument key, a DuplicateKeyException will be thrown
     
   }
   
   // dequeue()
   // deletes and returns item from front of this Queue
   // pre: !isEmpty()
   // post: this Queue will have one fewer element
   public Object dequeue() throws QueueEmptyException{
     Node prev = null;//Use to store the previous pair in the Queue
     Object headV = head.Job;
    //If the Queue currently contains a pair whose key field matches the argument key, then that pair is
    //removed from the Queue
    if(isEmpty() != true && head!=null){
       head=head.next;
     }else{
      throw new QueueEmptyException("Error: The Queue is Empty");
    }
     return headV;
   }
   
   // peek()
   // pre: !isEmpty()
   // post: returns item at front of Queue
   public Object peek() throws QueueEmptyException{
     Object item;
    if(isEmpty() != true){
    item = head.Job;
    return item; 
    }else{
      throw new QueueEmptyException("Error: The Queue is Empty");
    }
   }
   
   // dequeueAll()
   // sets this Queue to the empty state
   // pre: !isEmpty()
   // post: isEmpty()
   public void dequeueAll() throws QueueEmptyException{
     
    if(isEmpty() != true){
       head=null;       
    }else{
      throw new QueueEmptyException("Error: The Queue is Empty");
     }
      
   }
   
   // toString()
   // overrides Object's toString() method
   public String toString(){
    Node current=head;
    String output="";//Store the String representation that will be returned
    
    if(head!=null){//If there are pairs exist in the Queue
      
      //Add all of the String representations that exist in the Queue to String variable output
      while(current!=null){
       output=output + current.Job+" ";
       current=current.next;
      }
     return output;
    }else{//Return the empty String variable output if there is no pair exist in the Queue
     return output;
   }  
  } 
}