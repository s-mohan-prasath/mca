#include <stdio.h>
#include <stdlib.h>

void getArray(int,int * arr);
void getArrayLen(int*len);
//TODO: work on prob1
void prob1();

int main()
{
    prob1();
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
    int i,j,k,len;

    int section1[] = {101,102,103,101};
    int section2[] = {103,104,105};
    int section3[] = {106,107,102};

    int len1,len2,len3;
    len1 = sizeof(section1)/sizeof(section1[0]);
    len2 = sizeof(section2)/sizeof(section2[0]);
    len3 = sizeof(section3)/sizeof(section3[0]);
    len = len1+len2+len3;
    int merged[len];

    printf("Consolidate Sections: Merge multiple sections into a single list of item IDs.\n");
    int noOfArr = 0;
    i = 0;
    k = 0;
    while(i<len1){
        merged[k] = section1[i];
        k++;
        i++;
    }
    i = 0;
    while(i<len2){
        merged[k] = section2[i];
        i++;
        k++;
    }
    i = 0;
    while(i<len3){
        merged[k] = section3[i];
        k++;
        i++;
    }
    printArray(len,merged);

    int end1=0,end2=0;
    int temp[len];
    int noduplicate[len];
    i=0;
    k=0;
    while(i<len){
        ele = merged[i];
        j = 0;
        while(j<end1){
            if(ele==temp[j]){
                i++;
                continue;
            }
            j++;
        }
        noduplicate[end2] = ele;
        temp[end1] = ele;
        end1++;
        end2++;
        i++;
    }

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


