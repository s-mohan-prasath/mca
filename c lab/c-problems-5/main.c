#include <stdio.h>
#include <stdlib.h>

void getArray(int,int * arr);
void getArrayLen(int*len);
//TODO: work on prob1
void prob1();

int main()
{
    printf("Hello world!\n");
    return 0;
}

void prob1(){
    /*
    1. You work for a logistics company that manages a large warehouse. The warehouse has
different sections where items are stored. Each section is represented by an array of item
IDs, and each ID represents a unique item. Your manager has asked you to perform the
following tasks to reorganize the warehouse:
1. Consolidate Sections: Merge multiple sections into a single list of item IDs.
2. Remove Duplicates: Ensure that each item ID appears only once in the final list.
3. Sort Items: Sort the item IDs in ascending order
    */
    int i,len;
    getArrayLen(&len);
    int arr[len];
    getArray(len,arr);

    int section1[] = {101,102,103,101};
    int section2[] = {103,104,105};
    int section3[] = {106,107,102};

    int len1,len2,len3;
    len1 = sizeof(section1)/sizeof(arr[0]);
    len2 = sizeof(section2)/sizeof(arr[0]);
    len3 = sizeof(section3)/sizeof(arr[0]);
}

void getArrayLen(int *len)
{
    printf("Enter the length of Array : ");
    scanf("%d", len);
}

void getArray(int len, int *arr)
{
    for (int i = 0; i < len; i++)
    {
        printf("Enter Element (i=%d) : ", i);
        scanf("%d", &arr[i]);
    }
}

void printArray(int len, int *arr)
{
    printf("Elements are :\n");
    for (int i = 0; i < len; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");
}


