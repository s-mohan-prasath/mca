#include <stdio.h>
#include <stdlib.h>

void prob1();
void prob4();

int main()
{
    prob4();
    return 0;
}
void prob1(){

}

void prob4(){
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

    /*
    // to print the tmp array
    for(i = 0;i<row;i++){
        for(j = 0;j<2;j++){
            printf("%d, ",tmp[i][j]);
        }
    printf("\n");
    }
    */
}

