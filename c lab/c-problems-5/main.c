#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void getArray(int,int * arr);
void getArrayLen(int*len);
void prob1();
void prob2();
void prob3();
void prob4();
void prob5();
void prob6();
void prob7();
void prob8();
void prob9();
void prob10();
int min2(int,int);
int max2(int,int);
void sortArray(int len,int *arr);
void findArrayStat(int len,int * arr,int *maxi,int *mini,int *sum,float *avg);

int main()
{
    prob8();
    return 0;
}

void prob1(){
    /*
    1. You work for a logistics company that manages a large warehouse. The warehouse has
different sections where items are stored. Each section is represented by an array of item
IDs, and each ID represents a unique item. Your manager has asked you to perform the
following tasks to reorganize the warehouse:
1. Consolidate Sections: Merge multiple sections into a single list of item IDs.
2. Remove Duplicates: Ensure that each item ID appears only once in the final list.
3. Sort Items: Sort the item IDs in ascending order
    */
    //will get the list of elements in a single array
    int len,tempLen,i,j,k;
    getArrayLen(&len);
    int arr[len];
    getArray(len,arr);
    tempLen = len;
    for(i=0;i<tempLen;i++){
        for(j=i+1;j<tempLen;j++){
            if(arr[i]==arr[j]){
                for(k=j;k<tempLen-1;k++){
                    arr[k] = arr[k+1];
                }
                tempLen--;
            }
        }
    }
    printf("Duplicates removed : ");
    printArray(tempLen,arr);
    sortArray(tempLen,arr);
    printf("Sorted Items : ");
    printArray(tempLen,arr);
}

void prob2(){

/*
2. You are designing an advent calendar for a holiday event. The calendar has multiple
doors, each with a number representing the day of the month. Each day, a gift is revealed,
and you need to track the days when a specific type of gift is revealed. Your tasks are:
1. Find Days: Given an array representing the days of the month when gifts were
revealed, find all days where a specific type of gift was revealed.
2. Count Occurrences: Count how many times each type of gift was revealed.
*/

    int len;
    getArrayLen(&len);
    int arr[len];
    getArray(len,arr);
    int k;
    printf("Enter the gift type to find : ");
    scanf("%d",&k);

    int count = 0;
    int i =0;
    while(i<len){
        if(arr[i]==k)count++;
        i++;
    }
    int output[count];
    i = 0;
    while(i<count){
        output[i] = k;
        i++;
    }
    printf("Days with Gift type %d is ",k);
    printArray(count,output);
    printf("Occurrences : %d",count);

}

void prob3(){

/*
3. As a teacher, you need to manage the grades of your students. Each student’s grades are
stored in a list, and you need to perform the following operations:
1. Calculate Average Grade: Find the average grade of a student.
2. Find Highest Grade: Determine the highest grade among all students.
3. Sort Grades: Sort the grades of each student in ascending order.
*/

    printf("\nStudent Grade\n");
    int len;
    getArrayLen(&len);
    int arr[len];
    getArray(len,arr);
    int maxi,mini,sum;
    float avg;
    findArrayStat(len,arr,&maxi,&mini,&sum,&avg);
    printf("Average Grade : %f\n",avg);
    printf("Maximum Grade : %d\n",maxi);
    sortArray(len,arr);
    printf("Sorted Grade : ");
    printArray(len,arr);
}

void prob4(){

/*
4. Sam is responsible for managing the attendance records of an event. Each day’s
attendance is recorded in an array. Write a program that will help him in performing the
following tasks:
1. Find the Maximum Attendance: Determine the highest attendance recorded.
2. Find the Day with Minimum Attendance: Identify the day with the lowest
attendance.
3. Calculate the Average Attendance: Compute the average attendance over all days.
*/

    printf("\nAttendance Record\n");
    int len;
    getArrayLen(&len);
    int arr[len];
    getArray(len,arr);
    int maxi,mini,sum;
    float avg;
    findArrayStat(len,arr,&maxi,&mini,&sum,&avg);
    printf("Maximum Attendance : %d\n",maxi);
    printf("Minimum Attendance : %d\n",mini);
    printf("Average Grade : %f\n",avg);
}

