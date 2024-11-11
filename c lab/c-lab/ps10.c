#include <stdio.h>
#include <stdlib.h>
#include "helpfulfunctions.h"

int getStringValue(int len,char *s);
int ps10_prob2(){
    int l1;
    getStringLen(&l1);
    char s1[l1],s2[l1];
    printf("STRING 1\n");
    getString(s1);
    printf("STRING 2\n");
    getString(s2);
    int i1 = -1;
    int i2 = -1;
    char s1I1,s1I2;
    for(int i = 0;i<l1;i++){
        if(s1[i]!=s2[i]){
            if(i1==-1){
                s1I1 = s2[i];
                i1 = i;
            }
            else if(i2==-1){
                s1I2 = s2[i];
                i2 = i;
            }
            else{
                printf("false");
                return 0;
            }
        }
    }
    if(i1==-1 && i2==-1){
        printf("true");
        return 1;
    }else if(i2==-1){
        printf("false");
        return 0;
    }
    s1[i1] = s1I1;
    s1[i2] = s1I2;
    for(int i = 0;i<l1;i++){
        if(s1[i]!=s2[i]){
            printf("false");
            return 0;
        }
    }
    printf("true");
    return 1;
}
int ps10_prob3(){
    printf("Return true if the summation of the numerical values of firstWord and secondWord equals the numerical value of targetWord, or false otherwise.");
    int len1,len2,len3;
    printf("WORD 1 LENGTH\n");
    getStringLen(&len1);
    printf("WORD 2 LENGTH\n");
    getStringLen(&len2);
    printf("TARGET WORD LENGTH\n");
    getStringLen(&len3);
    char str1[len1],str2[len2],str3[len3];
    printf("WORD 1\n");
    getString(str1);
    printf("WORD 2\n");
    getString(str2);
    printf("TARGET WORD\n");
    getString(str3);

    int score1 = getStringValue(len1,str1);
    int score2 = getStringValue(len2,str2);
    int score3 = getStringValue(len3,str3);

    if(score1+score2==score3){
        printf("true");
        return 1;
    }else{
        printf("false");
        return 0;
    }
}

char* ps10_prob5(){
    int len,i,j;
    char c1,c2,temp;
    getStringLen(&len);
    char s[len];
    getString(s);
    int ascii[128];
    for(i=0;i<128;i++){
        ascii[i] = 0;
    }
    for(i=0;i<len-1;i++){
        ascii[s[i]%128]++;
    }
    for(i=0;i<len-1;i++){
        for(j=i+1;j<len-1;j++){
            c1 = s[i];
            c2 = s[j];
            if(ascii[c1%128] < ascii[c2%128] || (ascii[c1%128]==ascii[c2%128] && c1>c2)){
                temp = s[i];
                s[i] = s[j];
                s[j] = temp;
            }
        }
    }
    printf("%s",s);
    return s;
}
int getStringValue(int len,char *s){
    int i,num;
    num = 0;
    i = 0;
    while(s[i]!='\0'){
        num += (s[i]%97) * powerOf(10,--len);
        i++;
    }
    return num;
}



