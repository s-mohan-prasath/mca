#include <stdio.h>
#include <stdlib.h>

int min2(int a,int b){
    return (a<b)?a:b;
}
int min3(int a,int b,int c){
    return min2(a,min2(b,c));
}
int max2(int a,int b){
    return (a>b)?a:b;
}
int powerOf(int a,int b){
    int num = 1;
    for(int i = 0;i<b;i++){
        num *=a;
    }
    return num;
}
void swapInt(int *a,int *b){
    int temp = *a;
    *a=*b;
    *b=temp;
}
void swapChar(char *a,char *b){
    char temp = *a;
    *a=*b;
    *b=temp;
}

void getArrayLen(int *len)
{
    printf("Enter the length of Array : ");
    scanf("%d", len);
}
void getArray(int len, int *arr)
{
    for (int i = 0; i < len; i++)
    {
        printf("Enter Element (i=%d) : ", i);
        scanf("%d", &arr[i]);
    }
}
void printArray(int len,int*arr){
    for(int i = 0;i<len;i++){
        printf("%d ",arr[i]);
    }
    printf("\n");
}
void sortArray(int len,int*arr,char c){
    for(int i = 0;i<len;i++){
        for(int j = i+1;j<len;j++){
            int temp=arr[i];
            if(c=='a' && arr[i]>arr[j]){
                    arr[i]=arr[j];
                    arr[j]=temp;
            }else if(c!='a' && arr[i]<arr[j]){
                    arr[i]=arr[j];
                    arr[j]=temp;
            }
        }
    }

}
int findElementInArray(int len,int *arr,int ele){
    for(int i = 0;i<len;i++){
        if(arr[i]==ele){
                return 1;
        }
    }
    return 0;
}
void printSubArray(int *arr, int len, int start, int end)
{
    while (start <= end)
    {
        printf("%d ", arr[start]);
        start++;
    }
}
void findArrayStat(int len,int *arr,int *maxi,int *mini,int *sum,float *avg){
    int maxiii,miniii,lsum;
    maxiii = arr[0];
    miniii = arr[0];
    lsum = 0;
    int i = 0;
    while(i<len){
        if(arr[i]>maxiii){
            maxiii = arr[i];
        }
        else if(arr[i]<miniii){
            miniii = arr[i];
        }
        lsum+=arr[i];
        i++;

    }
    *mini = miniii;
    *maxi = maxiii;
    *sum = lsum;
    *avg = ((float)lsum/len);
}
// TWO D ARRAYS
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
void print2DArray(int arr[][5],int n,int m){
    for(int i = 0;i<n;i++){
        for(int j = 0;j<m;j++){
            printf("%d\t",arr[i][j]);
        }
        printf("\n");
    }
}
void print2DPointerArray(int n,int m,int *arr){
    int i,j;
    for(i=0;i<n;i++){
        for(j=0;j<m;j++){
            printf("%d\t",*(arr+(i*n+j)));
        }
        printf("\n");
    }
}
void print2DVariableColumnStrings(int rows,int *twod){
    int i;
    for(i=0;i<rows;i++){
        printf("%s\n",*(twod + i));
    }
}
// STRING FUNCTIONS
void getStringLen(int * len){
    printf("Enter the length of String : ");
    scanf("%d",len);
}
void getString(char*s){
    getchar();
    printf("Enter string : ");
    scanf("%[^\n]s",s);
}
char * concatStringMalloc(int l1,int l2,char *str1,char *str2){
    int len,i;
    len = l1-1+l2-1+1;
    char *output = malloc(len*sizeof(char));
    i = 0;
    while(i<l1-1){
        *(output+i) = *(str1+i);
        i++;
    }
    i = 0;
    while(i<l2-1){
        *(output+l1-1+i) = *(str2+i);
        i++;
    }
    *(output+len-1) = '\0';
    return output;
}
int sizeofStringMalloc(char *s){
    int i = 0;
    int count = 0;
    while(*(s+i)!='\0'){
        count++;
        i++;
    }
    return count+1;
}
char* createMultipleTimesString(int times,int s,int e,char* str){
    int len,i,j,k;
    len = (e-s)*times + 1; //+1 for last null character;
    char *output = malloc(len*sizeof(char));
    k = 0;
    for(i = 0;i<times;i++){
        j = s;
        while(j<e){
            *(output + k) = *(str+j);
            j++;
            k++;
        }
    }
    *(output+(len-1)) = '\0';
    return output;
}
char* createSubstring(int start,int end,char*str){
    int len = end-start+1;// +1 for last null character in the string
    char* substring = malloc(len*sizeof(char));
    for(int i = 0;i<len-1;i++){
        *(substring+i) = str[start+i];
    }
    *(substring + (len-1)) = '\0';
    return substring;
}
int createNumberFromString(int s,int e,char *str){
    int num,len;
    num = 0;
    len = e-s;
    while(len>0){
        num+=((int)(*(str+s)-'0')) * powerOf(10,len-1);
        s++;
        len--;
    }
    return num;
}

// CHARACTER FUNCTIONS
int checkAlphaNum(char c){
    if((c>=48 && c<=57)||(c>=65&&c<=90)||(c>=97&&c<=122))return 1;
    return 0;
}
int convertToUpperCase(char c){
    if(c>=65 && c<=90)return c+32;
    return c;
}
int checkVowel(char c){
    int vowels[10] = {65,69,73,79,85,97,101,105,111,117};
    for(int i = 0;i<10;i++){
        if(c==vowels[i])return 1;
    }
    return 0;
}
