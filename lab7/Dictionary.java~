/*
 * Dictionary.java
 * Programmer: Tiancheng Fu
 * CMPS 12B
 * Date: July 21st, 2018
 * Cruzid: tfu6
 * Programming Assignment 3
 * This java file contain 7 different methods that implement Dictionary ADT and defined the Dictionary object. 
 * The Dictionary ADT methods are isEmpty(), size(), lookup(String key), insert(String key, String value),
 * delete(String key), makeEmpty(), toString(). The specific functions of the methods and codes
 * are listed in the rest of comments.
 */
public class Dictionary implements DictionaryInterface{
  
  //Private inner Node class
  //This is the simpler and recommended way to define the Node class
  private class Node {
   String Key;
   String Value;
   Node next;
   
   //The Node class contain two String fields
   Node(String key, String value){
     Key = key;
     Value = value;
     next = null;
      }
    }
  
  private Node head; //Reference to the first Node in the linked list
  
  //Constructor for the Dictionary class
   public Dictionary(){
      head = null;
   }
   
  //This method return a reference to the Node containing its argument key, or return null if no such Node exists
  private Node findKey(String key){
    Node current = head;//Start to search from the head of the linked list
    Node r = null;//Store if the returning value
    boolean s = false; //If the Node containing its argument key been found use this boolean variable to stop the while loop
    
    //Continually searching for the Node containing its argument key untill its been found
    while ((current != null)&&(s == false)){
      if(current.Key.equals(key)){
        s = true;
        r = current;
      }
        current=current.next;//Set the current to the next Node
    }
    
    //Return the reference to the Node if the Node has been found or null if the Node has not been found
    if(r != null){
     return r; 
    }else{
      return null;}
  }
  
  //Returns true if the Dictionary contains no pairs, false otherwise
  public boolean isEmpty(){
    boolean empty = true;//Store the return value
    Node current = head;
    
    //If the Dictionary contain at least one pair, isEmpty() will return true, else it will return false
    while (current != null){
       empty = false;
       current = current.next;
    }
    return empty;
  }
  
  //Returns the number of (key, value) pairs in the Dictionary
  public int size(){
    Node current = head;
    int size = 0;//Store the return size
    
    //Add one to int variable size for every pair in the Dictionary until all pairs in the Dictionary are checked
    while (current != null){
      size++;
      current=current.next;
    }
    return size;
  }
  
  //If the Dictionary contains a pair whose key field matches the argument key, lookup returns the associated
  //value field. If no such pair exists in the Dictionary, a null reference is returned
  public String lookup(String key){
    Node current=head;
    
    //If the key been found then returns its associated value field, if the key has not been found then returns null
    if(findKey(key) !=null){
    return findKey(key).Value;
    }else{
    return null; 
   }
  }
  
  //Insert pair to the Dictionary. The insert() has the precondition that the Dictionary
  //does not currently contain the argument key
  public void insert(String key, String value) throws DuplicateKeyException{
    Node current;
    
    //If the Dictionary does not currently contain a pair whose key matches the argument key, then the pair
    //is added to the Dictionary
    if(findKey(key) == null){
      if(head == null){// If Dictionary was initially empty then insert the pair to the head position
        head = new Node(key,value);
      }else{
      current = head;
      //Insert the pair into the last position in the Dictionary
      while(current.next != null){
        current=current.next;
      }
      current.next=new Node(key, value);
     }
      
    //If a pair in the Dictionary whose key matches the argument key, a DuplicateKeyException will be thrown
    }else{
      throw new DuplicateKeyException("cannot insert duplicate keys");
   }
  }
  
  //Remove the part with the designating key from the dictionary. The delete() has the precondition that the Dictionary
  //currently contains the argument key
  public void delete(String key) throws KeyNotFoundException{
    Node prev = null;//Use to store the previous pair in the Dictionary
    
    //If the Dictionary currently contains a pair whose key field matches the argument key, then that pair is
    //removed from the Dictionary
    if(findKey(key) != null){
      if(head.Key.equals(key)){//If the head is the pair that need to be removed, remove it set the head to the pair next to it
       head=head.next; 
      }else{
        Node current = head;
        //Check all of the pairs in the Dictionary for the designating pair
        while (current.next != null){
          
        if (current.next.Key.equals(key)){//If the pair that next to the current pair is the designating pair, remove it by set it to the pair next to it 
            current.next = current.next.next;
            break;// Terminate the while loop
        }else{//Else set the current pair to the pair that next to it
            current = current.next;
        }
        
       }
      }
     //If no pair with the designating key exists in the dictionary, then a KeyNotFoundException is thrown
     }else{
      throw new KeyNotFoundException("cannot delete non-existent key");
    }
    
  }
  
  //Resets the Dictionary to the empty state
  public void makeEmpty(){
    
    //If there are pairs exist in the Dictionary, empty it by set its head pair to null
    if(head!=null){
    head=null;
    }

  }
  
  //Returns a String representation of the current state of the Dictionary
  public String toString(){
    Node current=head;
    String output="";//Store the String representation that will be returned
    
    if(head!=null){//If there are pairs exist in the Dictionary
      
      //Add all of the String representations that exist in the Dictionary to String variable output
      while(current!=null){
       output=output + current.Key+" "+current.Value+"\n";
       current=current.next;
     }
      
     return output;
    }else{//Return the empty String variable output if there is no pair exist in the Dictionary
     return output;
    }
    
  }
    
}

  
  
  
  
  
