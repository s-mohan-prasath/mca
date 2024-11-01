#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void ps2_prob1(){
/*
Write a C program that accepts a positive integer from the keyboard. If the input is invalid,
it stops with appropriate message. For a valid input, it determines the first and last digits of the number.
Further, it checks whether the first digit or the last digit is multiple of the other with appropriate message.
*/
    int n,first,last;
    printf("Enter a positive number : ");
    scanf("%d",&n);
    if(n<0){
        printf("INVALID INPUT - only positive numbers accepted\n");
        return;
    }
    last = n%10;
    while(n>10){
        n=n/10;
    }
    first = n;
    printf("\nFirst and last digit is %d and %d\n",first,last);
    if(first%last == 0){
        printf("first digit is a multiple of last digit\n");
    }else if(last%first ==0){
        printf("Last digit is a multiple of first digit\n");
    }else{
        printf("First and Last digits are not multiples of each other\n");
    }

}

void ps2_prob2(){
/*
Write a C program that reads two real numbers (from keyboard) representing the x and y coordinates
of a point in the Cartesian plane. It then checks whether the point lies inside,
outside or on a circle of radius 5 with centre at the origin. Finally,
it prints appropriate message too.

(Example: Typical input: 2.5 3.0
Typical output: The point lies inside the circle
Typical input: 1.9 4.8
Typical output: The point lies outside the circle
Typical input: 3.0 4.0 Typical output: The point lies on the circle)

*/
    float x,y,r=5.0;
    printf("2) To Check whether the point lies inside, outside or on the circle\n");
    printf("Enter the points in the format (x,y) : ");
    scanf("(%f,%f)",&x,&y);
    float lhs = x*x+y*y;
    float rhs = r*r;

    if(lhs<rhs)printf("\nPoint is inside the circle");
    else if(lhs>rhs)printf("\nPoint is outside the circle");
    else printf("\nPoint lies on the circle");

}

void ps2_prob3(){
/*
Write a C program that accepts a positive integer (from the keyboard).
If the input is invalid, it stops after printing the message Invalid input.
For a valid input, it then computes and prints out the sum
 1*n + 2*(n − 1) + 3*(n − 2) +...+ (n − 1)*2 + n*1
*/
    int n, mid,i=1,addition=0;
    long long sum = 0;
    printf("Enter the value of n : ");
    scanf("%d",&n);
    if(ps2_isPositiveNumber(n) == 0){
        printf("INVALID INPUT : value of n should be positive");
        return;
    }
    mid = n/2;
    if(n%2!=0){
        addition+=((mid+1)*(mid+1));
    }
    while(i<=mid){
        sum+=(i*n);
        i++;n--;
    }
    sum*=2;
    sum+=addition;
    printf("sum is %lld",sum);
}

void ps2_prob4(){
/*
Write a C program that accepts a three digit positive integer from the keyboard.
If the input is invalid, it stops after printing the message Invalid input.
For a valid input, it then checks whether the sum of the digits is equal
to the product of the digits. Finally, it prints appropriate message too.
(Example: Typical input: 123
Typical output: The sum of the digits is equal to the product of the digits
Typical input: 121
Typical output: The sum of the digits is NOT equal to the product of the digits)

*/
    int n,a,b,c;
    printf("Enter the three digit positive number : ");
    scanf("%d",&n);
    if(n<1000 && n>99){
        a = n%10;
        n/=10;
        b = n%10;
        c = n/10;
        if(a+b+c == a*b*c)printf("\n The sum of the digits is equal to the product of the digits");
        else printf("\n The sum of the digits is not equal to the product of the digits");
    }else{
        printf("\nINVALID INPUT : enter three digit positive number");
    }
}

void ps2_prob5(){
/*
Write a C program that accepts a three digit positive integer from the keyboard.
If the input is invalid, it stops after printing the message Invalid input.
For a valid input, it then checks whether the sum of the first and the last digits is
equal to the middle digit. Finally, it prints appropriate message too.
*/
    int a,b,c,n;
    printf("Enter the three digit positive number : ");
    scanf("%d",&n);
    if(ps2_isPositiveNumber(n)==1 && (n>99 && n<1000)){
        c = n%10;
        n = n/10;
        b = n%10;
        a = n/10;
        if(a+c==b)printf("\n sum of the first and the last digits is equal to the middle digit");
        else printf("\n sum of the first and the last digits is not equal to the middle digit");
    }else{
        printf("\nINVALID INPUT : enter three digit positive number");
    }
}

void ps2_prob6(){
/*
The Bessel function of the first kind of order zero is defined by J0(x)
  Write a C program that accepts real x from the keyboard.
  Then it calculates and prints out the value of J0(x) using the first 20 terms only.
*/
    float x;
    printf("Enter the value of x : ");
    scanf("%f",&x);
    //find factorial of the number
    float bessel = 1;
    long long int fact = 1;
    int power = 2;
    int  n = 1;
    while(n<20){
        bessel+= (pow(-1,n))*(pow(x,power))/(pow(2,power)*pow(fact,2));
        power+=2;
        fact*=n;
        n++;
    }
    printf("Bessel function value : %f",bessel);
}


//HELPER FUNCTIONS

int ps2_isPositiveNumber(int n){
    // to check whether the number is positive
    if(n>0)return 1;
    else return 0;
}

