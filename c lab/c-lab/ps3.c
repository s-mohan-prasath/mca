#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "helpfulfunctions.h"

void ps3_prob1(){
    int n;
    getArrayLen(&n);
    int arr[n];
    getArray(n,arr);
    if(n==0 || n==1){
        printf("No second largest number exist");
    }
    else if(n==2){
        if(arr[0]>arr[1]){
            printf("Second largest number is %d\n",arr[1]);
        }
        else{
            printf("Second largest number is %d\n",arr[0]);
        }

    }
    for(int i = 0;i<2;i++){
        for(int j=i+1;j<n;j++){
            if(arr[i]<arr[j]){
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
    printf("Second largest number is %d\n",arr[1]);
}

void ps3_prob2(){
    int n;
    getArrayLen(&n);
    int arr[n];
    getArray(n,arr);
    printf("Elements in Ascending order\n");
    sortArray(n,arr,'a');
    printArray(n,arr);
    printf("\nElements in Descending order\n");
    sortArray(n,arr,'d');
    printArray(n,arr);
}

void ps3_prob3(){
    int n;
    getArrayLen(&n);
    int arr[n];
    getArray(n,arr);
    int k;
    printf("Enter the search value : ");
    scanf("%d",&k);
    for(int i = 0;i<n;i++){
        if(k==arr[i]){
            printf("value = %d and index = %d\n",k,i);
            break;
        }
    }
    printf("value = %d is not present in the array",k);
}

void ps3_prob4(){
    int positives=0,negatives=0,evens=0,odds=0,n;
    getArrayLen(&n);
    int arr[n];
    getArray(n,arr);
    for(int i=0;i<n;i++){
        int num = arr[i];
        if(num>=0){
            positives++;
        }else{
            negatives++;
        }
        if(num%2==0){
            evens++;
        }else{
            odds++;
        }
    }
    printf("Number of Positive Numbers is %d\n",positives);
    printf("Number of Negative Numbers is %d\n",negatives);
    printf("Number of Even Numbers is %d\n",evens);
    printf("Number of Odd Numbers is %d\n",odds);
}

void ps3_prob5(){
    int n;
    getArrayLen(&n);
    int arr[n];
    getArray(n,arr);
    for(int i = 0;i<n;i++){
        for(int j = i+1;j<n;j++){
            if(arr[i]==arr[j]){
                printf("Array Contains Duplicates\n");
                return;
            }
        }
    }
    printf("No Duplicates present in the array\n");
    return;
}

void ps3_prob6(){
    int n,mid,temp;
    getArrayLen(&n);
    int arr[n];
    getArray(n,arr);
    mid = n/2;
    for(int i = 0;i<mid;i++){
        temp = arr[i];
        arr[i] = arr[n-i-1];
        arr[n-i-1] = temp;
    }
    printArray(n,arr);
}

void ps3_prob7(){
    int n;
    getArrayLen(&n);
    int arr[n];
    getArray(n,arr);
    int k;
    printf("\nEnter the value of k : ");
    scanf("%d",&k);
    int t = ceil((float)n/k);
    int times[n];
    int i = 0;
    while(i<n){
        int count = 0;
        for(int j=0;j<n;j++){
            if(arr[i]==arr[j])count++;
        }
        times[i] = count;
        i++;
    }
    int finalArr[n];
    int end = 0;
    for(i=0;i<n;i++){
        if(times[i]>t && findElementInArray(end,finalArr,arr[i])==0){
            printf("%d ",arr[i]);
            finalArr[end] = arr[i];
            end++;
        }
    }
    printf("\n");
}

void ps3_prob8(){
    int i,j,n,key,start,end;
    getArrayLen(&n);
    printf("Enter the value of key to rotate : ");
    scanf("%d",&key);
    end = n;
    int arr[n];
    getArray(n,arr);
    for(int t=0;t<key;t++){
        for(i=0;i<n-1;i++){
            //int temp = arr[i];
            //arr[i] = arr[i+1];
            //arr[i+1] = temp;
            arr[i] = arr[i]+arr[i+1];
            arr[i+1] = arr[i]-arr[i+1];
            arr[i] = arr[i]-arr[i+1];
        }
    }
    printf("Array is rotated by %d\n",key);
    printArray(n,arr);
}

void ps3_prob9(){
    int n1=5,n2=7;
    int arr1[5] = {-2,-1,0,1,2};
    int arr2[7] = {0,1,2,3,4,5,6};
    int merged[n1+n2];
    int i=0,j=0,k=0,arr1Exceed = 0,arr2Exceed = 0;
    int a=arr1[i],b=arr2[j];
    while(arr1Exceed!=1 || arr2Exceed!=1){
        if(arr1Exceed==1){
            merged[k] = b;
            j++;
        }
        else if(arr2Exceed==1){
            merged[k] = a;
            i++;
        }else if(a>=b){
            merged[k] = b;
            j++;
        }else{
            merged[k] = a;
            i++;
        }
        k++;
        if(i>=n1){
            arr1Exceed=1;
        }else{
            a = arr1[i];
        }
        if(j>=n2){
            arr2Exceed=1;
        }else{
            b = arr2[j];
        }
    }
    printf("Merged Array\n");
    printArray(k,merged);

}

//ERROR LOGS
/*
problem 1 errors
Z:\CODING\SEM1\C Lab\workout\c-problems-3\main.c|14|error: expected ')' before 'or'|

problem 5 errors
Z:\CODING\SEM1\C Lab\workout\c-problems-3\main.c|103|error: too few arguments to function 'getArrayLen'|

problem 6 errors
Z:\CODING\SEM1\C Lab\workout\c-problems-3\main.c|15|error: 'n' undeclared (first use in this function)|

problem 8 errors
Z:\CODING\SEM1\C Lab\workout\c-problems-3\main.c|146|error: 't' undeclared (first use in this function)|

problem 9 errors
variable sized objects may not be initialized

*/
