/*
 * Dictionary.c
 * Programmer: Tiancheng Fu
 * CMPS 12B
 * Date: August 15th, 2018
 * Cruzid: tfu6
 * Programming Assignment 5
 * This c file contain 7 different methods that implement Dictionary ADT and defined the constructor for the Dictionary and Node object.
 * based on hash-table and linked list data structures. The Dictionary ADT methods are isEmpty(Dictionary D), size(Dictionary D), lookup(Dictionary D, char* k),
 * insert(Dictionary D, char* k, char* v), delete(Dictionary D, char* k), makeEmpty(Dictionary D), printDictionary(FILE* out, Dictionary D).
 * The specific functions of the methods and codes are listed in the rest of comments.
 */

//Insert the library header files
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include"Dictionary.h"

const int tableSize = 101;
// private types --------------------------------------------------------------
// Declare NodeObj
typedef struct NodeObj{
   char* Key;
   char* Value;
   struct NodeObj* next;
} NodeObj;

// Node
typedef NodeObj* Node;

// newNode()
// constructor of the Node type
Node newNode(char* key, char* value) {
   Node N = malloc(sizeof(NodeObj));
   assert(N!=NULL);
   N->Key = calloc(strlen(key)+1, sizeof(char));
   strcpy(N->Key, key);
   N->Value = calloc(strlen(value)+1, sizeof(char));
   strcpy(N->Value, value);
   N->next = NULL;
   return(N);
}

// freeNode()
// destructor for the Node type
void freeNode(Node* pN){
   if( pN!=NULL && *pN!=NULL ){
      free((*pN)->Key);
      free((*pN)->Value);
      free(*pN);
      *pN = NULL;
   }
}

// Declare DictionaryObj
typedef struct DictionaryObj{
   Node * hashtable;
   int numItem;
} DictionaryObj;

// Dictionary
// Exported reference type
typedef struct DictionaryObj* Dictionary;

// newDictionary()
// constructor for the Dictionary type
Dictionary newDictionary(){
   Dictionary D = malloc(sizeof(DictionaryObj));
   D->hashtable = malloc(sizeof(NodeObj)*tableSize); // Declare the hash table in Dictionary
   D->numItem = 0; // The number of pairs in the Dictionary
   assert(D!=NULL);
   //D->Value = NULL;
   return D;
}

// freeDictionary()
// destructor for the Dictionary type
void freeDictionary(Dictionary* pD){
   if( pD!=NULL && *pD!=NULL ){
      if( !isEmpty(*pD) ){
        //Node *nd = pD->hashtable;
        //free(*nd);
        makeEmpty(*pD);
      }
      free((*pD)->hashtable);
      free(*pD);
      *pD = NULL;
   }
}

/* Below is functions for hash processes */
unsigned int rotate_left(unsigned int value, int shift) {
   int sizeInBits = 8*sizeof(unsigned int);
   shift = shift & (sizeInBits - 1);  // remainder of shift on division by sizeInBits
   if ( shift == 0 )
      return value;
   else
      return (value << shift) | (value >> (sizeInBits - shift)); // perform rotation
}

// pre_hash()
// turn a string into an unsigned int
unsigned int pre_hash(char* input) {  // input points to first char in string
   unsigned int result = 0xBAE86554;  // = 10111010111010000110010101010100, begin with a random looking bit pattern
   while (*input) {                   // while *input is not '\0' (not end of string)
      result ^= *input++;                // result = result ^ *input (current char alters result)
                                         // input++  (go to next char)
      result = rotate_left(result, 5);   // rotate result by fixed amount
   }
   return result;  // result is now a random looking bit pattern depending on input string
}

// hash()
// turns a string into an int in the range 0 to tableSize-1
int hash(char* key){
   return pre_hash(key)%tableSize;
}

// showBits()
// print out the bits in an unsigned int
void showBits(unsigned int x) {
   int i;
   int sizeInBits = 8*sizeof(unsigned int);
   char symbol[2] = {'0','1'};
   char* binary = malloc(sizeInBits + 1);

   memset(binary, 0, sizeInBits + 1);

   for (i=0; i<sizeInBits; i++) {
       binary[sizeInBits-i-1] = symbol[(x>>i) & 0x01];
   }

   printf("%s\n", binary);
   free(binary);
}
/* ------------------------------------------------------ */
// helper function use to find the Node with designating Key in the Dictionary and returns the Node
Node findKey(Dictionary D, char* k){
 Node current;
 if(D != NULL){
 int s = 0;
 int index = hash(k);

 current = D -> hashtable[index]; // set current to the first Node in the corresponding hash table
 // find the Node in the corresponding hash table and return the Node
 while (current != NULL){
    if(strcmp(current->Key, k)==0){
      break;
      s=1;
    }
    current = current->next;
   }

  }
 // if the Node is found in the dictionary return the Node, if not return NULL
 if(current != NULL){
    return current;
 }else{
 return NULL;
 }

}

