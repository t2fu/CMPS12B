#include<stdio.h>
#include<stdlib.h>
#include"Dictionary.h"

int main(int argc, char* argv[]){
  //d1.insert("1", "One");
  //d1.insert("2", "Two");
  //d1.insert("3", "Three");
  //d1.insert("4", "Four");
  //d1.insert("5", "Five");
  //d1.insert("4", "three");//This will cause the DuplicateKeyException
  //d1.insert("6", "Aa");
  //d1.insert("8", "Bb");
  //d1.insert("9", "Cc");
  //d1.insert("10", "Dd");
  //d1.insert("11", "Ff");
  //d1.insert("12", "Ss");

  //d1.delete("8");
  //d1.delete("9");
  //d1.delete("10");
  //d1.delete("11");
  //d1.delete("12");
  //d1.delete("6");

  //System.out.println("Size: "+d1.size());
  //System.out.println(d1);
  //System.out.println("The Value in Key 3 is "+d1.lookup("3"));
  //d1.insert("2", "One");//This will cause the DuplicateKeyException

  //d1.delete("1");
  //d1.delete("2");
  //d1.delete("4");
  //System.out.println(d1);
  //System.out.println("Size: "+d1.size());
  //if(d1.isEmpty()==true){
    //System.out.println("Insert test1 failed");
  //}

  //d1.makeEmpty();
  //if(d1.isEmpty() == true){
  //System.out.println("Dictionary has been Empty");
  //}else{
  //System.out.println("makeEmpty() has error");
  //}
  //System.out.println("Size: "+d1.size());
  //d1.delete("1");//This will cause the KeyNotFoundException
  //System.out.println(d1.isEmpty());
  //d1.insert("1", "One");
  //d1.insert("2", "Two");
  //d1.insert("4", "Four");
  //System.out.println(d1);
  //d1.delete("3");//This will cause the KeyNotFoundException

  //Testing insert(String key, String value) Dictionary ADT
  Dictionary d1 = newDictionary();

  insert(d1, "1", "One");
  insert(d1, "2", "Two");
  insert(d1, "3", "Three");
  insert(d1, "4", "Four");
  insert(d1, "5", "Five");
  //d1.insert("3", "three");//This will cause the DuplicateKeyException

  //Testing size() Dictionary ADT
  printf("Size: %d", size(d1));

  //Testing toString() Dictionary ADT
  //printDictionary(File* out, d1);

  //Testing lookup(String key) Dictionary ADT
  printf("The Value in Key 3 is %d", lookup(d1, "3"));
  //d1.insert("1", "One");//This will cause the DuplicateKeyException

  //Testing delete(String key) Dictionary ADT
  delete(d1, "1");
  delete(d1, "2");
  delete(d1, "4");
  printf(d1);
  printf("Size: "+size(d1));
  if(isEmpty(d1)== 1){
   printf("Insert test1 failed");
  }

  //Testing makeEmpty() Dictionary ADT
  makeEmpty(d1);
  if(isEmpty(d1) == 1){
  printf("Dictionary has been Empty");
  }else{
  printf("makeEmpty() has error");
  }
  printf("Size: "+size(d1));
  //d1.delete("1");//This will cause the KeyNotFoundException
  printf(isEmpty(d1));
  printf(d1);
  //d1.delete("3");//This will cause the KeyNotFoundException

return(EXIT_SUCCESS);
}

