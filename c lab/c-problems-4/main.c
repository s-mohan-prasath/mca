#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void getArrayLen(int *len);
void getArray(int len, int *arr);
void printArray(int len, int *arr);
void printSubArray(int *arr, int len, int start, int end);
int max2(int,int);
void prob1();
void prob2();
void prob3();
void prob4();
void prob5();
void prob6();
void prob7();
//TODO: check the function with the wide range of test cases and make it suitable to handle all the test cases
void prob8();

int main()
{
    prob6();
    return 0;
}

void prob1()
{
    int n, i = 0, sales, maxSale = 0, maxSaleId = 1, minSaleId = 1, minSale = 0, totalSales = 0, count;
    printf("Enter Number of Sales People : ");
    scanf("%d", &n);
    int arr[n][2];
    while (i < n)
    {
        printf("Enter the sales amount of sales person with id = %d : ", i + 1);
        scanf("%d", &sales);
        arr[i][0] = i + 1;
        arr[i][1] = sales;
        if (i == 0)
            minSale = sales;
        totalSales += sales;
        if (maxSale < sales)
        {
            maxSaleId = i + 1;
            maxSale = sales;
        }
        else if (minSale > sales)
        {
            minSaleId = i + 1;
            minSale = sales;
        }
        i++;
    }
    printf("Total Sales is %d\n", totalSales);
    printf("Average Sales is %1.3f\n", (float)totalSales / n);
    printf("Sales Person %d had the highest sale with %d.\n", maxSaleId, maxSale);
    printf("Sales Person %d had the lowest sale with %d.\n\n", minSaleId, minSale);
    printf("Enter a Value : ");
    scanf("%d", &sales);
    i = 0;
    count = 0;
    printf("\nSales people who exceeded the given sales value\n\n");
    while (i < n)
    {
        if (arr[i][1] > sales)
        {
            count++;
            printf("Sales Person with id = %d\n", i + 1);
        }
        i++;
    }
    printf("the total number of salespeople whose sales exceeded the value entered is %d\n", count);
}

void prob2()
{
    int i, n, noOfCorrect, ans;
    char gradeAgain;
    do
    {
        printf("\n\tGRADE A QUIZ\n");
        printf("enter total number of questions in Quiz : ");
        scanf("%d", &n);
        printf("Enter Answer Key For the Questions\n");
        int arr[n];
        i = 0;
        while (i < n)
        {
            printf("Qn %d : ", i + 1);
            scanf("%d", &arr[i]);
            i++;
        }
        i = 0;
        noOfCorrect = 0;
        while (i < n)
        {
            printf("Enter answer for Qn %d : ", i + 1);
            scanf("%d", &ans);
            if (arr[i] == ans)
                noOfCorrect++;
            i++;
        }
        printf("\n\nNumber of Questions Correct is %d", noOfCorrect);
        printf("\nPercentage of Correct is %1.2f%%", (float)100 * noOfCorrect / n);
        printf("\n\nDo you want to grade Another Quiz ? : ");
        while (getchar() != '\n')
            ; // This consumes the leftover newline character
        gradeAgain = getchar();
    } while (gradeAgain == 'y');
}

