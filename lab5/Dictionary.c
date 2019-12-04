/*
 * Dictionary.c
 * Programmer: Tiancheng Fu
 * CMPS 12B
 * Date: August 14th, 2018
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
   N->Key = key;
   N->Value = value;
   N->next = NULL;
   return(N);
}

// freeNode()
// destructor for the Node type
void freeNode(Node* pN){
   if( pN!=NULL && *pN!=NULL ){
      free(*pN);
      *pN = NULL;
   }
}

// Declare DictionaryObj
typedef struct DictionaryObj{
   Node head;
} DictionaryObj;

// Dictionary
// Exported reference type
typedef struct DictionaryObj* Dictionary;

// newDictionary()
// constructor for the Dictionary type
Dictionary newDictionary(){
   Dictionary D = malloc(sizeof(DictionaryObj));
   assert(D!=NULL);
   D->head = NULL;
   //D->Value = NULL;
   return D;
}

// freeDictionary()
// destructor for the Dictionary type
void freeDictionary(Dictionary* pD){
   if( pD!=NULL && *pD!=NULL ){
      if( !isEmpty(*pD) ) makeEmpty(*pD);
      free(*pD);
      *pD = NULL;
   }
}

//helper function use to find the Node with designating Key in the Dictionary and returns the Node
Node findKey(Dictionary D, char* k){
 Node current = D->head;
 Node r = NULL;
 int s =0;

 while((current != NULL)&&(s == 0)){
    //printf(current->Key);
    if(strcmp(current->Key, k)== 0){
        s = 1;
        r = current;
        //printf("s%", current->Key);
    }
    current = current->next;
 }

 if(r != NULL){
    return r;
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
  //If the key been found then returns its associated value field, if the key has not been found then returns null
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
   Node current = D->head;
   //If the Dictionary contain at least one pair, isEmpty() will return true, else it will return false
   if( current==NULL ){
      return 1;
   }else{
   //return(D->numItems==0);
   //freeNode(&current);
   return 0;
  }
}

// size()
// returns the number of (key, value) pairs in D
// precondition: none
int size(Dictionary D){
    int size = 0;
    Node current = D->head;
   //Add one to int variable size for every pair in the Dictionary until all pairs in the Dictionary are checked
     while( current != NULL){ //better to keep a variable recording size which get updating on insert and delete
      size++;
      current=current->next;
    }
   //freeNode(&current);
   return size;
}



// insert()
// inserts new (key,value) pair into D
// precondition: lookup(D, k)==NULL
void insert(Dictionary D, char* k, char* v){
Node current=D->head;
//If the Dictionary does not currently contain a pair whose key matches the argument key, then the pair
//is added to the Dictionary
if(lookup(D, k) == NULL){ //only do this when the dictionary is empty
     if(D->head == NULL){
        D->head=newNode(k, v);
        //printf("INSERTED");
      }
       else{
         current = D->head;
    //Insert the pair into the last position in the Dictionary
          while(current->next != NULL){
            current=current->next;
          }
       current->next=newNode(k,v);
     }

  //If a pair in the Dictionary whose key matches the argument key, end the program
  }else{
  printf("cannot insert duplicate keys");
  exit(EXIT_FAILURE);
 }
}

// delete()
// deletes pair with the key k
// precondition: lookup(D, k)!=NULL
void delete(Dictionary D, char* k){
Node temp;
if(lookup(D, k) != NULL){
    //If the Dictionary currently contains a pair whose key field matches the argument key, then that pair is
    //removed from the Dictionary
    if(strcmp(D->head->Key, k) == 0){
       temp=D->head;
       D->head=D->head->next;
       freeNode(&temp);
    }else{
       Node current = D->head;
    //Check all of the pairs in the Dictionary for the designating pair
    while (current->next != NULL){
     if(strcmp(current->next->Key, k) == 0){//If the pair that next to the current pair is the designating pair, remove it by set it to the pair next to it
        temp=current->next;
        current->next = current->next->next;
        freeNode(&temp);
        break;// Terminate the while loop
     }else{//Else set the current pair to the pair that next to it

        current = current->next;

     }
    }
    //freeNode(&current);
   }
  //If no pair with the designating key exists in the dictionary, end the program
  }else{
   printf("cannot delete non-existent key");
   exit(EXIT_FAILURE);
  }
}

// makeEmpty()
// re-sets D to the empty state.
// precondition: none
void makeEmpty(Dictionary D){
 //If there are pairs exist in the Dictionary, empty it by set its head pair to null
   if(D->head != NULL){
      D->head = NULL;
   }

}

// printDictionary()
// precondition: none
// prints a text representation of D to the file pointed to by out
void printDictionary(FILE* out, Dictionary D){
 Node current = D->head;
 //char* output="Shit";//Store the String representation that will be returned

 if(D != NULL){//If there are pairs exist in the Dictionary

    //Add all of the String representations that exist in the Dictionary to String variable output
    while(current != NULL){
        //char* s;
        fprintf(out,"%s %s\n", current->Key, current->Value);
        current = current -> next;
    }
     //freeNode(&current);
     //fprintf(out,"%d", size(D));
    //fclose(out);
 }

}