void prob5(){

/*
5. You are analyzing scores from a video game competition. The scores for each player are
recorded in an array. You need to:
1. Determine the Top Scorer: Find the player with the highest score.
2. Calculate the Number of Players above a Threshold: Count how many players
scored above a certain threshold.
3. Sort Scores in Ascending Order: Sort the scores to see them in order.
*/

    printf("\nVideo game competition\n");
    int len;
    getArrayLen(&len);
    int arr[len];
    getArray(len,arr);
    int thresh;
    printf("Enter threshold : ");
    scanf("%d",&thresh);
    int maxi,mini,sum;
    float avg;
    findArrayStat(len,arr,&maxi,&mini,&sum,&avg);
    printf("Top Scorer's score : %d\n",maxi);
    int count = 0;
    for(int i = 0;i<len;i++){
        if(arr[i]>thresh)count++;
    }
    printf("No of Players above %d : %d\n",thresh,count);
    sortArray(len,arr);
    printf("Sorted Scores : ");
    printArray(len,arr);
}

void prob6(){

/*
6. Given an array of integers 'ARR’ of size ‘N’. Replace each element of this array with
its corresponding rank and return the array.
The rank of an element is an integer between 1 to ‘N’ inclusive that represents how large
the element is in comparison to other elements of the array. The following rules can also
define the rank of an element:
1. It is an integer starting from 1.
2. The larger the element, the larger the rank. If two elements are equal, their rank must
be the same.
*/
    printf("\nRank of the elements in the array\n");
    int len;
    getArrayLen(&len);
    int arr[len];
    getArray(len,arr);
    int i,j,isPresent,count;
    int duplicatesRemoved[len];
    int start,end;
    end=0;
    for(i=0;i<len;i++){
        isPresent=0;
        for(j=0;j<end;j++){
            if(arr[i]==duplicatesRemoved[j]){
                isPresent=1;
                break;
            }
        }
        if(isPresent!=1){
            duplicatesRemoved[end] = arr[i];
            end++;
        }
    }
    for(i=0;i<len;i++){
        count=1;
        for(j=0;j<end;j++){
            if(arr[i]>duplicatesRemoved[j]){
                count++;
            }
        }
        arr[i]=count;
    }
    printArray(len,arr);
}

void prob7(){
/*
7. You are given an array/list 'prices' where the elements of the array represent the prices
of the stock as they were yesterday and indices of the array represent minutes. Your task is
to find and return the maximum profit you can make by buying and selling the stock. You
can buy and sell the stock only once.
Note:
You can’t sell without buying first.
*/
    printf("\nStock Market Buy & Sell\n");
    int len;
    getArrayLen(&len);
    int arr[len];
    getArray(len,arr);
    int mini,profit;
    mini = arr[0];
    profit = 0;
    for(int i = 1;i<len;i++){
        mini = min2(arr[i],mini);
        profit = max2(arr[i]-mini,profit);
    }
    printf("maximum profit is %d\n",profit);
}

void prob8(){
/*
8. Given an array of distinct integers, find all the pairs having positive value and negative
value of a number that exists in the array. Return the pairs in any order.
*/
    printf("\nPositive and Negative pairs\n");
    int len;
    getArrayLen(&len);
    int arr[len];
    getArray(len,arr);
    int tmp[len];
    int i,j,n,m,eleI,end,isPresent;
    end = 0;
    for(i=0;i<len;i++){
        isPresent = 0;
        eleI = arr[i];
        if(eleI==0)continue;
        for(j=0;j<end;j++){
            if(abs(eleI)==tmp[j]){
                isPresent=1;
                break;
            }
        }
        if(isPresent==1)continue;
        for(m=i+1;m<len;m++){
            if(eleI+arr[m]==0){
                printf("(%d %d), ",-abs(eleI),abs(eleI));
                tmp[end]=abs(eleI);
                end++;
                break;
            }
        }
    }
}

