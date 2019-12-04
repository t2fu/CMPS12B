public class BinomialCoefficients{
   
   public static int C(int n, int k){
      if(k>n)
         return 0;
      else if(k==0 || k==n)
         return 1;
      else
         return C(n-1, k-1)+C(n-1,k);
   
   }

   public static void main(String[] args){

      
     int [] A={1,2,3,4,5,6};
         System.out.println(C(5,3));
         System.out.println(BinarySearch(A,0,A.length-1,6));
         System.out.println(getValue(3, 13, 5));
         displayOctal(10);
   }
   
   public static int sum(int n){
     if(n>0){
      return n+sum(n-1); 
     }
    return n;
   }
   static int sum2(int n, int m){
  if( n>m ){
  return 0;
 }else{
  return m+sum2(n,m-1);
 }
}
   static int BinarySearch(int[] X, int p, int r, int target){
 if( p<=r ){
 int q = (p+r)/2;
 System.out.print(X[q]+" ");
 if( target==X[q] ){
 return q;
 }else if( target<X[q] ){
 return BinarySearch(X, p, q-1, target);
 }else{ // target>X[q]
 return BinarySearch(X, q+1, r, target);
 }
 }else{
 return -1;
 }
 }
   static void displayOctal(int n){
 if(n>0){
 if(n/8>0){
 displayOctal(n/8);
 }
 System.out.println(n%8);
 }
}
   public static int getValue(int a, int b, int n){
 int x, c;
 System.out.println("arrive: a = " + a + " b = " + b);
 c = (a+b)/2;
 if( c*c <= n ){
 x = c;
 }else{
 x = getValue(a, c-1, n);
 }
 System.out.println("depart: a = " + a + " b = " + b);
 return x;
 }
}