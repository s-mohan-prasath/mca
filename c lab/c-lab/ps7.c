
#include <stdio.h>
#include <stdlib.h>
#include "helpfulfunctions.h"

int checkRange(int,int,int,int);

void ps7_prob1(){

/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix
matrix. This matrix has the following properties:
- Integers in each row are sorted in ascending from left to right.
- Integers in each column are sorted in ascending from top to bottom.

Test case 1
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
target = 5
Output: true

*/

    int n,m,k;
    printf("Enter target : ");
    scanf("%d",&k);
    get2DArrayLen(&n,&m);
    int arr[n][m];
    get2DArray(n,m,&arr[0][0]);
    int i,end,s1,e1,m1,s2,e2,m2;
    i = 0;
    s1 = 0;
    e1 = m;
    while(s1<=e1){
        m1 = (s1+e1)/2;
        printf("bin 1 : mid = %d & value = %d\n\n",m1,arr[i][m1]);
        if(arr[i][m1]==k){
            printf("true");
            return;
        }else if(arr[i][m1]<k){
            s1=m1+1;
        }else{
            e1=m1-1;
        }
    }
    if(arr[i][m1]>k){
        i = 0;
        end = m1;
    }else{
        i = m1;
        end = m-1;
    }
    while(i<=end){
        s2 = 0;
        e2 = n;
        while(s2<=e2){
            m2 = (s2+e2)/2;
            printf("bin 2 : mid = %d & value = %d\n\n",m2,arr[m2][i]);
            if(arr[m2][i]==k){
                printf("true");
                return;
            }else if(arr[m2][i]<k){
                s2=m2+1;
            }else{
                e2=m2-1;
            }
        }
        i++;
    }
    printf("false");
}

void ps7_prob2(){

/*
2. You are given an integer array nums. You need to create a 2D array from nums satisfying
the following conditions:
� The 2D array should contain only the elements of the array nums.
� Each row in the 2D array contains distinct integers.
� The number of rows in the 2D array should be minimal.
Return the resulting array. If there are multiple answers, return any of them.
Note that the 2D array can have a different number of elements on each row.
Test Case 1:
Input: nums = [1,3,4,1,2,3,1]
Output: [[1,3,4,2],[1,3],[1]]
Explanation: We can create a 2D array that contains the following rows:
- 1,3,4,2
- 1,3
*/

    int i,j,k,onedlen,tmp;
    printf("Enter the length of Array : ");
    scanf("%d",&onedlen);
    int onedArray[onedlen];
    for(i = 0;i<onedlen;i++){
        printf("Enter the value (i=%d) : ",i);
        scanf("%d",&onedArray[i]);
    }
    //sort
    for(i = 0;i<onedlen;i++){
        for(j=i+1;j<onedlen;j++){
            if(onedArray[i]>onedArray[j]){
                tmp = onedArray[i];
                onedArray[i] = onedArray[j];
                onedArray[j] = tmp;
            }
        }
    }
    int len = 1;
    int *lengths = malloc(sizeof(int)*len);
    int **twod = malloc(sizeof(int *)*len);
    lengths[0] = 1;
    twod[0] = malloc(sizeof(int)*lengths[0]);
    i = 0;
    int prev = onedArray[0];
    twod[i][0] = prev;
    for(k=1;k<onedlen;k++){
        if(onedArray[k]!=prev){
            i = 0;
            lengths[i]++;
            twod[i] = realloc(twod[i],sizeof(int)*lengths[i]);
            twod[i][lengths[i]-1] = onedArray[k];
            prev = onedArray[k];
        }else{
            i++;
            if(i==len){
                len++;
                lengths = realloc(lengths,len*sizeof(int));
                twod = realloc(twod,len*sizeof(int *));
                lengths[len-1] = 1;
                twod[len-1] = malloc(sizeof(int)*lengths[len-1]);
                twod[len-1][0] = onedArray[k];
            }else{
                lengths[i]++;
                twod[i] = realloc(twod[i],sizeof(int)*lengths[i]);
                twod[i][lengths[i]-1] = onedArray[k];
            }
        }
    }
    //print 2d array
    for(i = 0;i<len;i++){
        for(j = 0;j<lengths[i];j++){
            printf("%d ",twod[i][j]);
        }
        printf("\n");
    }
}

