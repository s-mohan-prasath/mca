#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <limits.h>

void prob1();
void prob2();
void prob3();
void prob4();
//TODO: work on the problem 5, you got the logic but you don't know how to give the base condition for the recursive function
void prob5();
int min2(int,int);
int min3(int,int,int);
void print2DArray(int arr[][5],int n,int m);
int prob5Sum(int arr[][4],int row,int col,int n,int m);

int main()
{
    int arr[5][5] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{0,17,18,19,20},{21,22,23,24,25}};
    prob5();
    return 0;
}
void prob1(){
    int arr[5][5] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
    int sum = 0,i,j,ii,n,sumMajor=0,sumMinor=0,sumUpper=0,sumLower=0,ele;
    n = sizeof(arr)/sizeof(arr[0]);
    i = 0;
    j = 0;
    // find the major and minor diagonal sum
    while(i<n){
        sumMajor+=arr[i][j];
        sumMinor+=arr[i][n-1-j];
        ele = arr[i][ii];
        ii = 0;
        while(ii<n){
            if(i==ii){
                sumUpper+=ele;
                sumLower+=ele;
            }else if(ii>i){
                sumUpper+=ele;
            }else{
                sumLower+=ele;
            }
            ii++;
        }
        i++;
        j++;
    }
    printf("i) To compute the sum of the Major diagonal\n");
    printf("Sum of Major Diagonal is %d\n",sumMajor);
    printf("ii) To compute the sum of the Minor diagonal\n");
    printf("Sum of Minor Diagonal is %d\n",sumMinor);
    printf("iii) To compute the sum of the Upper Triangular Matrix\n");
    printf("Sum of Upper Triangular Matrix is %d\n",sumUpper);
    printf("iv) To compute the sum of the Lower Triangular Matrix\n");
    printf("Sum of Lower Triangular Matrix is %d\n",sumLower);
}
void prob2(){
    int arr[5][5] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{0,17,18,19,20},{21,22,23,24,25}};
    int i,j,pointI,pointJ,count,n,m;
    count = 0;
    n = sizeof(arr)/sizeof(arr[0]);
    m = sizeof(arr[0])/sizeof(arr[0][0]);
    for(i = 0;i<n;i++){
        for(j = 0;j<m;j++){
            if(arr[i][j]==0){
                pointI = i;
                pointJ = j;
                count++;
            }
        }
        if(count>1){
            break;
        }
    }
    if(count==1){
        for(j = 0;j<m;j++){
            arr[pointI][j] = 0;
        }
        for(i = 0;i<n;i++){
            arr[i][pointJ] = 0;
        }
    }
    print2DArray(arr,n,m);
}
void prob3(){
    printf("Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix. Note that it is the kth smallest element in the sorted order, not the kth distinct element.\n\n");
    int arr[5][5] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{0,17,18,19,20},{21,22,23,24,25}};
    int k,n=5;
    print2DArray(arr,5,5);
    printf("Enter the value of k : ");
    scanf("%d",&k);
    printf("The index of kth smallest element in the matrix is %d\n",arr[k/n][k%n-1]);
}
void prob4(){
    //int arr[][4] = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
    int arr[][6] = {{0,0,0,0,0,0},{0,1,1,0,0,0},{0,1,1,1,0,0},{0,0,1,0,0,0},{0,0,0,0,0,0}};
    int row,col,top,left,bottom,right,n,m,sides=0,total=0;
    n = sizeof(arr)/sizeof(arr[0]);
    m = sizeof(arr[0])/sizeof(arr[0][0]);
    for(int row = 0;row<n;row++){
        for(int col = 0;col<m;col++){
            if(arr[row][col]==1){
                top = ((row-1)<0) ? 1 : (arr[row-1][col]==1) ? 0 : 1;
                bottom = ((row+1)==n) ? 1 : (arr[row+1][col]==1) ? 0 : 1;
                left = ((col-1)<0) ? 1 : (arr[row][col-1]==1) ? 0 : 1;
                right = ((col+1)==m) ? 1 : (arr[row][col+1]==1) ? 0 : 1;
                sides = top+bottom+left+right;
                total+=sides;
            }
        }
    }
    printf("Perimeter of the Island is %d\n",total);
}
void prob5(){
    int arr[][4] = {{5,3,8,4},{2,1,6,3},{7,2,4,5},{9,6,1,3}};
    int n = sizeof(arr)/sizeof(arr[0]);
    int m = sizeof(arr[0])/sizeof(arr[0][0]);

    int mini=INT_MAX;
    int row = 0;
    for(int col = 0;col<m;col++){
        mini = min2(mini,prob5Sum(arr,row,col,n,m));
    }
    printf("The Minimum sum of the falling path is %d",mini);
}
int prob5Sum(int arr[][4],int row,int col,int n,int m){
    if(row==n-1){
        return arr[row][col];
    }else{
        int a,b,c;
        int sum;
        b = prob5Sum(arr,row+1,col,n,m);
        if(col-1>=0 && col+1<m){
            a = prob5Sum(arr,row+1,col-1,n,m);
            c = prob5Sum(arr,row+1,col+1,n,m);
            sum = min3(a,b,c);
        }
        else if(col-1>=0){
            a = prob5Sum(arr,row+1,col-1,n,m);
            sum = min2(a,b);
        }else if(col+1<m){
            c = prob5Sum(arr,row+1,col+1,n,m);
            sum = min2(b,c);
        }
        return arr[row][col] + sum;
    }
}
int min2(int a,int b){
    return (a<b) ? a:b;
}
int min3(int a,int b,int c){
    return min2(a,min2(b,c));
}
void print2DArray(int arr[][5],int n,int m){
    for(int i = 0;i<n;i++){
        for(int j = 0;j<m;j++){
            printf("%d\t",arr[i][j]);
        }
        printf("\n");
    }
}
