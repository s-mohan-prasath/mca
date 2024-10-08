#include <stdio.h>
#include <stdlib.h>

void prob1();

int main()
{
    return 0;
}
void prob1(){
    int[][] arr = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
    int t = 5;

    int m,n;
    n = sizeof(arr)/sizeof(arr[0]);
    m = sizeof(arr[0])/sizeof(arr[0][0]);

    int i=0,j=m,mid,row,col,ele;
    while(i<j){
        mid = (i+j)/2;
        if( arr[0][mid] == t || arr[n-1][mid]==t )return true;
        else if(arr[])
        i++;
    }

}
