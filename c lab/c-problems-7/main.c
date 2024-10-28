#include <stdio.h>
#include <stdlib.h>

void prob1();
void prob4();

void get2DArray(int n,int m,int *arr);
void get2DArrayLen(int *n,int*m);

int main()
{
    prob1();
    return 0;
}
void prob1(){
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
}

void get2DArrayLen(int *n,int *m){
    printf("Enter number of rows (n) : ");
    scanf("%d",n);
    printf("Enter number of columns (m) : ");
    scanf("%d",m);
}
void get2DArray(int n,int m,int *arr){
    int i,j;
    for(i=0;i<n;i++){
        for(j=0;j<m;j++){
            printf("Enter (%d,%d) : ",i,j);
            scanf("%d",arr+(i*m+j));
        }
    }
}
