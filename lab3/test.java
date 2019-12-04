public class test{
 
  public static void main(String [] args){
    
  String lol="What";
  stringReverse(lol);
    System.out.println(lol);
    
    
  }
  public static void stringReverse(String s){//This recursive method will call a void method named stringReverse2 and return a String that is the reversal of the first n characters of String variable s

  //Delcare three char arrays to store the letters of the String s
  char [] c = new char[s.length()];
  char [] d = new char[s.length()];
  //Insert the letters in String s that are required to reverse into char arrays d and c
  for(int i = 0; i < s.length(); i++){
   d[i] = s.charAt(i);
   c[i] = s.charAt(i);
  }
  int n = s.length();
  //If there still are letters left in the char array c that didn't get copy and swap its position then insert into char array d
  for(int j = n; j > s.length()/2; j--){
   d[s.length()-j] = c[j-1];//Copying the nth element from the left in c[] into the nth element from the right in d[]
   d[j-1] = c[s.length()-j];//Copying the nth element from the right in c[] into the nth element from the left in d[]
   //System.out.print(d[s.length()-j]+" "+d[j-1]);
  }
   s=String.valueOf(d);
   System.out.println(s);
   //return s;
  }
}