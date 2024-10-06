#include <stdio.h>
#include <stdlib.h>

void zoho_qn1();
void zoho_qn2();

int main()
{
    int x = 1;
    x += ++x + x++ + ++x;
    printf("%d ",x);
    return 0;
}

//ZOHO round 1 questions

void zoho_qn1(){
    int num = 30;
    for(int counter = 0;counter<5;counter++){

        switch(counter){
        case 0:
            num+=3;
            break;
        case 2:
            num-=5;
        case 4:
            num*=2;
        default:
            num+=1;
            break;
        }
    printf("%d ",num);
    }
}

void zoho_qn2(){
    int p = 20,q = 30;
    int x = (p++)+(++q)+(p--)+(--q);
    int y = (q--)+(--p)+(++q)+(p++);
    printf("%d %d %d %d\n",x,p,y,q);
}
