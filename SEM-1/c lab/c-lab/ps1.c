#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void ps1_prob1(){
/*
Write a C program to compute the following
f = (x^3 - 2*x^2 + x - 6.3)/(x^2 + 0.05*x + 3.14)
*/
    printf("Problem 1\n");
    int x;
    float out;
    printf("Enter the value of x : ");
    scanf("%d",&x);
    out = ((x*x*x)-2*x*x+x-6.3)/(x*x+0.05*x+3.14);
    printf("%f",out);
}

void ps1_prob2(){
/*
Write a C program to print the roots of a quadratic equation
*/
    printf("Find roots of the equation?\n");
    int a,b,c;
    printf("Enter the coefficient of x^2 x and constant (space separated) : ");
    scanf("%d %d %d",&a,&b,&c);
    if(a==0){
            printf("\nGiven equation is not a quadratic equation\n");
    }
    else{
        int d = ps1_prob2Disc(a,b,c);
        if(d<0){
            printf("Roots are Imaginary\n");
            printf("(%d+(%d)i)/%d and (%d+(%d)i)/%d",-b,d,2*a,-b,-d,2*a);
        }
        else{
            float dd = sqrt(d);
            float root1 = (float)((-b+dd)/(2*a));
            float root2 = (float)((-b-dd)/(2*a));
            printf("Root are %f %f",root1,root2);
        }
    }
}

void ps1_prob3(){
/*
Write the complete C program that asks the user to enter the value for t
from the keyboard and then it computes and prints the value of p which
is expressed as a function of t by

p(t) = { 20          when 0<t<=2
         4(t+2)      when 13<t<=16 or t>30
         4(t^2 + 2t) when otherwise
        }
*/
    int t;
    printf("\nEnter the value of t : ");
    scanf("%d",&t);
    int p;
    if(t>0 && t<=2){
        printf("%d",20);
    }else if((t>13 && t<=16) || t>30){
        printf("%d",4*(t+2));
    }else{
    printf("%d",4*(t*t+2*t));
    }
}

void ps1_prob4(){
/*
Write a program that outputs the day of the week given a date expressed as y (day) m (month) o (year).
You will use the following formula:

m1 = { m-2  si m>=3
       m+10 si1 m<3
}

a1 = { a    si m>=3
       a-1  si m<3
}

and with ns being the two first digits of a1 and as the two last digits of a1

f = j + as + ((as)/4) - 2(ns) + (ns/4) + (26(m1) - 2)/10

The day of the week will then be given by the modulo off and 7 (0 is Sunday, 1 Monday etc). Let the date be
DD/MM/CCYY (european format), where DD is the day of the month, MM is the month, CC the century-digits and
 YY the year within the century. The for the date 23/06/1994. Starting with the century CC-digits,
 calculate CC/4 - 2*CC-1 and remember the result. With all divisions in this exercise, discard any remainder
  and just keep the whole part. So, in our example, this is 19/4=4 minus 2*19=38 minus 1, giving minus 35.
Now, using the year YY, calculate 5*YY/4. In this example that's 5*94 = 470/4 = discarding the remainder.
Adding this to our existing result gives 117-35 = 82.
Using the month MM, calculate 26*(MM+1)/10. In our example this is 26*7 = 182 / 10 = 18,
again discarding the remainder. Add this to our running total giving 82+18 = 100.
Finally just add the day DD. Here 100 + 23 = 123.
Now divide the result by 7, just keeping the remainder; here 123(mod 7) = 4. Counting Sunday as zero, Monday = 1 etc,
we get 4 = Thursday. Easy, when you know how

*/
    int cc,yy,mm,dd;
    printf("Enter the date in the format dd/mm/cc/yy : ");
    scanf("%d/%d/%d/%d",&dd,&mm,&cc,&yy);

    cc = (int)(cc/4) - 2*cc -1;
    yy = (int)5*yy/4;
    mm = (int)(26*(mm+1)/10);
    dd = cc+yy+mm+dd;
    ps1_prob4PrintDay(dd%7);
}

