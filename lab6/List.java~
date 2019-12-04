/*
 * List.java
 * Programmer: Tiancheng Fu
 * CMPS 12M
 * Date: August 10th, 2018
 * Cruzid: tfu6
 * Lab Assignment 6
 * This java file contain 8 different methods that implement the List ADT and defined the List constructor. 
 * The Dictionary ADT methods are isEmpty(), size(), get(int index), add(int index, T newItem),
 * remove(int index), removeAll(), toString(), equals(Object rhs). This file was built based on the IntegerList.java
 * on the webpage. The specific functions of the methods and codes are listed in the rest of the comments.
 */

// Annotate warning
@SuppressWarnings("overrides")
public class List<T> implements ListInterface<T>{
  
  // Private inner Node class
  private class Node{

    T item;
    Node next;
    
    // The Node class contain one field of an abstract type with the use of Java Generics
    Node(T i){
      item = i;
      next =null;
     }
    }
   
   // Fields for the List class
   private Node head;     // reference to first Node in List
   private int numItems;  // number of items in this List

   // List()
   // constructor for the List class
   public List(){
      head = null;
      numItems = 0;
   }

   // private helper method -------------------------------------------------
   // find()
   // this is a helper method returns a reference to the Node at position index in this List
   private Node find(int index){
      Node N = head;
      for(int i=1; i<index; i++){
         N = N.next;
      }
      return N;
   }

   // ADT operations ----------------------------------------------------------
   
   // isEmpty()
   // pre: none
   // post: returns true if this IntgerList is empty, false otherwise   
   public boolean isEmpty(){
      return(numItems == 0);
   }

   // size()
   // pre: none
   // post: returns the number of elements in this IntegerList
   public int size() {
      return numItems;
   }

   // get()
   // pre: 1 <= index <= size() -> throws ListIndexOutOfBoundsException and print out error statement
   // post: returns item at position index in this List
   public T get(int index) throws ListIndexOutOfBoundsException {
      if( index < 1 || index > numItems ){
          throw new ListIndexOutOfBoundsException("get(): invalid index: " + index);
      }
      Node N = find(index);
      return N.item;
   }

   // add()
   // inserts newItem in this List at position index
   // pre: 1 <= index <= size()+1 -> throws ListIndexOutOfBoundsException and print out error statement
   // post: !isEmpty(), items to the right of newItem are renumbered
   public void add(int index, T newItem) throws ListIndexOutOfBoundsException{
      if( index < 1 || index > (numItems+1) ){
         throw new ListIndexOutOfBoundsException("IntegerList Error: add() called on invalid index: " + index);
      }
      // If the index is 1 then insert the newItem into the head position
      if(index==1){
         Node N = new Node(newItem);
         N.next = head;
         head = N;
      }else{// Else at the point index >=2, insert the newItem at the index position and renumber the items to the right of newItem
         Node P = find(index-1);
         Node C = P.next;
         P.next = new Node(newItem);
         P = P.next;
         P.next = C;
      }
      
      numItems++;// Add one to the number of items in the List
   }

   // remove
   // deletes item from position index
   // pre: 1 <= index <= size() -> throws ListIndexOutOfBoundsException and print out error statement
   // post: items to the right of deleted item are renumbered
   public void remove(int index) throws ListIndexOutOfBoundsException{
      if( index < 1 || index > numItems ){
         throw new ListIndexOutOfBoundsException("IntegerList Error: remove() called on invalid index: " + index);
      }
      if(index==1){// If index =1, Delete the item at the head position and renumber the items to the right of deleted item
         Node N = head;
         head = head.next;
         N.next = null;
      }else{// Else delete the item at the index position and renumber the items to the right of deleted item
         Node P = find(index-1);
         Node N = P.next;
         P.next = N.next;
         N.next = null;
      }
      numItems--;// Minus one to the number of items in the List
   }

   // removeAll()
   // pre: none
   // post: The List isEmpty() = true
   public void removeAll(){
      head = null;
      numItems = 0;
   }
   
   // equals()
   // pre: none
   // post: returns true if this List matches rhs, false otherwise
   // Overrides Object's equals() method
   @SuppressWarnings("unchecked")
   public boolean equals(Object rhs){
      boolean eq = false;
      List<T> R = null;
      // First check if the classes of both list are the same, then check if the class and value of the items in the lists are the same
      // If they are the same return true, else return false
      if(rhs.getClass() == this.getClass()){
        R = (List<T>) rhs;
        if(this != null && R !=null && this.numItems == R.numItems){
          Node current1 = this.head;
          Node current2 = R.head;
          while(current1 != null && current2 != null){
            if(current1.item.equals(current2.item)){
              eq=true;
            }else{
              eq=false; 
              break;
            }
            current1 = current1.next;
            current2 = current2.next;
         }
        }
       }
      return eq;
   }
   
   // toString()
   // pre: none
   // post: prints current items in the list to stdout
   // Overrides Object's toString() method
   public String toString(){
      StringBuffer sb = new StringBuffer();
      Node N = head;

      for( ; N!=null; N=N.next){
         sb.append(N.item).append(" ");
      }
     return new String(sb);
   }

}