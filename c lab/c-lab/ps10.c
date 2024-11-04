#include <stdio.h>
#include <stdlib.h>

int getStringValue(int len,char *s);
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