int ps7_prob3(){

/*
Q3. Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
*/

    int n,m,i,j,k,diagFirstEle,iStart,jStart;
    get2DArrayLen(&n,&m);
    int arr[n][m];
    get2DArray(n,m,&arr[0][0]);
    k = n+m-1;
    iStart = n-1;
    jStart = 0;
    while(k>0){
        i = iStart;
        j = jStart;
        diagFirstEle = arr[i][j];
        while(checkRange(i,j,n,m)==1){
            if(arr[i][j]!=diagFirstEle){
                printf("Given matrix is not a toeplitz matrix\n");
                return 0;
            }
            i++;
            j++;
        }
        printf("\n");
        if(iStart==0){
            jStart++;
        }else{
            iStart--;
        }
        --k;
    }
    printf("Given matrix is a Toeplitz matrix\n");
    return 1;
}

void ps7_prob4(){

/*
Q4. You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's
(representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's
will appear to the left of all the 0's in each row.
A row i is weaker than a row j if one of the following is true:
� The number of soldiers in row i is less than the number of soldiers in row j.
� Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
Test Case 1:
Input: mat =
[[1,1,0,0,0],
[1,1,1,1,0],
[1,0,0,0,0],
[1,1,0,0,0],
[1,1,1,1,1]],
k = 3
Output: [2,0,3]
*/

    int i,j,k,ii,row,col,count,x,y;
    printf("Enter The Weakest row k : ");
    scanf("%d",&k);
    printf("Enter Number of Rows : ");
    scanf("%d",&row);
    printf("Enter Number of Columns : ");
    scanf("%d",&col);
    int arr[row][col];
    int tmp[row][2];
    printf("Enter Number of Soldiers in Each Row - \n");
    i = 0;
    while(i<row){
        printf("Enter Number : ");
        scanf("%d",&count);
        tmp[i][0] = count;
        tmp[i][1] = i;
        j = 0;
        while(j<col){
            if(j<count){
                arr[i][j] = 1;
            }else{
                arr[i][j] = 0;
            }
            j++;
        }
        i++;
    }

    // SORTING THE ROWS of tmp

    for(i=0;i<row;i++){
        for(j=i+1;j<row;j++){
            if((tmp[i][0] > tmp[j][0]) || (tmp[i][0] == tmp[j][0] && tmp[i][1] > tmp[j][1])){
                x = tmp[i][0];
                tmp[i][0] = tmp[j][0];
                tmp[j][0] = x;
                y = tmp[i][1];
                tmp[i][1] = tmp[j][1];
                tmp[j][1] = y;
            }
        }
    }
    i = 0;
    printf("\nWeakest Row Indices...\n");
    while(i<k){
        printf("%d ",tmp[i][1]);
        i++;
    }
}

void ps7_prob5(){

/*
Q5. Anti-theft security devices are activated inside a bank. You are given a 0-indexed binary
string array bank representing the floor plan of the bank, which is an m x n 2D matrix.
bank[i] represents the ith row, consisting of '0's and '1's. '0' means the cell is empty, while'1'
means the cell has a security device.
There is one laser beam between any two security devices if both conditions are met:
� The two devices are located on two different rows: r1 and r2, where r1 < r2.
� For each row i where r1 < i < r2, there are no security devices in the ith row.
Laser beams are independent, i.e., one beam does not interfere nor join with another.
Return the total number of laser beams in the bank.
*/


    // NOTE : GIVE COLUMN SIZE m+1 and give for j = mth index value as 0
    // because - arr[n-1][m-1] value stores '\0' character, you cannot give 1 in that (n-1)(m-1) index
    int n,m,i,j,currOnes,prevOnes,noOfBeams;
    printf("Find the number of laser beams inside the bank\n\n");
    printf("NOTE : GIVE COLUMN SIZE m+1 and give for j = mth index value as 0\n");
    printf("because -> arr[n-1][m-1] value stores null character, you cannot give 1 in that (n-1)(m-1) index\n");
    get2DArrayLen(&n,&m);
    char arr[n][m];
    for(i = 0;i<n;i++){
        printf("Enter the column string : ");
        scanf("%s",arr[i]);
    }
    noOfBeams = 0;
    prevOnes = 0;
    for(i=0;i<n;i++){
        currOnes = 0;
        j = 0;
        while(j<m){
            if(arr[i][j]=='1')currOnes++;
            j++;
        }
        if(currOnes != 0){
            if(prevOnes!=0){
            noOfBeams += (prevOnes*currOnes);
            }
            prevOnes = currOnes;
        }
    }
    printf("No of Laser Beams in the Bank is %d",noOfBeams);
}

int checkRange(int i,int j,int n,int m){
    if(i>=0 && i<n && j>=0 && j<m)return 1;
    return 0;
}

