/* 
 * KeyNotFoundException.java
 * Programmer: Tiancheng Fu
 * CMPS 12B
 * Date: July 21st, 2018
 * Cruzid: tfu6
 * Programming Assignment 3
 * This java file define the KeyNotFoundException exception class to be thrown. KeyNotFoundException
 * is a subclass of RuntimeException.
 */
public class KeyNotFoundException extends RuntimeException{
  
  public KeyNotFoundException(String s){
      super(s);//Call the constructor, methods and properties of parent class
   }
  
}