#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>
#include "lib.h"

void zoho_qn1();
void zoho_qn2();
int min2(int,int);
void maxAreaInSquare();

// IMPLEMENTING LINKED LIST

void print2DArray(int n,int m,char twod[n][m]);
void print2DMallocChars(int n,char ** twod);
void create2DChars();
struct birth{
    int dd;
    int mm;
    int yyyy;
};
struct student{
    char name[50];
    int age;
    struct birth dob;
};

int main()
{
    return 0;
}
void structuresUsingPointers(){
    struct student s1,*ptr;
    ptr = &s1;
    printf("Enter Name Age dd mm yyyy : ");
    scanf("%s %d %d %d %d",ptr->name,&ptr->age,&ptr->dob.dd,&ptr->dob.mm,&ptr->dob.yyyy);
    printf("%s %d %d %d %d",ptr->name,ptr->age,ptr->dob.dd,ptr->dob.mm,ptr->dob.yyyy);
}
void arrayOfStructures(){
    struct student students[3];
    for(int i = 0;i<3;i++){
        printf("Enter Name Age dd mm yyyy : ");
        scanf("%s %d %d %d %d",students[i].name,&students[i].age,&students[i].dob.dd,&students[i].dob.mm,&students[i].dob.yyyy);
    }
    for(int i =0;i<3;i++){
        printf("%s %d %d/%d/%d\n",students[i].name,students[i].age,students[i].dob.dd,students[i].dob.mm,students[i].dob.yyyy);
    }
}
void workingWithMemCpy(){
    int nums1[5] = {1,2,3,4,5};
    int nums2[5] = {6,7,8,9,10};
    memcpy(nums1,nums2,3*sizeof(int));
    for(int i =0;i<5;i++){
        printf("%d\t",nums1[i]);
    }
}
void print2DMallocChars(int n,char ** twod){
    for(int i = 0;i<n;i++){
        printf("%s\n",twod[i]);
    }
}
void print2DArray(int n,int m,char twod[n][m]){
    for(int i = 0;i<n;i++){
        printf("%s\n",twod[i]);
    }
}
void create2DChars(){
    int n = 3,m=3;
    char names[n][m];
    for(int i = 0;i<n;i++){
        printf("Enter name %d : ",i+1);
        scanf("%s",names[i]);
    }
    printf("names\n");
    char temp[m];
    strcpy(temp,names[0]);
    strcpy(names[0],names[1]);
    strcpy(names[1],temp);
    print2DArray(n,m,names);
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
