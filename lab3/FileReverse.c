/*
 * FileReverse.c
 * Programmer: Tiancheng Fu
 * CMPS 12M
 * Date: July 18th, 2018
 * Cruzid: tfu6
 * The program will allows the user to enter a input and an output file. The program will read the words in the input file
 * and split the words from the whitespaces and empty lines in between them. Then the program will
 * print out the words contain in the input file which have been split in backward order into the user entered output file.
 * The FileReverse.c is built based on the FileReverse.java from Lab Assignment 2 and FileIO.c from the Lab Assignment 3 pdf file.
 * The FileReverse.c includes a void type function called stringReverse(), which will reverse the characters of String variable s.
 * The specific functions of the functions and codes are listed in the comments.
 *
 */
 //Insert the library header files
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

  void stringReverse(char* s){//This void function will reverse the letters of a given word

  //Declare char array to store the letters from the given word s
  char* c [strlen(s)];

  //Insert the letters in given word s into char array c
  for(int i = 0; i < strlen(s); i++){
   c[i] = s[i];
  }
  int n = strlen(s);//Integer variable uses to store the length of the given word s

  //Reverse all the letters in the given word s by swap their position
  for(int j = n; j > strlen(s)/2; j--){

   s[strlen(s)-j] = c[j-1];//Copying the jth element from the left in c[] into the jth element from the right in word s
   s[j-1] = c[strlen(s)-j];//Copying the jth element from the right in c[] into the jth element from the left in word s

  }

}

//This function main will allow the user to enter an input file and an output file and split the words in the input file and use function stringReverse() to output those words in backward order in the user entered output file
int main(int argc, char* argv[]){
 FILE* in; /* File handle for input */
 FILE* out; /* File handle for output */

 char word[256]; /* Char array to store words from input file */
 /* Check command line for correct number of arguments */
 if( argc < 2 ){ /* Print out error statement if user entered less than two arguments */
 printf("Usage: %s <input file> <output file>\n", argv[0]);
 exit(EXIT_FAILURE);
 }

 /* Open input file for reading */
 in = fopen(argv[1], "r");
 if( in==NULL ){ /* Print out error statement if user entered input file is wrong */
 printf("Unable to read from file %s\n", argv[1]);
 exit(EXIT_FAILURE);
 }
 /* Open output file for writing */
 out = fopen(argv[2], "w");
 if( out==NULL ){ /* Print out error statement if user entered output file is wrong */
 printf("Unable to write to file %s\n", argv[2]);
 exit(EXIT_FAILURE);
 }

 /* Read words from input file and print on separate lines to output file after reversed them */
 while( fscanf(in, " %s", word) != EOF ){
  stringReverse(word);/* Reverse the word */
  fprintf(out, "%s\n", word); /* Print out the reversed word into the output file */
 }
 /* close input and output files and end the program */
 fclose(in);
 fclose(out);
 return(EXIT_SUCCESS);
}