// lookup()
// returns the value v such that (k, v) is in D, or returns NULL if not
// such value v exists.
// precondition: none
 char* lookup(Dictionary D, char* k){
  char* value;
  // using the helper function findKey() to find the pair with corresponding k value, if the key been found then returns its associated value field, if the key has not been found then returns null
  if(findKey(D, k) != NULL){
    value = findKey(D, k)->Value;
    return value;
  }else{
   return NULL;
  }
}

//----------------------------------------------------------------------------------------------------//
// isEmpty()
// returns 1 (true) if S is empty, 0 (false) otherwise
// precondition: none
int isEmpty(Dictionary D){
   //If the Dictionary contain zero pair or it is NULL, isEmpty() will return true (1), else it will return false (2)
   int s = 1;
   //if( D->hashtable == NULL || D->numItem == 0){
     // return 1;
   //}else{
   for(int i=0; i<tableSize; i++){
      Node current;
      if((D != NULL && D -> numItem > 0) || (D != NULL && D->hashtable[i] != NULL)){
        s = 0;
        break;
     }else{
        s = 1;
     }
   }
   return s;
}

// size()
// returns the number of (key, value) pairs in D
// precondition: none
int size(Dictionary D){
   //Add one to int variable size for every pair in the Dictionary until all pairs in the Dictionary are checked
     //while( current != NULL){ //better to keep a variable recording size which get updating on insert and delete
      //size++;
      //current=current->next;
    //}x`x`sq
   return D->numItem;
}



// insert()
// inserts new (key,value) pair into D
// precondition: lookup(D, k)==NULL
void insert(Dictionary D, char* k, char* v){
//If the Dictionary does not currently contain a pair whose key matches the argument key, then the pair
//is added to the Dictionary
Node current;
if(lookup(D, k) == NULL){
 // insert the new Node into the corresponding hash table
 int index = hash(k);
 current = D -> hashtable[index];

     if(D->hashtable[index] == NULL){// only do this when the current hash table is empty
        D -> hashtable[index] = newNode(k, v);
        //printf("INSERTED");
        D->numItem++;
      }else{// when the current hash table is not empty
        // insert the pair into the last position in the hash table
        while(current->next != NULL){
           current=current->next;
        }
       current->next=newNode(k,v);
       D->numItem++;
     }

  //If a pair in the Dictionary whose key matches the argument key, end the program and output an error statement
  }else{
  printf("cannot insert duplicate keys");
 }
}

// delete()
// deletes pair with the key k
// precondition: lookup(D, k)!=NULL
void delete(Dictionary D, char* k){
Node temp;
// if the Dictionary currently contains a pair whose key field matches the argument key, then that pair will be
// removed from the Dictionary
if(lookup(D, k) != NULL){
   // delete the pair from its corresponding hash table after the hash table been find
   int index = hash(k);
   Node head = D -> hashtable[index];
    // if the pair need to be deleted is the head Node in the current hash table, set the pair next to it to be the head of current hash table
    if(strcmp(head->Key, k) == 0){

       D->hashtable[index]=D->hashtable[index]->next;
       freeNode(&head);
       D->numItem--;
    // if the pair need to be deleted is not the head Node in the current hash table
    }else{
       Node current = D -> hashtable[index];
     // check all of the pairs in the hash table for the designating pair
    while (current->next != NULL){
     if(strcmp(current->next->Key, k) == 0){// if the pair that next to the current pair is the designating pair, remove it by set it to the pair next to it
        temp=current->next;
        current->next = current->next->next;
        freeNode(&temp);
        break;// Terminate the while loop
     }else{// else set the current pair to the pair that next to it

        current = current->next;

     }
    }
    //freeNode(&current);
    D->numItem--;
   }
  //If no pair with the designating key exists in the dictionary, end the program and output an error statement
  }else{
   printf("cannot delete non-existent key");
  }
}

// makeEmpty()
// re-sets D to the empty state.
// precondition: none
void makeEmpty(Dictionary D){
   //If the hash tables of the Dictionary is not NULL, empty it by set it to NULL
   for(int i=0; i<tableSize; i++){
     if(D -> hashtable[i] != NULL){
        Node current = D -> hashtable[i];
        Node temp;
       while(current != NULL){
        temp = current;
        current = current -> next;
        freeNode(&temp);
       }
     }
     D -> hashtable[i] = NULL;
   }

   D->numItem = 0;

}

// printDictionary()
// precondition: none
// prints a text representation of D to the file pointed to by out
void printDictionary(FILE* out, Dictionary D){

 if(D != NULL && D -> hashtable != NULL){// If the Dictionary D is not NULL
   // print out all of the String representations of pairs that exist in the Dictionary to String variable output
   for(int i=0; i<tableSize;i++){
    if(D -> hashtable[i] != NULL){
       Node current = D -> hashtable[i];
       //printf("%d", sizeof(D->hashtable[i]));
    // print out all of the String representations of pairs that exist in the current hash table to String variable output
    while(current != NULL && current->Key != NULL && current->Value !=NULL){
        //char* s;
        fprintf(out,"%s %s\n", current->Key, current->Value);

        //current = current -> next;
        break;
    }
     //freeNode(&current);
     //fprintf(out,"%d", size(D));
    //fclose(out);
    }
  }
 }

}
