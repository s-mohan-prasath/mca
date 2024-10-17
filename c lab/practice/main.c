#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

void zoho_qn1();
void zoho_qn2();
int min2(int,int);
void maxAreaInSquare();

int main()
{
    maxAreaInSquare();
    return 0;
}

//ZOHO round 1 questions

void maxAreaInSquare(){

    int n,m,minI,i,j,ii,jj,start,end,area,count,maxArea,e;
    printf("Enter number of rows : ");
    scanf("%d",&n);
    printf("Enter number of columns : ");
    scanf("%d",&m);
    int arr[n][m];
    for(i=0;i<n;i++){
        for(j=0;j<m;j++){
            printf("enter number %d,%d : ",i,j);
            scanf("%d",&arr[i][j]);
        }
    }
    i = 0;
    minI = INT_MAX;
    maxArea = 0;
    start = -1;
    end = -1;
    while(i<n){
        j = 0;
        while(j<m){
            e = arr[i][j];
            if(e==1 && start == -1){
                start = j;
                end = start+1;
            }
            else if((e==0 && start !=-1) || (e==1 && j+1==m)){
                jj = start;
                if(e==1)end++;
                while(jj<end){
                    ii = i;
                    count = 0;
                    while(ii<n && arr[ii][jj] == 1){
                        ii++;
                        count++;
                    }
                    minI = min2(minI,count);
                    area = (jj-start+1)*minI;
                    maxArea = (area>maxArea) ? area : maxArea;
                    jj++;
                }
                minI = INT_MAX;
                start = -1;
                end = -1;
            }
            else if(e==1 && start !=-1)
            {
                end++;
            }
            j++;
        }
        i++;
    }
    printf("Max area is %d",maxArea);
}

int min2(int a,int b){
    return (a<b)?a:b;
}

void zoho_qn1(){
    int num = 30;
    for(int counter = 0;counter<5;counter++){

        switch(counter){
        case 0:
            num+=3;
            break;
        case 2:
            num-=5;
        case 4:
            num*=2;
        default:
            num+=1;
            break;
        }
    printf("%d ",num);
    }
}

void zoho_qn2(){
    int p = 20,q = 30;
    int x = (p++)+(++q)+(p--)+(--q);
    int y = (q--)+(--p)+(++q)+(p++);
    printf("%d %d %d %d\n",x,p,y,q);
}
