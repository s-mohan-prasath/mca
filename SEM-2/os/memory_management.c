#include <string.h>

void square(int *num){
    *num = (*num)*(*num);
}
void copy(){
    char str[100];
    strcpy(str,"hakuna matata!");
    printf("%s\n",str);
}
void program3(){
    char answer[5];
    printf("Type something : ");
    gets(answer);
    printf("you typed : %s\n",answer);
}
