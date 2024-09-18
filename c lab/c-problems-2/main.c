#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int isPositiveNumber(int n);
void prob1();
void prob2();
void prob3();
void prob4();
void prob5();
void prob6();

int main()
{
    prob6();
    return 0;
}
void prob1(){
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

void prob2(){
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

void prob3(){
    int n, mid,i=1,addition=0;
    long long sum = 0;
    printf("Enter the value of n : ");
    scanf("%d",&n);
    if(isPositiveNumber(n) == 0){
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

void prob4(){
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

void prob5(){
    int a,b,c,n;
    printf("Enter the three digit positive number : ");
    scanf("%d",&n);
    if(isPositiveNumber(n)==1 && (n>99 && n<1000)){
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

void prob6(){
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

int isPositiveNumber(int n){
    if(n>0)return 1;
    else return 0;
}

