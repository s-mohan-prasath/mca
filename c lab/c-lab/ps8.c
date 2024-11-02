#include <stdio.h>
#include <stdlib.h>
#include "helpfulfunctions.h"

//ps8_prob2
int gridMaxSum = 0;
int indexMaxValue;
int gI,gJ;

int ps8_prob1(){
/*
A maze is laid out on a two dimensional grid. At each grid square there is either a clue
telling you where to go to find a prize, or the prize itself! We model the grid as a 10 x
10 integer array. A value of 4 stored in the grid indicates the prize. Exactly 1 square in
the grid will store this value. All the other squares will store integers in between 0 and
3, inclusive. Assuming that your current location is row r, column c, a value of 0
indicates that you should move to row r-1, column c. A value of 1 indicates that you
should move to row r, column c+1. A value of 2 indicates that you should move to
row r+1, column c. A value of 3 indicates that you should move to row r, column c-1.
You are guaranteed that no move will take you out of the grid boundary. Write c
function below so that it takes in the grid, your current row location and your current
column location, and returns the number of moves you will take to get to the prize.
Note: your function should return 0 if the current location (curR, curC) has the
prize.

ALGORITHM NOTE:
if 0 - move up, 1 - move right, 2 - move down, 3 - move left
*/
    int n,m,curR,curC;
    get2DArrayLen(&n,&m);
    printf("Enter current row location (curR) : ");
    scanf("%d",&curR);
    printf("Enter current column location (curC) : ");
    scanf("%d",&curC);
    int arr[n][m];
    get2DArray(n,m,arr);
    int moves,dir;
    moves = 0;
    while(arr[curR][curC]!=4){
        dir = arr[curR][curC];
        switch(dir){
        case 0:
            curR--;
            break;
        case 1:
            curC++;
            break;
        case 2:
            curR++;
            break;
        case 3:
            curC--;
            break;
        default:
            printf("INVALID INPUT\n");
            break;
        }
        moves++;
    }
    printf("Number of moves to get prize : %d\n",moves);
    return moves;
}

int ps8_prob2(){
/*
2. A potential mining area is broken into a grid of 100 cells arranged in 10 rows and 10
columns. Using a sampling technique, the potential mining value of each cell has been
ascertained. The company is only willing to rent a 3 x 3 arrangement of the cells. We
define
the index of a 3 x 3 mining area to be 10 times the row number of its center cell plus
the
column number of its center cell. Complete the function below so that it takes in a two
dimensional integer array of size 10 x 10 storing the values of each mining cell and
returns
the index of the 3 x 3 mining area with the largest total value. You may assume that a
unique 3 x 3 mining area has maximal value. (Note: there will be four nested loops in
your
solution. Normally one would code an auxiliary function that sums the value of one
mining
area, but for this question, please write all of your code in this single funciton.)
int getIndexBestArea(int grid[][SIZE]);

use the following as input :
arr = 5 3 8 4 6 1 7 9 2 5 4 7 3 8 6 5 1 9 2 4 8 2 5 7 1 4 9 6 3 8 1 5 7 2 3 8 6 4 9 2 9 6 3 5 1 4 8 7 2 5 7 1 6 3 9 8 4 2 6 4 9 2 5 7 8 1 3 6 3 1 8 9 2 4 7 5 8 7 5 4 3 6 1 9 2 8 4 9 6 2 5 3 7 1 2 3 4 5 6 7
*/
    int n,m;
    get2DArrayLen(&n,&m);
    int arr[n][m];
    get2DArray(n,m,arr);

    int i,j,gridSum;
    int tl,tm,tr,ml,mm,mr,bl,bm,br;
    int index;

    for(i = 0;i<=7;i++){
        for(j=0;j<=7;j++){
            tl = arr[i][j];
            tm = arr[i][j+1];
            tr = arr[i][j+2];
            ml = arr[i+1][j];
            mm = arr[i+1][j+1];
            mr = arr[i+1][j+2];
            bl = arr[i+2][j];
            bm = arr[i+2][j+1];
            br = arr[i+2][j+2];
            gridSum = tl+tm+tr+ml+mm+mr+bl+bm+br;
            if(gridMaxSum<gridSum){
                gridMaxSum = gridSum;
                gI = i+1;
                gJ = j+1;
                indexMaxValue = 10 * (i+1) + (j+1);
            }
        }
    }
    printf("(%d,%d)",gI,gJ);
    printf("%dmaximum potential 3x3 grid index : %d",indexMaxValue);
    return indexMaxValue;
}

