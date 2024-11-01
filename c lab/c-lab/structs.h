struct Node{
    int data;
    struct Node *link;
};
struct LinkedList{
    struct Node * head;
    struct Node * tail;
    int length;
};
//node functions
struct Node* createNode(int data);


//linkedlist functions
struct LinkedList* createLinkedList();
void addNodeToLinkedList(struct LinkedList*ll,int data);
void printLinkedList(struct LinkedList *ll);
int findInLinkedList(struct LinkedList*ll,int target);
