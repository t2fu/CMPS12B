/*
 * DuplicateKeyException.java
 * Programmer: Tiancheng Fu
 * CMPS 12B
 * Date: July 21st, 2018
 * Cruzid: tfu6
 * Programming Assignment 3
 * This java file define the DuplicateKeyException exception class to be thrown. DuplicateKeyException
 * is a subclass of RuntimeException.
 */
public class DuplicateKeyException extends RuntimeException{

   public DuplicateKeyException(String s){
      super(s);//Call the constructor, methods and properties of parent class
   }
  
}