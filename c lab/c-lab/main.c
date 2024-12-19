#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include "ps1.h"
#include "ps2.h"
#include "ps3.h"
#include "ps4.h"
#include "ps5.h"
#include "ps6a.h"
#include "ps7.h"
#include "ps8.h"
#include "string_ps.h"
#include "ps10.h"
#include "structs.h"
#include "ca2lab.h"
#include "files.h"
#include <time.h>

void fun(int n,int m,int *matrix){
    for(int i = 0;i<n;i++){
        for(int j=0;j<m;j++){
            printf("%d\t",*(matrix+i*m+j));
        }
        printf("\n");
    }
}
void nice(int n,int m,int (*matrix)[m]){
    for(int i = 0;i<n;i++){
        printf("%d",*((*matrix++)+1));
        printf("\n");
    }
}
int main()
{
    int matrix[][4] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    //fun(3,4,matrix[0]);
    nice(3,4,matrix);
    //fileCRUD();
    return 0;
}








