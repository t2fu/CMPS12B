/*
 * Dictionary.java
 * Programmer: Tiancheng Fu
 * CMPS 12M
 * Date: August 17th, 2018
 * Cruzid: tfu6
 * Lab Assignment 7
 * This java file was wrote based on the Dictionary.c on the webpage and the Binary Search Tree (BST) structure
 * This java file contain 7 different methods that implement Dictionary ADT and defined the Dictionary object. 
 * The Dictionary ADT methods are isEmpty(), size(), lookup(String key), insert(String key, String value),
 * delete(String key), makeEmpty(), toString(). The specific functions of the methods and codes
 * are listed in the rest of comments.
 */

 // import packages to the program
 import java.io.*;
 import java.util. *;
 public class Dictionary implements DictionaryInterface{
  //Private inner Node class
  private class Node {
   String key;
   String value;
   Node left;
   Node right;
   
   //The Node class contain two String fields and it is build based on the Binary Search Tree (BST) structure
   Node(String KeyI, String ValueI){
     key = KeyI;
     value = ValueI;
     left = null;
     right = null;
      }
    }
  
  private int numPairs; // number of pairs in the dictionary
  private Node root; // reference to the root in the Binary Search Tree
  
  // constructor for the Dictionary class
   public Dictionary(){
      root = null;
      numPairs = 0;
   }
   
  // private functions -----------------------------------------------------------
   
  //This method return a reference to the Node containing its argument key, or return null if no such Node exists
  private Node findKey(Node R, String k){
    // return the Node if when it has been find
    if (R == null || k.equals(R.key)){
      return R; 
    }
    // go through the left side of the subtree
    if( k.compareTo(R.key) < 0){
      return findKey(R.left, k);
    }else{ // k.compareTo(R.key) > 0, go through the right side of the subtree
      return findKey(R.right, k);
    }
  }
  
  // findParent()
  // returns the parent of N in the subtree rooted at R, or returns null
  // if N is equal to R. (pre: R != null)
  private Node findParent(Node N, Node R){
    Node P = null;
    if( N != R ){
      P = R;
      while( P.left != N && P.right != N ){
        if(N.key.compareTo(P.key)<0){
            P = P.left;
        }else{
            P = P.right;
        }
       }
    }
    return P;
  }

  // findLeftmost()
  // returns the leftmost Node in the subtree rooted at R, or NULL if R is null.
  private Node findLeftmost(Node R){
    Node L = R;
    if( L != null ) for( ; L.left != null; L = L.left);
    return L;
  }

  // printInOrder()
  // prints the (key, value) pairs belonging to the subtree rooted at R in order
  // of increasing keys to file pointed to by out.
  private String printInOrder(Node R){
    String output="";
    if(R != null){
      output = output + printInOrder(R.left);
      output = output + R.key+" "+R.value+"\n";
      output = output + printInOrder(R.right);
    }
    return output;
  }
  
  // deleteAll()
  // deletes all Nodes in the subtree rooted at N.
  private void deleteAll(Node N){
   if( N != null){
      deleteAll(N.left);
      deleteAll(N.right);
      N = null;
    }
  }

  // public functions -----------------------------------------------------------

  // isEmpty()
  // pre: none
  // returns true if this Dictionary is empty, false otherwise
  public boolean isEmpty(){
    if(numPairs==0){
      return true;
    }else{
      return false; 
    }
  }

   // size()
   // returns the number of (key, value) pairs in D
   // pre: none
   public int size(){
      return(numPairs);
   }

   // lookup()
   // pre: none
   // returns value associated key, or null reference if no such key exists
   public String lookup(String key){
     Node N = null;
     N = findKey(root, key);
     if(N == null){
        return null;
     }else{
        return N.value;
     }
   }

   // insert()
   // inserts new (key,value) pair into this Dictionary
   // pre: lookup(key) == null
   public void insert(String key, String value) throws DuplicateKeyException{
      Node N, A, B;
      //If the Dictionary does not currently contain a pair whose key matches the argument key, then the pair
      //is added to the Dictionary
      if(lookup(key) == null){
      N = new Node(key, value);
      B = null;
      A = root;
      while( A != null ){
         B = A;
         if(key.compareTo(A.key) < 0 ){
           A = A.left;
         }else{
           A = A.right;
         }
      }
      if( B == null ){
        root = N;
      }else if(key.compareTo(B.key)<0 ){
        B.left = N;
      }else{
        B.right = N;
      }
      numPairs++;
     }else{ // If a pair in the Dictionary whose key matches the argument key, a DuplicateKeyException will be thrown
        throw new DuplicateKeyException("Error: cannot insert duplicate keys");
     }
   }

   // delete()
   // deletes pair with the given key
   // pre: lookup(key) != null
   public void delete(String key) throws KeyNotFoundException{
     
      Node N, P, S;
      N = findKey(root, key);
      //If the Dictionary currently contains a pair whose key field matches the argument key, then that pair is
      //removed from the Dictionary
      if(lookup(key) != null){
      if(N.left == null && N.right == null){  // case 1 (no children)
      if(N == root){
         root = null;
      }else{
         P = findParent(N, root);
         if(P.right == N){
           P.right = null;
         }else{
           P.left = null;
         }
      }
    }else if( N.right == null ){  // case 2 (left but no right child)
      if( N == root ){
         root = N.left;
      }else{
         P = findParent(N, root);
         if( P.right==N ){
           P.right = N.left;
         }else{
           P.left = N.left;
         }
      }
    }else if( N.left == null ){  // case 2 (right but no left child)
      if( N == root ){
         root = N.right;
      }else{
         P = findParent(N, root);
         if( P.right==N ){
           P.right = N.right;
         }else{
           P.left = N.right;
         }
      }
    }else{ // case3: (two children: N->left!=NULL && N->right!=NULL)
      S = findLeftmost(N.right);
      N.key = S.key;
      N.value = S.value;
      P = findParent(S, N);
      if( P.right == S ){
        P.right = S.right;
      }else{
        P.left = S.right;
      }
     }
     numPairs--;
    // If no pair with the designating key exists in the dictionary, then a KeyNotFoundException is thrown
    }else{
      throw new KeyNotFoundException("Error: cannot delete non-existent key");  
   }
  }

   // makeEmpty()
   // this will delete all of the pairs in the dictionary
   // pre: none
   public void makeEmpty(){
     deleteAll(root);
     root = null;
     numPairs = 0;
   }

   // toString()
   // returns a String representation of the current state of the Dictionary
   // overrides Object's toString() method
   // pre: none
   public String toString(){
     return printInOrder(root);
   }

 }
