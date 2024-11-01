#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <limits.h>
#include "helpfulfunctions.h"

int ps6a_prob5Sum(int *arr,int row,int col,int n,int m);

void ps6a_prob1(){
/*
1) Given a square matrix A[5][5], write code to perform the following operations.
a. To compute sum of the major diagonal
b. To compute sum of minor diagonal
c. To compute sum of the elements in the upper triangular matrix
d. To compute the sum of the elements in the lower triangular matrix
*/
    int n,m;
    get2DArrayLen(&n,&m);
    int arr[n][m];
    get2DArray(n,n,arr[0]);
    int sum = 0,i,j,ii,sumMajor=0,sumMinor=0,sumUpper=0,sumLower=0,ele;
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
void ps6a_prob2(){

/*
2) Given a m x n matrix, consisting exactly of a single zero, set its entire row and column to 0.
*/

    int n,m;
    get2DArrayLen(&n,&m);
    int arr[n][m];
    get2DArray(n,m,arr[0]);

    int i,j,count;
    count = 0;

    int i_s[n];
    int j_s[m];
    // make all the elements in i_s and j_s to 0
    for(i=0;i<n;i++){
        i_s[i] = 0;
    }
    for(i=0;i<m;i++){
        j_s[i] = 0;
    }
    // find the index i,j for which arr[i][j] == 0
    for(i=0;i<n;i++){
        for(j=0;j<m;j++){
            if(arr[i][j]==0){
                i_s[i] = 1;
                j_s[j] = 1;
            }
        }
    }
    printArray(n,i_s);
    printArray(m,j_s);
    // change the ith and jth row elements to zero
    for(i = 0;i<n;i++){
        if(i_s[i]==1){
            for(j=0;j<m;j++){
                arr[i][j] = 0;
            }
        }
    }
    for(j = 0;j<m;j++){
        if(j_s[j]==1){
            for(i=0;i<n;i++){
                arr[i][j] = 0;
            }
        }
    }
    print2DPointerArray(n,m,arr[0]);
}
void ps6a_prob3(){

/*
Given an n x n matrix where each of the rows and columns is sorted in ascending
order, return the kth smallest element in the matrix. Note that it is the kth smallest
element in the sorted order, not the kth distinct element.
*/
    printf("find the kth smallest element\n");
    int n,m,i,j,k,count;
    get2DArrayLen(&n,&m);
    printf("enter the value of k : ");
    scanf("%d",&k);
    if(k>n*m){
        printf("k is invalid\n");
        return;
    }
    int arr[n][m];
    get2DArray(n,m,arr[0]);

    int pointJ[n];
    for(i = 0;i<n;i++){
        pointJ[i]=0;
    }
    int minI,minJ,minValue,val;
    minI = 0;
    minValue = INT_MAX;
    for(count=1;count<=k;count++){
        for(i = 0;i<n;i++){
            j = pointJ[i];
            if(j<m){
                val = arr[i][j];
                if(minValue>val){
                    minValue = val;
                    minI = i;
                }
            }
        }
        pointJ[minI]++;
        printf("num : %d - %d\n",count,minValue);
        if(count!=k){
            minValue = INT_MAX;
        }
    }
    printf("kth smallest integer in the sorted 2D array : %d",minValue);
}
void ps6a_prob4(){

/*
4) You are given row x col grid representing a map where grid[i][j] = 1 represents land
and grid[i][j] = 0 represents water. Grid cells are connected horizontally/vertically
(not diagonally). The grid is completely surrounded by water, and there is exactly one
island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water
around the island. One cell is a square with side length 1. The grid is rectangular,
width and height don't exceed 100. Determine the perimeter of the island.
*/
    int n,m;
    get2DArrayLen(&n,&m);
    int arr[n][m];
    get2DArray(n,m,arr[0]);
    int row,col,top,left,bottom,right,sides=0,total=0;
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
void ps6a_prob5(){

/*
Given an n x n array of integers matrix, return the minimum sum of any falling path
through matrix. A falling path starts at any element in the first row and chooses the
element in the next row that is either directly below or diagonally left/right.
Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row
+ 1, col), or (row + 1, col + 1).
*/

    int n,m;
    get2DArrayLen(&n,&m);
    int arr[n][m];
    get2DArray(n,m,arr[0]);

    int mini=INT_MAX;
    int row = 0;
    for(int col = 0;col<m;col++){
        mini = min2(mini,ps6a_prob5Sum(&arr[0][0],row,col,n,m));
    }
    printf("The Minimum sum of the falling path is %d",mini);
}
int ps6a_prob5Sum(int*arr,int row,int col,int n,int m){
    if(row==n-1){
        return *(arr+(row*m+col));
    }else{
        int a,b,c;
        int sum;
        b = ps6a_prob5Sum(arr,row+1,col,n,m);
        if(col-1>=0 && col+1<m){
            a = ps6a_prob5Sum(arr,row+1,col-1,n,m);
            c = ps6a_prob5Sum(arr,row+1,col+1,n,m);
            sum = min3(a,b,c);
        }
        else if(col-1>=0){
            a = ps6a_prob5Sum(arr,row+1,col-1,n,m);
            sum = min2(a,b);
        }else if(col+1<m){
            c = ps6a_prob5Sum(arr,row+1,col+1,n,m);
            sum = min2(b,c);
        }
        return *(arr+(row*m+col)) + sum;
    }
}