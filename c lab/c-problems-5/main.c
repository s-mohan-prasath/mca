#include <stdio.h>
#include <stdlib.h>

void getArray(int,int * arr);
void getArrayLen(int*len);
//TODO: work on prob1
void prob1();
void prob2();
void prob3();
void sortArray(int len,int *arr);
void findArrayStat(int len,int * arr,int *maxi,int *mini,int *sum,float *avg);

int main()
{
    prob3();
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
}

void prob2(){
    int len;
    getArrayLen(&len);
    int arr[len];
    getArray(len,arr);
    int k;
    printf("Enter the gift type to find : ");
    scanf("%d",&k);

    int count = 0;
    int i =0;
    while(i<len){
        if(arr[i]==k)count++;
        i++;
    }
    int output[count];
    i = 0;
    while(i<count){
        output[i] = k;
        i++;
    }
    printf("Days with Gift type %d is ",k);
    printArray(count,output);
    printf("Occurrences : %d",count);

}

void prob3(){
    printf("\nStudent Grade\n");
    int len;
    getArrayLen(&len);
    int arr[len];
    getArray(len,arr);
    int maxi,mini,sum;
    float avg;
    findArrayStat(len,arr,&maxi,&mini,&sum,&avg);
    printf("Average Grade : %f\n",avg);
    printf("Maximum Grade : %d\n",maxi);
    sortArray(len,arr);
    printf("Sorted Grade : ");
    printArray(len,arr);
}

void findArrayStat(int len,int *arr,int *maxi,int *mini,int *sum,float *avg){
    int maxiii,miniii,lsum;
    maxiii = arr[0];
    miniii = arr[0];
    lsum = 0;
    int i = 0;
    while(i<len){
        if(arr[i]>maxiii){
            maxiii = arr[i];
        }
        else if(arr[i]<miniii){
            miniii = arr[i];
        }
        lsum+=arr[i];
        i++;

    }
    *mini = miniii;
    *maxi = maxiii;
    *sum = lsum;
    *avg = ((float)lsum/len);
}

void sortArray(int len,int *arr){
    int temp;
    for(int i = 0;i<len;i++){
        for(int j = i;j<len;j++){
            if(arr[i]>arr[j]){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
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
    for (int i = 0; i < len; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");
}


