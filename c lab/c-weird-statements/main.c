#include <stdio.h>
#include <stdlib.h>

//IF STATEMENTS
void w1(){
    int x = -5;
    if(x>0 ? x>10 : x>-10){// if block will be executed based on ternary condition
        printf("I am executed\n");
    }else{
        printf("I am not executed\n");
    }
}
void w2(){
    /*

    Dangling else problem
    When an else appears without a clear if due to lack of braces
    */
    int x = 5,y=11;
    if (x == 6)
        if (y == 10)printf("x is 5 and y is 10\n");
    else printf("This else is ambiguous\n");
}
// LOOPS
void w3(){
    /*
    MULTIPLE INITIALIZATION IN THE WHILE LOOP
    */
    for (int i = 0, j = 10; i < 10 && j>5; i++, j--) {
        printf("i = %d, j = %d\n", i, j);
    }
}
void w4(){
    //infinite loop
    for(;;);
    // or
    for(;;){

    }
}
int main()
{
    int x,y;
    while(1){
    printf("\nEnter Numbers : ");
    printf("%d",scanf("%d %d",&x,&y));
    printf("\nx=%d, y=%d",x,y);
    while(getchar())break;
    }
    return 0;
}
