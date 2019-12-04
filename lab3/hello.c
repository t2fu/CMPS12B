#include <stdio.h>
void stringReverse(char* s){//This recursive method will call a void method named stringReverse2 and return a String that is the reversal of the first n characters of String variable s

  //Delcare three char arrays to store the letters of the String s
  char* c [strlen(s)];
  //char d [strlen(s)];//Char array d stores the letters that have been reversed
  //char e [strlen(s)];//Char array e stores the letters that are not required to reverse

  //Insert the letters in String s that are required to reverse into char arrays d and c
  for(int i = 0; i < strlen(s); i++){
   //d[i] = s[i];
   c[i] = s[i];
  }
  int n = strlen(s);
  //If there still are letters left in the char array c that didn't get copy and swap its position then insert into char array d
  for(int j = n; j > strlen(s)/2; j--){

   s[strlen(s)-j] = c[j-1];//Copying the nth element from the left in c[] into the nth element from the right in d[]
   s[j-1] = c[strlen(s)-j];//Copying the nth element from the right in c[] into the nth element from the left in d[]

  }

  }
int main(){
    char* lol="Hello World";
    stringReverse(lol);
    printf("%s",lol);
    return 0;
    }
