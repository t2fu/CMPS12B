import java.io.*;
import java.util.Scanner;
class SearchTest{
  
 public static void main(String[] args) {
   String [] words={"ccc", "bbb", "ddd", "aaa"};
   int [] lines={1,2,3,4};
    mergeSort(words,lines,0,words.length-1);
    for(int i=0;i<words.length;i++){
    System.out.print(" "+words[i]);
    //System.out.println("");
    System.out.print(" "+lines[i]);
    }
    System.out.println(binarySearch(words, 0, words.length-1, "aaa"));
   
   
   
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