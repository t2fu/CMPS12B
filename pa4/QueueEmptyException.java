/*
 * QueueEmptyException.java
 * Programmer: Tiancheng Fu
 * CMPS 12B
 * Date: August 6th, 2018
 * Cruzid: tfu6
 * Programming Assignment 4
 * The QueueEmptyException.java define the exception class to be thrown.
 * The exception class is subclass of the RuntimeException.
 */
public class QueueEmptyException extends RuntimeException{
  
  public QueueEmptyException(String s){
      super(s);
   }
  
}