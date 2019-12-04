/*
 * DictionaryTest.c
 * Programmer: Tiancheng Fu
 * CMPS 12B
 * Date: August 15th, 2018
 * Cruzid: tfu6
 * Programming Assignment 5
 * This java file serve as a test client for the Dictionary ADT while it is under construction.
 * This file only contain a main() function. This file throughly tested each Dictionary ADT in isolation
 * before it is used in any application.
 */

//Insert the library header files
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include"Dictionary.h"

int main(int argc, char* argv[]){
  //Dictionary d1 = newDictionary();
  //d1.insert(d1, "1", "One");
  //d1.insert(d1, "2", "Two");
  //d1.insert(d1, "3", "Three");
  //d1.insert(d1, "4", "Four");
  //d1.insert(d1, "5", "Five");
  //d1.insert(d1, "4", "three");//This will cause the program to end
  //d1.insert(d1, "6", "Aa");
  //d1.insert(d1, "8", "Bb");
  //d1.insert(d1, "9", "Cc");
  //d1.insert(d1, "10", "Dd");
  //d1.insert(d1, "11", "Ff");
  //d1.insert(d1, "12", "Ss");

  //d1.delete(d1, "8");
  //d1.delete(d1, "9");
  //d1.delete(d1, "10");
  //d1.delete(d1, "11");
  //d1.delete(d1, "12");
  //d1.delete(d1, "6");

  //System.out.println("Size: %d", size(d1));
  //printDictionary(d1);
  //System.out.println("The Value in Key 3 is %d", d1.lookup(d1, "3"));
  //d1.insert(d1, "2", "One");//This will cause the program to end

  //d1.delete(d1, "1");
  //d1.delete(d1, "2");
  //d1.delete(d1, "4");
  //printDictionary(d1);
  //System.out.println("Size: %d", size(d1));
  //if(isEmpty(d1)==1){
    //System.out.println("Insert test1 failed");
  //}

  //makeEmpty(d1);
  //if(isEmpty(d1) == 1){
  //System.out.println("Dictionary has been Empty");
  //}else{
  //System.out.println("makeEmpty() has error");
  //}
  //System.out.println("Size: "+size(d1));
  //d1.delete(d1, "1");//This will cause the program to end
  //System.out.println("d1 isEmpty: %d", isEmpty(d1));
  //d1.insert(d1, "1", "One");
  //d1.insert(d1, "2", "Two");
  //d1.insert(d1, "4", "Four");
  //Test the printDictionary(File* out, Dictionary D) function
  //printDictionary("out", d1);
  //d1.delete(d1, "3");//This will cause the program to end

  //Testing insert(Dictionary D, char* key, char* value) Dictionary ADT
  Dictionary d1 = newDictionary();

  insert(d1, "1", "One");
  insert(d1, "2", "Two");
  insert(d1, "3", "Three");
  insert(d1, "4", "Four");
  insert(d1, "5", "Five");
  //d1.insert("3", "three");//This will cause the DuplicateKeyException
  if(isEmpty(d1)== 1){
   printf("Empty\n");
  }
  //Testing size() Dictionary ADT
  printf("Size: %d \n", size(d1));
  printDictionary(stdout, d1);
  //printf("Running");
  //Testing printDictionary() Dictionary ADT
  //printDictionary("out", d1);

  //Testing lookup(String key) Dictionary ADT

  //printDictionary(stdout, d1);
  printf("The Value in Key 3 is %s \n", lookup(d1, "3"));
  printf("The Value in Key 5 is %s \n", lookup(d1, "5"));
  printf("The Value in Key 4 is %s \n", lookup(d1, "4"));
  printf("The Value in Key 1 is %s \n", lookup(d1, "1"));
  //insert(d1, "1", "One");//This will cause the program to end

  //Testing delete(Dictionary D, String key) Dictionary ADT
  delete(d1, "1");
  delete(d1, "2");
  delete(d1, "4");
  printDictionary(stdout, d1);
  printf("Size: %d \n", size(d1));
  if(isEmpty(d1)== 1){
   printf("Insert test1 failed \n");
  }

  //Testing makeEmpty() Dictionary ADT
  makeEmpty(d1);
  if(isEmpty(d1) == 1){
  printf("Dictionary has been Empty\n");
  }else{
  printf("makeEmpty() has error\n");
  }
  printf("Size: %d\n", size(d1));
  //delete(d1, "1");//This will cause the program to end
  printf("isEmpty %d\n", isEmpty(d1));
  printDictionary(stdout, d1);
  //Test the destructor for the Dictionary type
  freeDictionary(&d1);
  //delete(d1, "3");//This will cause the program to end

return(EXIT_SUCCESS);
}