void prob3()
{
    int l, temp;
    printf("LENGTH OF THE ARRAY SHOULD BE EVEN \n");
    getArrayLen(&l);
    if (l % 2 != 0)
    {
        printf("ERROR : number of elements should be even");
        return;
    }
    printf("ARRAY SHOULD HAVE EQUAL NUMBER OF POSITIVE AND NEGATIVE NUMBERS\n");
    int arr[l];
    getArray(l, arr);
    if (l == 3)
    {
        if (!(arr[0] >= 0 && arr[2] >= 0) || !(arr[0] < 0 && arr[2] < 0))
        {
            temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }
    }
    else if (l > 3)
    {
        int i, j;
        i = 0;
        j = 1;
        while (i < l && j < l)
        {
            while (arr[i] >= 0)
                i += 2;
            while (arr[j] < 0)
                j += 2;
            if (i > l || j > l)
            {
                break;
            }
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    printArray(l, arr);
}

void prob4()
{
    // referred from https:www.geekinterview.com/question_details/39488
    int arr[] = {1, 2, 3, 4, 5, 6, 6};
    int len = sizeof(arr) / sizeof(int);
    if (len == 0)
        return;
    int i = 0, RegularSum = 0, MySum = 0, RegularMult = 1, MyMult = 1, x, y; // x - duplicated, y - removed
    while (i < len)
    {
        RegularSum += i + 1;
        MySum += arr[i];
        RegularMult *= i + 1;
        MyMult *= arr[i];
        i++;
    }

    x = (int)((float)MyMult * abs(RegularSum - MySum) / abs(MyMult - RegularMult));
    y = (int)((float)x * RegularMult / MyMult);
    printf("Missing Number is %d\nDuplicated Number is %d", y, x);

    /*

use the following method:

mark the missing number as M and the duplicated as D

1) compute the sum of regular list of numbers from 1 to N call it RegularSum
2) compute the sum of your array (the one with M and D) call it MySum
now you know that MySum-M+D=RegularSum
this is one equation.
the second one uses multiplication:
3) compute the multiplication of numbers of regular list of numbers from 1 to N call it RegularMultiplication
4) compute the multiplication of numbers of your list  (the one with M and D) call it MyMultiplication
now you know that MyMultiplication=RegularMultiplication*D/M
at this point you have two equations with two parameters, solve and rule!

    */
}

void prob5()
{
    int i, j, len, ele, temp, maxLen, currLen;
    getArrayLen(&len);
    int arr[len];
    getArray(len, arr);
    if (len == 0)
        return;
    if (len == 1)
    {
        printf("Maximum length of the consecutive subsequence is 1");
        return;
    }
    i = 0;
    while (i < len)
    {
        j = i + 1;
        while (j < len)
        {
            if (arr[i] > arr[j])
            {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        i++;
    }
    printArray(len, arr);
    i = 0;
    maxLen = 1;
    currLen = 1;
    while (i < len - 1)
    {
        if (arr[i] == arr[i + 1] - 1)
            currLen++;
        else if (arr[i] == arr[i + 1])
        {
            i++;
        }
        else
        {
            if (currLen > maxLen)
            {
                maxLen = currLen;
                currLen = 1;
            }
        }
        i++;
    }
    if (currLen > maxLen)
        maxLen = currLen;
    printf("Maximum length of consecutive subsequence is %d", maxLen);
}

void prob6()
{
    int arr[] = {1,2,3,0,-1,-10};
    int len = 6;
    int i;

    int prod1 = arr[0];
    int maxProd1 = arr[0];
    for(i = 1;i<len;i++){
        if(prod1==0)prod1=arr[i];
        else{
            prod1*=arr[i];
            maxProd1 = max2(maxProd1,prod1);
        }
    }
    maxProd1 = max2(maxProd1,prod1);

    int prod2 = arr[len-1];
    int maxProd2 = arr[len-1];
    for(i = len-2;i>=0;i--){
        if(prod2==0)prod2=arr[i];
        else{
            prod2*=arr[i];
            maxProd2 = max2(maxProd2,prod2);
        }
    }
    maxProd2 = max2(maxProd2,prod2);

    printf("%d",max2(maxProd1,maxProd2));
}

void prob8()
{
}

void prob7()
{
    /*
    Edge cases
    1) all negative numbers
    2) all positive numbers
    3) only one element
    */
    printf("Write a C program to find sub array with largest sum in array of both positive and negative number?\n");
    int len;
    getArrayLen(&len);
    int arr[len];
    getArray(len, arr);
    if (len == 0)
        return;
    if (len == 1)
    {
        printf("Max Sum in subarray is %d\n", arr[0]);
        printf("Subarray : %d\n", arr[0]);
        return;
    }
    int start, end, i, sum, maxSum;
    i = 1;
    sum = arr[0];
    maxSum = arr[0];
    start = end = 0;
    while (i < len)
    {
        if (sum <= 0)
        {
            if (arr[i] >= sum)
            {
                sum = arr[i];
                maxSum = sum;
                start = end = i;
            }
        }
        else
        {
            sum += arr[i];
            if (sum >= maxSum)
            {
                maxSum = sum;
                end = i;
            }
        }
        i++;
    }
    printf("Sub Array with maximum sum is %d\nSubarray : ", maxSum);
    printSubArray(arr, len, start, end);
    printf("\n");
}

// HELPER FUNCTION

int max2(int a,int b){
    return (a>b) ? a:b;
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

void printArray(int len, int *arr)
{
    printf("Elements are :\n");
    for (int i = 0; i < len; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

void printSubArray(int *arr, int len, int start, int end)
{
    while (start <= end)
    {
        printf("%d ", arr[start]);
        start++;
    }
}
