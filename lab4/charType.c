/*
 * charType.c
 * Programmer: Tiancheng Fu
 * CMPS 12M
 * Date: July 26th, 2018
 * Cruzid: tfu6
 * The charType.c allows the user input two command line arguments giving the input and output file names respectively.
 * Then the program will classifies the characters on line of the input file into following categories: alphabetic characters (upper or lower case),
 * numeric characters (digits 0-9), punctuation, and white space (space, tab, or newline); this classification process will done with
 * the void function extract_chars, which have 5 parameters and adding classified alphabetic, numeric, punctuation, and whitespace characters
 * into each corresponding variable. The specific functions of the program functions and codes are listed in the comments.
 */
 //Insert the library header files
#include<stdio.h>
#include<ctype.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>

#define MAX_STRING_LENGTH 100

int main(int argc, char* argv[]){
 FILE* in; /* File handle for input */
 FILE* out; /* File handle for output */

 char* inputA; // String holding all alphabetic characters
 char* inputD; // String holding all numeric characters (D for Digit)
 char* inputP; // String holding all punctuation characters
 char* inputW; // String holding all whitespace characters
 char* line [MAX_STRING_LENGTH]; // String array holding data from each input line

 int lineNum = 0; //Integer holding the numbers of the input lines

   //Check command line for correct number of arguments
   if( argc < 3 ){
      printf("Usage: %s <input file> <output file>\n", argv[0]);
      exit(EXIT_FAILURE); //End the program
    }

   //Open input file for reading and print out error if the program is unable to read from the corresponding file
   if( (in=fopen(argv[1], "r"))==NULL ){
      printf("Unable to read from file %s\n", argv[1]);
      exit(EXIT_FAILURE); //End the program
    }

   //Open output file for writing and print out error if the program is unable to print to the corresponding file
   if( (out=fopen(argv[2], "w"))==NULL ){
      printf("Unable to write to file %s\n", argv[2]);
      exit(EXIT_FAILURE); //End the program
    }

   //Allocate strings inputA, inputD, inputP, and inputW from heap memory
   inputA = calloc(MAX_STRING_LENGTH+1, sizeof(char));
   inputD = calloc(MAX_STRING_LENGTH+1, sizeof(char));
   inputP = calloc(MAX_STRING_LENGTH+1, sizeof(char));
   inputW = calloc(MAX_STRING_LENGTH+1, sizeof(char));
   assert( line!=NULL && inputA!=NULL && inputD!=NULL && inputP!=NULL && inputW!=NULL);

    /* Read each line in the input file, extract the characters into appropriate character arrays */
    while(fgets(line, sizeof line, in) != NULL){

     /* Print results into the file */
     ++lineNum; //Count the line number of the input line

     extract_chars(line, inputA, inputD, inputP, inputW);
     fprintf(out, "line %d contains:\n", lineNum);

     fprintf(out, "%d alphabetic characters: %s\n", strlen(inputA), inputA);
     fprintf(out, "%d numeric characters: %s\n", strlen(inputD), inputD);
     fprintf(out, "%d punctuation characters: %s\n", strlen(inputP), inputP);
     fprintf(out, "%d whitespace characters: %s\n", strlen(inputW), inputW);

   }

   // Free heap memory associated with string variables line, inputA, inputD, inputP, and inputW
   free(inputA);
   free(inputD);
   free(inputP);
   free(inputW);

   // Close input and output files
   fclose(in);
   fclose(out);
   //End the program after it successfully executed
   return EXIT_SUCCESS;
  }
/*
 *The extract_chars void function will done with classify characters in the input lines into 4 categories and store them into appropriate output
 *output character arrays. The void function extract_chars have 5 parameters, a(alphabetic), d(digits), p(punctuation), and w(whitespace);
 *The function's four classification categories are: alphabetic(upper or lower case), numeric(digits 0-9), punctuation, and whitespace characters(space, tab, or newline).
 */
void extract_chars(char* s, char* a, char* d, char* p, char* w){
   // Integer variables use to represent the current positions of the character arrays
   int i=0, j1=0;
   int j2=0;
   int j3=0;
   int j4=0;

   while(s[i]!='\0' &&i < MAX_STRING_LENGTH){
      //Check if the character is a numeric(digits 0-9) character
      if( isdigit(s[i])){
       d[j1] = s[i];
       j1++;
      }
      //Check if the character is a whitespace(space, tab, or newline) character
      else if( isspace( s[i])){
      w[j4] = s[i];
      j4++;}
      //Check if the character is an alphabetic(upper or lower case) character
      else if( isalpha( s[i] )){
       a[j2] = s[i];
       j2++;
      }
      //Check if the character is a punctuation character
      else if( ispunct( s[i])){
       p[j3] = s[i];
       j3++;
      }
      i++;//change to the next character in the input line
   }

   // The output arrays will each be terminated by the null character '\0', making them into valid C strings
   d[j1] = '\0';
   a[j2] = '\0';
   p[j3] = '\0';
   w[j4] = '\0';
}