void ps1_prob5(int a, int b){
/*
Write a program to find the biggest among two numbers without using any control structures.
*/
    int x = a+b;
    int y = abs(a-b);
    int d = (x+y)/2;
    printf("Maximum number is %d",d);
}

void ps1_prob6(){
/*
    Write a C program to print # the format given below
*/
    printf("\nProblem - 6\nWhat do you want to print in the console : \n");
    printf("Type 1 for triangle\nType 2 for Pyramid\nType 3 for Diamond\nType 4 for Right Arrow\nType 5 for Inverse Pyramid\n\ntype: ");
    int n;
    scanf("%d",&n);
    if(n==1){
        ps1_prob6RightTriangle();
    }else if(n==2){
        ps1_prob6Pyramid();
    }else if(n==3){
        ps1_prob6Diamond();
    }else if(n==4){
        ps1_prob6RightArrow();
    }else if(n==5){
        ps1_prob6InversePyramid();
    }

}

void ps1_prob7(){
/*
Write a program for a matchstick game being played between the computer and a user. Your program should ensure that the computer always wins. Rules for the game are as follows:
There are 21 matchsticks.
The computer asks the player to pick 1, 2, 3, or 4 matchsticks.
After the person picks, the computer does its picking.
Whoever is forced to pick up the last matchstick loses the game.
*/

    printf("\nMATCH STICK GAME\nRULES : player can only pick 1,2,3 or 4 sticks\n\n");
    int turn = 0,sticks=21,k;
    /*
    0th turn is for user
    1st turn is for computer

    sticks - this variable will maintain the number of sticks after the pickup
    k - number of sticks picked by user
    */

    while(sticks!=0){
        printf("\nMatchsticks left : %d\n",sticks);
        if(turn==0){
            printf("USER TURN (pick sticks) : ");
            scanf("%d",&k);
            if(k<=0 || k>4 || k>sticks){
                printf("INVALID INPUT\n");
                continue;
            }
            printf("You pick %d sticks\n",k);
            turn = 1;
        }else if(turn == 1){
            k = 5-k;
            printf("COMPUTER TURN (pick sticks) : %d\n",k);
            printf("computer pick %d sticks\n",k);
            turn = 0;
        }
    sticks-=k;
    }
    printf("You lose the game");
}

void ps1_prob8(){
/*
A number is said to be perfect if it is equal to the sum of all numbers which are its
factors (excluding itself). So, for example, 6 is perfect, because it is the sum of its
factors 1,2,3. Write a program which determines if a number is perfect.
It should also print its factors.
*/
    int k;
    printf("\nCHECK WHETHER THE NUMBER IS PERFECT?\n\nEnter the number : ");
    scanf("%d",&k);
    int sum = 0;
    if(k==1)printf("\nGIVEN NUMBER IS PERFECT NUMBER");
    else{
        for(int i=1;i<k;i++){
            if(k%i==0){
                printf("\nFactor = %d\n",i);
                sum+=i;
            }
        }
        if(sum==k)printf("\nGIVEN NUMBER IS A PERFECT NUMBER");
        else printf("\nGIVEN NUMBER IS NOT A PERFECT NUMBER");
    }
}

void ps1_prob9(){
/*
Write a program that takes as input a natural number x and prints the smallest palindrome
larger than x. A palindrome is a word, number, phrase, or other sequence of characters which
reads the same backward as forward, such as madam, racecar. There are also numeric palindromes,
including date/time stamps using short digits
1 l/l l/l 1 11:11 and long digits 02/02/2020.
*/
    int n,i,nd,start,end;
    printf("Enter a number : ");
    scanf("%d",&n);
    if(n<0){
        printf("ERROR : Enter a number greater than 0\n");
        return;
    }
    i = n+1;
    while(1){
        nd = ps1_prob9FindNumOfDigits(i);
        int num[nd];
        ps1_prob9IntToArray(i,num);
        start = 0;
        end = nd-1;
        while(start<end){
            if(num[start]!=num[end]){
                break;
            }
            start++;
            end--;
        }
        if(start==end || start>end){
            printf("Smallest palindrome number greater than %d is %d\n",n,i);
            return;
        }
        i++;
    }
}


