#include <stdio.h>
#include <stdlib.h>
#include "helpfulfunctions.h"

int getStringValue(int len,char *s);
void ps10_prob4_sortSimul(int *m,char *c);
int ps10_prob6_recur(int s1,int e1,int s2,int e2,char *str1,char *str2);


int ps10_prob1(){
    int len;
    getStringLen(&len);
    char str[len];
    getString(str);
    int i,j,index,oddCount,output;
    oddCount = output = 0;
    int counter[26];
    makeArrayElementsZero(26,counter);
    for(i=0;i<len-1;i++){
        for(j=i;j<len-1;j++){
            index = str[j]%97;
            if((++counter[index])%2==0){
                oddCount--;
            }else{
                oddCount++;
            }
            if(oddCount==0 || oddCount==1)output++;
        }
        makeArrayElementsZero(26,counter);
        oddCount = 0;
    }
    printf("The number of beautiful strings are %d\n",output);
    return output;
}
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
char* ps10_prob4(){
    int a,b,ch;
    printf("Enter the value of a b c : ");
    scanf("%d %d %d",&a,&b,&ch);
    int len = a+b+ch;
    char *printer = malloc(len*sizeof(char));

    int m[] = {a,b,ch};
    char c[] = {'a','b','c'};

    int  i = 0;
    ps10_prob4_sortSimul(m,c);
    while(m[0]>1){
        printer[i++] = c[0];
        printer[i++] = c[0];
        m[0]-=2;
        if(m[1]==0 && m[2]==0){
            printer[i] = '\0';
            return printer;
        }
        if(m[1]==0){
            swapInt(&m[1],&m[2]);
            swapChar(&c[1],&c[2]);
        }
        if(m[1]>=1){
            printer[i++] = c[1];
            m[1]-=1;
        }
        if(m[0]<=1){
            ps10_prob4_sortSimul(m,c);
        }
    }
    if(m[0]==1){
        printer[i++] = c[0];
        if(m[1]==1){
            printer[i++] = c[1];
            if(m[2]==1){
                printer[i++] = c[2];
            }
        }
    }
    printer[i] = '\0';
    return printer;
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
int ps10_prob6(){
    int l1,l2;
    printf("ENTER LENGTH OF PATTERN STRING\n");
    getStringLen(&l1);
    printf("ENTER LENGTH OF STRING\n");
    getStringLen(&l2);
    char str1[l1],str2[l2];
    printf("ENTER PATTERN STRING\n");
    getString(str1);
    printf("ENTER STRING\n");
    getString(str2);
    return ps10_prob6_recur(0,l1,0,l2,str1,str2);
}
int ps10_prob6_recur(int s1,int e1,int s2,int e2,char *str1,char *str2){
    if(s1==e1 && s2==e2){
        return 1;
    }
    else if(s1!=e1 && s2!=e2 && (str1[s1]==str2[s2] || str1[s1]=='?')){
        return ps10_prob6_recur(s1+1,e1,s2+1,e2,str1,str2);
    }else if(s1!=e1 &&str1[s1]=='*'){
        int output = 0;
        for(int i = s2; i<=e2;i++){
            output |= ps10_prob6_recur(s1+1,e1,i,e2,str1,str2);
            if(output){
                return 1;
            }
        }
        return 0;
    }else{
        return 0;
    }
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
void ps10_prob4_sortSimul(int *m,char *c){
    int tempM;
    char tempC;
    for(int i = 0;i<3;i++){
        for(int j = i+1;j<3;j++){
            if(m[i]<=m[j]){
                swapInt(&m[i],&m[j]);
                swapChar(&c[i],&c[j]);
            }
        }
    }
}