int ps8_prob3(){
/*
3. An escape room has a box with a puzzle on it, which is in the form of an n by n grid.
The grid can be modeled as a two dimensional square array of integers. There exists
exactly a single location on the grid where a key can be placed to open a box. The key
is modeled as a cross, with a center square, along with the square directly above it,
below it, to the left of it and to the right of it. In order for a cross to be opened by the
key, the value in the center square must be exactly one more than the values above,
below, to the left and to the right of the center square, and each of these four values
must be the same. Write a function that takes in the two dimensional array of integers
and the size of the grid (a single value that represents both the number of rows and
columns on the grid), and returns the location of the center square of the location
where the key fits. Since this location is both a row and column but only a single
integer is returned by the function, if the center of the key is at row r, column c, then
return the single integer rn + c, where n is the number of rows (and columns) in the
grid. The row, column numbering should be 0-based, with the first index into the
array indicating the row and the second index indicating the column. For example,
if the input into the function was the following grid shown below and n = 6, the
function should return 20, since the middle of the cross is at row 3, column 2, and 3*6
+ 2 = 20.
(The cross is highlighted and underlined.)

SAMPLE TESTCASE
arr[6][6] = {1 2 2 2 3 4 5 1 1 2 1 5 4 3 3 3 5 6 2 3 2 3 0 0 0 0 3 0 0 0 0 0 0 0 0 0}
*/
    int n,i,j,top,left,right,bottom,ele,index;
    printf("Enter the length of nxn grid : ");
    scanf("%d",&n);
    if(n<3){
        printf("Enter the value of n as greater than 2\n");
        return -1;
    }
    int arr[n][n];
    get2DArray(n,n,&arr[0][0]);

    for(i=1;i<n-1;i++){
        for(j=1;j<n-1;j++){
            top = arr[i-1][j];
            right = arr[i][j+1];
            bottom = arr[i+1][j];
            left = arr[i][j-1];
            ele = arr[i][j]+1;
            if(top==ele && right==ele && bottom==ele && left==ele){
                index = n*i+j;
                printf("index : %d",index);
                break;
            }
        }
    }
    return index;
}

int ps8_prob4(){
/*
Write a function that takes in a 10 x 10 integer array and determines if there exists
atleast
one row or one column that store the same value. (This is essentially similar to
checking
for a winner in tic-tac-toe without having to check the diagonals.) If such a row or
column exists, your function should return 1, otherwise it should return 0. You may
assume that the dimensions of grid are 10 x 10.
int hasSameRowOrCol(int grid[][SIZE]);

SAMPLE Testcase:
arr[5][5] = 1 2 3 4 5 6 7 8 9 10 10 10 10 10 10 11 12 13 14 15 16 17 18 19 20
arr[6][6] = 1 2 3 4 5 6 7 8 3 10 11 12 13 14 3 15 17 18 19 20 3 22 23 24 25 26 3 28 29 30 31 32 3 34 35 36
*/
    int n,i,j;
    printf("Enter the length of nxn grid : ");
    scanf("%d",&n);
    int arr[n][n];
    get2DArray(n,n,&arr[0][0]);

    int colTrack[n];
    int rowTrack[n];
    for(i = 0;i<n;i++){
        rowTrack[i] = colTrack[i] = n;
    }
    for(i = 0;i < n;i++){
        for(j = 0;j<n;j++){
            if(arr[i][j]==arr[0][j])colTrack[j]--;
            if(arr[i][j]==arr[i][0])rowTrack[i]--;
        }
    }
    for(i=0;i<n;i++){
        if(rowTrack[i]==0 || colTrack[i]==0){
            (rowTrack[i]==0) ? printf("row %d elements are same\n",i+1) : printf("column %d elements are same\n",i+1);
            return 1;
        }
    }
    printf("No row/column elements are same\n");
    return 0;
}

int ps8_prob5(){
/*
5. Superman must leap up and down a whole skyline of buildings in order to keep
Metropolis safe. It takes him no energy to leap down from a tall building to a shorter
one because hecan glide down with his cape. But, he does expend energy whenever he
must jump up froma shorter building to a taller one. You must write a function that
takes in the heights of thebuildings in feet of Metropolis in an integer array, along
with the length of the array, andreturn the total number of feet Superman must "jump
up" if he jumps from building tobuilding in order. For example, if there were six
buildings in Metropolis with the heights1000, 800, 750, 900, 800, 900, then Superman
would have to jump a height of 150 feetfrom the third building to the fourth and
another 100 feet from the fifth building to the sixthfor a total of 250 feet he must jump
up. Please use the prototype below.
int distanceJumped(int buildings[], int length);

SAMPLE INPUT
arr[6] = 1000 800 750 900 800 900
ouput = 250
*/
    int len;
    getArrayLen(&len);
    int arr[len];
    getArray(len,arr);
    int i = 0;
    int jumpUps = 0;
    while(i<len-1){
        if(arr[i]<arr[i+1]){
            jumpUps+=arr[i+1]-arr[i];
        }
        i++;
    }
    printf("The Total number of feet superman must jump up is %d\n",jumpUps);
    return jumpUps;
}


