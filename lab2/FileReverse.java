/*
 * FileReverse.java
 * Programmer: Tiancheng Fu
 * CMPS 12M
 * Date: July 12th, 2018
 * Cruzid: tfu6
 * This program have one return type recursive method stringReverse and stringReverse2 which are based on reverseArray1,2,3 from pa1, and a main class that allow the user to enter a input file's name
 * and a output file's name. Then the program will read the words in the input and removes the blank lines and white spaces.
 * After that, the program will use the stringReverse and stringReverse2 methods to reverse the words and print them into the user named file.
 * The specific functions of the method and codes are listed in the rest of the comments. 
 * 
 */
//Importing packages to java
import java.io.*;
import java.util.*;
class FileReverse{
  
 public static void main(String[] args) throws IOException{//Throw IOExaception to the class so the program will keep running when there is a runtime error
   
   Scanner in = null;//Scanner to check inputs from the input file
   PrintWriter out = null;//PrintWriter use to output words to the output file
   String line = null;//String variable use to temporarily store a word from the input file
   String[] token = null;//String array use to store all the words in the input file
   
   int i, n;//Integer variables use to count the number of the words in the input file
   
 // Check number of command line arguments is at least 2
   if(args.length < 2){//If the number of command line arguments is less than 2 then stop the program
     System.out.println("Usage: FileCopy <input file> <output file>");
     System.exit(1);
 }
   
 // open files
   in = new Scanner(new File(args[0]));
   out = new PrintWriter(new FileWriter(args[1]));
   
 // read lines from in, extract and print tokens from each line
 while( in.hasNextLine() ){
 // trim leading and trailing spaces, then add one trailing space so
 // split works on blank lines
   line = in.nextLine().trim() + " ";
 // split line around white space
   token = line.split("\\s+");
 // print out tokens in reverse order
   n = token.length;
   
 for(i=0; i<n; i++){
   out.println(" "+stringReverse(token[i], token[i].length()));
  }
 }
 // close the output and input file
 in.close();
 out.close();
   
 }
 
  public static String stringReverse(String s, int n){//This recursive method will call a void method named stringReverse2 and return a String that is the reversal of the first n characters of String variable s
  
  //Delcare three char arrays to store the letters of the String s
  char [] c = new char [n];
  char [] d = new char [n];//Char array d stores the letters that have been reversed
  char [] e = new char [s.length()-n];//Char array e stores the letters that are not required to reverse
  
  //Insert the letters in String s that are required to reverse into char arrays d and c
  for(int i = 0; i < n; i++){
   d[i] = s.charAt(i);
   c[i] = s.charAt(i);
  }
  
  //Insert the letters in String s that are not required to reverse into char array e
  for(int j = n; j < s.length(); j++){
   e[j-n] = s.charAt(j); 
  }
  
   stringReverse2(c, n, d);//Call void method stringReverse2 to reverse the letters in the string s that are required to reverse
   s = String.valueOf(d) + String.valueOf(e);//Combine the letters in d and e into a word and insert it into String s
   
   return s;//return the word that has been reversed
  }
  
  public static void stringReverse2(char []c, int n, char []d){//This method will copy the leftmost n elements in c[] into the rightmost n positions in d[] in reverse order
    
    if(n>0){//If there still are letters left in the char array c that didn't get copy and swap its position then insert into char array d

    d[d.length-n] = c[n-1]; //Copying the nth element from the left in c[] into the nth element from the right in d[]
    
    stringReverse2(c, n-1, d); //Call the method itself again without copy and swap the elements that already got swapped
    
    }
 
}
 
}