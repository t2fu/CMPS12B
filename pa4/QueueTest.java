/*
 * QueueTest.java
 * Programmer: Tiancheng Fu
 * CMPS 12B
 * Date: August 6th, 2018
 * Cruzid: tfu6
 * Programming Assignment 4
 * This java file serve as a test client for the Queue ADT while it is under construction.
 * This file only contain a main() method. This file throughly tested each Dictionary ADT in isolation
 * before it is used in any application.
 */
public class QueueTest{
  public static void main(String[] args){
  //Job j1 = new Job("1", "1");
  //Job j2 = new Job("2", "2");
  //Job j3 = new Job("3", "3");
  //Job j4 = new Job("4", "4");
  //Job j5 = new Job("5", "5");
  //Job j6 = new Job("6", "6");

  //Queue q8= new Queue();
  //q8.enqueue(j1);
  //q8.enqueue(j2);
  //q8.enqueue(j3);
  //q8.enqueue(j4);
  //q8.enqueue(j5);
  
  //q8.dequeue();
  //q8.dequeue();
  //q8.dequeue();
  //q8.dequeue();
  //q8.dequeue();
  //q8.dequeue();//This will cause the QueueEmptyException
  //System.out.println("Size: "+d8.length());
  //System.out.println(d8);
  //System.out.println("The Next Job is: "+d8.peek());
  //d8.enqueue(j6);
  
  //d8.dequeueAll();

  //if(d8.isEmpty() == true){
  //System.out.println("Dictionary has been Empty");
  //}else{
  //System.out.println("dequeueAll() has error");  
  //}
  //System.out.println("Length of d8: "+d8.length());
    
  Queue q1= new Queue();
  Job j1 = new Job(2,2);
  Job j2 = new Job(3,4);
  Job j3 = new Job(5,6);
  Job j4 = new Job(6,8);
  Job j5 = new Job(7,10);
  //Testing insert(Object) Queue ADT
  
  q1.enqueue(j1);
  q1.enqueue(j2);
  q1.enqueue(j3);
  q1.enqueue(j4);
  q1.enqueue(j5);
  //d1.insert("3", "three");//This will cause the QueueEmptyException
  
  //Testing size() Queue ADT
  System.out.println("Length: "+q1.length());
  
  //Testing toString() Queue ADT
  System.out.println(q1);
  
  //Testing lookup(String key) Queue ADT
  System.out.println("The head job is "+q1.peek());
  //d1.insert("1", "One");//This will cause the QueueEmptyException
  
  //Testing dequeue() Queue ADT  
  q1.dequeue();
  q1.dequeue();
  q1.dequeue();
  System.out.println(q1);
  System.out.println("length: "+q1.length());
  if(q1.isEmpty() == true){
    System.out.println("Insert test1 failed");
  }
  
  //Testing dequeueAll() Dictionary ADT
  q1.dequeueAll();
  if(q1.isEmpty() == true){
  System.out.println("Dictionary has been Empty");
  }else{
  System.out.println("dequeueAll() has error");  
  }
  System.out.println("Length: "+q1.length());
  //d1.dequeue("1");//This will cause the QueueEmptyException
  System.out.println("isEmpty(): "+q1.isEmpty());
  System.out.println(q1);
  //d1.dequeue("3");//This will cause the QueueEmptyException
  
  }
}