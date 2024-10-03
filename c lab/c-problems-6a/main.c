#include <stdio.h>
#include <stdlib.h>

void prob1();
void print2DArray(int arr[][5],int n,int m);

int main()
{
    prob2();
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
void print2DArray(int arr[][5],int n,int m){
    for(int i = 0;i<n;i++){
        for(int j = 0;j<m;j++){
            printf("%d\t",arr[i][j]);
        }
        printf("\n");
    }
}