void ps1_prob10(){
/*
According to a study, the approximate level of intelligence of a person can be calculated
using the following formula: i = 2 + ( y + 0.5 x )
Write a program, which will produce a table of values of i, y and x, where y varies from 1 to 6,
and, for each value of y, x varies from 5.5 to 12.5 in steps of 0.5.

*/
    int y;
    float x,i;
    for(y=1;y<7;y++){
        for(x=5.5;x<=12.5;x+=0.5){
            i = (float)(2+(y+0.5*x));
            printf("x=%1.2f y=%d i=%1.2f\n",x,y,i);
        }
        printf("\n");
    }
}

// HELPER FUNCTIONS

void ps1_prob6RightTriangle(){
/*
#
##
###
####
#####

k = denotes the number of line in the shape
*/
    int k;
    printf("\nEnter the size of Right Triangle (k) : ");
    scanf("%d",&k);
    printf("\n");
    for(int i=1;i<=k;i++){
        for(int j=1;j<=i;j++){
            printf("#");
        }
        printf("\n");
    }
}

void ps1_prob6InversePyramid(){
/*
#########
 #######
  #####
   ###
    #
k - denotes the maximum number of character in the first line
*/
    int k;
    printf("\nEnter the length of Pyramid (odd number k ) : ");
    scanf("%d",&k);
    printf("\n");
    if(k%2==0){
        printf("I won't print Pyramid for your even number input...\n");
    }else{
        int mid = (int)floor(k/2);
        int startPin = 0;
        int rows = k;
        int columncount = k;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<columncount;j++){
                if(j>=startPin){
                    printf("*");
                }else{
                    printf(" ");
                }
            }
            startPin++;
            columncount--;
            printf("\n");
        }
    }

}

void ps1_prob6Pyramid(){
/*
    #
   ###
  #####
 #######
#########

k - denotes the maximum number of character in the last line
*/
    int k;
    printf("\nEnter the length of Pyramid (odd number) : ");
    scanf("%d",&k);
    printf("\n");
    if(k%2==0){
        printf("I won't print Pyramid for your even number input...\n");
    }else{
        int mid = (int)floor(k/2);
        int startPin = mid;
        int rows = mid+1;
        int columncount = mid+1;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<columncount;j++){
                if(j>=startPin){
                    printf("*");
                }else{
                    printf(" ");
                }
            }
            startPin--;
            columncount++;
            printf("\n");
        }
    }

}

void ps1_prob6Diamond(){
/*
    #
   ###
  #####
 #######
#########
 #######
  #####
   ###
    #

k - denotes the maximum number of character in the middle line
*/
    int k;
    printf("\nEnter the length of Diamond (odd number) : ");
    scanf("%d",&k);
    printf("\n");
    if(k%2==0){
        printf("I won't print Diamond for your even number input...\n");
    }else{
        int mid = (int)floor(k/2);
        int startPin = mid;
        int rows = k+1;
        int columncount = mid+1;
        int i;
        for(i = 0;i<rows;i++){
            int j;
            for(j = 0;j<columncount;j++){
            if(j>=startPin){
                printf("*");
            }else{
                printf(" ");
            }
        }
            if(i<mid){
                startPin--;
                columncount++;
            }else{
                startPin++;
                columncount--;
            }
            printf("\n");
        }
    }

}

