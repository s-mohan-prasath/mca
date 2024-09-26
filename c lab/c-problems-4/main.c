#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void getArrayLen(int *len);
void getArray(int len,int *arr);
void printArray(int len,int *arr);
void prob3();

int main()
{

    return 0;
}

void prob3(){
    int l,temp;
    printf("LENGTH OF THE ARRAY SHOULD BE EVEN \n");
    getArrayLen(&l);
    if(l%2!=0){
        printf("ERROR : number of elements should be even");
        return;
    }
    printf("ARRAY SHOULD HAVE EQUAL NUMBER OF POSITIVE AND NEGATIVE NUMBERS\n");
    int arr[l];
    getArray(l,arr);
    if(l==3){
        if(!(arr[0]>=0 && arr[2]>=0) || !(arr[0]<0 && arr[2]<0)){
            temp = arr[0];
            arr[0]=arr[1];
            arr[1]=temp;
        }
    }else if(l>3){
        int i,j;
        i = 0;
        j = 1;
        while(i<l && j<l){
            while(arr[i] >= 0)i+=2;
            while(arr[j] < 0)j+=2;
            if(i>l || j>l){
                break;
            }
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    printArray(l,arr);
}

void prob8(){
    printf("\nWrite a C program to find all pairs on integer array whose sum is equal to given number\n");
    int len;
    getArrayLen(&len);
    int arr[len];
    getArray(len,arr);
    int k;
    printf("Enter the value of the sum of the pairs : ");
    scanf("%d",&k);
    printf("Pair of Element are : \n");
    for(int i = 0;i<len;i++){
        for(int j = i+1;j<len;j++){
            if(arr[i] + arr[j]==k){
                printf("(%d,%d) ",arr[i],arr[j]);
            }
        }
    }
}

void prob7(){

    int len;
    getArrayLen(&len);
    int arr[len];
    getArray(len,arr);

    printf("\nWrite a C program to find sub array with maximum sum in an array of positive and negative number.\n");
    int start,end,i;
    i = 0;
    sum = 0;
    maxSum = 0;
    while(i<len){
        if(sum<=0){
            sum = arr[i];
            maxSum = max(sum,arr[i]);
        }else{

        }
        i++;
    }
}

// HELPER FUNCTION

void getArrayLen(int *len){
    printf("Enter the length of Array : ");
    scanf("%d",len);
}

void getArray(int len,int *arr){
    for(int i = 0;i<len;i++){
        printf("Enter Element (i=%d) : ",i);
        scanf("%d",&arr[i]);
    }
}

void printArray(int len,int *arr){
    printf("Elements are :\n");
    for(int i = 0;i<len;i++){
        printf("%d ",arr[i]);
    }
    printf("\n");
}






