/*
 * ListTest.java
 * Programmer: Tiancheng Fu
 * CMPS 12M
 * Date: August 10th, 2018
 * Cruzid: tfu6
 * Lab Assignment 6
 * This java file serve as a test client for the List ADT while it is under construction.
 * This file only contain a main() method. This file throughly tested each List ADT in isolation
 * before it is used in any application.
 */
public class ListTest{
   public static void main(String [] args){
    
      //List<String> ls = new List<String>();
      //List<Double> ld = new List<Double>();
      //List<int> li = new List<int>();
      
      //li.add(1, "1");
      //li.add(2, "2");   
    
      //System.out.println(li);
    
      //ls.add(1, "One");
      //ls.add(2, "Two");
      //ls.add(3, "Three");
      //ls.add(4, "Four");
      //ls.add(5, "Five");
      //ls.add(6, "Six");
     
      //System.out.println("The item at index 5 in ls is: "+ls.get(5));
      //System.out.println("The item at index 6 in ls is: "+ls.get(6));    
      //System.out.println("The size of ls is: "+ls.size());
      
      //ps.add(8, "Eight"); //This will call ListIndexOutOfBoundsException
      //ld.add(1, 1.1);
      //ld.add(2, 2.2);
      //ld.add(3, 3.3);
      //ld.add(4, 4.4);
      //ld.add(5, 5.5);
      //ld.add(6, 6.6);
      //ld.add(7, 7.7);
      //ld.add(8, 8.8);

      //System.out.println(ls);
      //System.out.println(ld);
      
      //System.out.println("The size of ld is: "+ld.size());
      
      //ld.remove(1);
      //ld.remove(2);
      //ld.remove(3);
      //ld.remove(4);
      //ld.remove(5);
    
      //System.out.println(ld);
      
      //ld.removeAll();
      
      //System.out.println("The size of ld after removeAll() is: "+ld.size());
      
      //ld.remove(1); //This will cause ListIndexOutOfBoundsException
      //ld.get(1); //This will cause ListIndexOutOfBoundsException

      //List<String> ls2 = new List<String>();
      //ls2.add(1, "two");
      //List<List<String> > lls = new List<List<String> >();
      //lls.add(1, ls2);
      //System.out.println(lls);
    
      //Pair<String> ls3 = new Pair<String>();
    
      //ls3.add(1, "very");
      //ls3.add(2, "two");
      //ls3.add(3, "three");
      
      //System.out.println("ls isEmpty: "+ls.isEmpty());
      //System.out.println("ls3 isEmpty: "+ls3.isEmpty());
      //System.out.println(ls.equals(ld));
      //System.out.println(ls.equals(ls2));
      //System.out.println(ls);
      //System.out.println(ls3);
    
      //if(ls.equals(ls3)){
         //System.out.println("equals() error");
      //}else{
         //System.out.println("equals() worked");
      //}
      //System.out.println(ls.equals(lls));     
      ////////////////////////////////////////////////////////////
      //Testing the constructor for List class
      List<String> ps = new List<String>();
      List<Double> pd = new List<Double>();
      List<String> ps3 = new List<String>();
      
      //Testing add(int index, T newItem) List ADT
      ps.add(1, "very");
      ps.add(2, "two");
      ps.add(3, "three");
      
      //Testing size() List ADT
      System.out.println("The size of ps is: "+ps.size());
      
      //ps.add(5, "Five"); //This will call ListIndexOutOfBoundsException
      pd.add(1, 2.5);
      pd.add(2, 2.6);
      pd.add(3, 2.7);
      pd.add(4, 2.8);
      pd.add(5, 2.9);
      pd.add(6, 3.1);
      
      //Testing toString() List ADT
      System.out.println(ps);
      System.out.println(pd);
      
      //Testing get(int index) List ADT
      System.out.println("The item at index 5 in pd is: "+pd.get(5));
      System.out.println("The item at index 6 in pd is: "+pd.get(6));
      System.out.println("The size of pd is: "+pd.size());
      
      //Testing remove(int index) List ADT
      pd.remove(1);
      pd.remove(2);
      pd.remove(3);
      
      System.out.println(pd);
      System.out.println("1.pd isEmpty: "+pd.isEmpty());
      //Testing removeAll() List ADT
      pd.removeAll();
      
      //Testing isEmpty() List ADT
      System.out.println("2.pd isEmpty: "+pd.isEmpty());
      
      System.out.println("The size of pd after removeAll() is: "+pd.size());
      
      //pd.remove(1); //This will cause ListIndexOutOfBoundsException
      //pd.get(1); //This will cause ListIndexOutOfBoundsException
      
      List<String> ps2 = new List<String>();
      ps2.add(1, "two");
      List<List<String>> pps = new List<List<String>>();
      pps.add(1, ps2);
      System.out.println(pps);
      
      ps3.add(1, "very");
      ps3.add(2, "two");
      ps3.add(3, "three");
      
      //Testing equals(Object rhs) List ADT
      System.out.println(ps.equals(pd));
      System.out.println(ps.equals(ps2));
      System.out.println(ps);
      System.out.println(ps3);
      
      if(ps.equals(ps3)){
         System.out.println("equals() worked");
      }else{
         System.out.println("equals() error");
      }
      
      System.out.println(ps.equals(pps));
      
   }
}