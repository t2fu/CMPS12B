/*
 * 
 * 
 * 
 * 
 * 
 */ 
import java.io.*;
import java.util.Scanner;
class Search{
  
 public static void main(String[] args) throws IOException{
   
 Scanner in = null;

 String line = null;
 String [] wordF = null;
 int i, n, lineNumber = 0;
 // check number of command line arguments is at least 2
 if(args.length < 2){
 System.out.println("Usage: Search file target1 [target2..]");
 System.exit(1);
 }
 // open files
 in = new Scanner(new File(args[0]));
 String [] wordS = new String [args.length-1];
 boolean [] check= new boolean [args.length-1];
 for(int j=0;j<args.length-1;j++){
   wordS[j]=args[j+1];
   System.out.println(wordS[j]);
 }
 // read lines from in, extract and print tokens from each line
 while( in.hasNextLine() ){
 lineNumber++;
 
 // trim leading and trailing spaces, then add one trailing space so
 // split works on blank lines
 line = in.nextLine().trim() + " ";
 // split line around white space
 wordF = line.split("\\s+");
 // print out tokens
 
 for(int k=0;k<args.length-1;k++){
   if(wordF[0].equals(wordS[k])){
  System.out.println(wordS[k]+" found on line " + lineNumber);
  check[k]=true;
   }
  }
 
  }
 // close files
 in.close();
   
 for(int k=0;k<args.length-1;k++){
    if(check[k]!=true){
   System.out.println(wordS[k]+" not found");
    }
  }
  }
 
 static void mergeSort(String[] word, int[] lineNumber, int p, int r){
   int q;
      if(p < r) {
         q = (p+r)/2;
        //  System.out.println(p+" "+q+" "+r);
         mergeSort(word, lineNumber, p, q);
         mergeSort(word, lineNumber, q+1, r);
         merge(word, lineNumber, p, q, r);
      }
  }
 static void merge(String[] word, int[] lineNumber, int p, int q, int r){
   int n1 = q-p+1;
      int n2 = r-q;
      String [] L = new String[n1];
      String[] R = new String[n2];
      int [] l1 = new int [n1];
      int [] l2 = new int [n2];
      int i, j, k;

      for(i=0; i<n1; i++){
         L[i] = word[p+i];
         l1[i] = lineNumber[p+i];
      }
      
      for(j=0; j<n2; j++){ 
         R[j] = word[q+j+1];
         l2[j] = lineNumber[q+j+1];
      }

      i = 0; j = 0;
      for(k=p; k<=r; k++){
         if( i<n1 && j<n2 ){
            if( L[i].compareTo(R[j])<0 ){
               word[k] = L[i];
               lineNumber[k]=l1[i];
               i++;
            }else{
               word[k] = R[j];
               lineNumber[k] = l2[j];
               j++;
            }
         }else if( i<n1 ){
            word[k] = L[i];
            lineNumber[k]=l1[i];
            i++;
         }else{ // j<n2
            word[k] = R[j];
            lineNumber[k]=l2[j];
            j++;
         }
      }
      
 }
     static String binarySearch(String[] A, int p, int r, String target){
      int q;
      if(p > r) {
         return "Not Found";
      }else{
         q = (p+r)/2;
         if(target.equals(A[q])){
            return A[q];
         }else if(target.compareTo(A[q])<0){
            return binarySearch(A, p, q-1, target);
         }else{ // target > A[q]
            return binarySearch(A, q+1, r, target);
         }
      }
   }
 
} 