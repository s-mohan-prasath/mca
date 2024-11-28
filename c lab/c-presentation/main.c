#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void print2DArray(int n,int m,int *arr);
void printArray(int n,int *arr);
void sortAscending(long long n,int *arr);
long long powerOf(int a,int b);
void approach1(int k,int n,int m,int *matrix);
void approach2(int k,int n,int m,int *matrix);

int main()
{
    //----------------------APPROACH 1------------------------------
    //int arr[3][3] = {1,10,10,1,4,5,2,3,6};
    //approach1(7,3,3,&arr[0][0]);
    //----------------------APPROACH 2------------------------------
    int arr[3][4] = {1,10,10,11,1,4,5,15,2,3,6,20};
    approach2(25,3,4,&arr[0][0]);

    return 0;
}

void approach1(int k,int n,int m,int *matrix){
    long long size = powerOf(m,n);
    int sumArr[size];
    int sumArrPoint = 0;
    for(int j=0;j<m;j++){
        findSum_r(0,j,n,m,0,&sumArrPoint,sumArr,matrix);
    }
    sortAscending(size,sumArr);
    printArray(size,sumArr);
    printf("\n%dth smallest sum in the matrix : %d",k,*(sumArr+(k-1)));
}
void approach2(int k,int n,int m,int *matrix){
    if(n==1){
        return *(matrix+(k-1));
    }
    int *kSums = malloc(k*sizeof(int));
    int end = (k<m) ? k : m;
    int len = k*m;
    int *twoRowSums = malloc(len*sizeof(int));
    memcpy(kSums,matrix,end*sizeof(int));
    for(int i = 1;i<n;i++){
        for(int x=0;x<end;x++){
            for(int j = 0;j<m;j++){
                *(twoRowSums+(x*m+j))=kSums[x]+(*(matrix+(m*i+j)));
            }
        }
        if(end*m<k){
            end = end*m;
        }else{
            end = k;
            sortAscending(end*m,twoRowSums);
        }
        memcpy(kSums,twoRowSums,end*sizeof(int));
    }
    printf("\n%dth smallest sum in the matrix : %d",k,kSums[k-1]);
    return;
}
void findSum_r(int i,int j,int n,int m,int currSum,long long *sumArrPoint,int *sumArr,int *matrix){
    if(i==n-1){
        *(sumArr+(*sumArrPoint)) = currSum + *(matrix+(m*i+j));
        *sumArrPoint = *sumArrPoint + 1;
        return;
    }
    int ele = *(matrix + (m*i+j));
    for(int k = 0;k<m;k++){
        findSum_r(i+1,k,n,m,currSum+ele,sumArrPoint,sumArr,matrix);
    }
}
void sortAscending(long long n,int *arr){
    int temp;
    for(long long i = 0;i<n;i++){
        for(long long j=i+1;j<n;j++){
            if(arr[i]>arr[j]){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
long long powerOf(int a,int b){
    if(b==0)return 1;
    return a*powerOf(a,b-1);
}
void printArray(int n,int *arr){
    printf("\n");
    for(int i = 0;i<n;i++){
        printf("%d,",*(arr+i));
    }
}
void print2DArray(int n,int m,int *arr){
    for(int i = 0;i<n;i++){
        for(int j = 0;j<m;j++){
            printf("%d\t",*(arr+(i*m+j)));
        }
        printf("\n");
    }
}
