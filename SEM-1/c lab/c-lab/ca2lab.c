#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"helpfulfunctions.h"

char* ca2_prob1_call(int strLen,char *str,int n,int m,char*dic);
void ca2_prob1(){
    int n,m,strLen;
    printf("Enter string length : ");
    scanf("%d",&strLen);
    char str[strLen];
    printf("Enter the string : ");
    scanf("%s",str);
    printf("Enter n : ");
    scanf("%d",&n);
    printf("Enter m : ");
    scanf("%d",&m);
    char dic[n][m];
    for(int i = 0;i<n;i++){
        printf("Enter %dth string : ",i);
        scanf("%s",dic[i]);
    }
    printf("%s",ca2_prob1_call(strLen,str,n,m,dic[0]));
}

char* ca2_prob1_call(int strLen,char *str,int n,int m,char*dic){
    int stringsLen[n];
    for(int i = 0;i<n;i++){
        stringsLen[i] = strlen((dic+(i*m)));
    }
    for(int i = 0;i<n;i++)printf("%s\n",dic+(i*m));
    char tempStr[m];
    int tempInt;
    //sorting
    for(int i = 0;i<n;i++){
        for(int j = i+1;j<n;j++){
            if(stringsLen[i]<stringsLen[j]){
                strcpy(tempStr,dic+(i*m));
                strcpy(dic+(i*m),dic+(j*m));
                strcpy(dic+(j*m),tempStr);
                tempInt = stringsLen[i];
                stringsLen[i] = stringsLen[j];
                stringsLen[j] = tempInt;
            }
        }
    }
    printf("\n\n");
    for(int i = 0;i<n;i++)printf("%s\n",dic+(i*m));
}