void ps1_prob6RightArrow(){
/*
#####
  ####
    ###
      ##
        #
        #
      ##
    ###
  ####
#####

k - number of characters in the first and last line
*/
    int n;
    printf("Enter a number greater than 2 : ");
    scanf("%d",&n);
    int i=0,start=0,rows=2*n,cols=n;
    while(i<rows){
        int j = 0;
        while(j<cols){
            if(j>=start){
                printf("*");
            }else{
                printf(" ");
            }
            j++;
        }
        printf("\n");
        if(i<n-1){
            cols++;
            start+=2;
            i++;
        }
        else{
            if(i==n-1){
                i++;
                continue;
            }else{
                cols--;
                start-=2;
                i++;
            }
        }
    }

}

void ps1_prob4PrintDay(int n){
    if(n==0)printf("SUNDAY");
    else if(n==1)printf("MONDAY");
    else if(n==2)printf("TUESDAY");
    else if(n==3)printf("WEDNESDAY");
    else if(n==4)printf("THURSDAY");
    else if(n==5)printf("FRIDAY");
    else printf("SATURDAY");
    printf("\n");
}

int ps1_prob2Disc(int a,int b,int c){
    return (b*b-4*a*c);
}

int ps1_prob9FindNumOfDigits(int n){
    int count = 0;
    while(n>0){
        count++;
        n/=10;
    }
    return count;
}

void ps1_prob9IntToArray(int n,int *arr){
    int i = 0;
    while(n>0){
        arr[i] = n%10;
        i++;
        n/=10;
    }
}


/*
-------------------CONFLICTING TYPES FOR PROB1

I got this error for scanf('%d',&x); here, instead of using characters, i have to only use the strings as the argument
mismatch declaration of prob1 declaration data type

C:\Users\MCA\Desktop\D24MX113\C-LAB\c-lab-handson-1\main.c|11|error: conflicting types for 'prob1'|
C:\Users\MCA\Desktop\D24MX113\C-LAB\c-lab-handson-1\main.c|4|note: previous declaration of 'prob1' was here|
C:\Users\MCA\Desktop\D24MX113\C-LAB\c-lab-handson-1\main.c||In function 'prob1':|
C:\Users\MCA\Desktop\D24MX113\C-LAB\c-lab-handson-1\main.c|15|warning: multi-character character constant [-Wmultichar]|
C:\Users\MCA\Desktop\D24MX113\C-LAB\c-lab-handson-1\main.c|15|warning: passing argument 1 of 'scanf' makes pointer from integer without a cast [-Wint-conversion]|
C:\Program Files\CodeBlocks\MinGW\x86_64-w64-mingw32\include\stdio.h|523|note: expected 'const char * restrict' but argument is of type 'int'|

------------------REDEFINITION OF ps1_prob4

I have defined two ps1_prob4 function in the script

||=== Build file: "no target" in "no project" (compiler: unknown) ===|
Z:\CODING\SEM1\C Lab\workout\c-problems-1\main.c||In function 'main':|
Z:\CODING\SEM1\C Lab\workout\c-problems-1\main.c|9|warning: implicit declaration of function 'ps1_prob4'; did you mean 'prob2'? [-Wimplicit-function-declaration]|
Z:\CODING\SEM1\C Lab\workout\c-problems-1\main.c|13|warning: conflicting types for 'ps1_prob4'|
Z:\CODING\SEM1\C Lab\workout\c-problems-1\main.c|9|note: previous implicit declaration of 'ps1_prob4' was here|
Z:\CODING\SEM1\C Lab\workout\c-problems-1\main.c||In function 'ps1_prob6':|


ps1_prob6 error

Z:\CODING\SEM1\C Lab\workout\c-problems-1\main.c|206|error: 'cols' undeclared (first use in this function); did you mean 'cos'?|
int i=0,start=0;rows=2*n,cols=n;

prob 7 error
Z:\CODING\SEM1\C Lab\workout\c-problems-1\main.c|116|error: 'stick' undeclared (first use in this function); did you mean 'sticks'?|

*/