void prob9(){
/*
9. You are part of an adventurous expedition team that has just returned from a lost city
exploration. During your journey, you collected various artifacts, each represented by an integer
value denoting its importance. However, your team accidentally mixed up the artifacts. You need
to sort the artifacts, find certain interesting statistics, and identify any special patterns.
Note:
Here’s what you need to do:
1. Sort the Artifacts: Sort the array of artifact values in non-decreasing order.
2. Find the Most Common Artifact: Determine which artifact value appears most
frequently. If there's a tie, choose the smallest value among the most frequent ones.
3. Identify the Missing Values: Find out which integer values are missing from the
sequence between the smallest and largest artifact values.
4. Calculate the Sum of All Unique Artifacts: Compute the sum of all unique artifact
values.
*/

    int len;
    getArrayLen(&len);
    int arr[len];
    getArray(len,arr);
    int uniqueArray[len];
    int i,j,end,isPresent,count;

    printf("Sorted Artifacts : ");
    sortArray(len,arr);
    printArray(len,arr);

    // removing duplicates in the array
    end = 0;
    for(i=0;i<len;i++){
        isPresent = 0;
        for(j=0;j<end;j++){
            if(arr[i]==uniqueArray[j]){
                isPresent=1;
                break;
            }
        }
        if(isPresent==0){
            uniqueArray[end]=arr[i];
            end++;
        }
    }
    if(end!=0){
        int freq[end];
        for(i=0;i<end;i++){
            count=1;
            for(j=0;j<len;j++){
                if(uniqueArray[i]==arr[j])count++;
            }
        freq[i]=count;
        }

        // finding the most common artifact
        int mini,maxFreq;
        maxFreq = freq[0];
        mini = uniqueArray[0];
        for(i=0;i<end;i++){
            if(freq[i]>maxFreq){
                mini = uniqueArray[i];
                maxFreq = freq[i];
            }else if(freq[i]==maxFreq){
                if(mini>uniqueArray[i]){
                    mini = uniqueArray[i];
                }
            }
        }
        printf("Most common artifact : %d\n",mini);
    }

    // finding the missing values & sum of unique artifacts
    int minimum,maximum,sum,allLen;
    minimum = uniqueArray[0];
    maximum = uniqueArray[end-1];
    allLen = maximum-minimum+1;
    sum = 0;
    int all[allLen];
    for(i = 0;i<allLen;i++){
        all[i] = i+minimum;
    }
    printArray(allLen,all);
    for(i=0;i<end;i++){
        all[uniqueArray[i]-minimum]=0;
        sum+=uniqueArray[i];
    }
    printArray(allLen,all);
    printf("Missing artifacts : ");
    for(i=0;i<allLen;i++){
        if(all[i]!=0)printf("%d,",all[i]);
    }
    printf("\nSum of Unique Artifacts is %d",sum);
}

void prob10(){
/*
10. Given a sorted array of distinct integers and a target value, return the index if the target
is found. If not, return the index where it would be if it were inserted in order.
*/
    int len,t,i;
    getArrayLen(&len);
    int arr[len];
    getArray(len,arr);
    printf("Enter the target (t) : ");
    scanf("%d",&t);
    for(i=0;i<len;i++){
        if(arr[i]>=t){
            printf("Index : %d",i);
            break;
        }
    }
    if(i==len){
        printf("Index : %d",i);
    }
}

int min2(int a,int b){
    return (a<b)?a:b;
}

int max2(int a,int b){
    return (a>b)?a:b;
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

void sortArray(int len,int *arr){
    int temp;
    for(int i = 0;i<len;i++){
        for(int j = i;j<len;j++){
            if(arr[i]>arr[j]){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
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
    for (int i = 0; i < len; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");
}


