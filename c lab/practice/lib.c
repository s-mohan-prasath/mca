#include "lib.h"
#include <stdio.h>
#include <stdlib.h>

struct Node* createNode(int data){
    struct Node* n = malloc(sizeof(struct Node));
    n->data = data;
    n->link = NULL;
    return n;
};
struct LinkedList* createLinkedList(){
    struct LinkedList* ll = malloc(sizeof(struct LinkedList));
    ll->head = NULL;
    ll->tail = NULL;
    ll->length = 0;
    return ll;
};
void addNodeToLinkedList(struct LinkedList*ll,int data){
    struct Node* tmp = ll->head;
    struct Node* newNode = createNode(data);
    if(tmp==NULL){
        ll->head = newNode;
        ll->tail = newNode;
    }else{
        while(tmp->link != NULL){
            tmp = tmp->link;
        }
        tmp->link = newNode;
        ll->tail = newNode;
    }
    ll->length +=1;
}
int findInLinkedList(struct LinkedList*ll,int target){
    struct Node* tmp = ll->head;
    while(tmp->link != NULL){
        if(tmp->data==target)return 1;
        tmp=tmp->link;
    }return 0;
}
void printLinkedList(struct LinkedList *ll){
    struct Node *tmp = ll->head;
    while(tmp != NULL){
        printf("%d -> ",tmp->data);
        tmp = tmp->link;
    }
}

