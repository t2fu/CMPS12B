
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include"Dictionary.h"

// private types --------------------------------------------------------------
// NodeObj
typedef struct NodeObj{
   int item;
   struct NodeObj* next;
} NodeObj;

// Node
typedef NodeObj* Node;

// newNode()
// constructor of the Node type
Node newNode(int x) {
   Node N = malloc(sizeof(NodeObj));
   assert(N!=NULL);
   N->item = x;
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

// Dictionary
typedef struct DictionaryObj{
   char* Key;
   char* Value;
   struct DictionaryObj* next;
} DictionaryObj;

typedef  DictionaryObj* Dictionary;
// newNode()
// constructor of the Node type
Dictionary newDictionary(void){
   Dictionary D = malloc(sizeof(DictionaryObj));
   assert(D!=NULL);
   D->Key = NULL;
   D->Value = NULL;
   return(D);
}

// freeNode()
// destructor for the Node type
void freeDictionary(Dictionary* pD){
   if( pD!=NULL && *pD!=NULL ){
      free(*pD);
      *pD = NULL;
   }
}
//----------------------------------------------------------------------------------------------------//
// isEmpty()
// returns 1 (true) if S is empty, 0 (false) otherwise
// pre: none
int isEmpty(Dictionary D){
   if( D==NULL ){
      //fprintf(stderr, "Stack Error: calling isEmpty() on NULL Stack reference\n");
      //exit(EXIT_FAILURE);
      return 1;
   }
   //return(D->numItems==0);
   return 0;
}

int size(Dictionary D){
    int size = 0;
    Dictionary current = D;
   if( D==NULL ){
      fprintf(stderr, "Dictionary Error: calling size on NULL Stack reference\n");
      exit(EXIT_FAILURE);
   }
   while( current != NULL) {
     size++;
      current=current->next;
   }
   return size;
}

char* lookup(Dictionary D, char* k){
 Dictionary current = D;
 char* value = NULL;

 while( current != NULL){

    if(strcmp(current->Key, k) == 0){
     value = current->Value;
    }
    current = current->next;
 }
 return value;
}

void insert(Dictionary D, char* k, char* v){
Dictionary current = D;

if(D == NULL){
    D->Key = k;
    D->Value = v;
}
else{
    current = D;
    while(current->next != NULL){
        current=current->next;
    }
    current->next->Key=k;
    current->next->Value=v;
}

}

void delete(Dictionary D, char* k){
    Dictionary Prev = NULL;

    if(strcmp(D->Key, k) == 0){
    D=D->next;
    }else{
    Dictionary current = D;

    while (current->next != NULL){
     if(strcmp(current->next->Key, k) == 0){
        current->next = current->next->next;
        break;
     }else{
     current = current->next;
     }
    }
    }

}

void makeEmpty(Dictionary D){

 if(D != NULL){
    D = NULL;
 }

}

void printDictionary(FILE* out, Dictionary D){
 Dictionary current = D;
 char* output="";

 if(D != NULL){

    while(current != NULL){
        char* s = ("%d %d\n" ,current->Key, current->Value);
        output = strcat(output, s);
        fprintf(out, output);
        current = current -> next;
    }

    fclose(out);
 }
}
/*int main(){
 return(EXIT_SUCCESS);
}
*/
