#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "ps11.h"

void ps11_prob2_add_stu(struct Student *stu);
void ps11_prob2_display_stu(int size,struct Student students[size]);
void ps11_prob2_delete_stu(char *stu,int *size,struct Student *students);

int ps11_prob1(){
/*
1. Declare a variable of the following struct and read appropriate values to each of the
data members.

struct Phone
{
char firstName[10];
char lastName[10];
char phoneNumber[10];
};

Write a function that accepts two arguments of struct Phone and determines if the two
structs contain the same phone number. The function should return true if the phone
numbers match, but should return false if they do not match.
*/
    struct Phone ph1,ph2;
    strcpy(ph1.firstName,"Mohan");
    strcpy(ph1.lastName,"Prasath");
    strcpy(ph1.phoneNumber,"9025802851");
    strcpy(ph2.firstName,"Raji");
    strcpy(ph2.lastName,"Mom");
    strcpy(ph2.phoneNumber,"9025802851");

    return ps11_prob1_call(&ph1,&ph2);
}
void ps11_prob2(){
/*
2. Write a C program to keep records and perform statistical analysis for a class of 20
students. The information of each student contains ID, Name, Sex, quizzes Scores (2
quizzes per semester), mid-term score, final score, and total score.
Use functions, pointers appropriately. Do all validations
The program will prompt the user to choose the operation of records from a menu as
shown below:
*/
    int n,end,max_students;
    char c;
    char roll[8];
    max_students = 20;
    struct Student students[max_students];
    end = 0;
    while(1){
        printf("\nMenu\n"
           "============================================\n"
           "1. Add student records\n"
           "2. Delete student records\n"
           "3. Update student records\n"
           "4. View all student records\n"
           "5. Calculate an average of a selected student’s scores\n"
           "6. Show student who gets the max total score\n"
           "7. Show student who gets the min total score\n"
           "8. Find student by ID\n"
           "9. Sort records by total scores\n"
           "10. Exit\n\n");
        printf("Statistics : student count = %d",end);
        printf("\n\n\nEnter : ");
        scanf("%d",&n);
        switch(n){
        case 1:
            if(end==max_students){
                printf("\nStudent Records Limit exceeded\n");
            }else{
                ps11_prob2_add_stu(&students[end]);
                end++;
            }
            break;
        case 2:

            printf("\n--------Delete Student Record ------\n");
            printf("Enter Student Roll No : ");
            scanf("%s",roll);
            ps11_prob2_delete_stu(roll,&end,&students[0]);
            break;
        case 3:
            break;
        case 4:
            ps11_prob2_display_stu(end,students);
            break;
        case 5:
            break;
        case 6:
            break;
        case 7:
            break;
        case 8:
            break;
        case 9:
            break;
        case 10:
            break;
        default:
            printf("invalid entry..\n");
        }
    }


}
int ps11_prob1_call(struct Phone *p1,struct Phone *p2){
    for(int i = 0;i<10;i++){
        if(*((p1->phoneNumber)+i) != *((p2->phoneNumber)+i))return 0;
    }
    return 1;
}
/*
    char id[8];
    char name[20];
    char sex;
    float quiz1_score;
    float quiz2_score;
    float midterm_score;
    float final_score;
    float total_score;
*/
void ps11_prob2_add_stu(struct Student *stu){
    printf("--------Add STudent Record ------\n");
    printf("Enter id name sex quiz1_score quiz2_score midterm_score final_score total_score : ");
    scanf("%s %s %c %f %f %f %f %f",stu->id,stu->name,&(stu->sex),&(stu->quiz1_score),&(stu->quiz2_score),&(stu->midterm_score),&(stu->final_score),&(stu->total_score));
}
void ps11_prob2_display_stu(int size,struct Student stu[size]){
    printf("-----------STUDENTS-------------\n");
    for(int i = 0;i<size;i++){
        printf("ROLL NUMBER : %s\nName : %s\nSex : %c\nQuiz Score 1 : %.2f\nQuiz Score 2 : %.2f\nMidterm Score : %.2f\nFinal Score : %.2f\nTotal Score 1 : %.2f\n",stu[i].id,stu[i].name,stu[i].sex,stu[i].quiz1_score,stu[i].quiz2_score,stu[i].midterm_score,stu[i].final_score,stu[i].total_score);
        printf("----------------------------------------\n");
    }
}
void ps11_prob2_delete_stu(char *stu,int *size,struct Student *students){
    int i;
    for(i = 0;i<*size;i++){
        if(strcmp(students[i].id,stu)==0)break;
    }
    if(i==*size){
        printf("No Student Found for the given id\n");
        return;
    }
    for(int j = i;j<(*size)-1;j++){
        students[i] = students[i+1];
    }
    (*size)--;
}




























