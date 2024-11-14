int max2(int,int);
int min2(int,int);
int min3(int a,int b,int c);
void swapChar(char *a,char *b);
void swapInt(int *a,int *b);
int powerOf(int a,int b);
// ARRAYS
void getArrayLen(int*len);
void getArray(int len,int*arr);
void printArray(int len,int*arr);
void sortArray(int len,int*arr,char c);
int findElementInArray(int len,int *arr,int ele);
void printSubArray(int *arr, int len, int start, int end);
void findArrayStat(int len,int * arr,int *maxi,int *mini,int *sum,float *avg);
//two D arrays
void get2DArrayLen(int*n,int*m);
void get2DArray(int n,int m,int *arr);
void print2DArray(int arr[][5],int n,int m);
void print2DPointerArray(int n,int m,int *arr);
void print2DVariableColumnStrings(int rows,int *twod);
// strings
void getStringLen(int*len);
void getString(char*s);
int sizeofStringMalloc(char *s);
char* createSubstring(int s,int e,char *str);
char* concatStringMalloc(int l1,int l2,char *str1,char *str2);
char* createMultipleTimesString(int times,int s,int e,char* str);
int createNumberFromString(int s,int e,char *str);
// CHARACTER FUNCTIONS
int checkVowel(char c);
int checkAlphaNum(char c);
int convertToUpperCase(char c);
