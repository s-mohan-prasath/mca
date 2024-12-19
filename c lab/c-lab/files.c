#include<stdio.h>
#include<stdlib.h>

typedef struct student{
    int id;
    char name[50];
};
char stu_records_filename[] = "student_records.dat";

void readFile(char *filename){
    FILE *ptr = fopen(filename,"r");
    if(ptr==NULL){
        printf("Could not read file");
        return;
    }
    char content[1000];
    fread(content,50,1,ptr);
    fclose(ptr);
    printf("%s",content);
}
void writeFile(char *filename){
    FILE *ptr = fopen(filename,"w");
    if(ptr==NULL){
        printf("Could not write file");
        return;
    }
    char content[1000] = "Hi buddy, this is a new content\nnews";
    fputs(content,ptr);
    fclose(ptr);
}
void readBinFile(char *filename){
    FILE *ptr = fopen(filename,"rb");
    if(ptr==NULL){
        printf("Could not read file");
        return;
    }
    char content[1000];
    fread(content,50,1,ptr);
    fclose(ptr);
    printf("%s",content);
}
void writeBinFile(char *filename){
    FILE *ptr = fopen(filename,"wb");
    if(ptr==NULL){
        printf("Could not write file");
        return;
    }
    char content[1000] = "Hi buddy, this is a new content\nnews";
    fputs(content,ptr);
    fclose(ptr);
}

void stud_input(struct student *stu){
    printf("\nEnter ID of the Student : ");
    scanf("%d",&stu->id);
    printf("Enter Name of the Student : ");
    scanf("%s",stu->name);
}
void stud_output(struct student *stu){
    printf("Id : %d , Name : %s",stu->id,stu->name);
}

void fileCRUD_add_student(const struct student data){
    FILE *stu_records = fopen(stu_records_filename,"ab+");
    fwrite(&data,sizeof(struct student),1,stu_records);
    fclose(stu_records);
}
void fileCRUD_search_student(){
}
void fileCRUD_delete_student(){
    int id,found;
    struct student stu;
    printf("Enter Id of the student to delete : ");
    scanf("%d",&id);
    FILE *stu_records = fopen(stu_records_filename,"rb");
    FILE *temp = fopen("temp.dat","wb");
    while(fread(&stu,sizeof(struct student),1,stu_records)){
        if(stu.id==id){
            found = 1;
        }else{
            fwrite(&stu,sizeof(struct student),1,temp);
        }
    }
    fclose(stu_records);
    fclose(temp);
    remove(stu_records_filename);
    rename("temp.dat",stu_records_filename);
    if(found){
        printf("Student Record of Id %d is deleted\n",id);
    }else{
         printf("Cannot Find Student Record with Id %d\n",id);
    }
}
void fileCRUD_update_student(){
    int id,found;
    struct student stu;
    printf("Enter Id of the student to update : ");
    scanf("%d",&id);
    FILE *stu_records = fopen(stu_records_filename,"rb+");
    while(fread(&stu,sizeof(struct student),1,stu_records)){
        if(stu.id==id){
            found = 1;
            printf("\nFound a Student Record with id %d\n",id);
            stud_output(&stu);
            printf("\nEnter new details of the student\n\n");
            stud_input(&stu);
            fseek(stu_records,-(long)sizeof(struct student),SEEK_CUR);
            fwrite(&stu,sizeof(struct student),1,stu_records);
            break;
        }
    }
    fclose(stu_records);
    if(found){
        printf("Student Record of Id %d is updated",id);
    }else{
         printf("Cannot Find Student Record with Id %d",id);
    }
}
void fileCRUD_display_students() {
    struct student stu;
    FILE *stu_records = fopen(stu_records_filename,"r");
    printf("\nStudent Records\n");
    while(fread(&stu,sizeof(struct student),1,stu_records)){
        printf("Name : %s , Id : %d\n",stu.name,stu.id);
    }
    printf("\n");
    fclose(stu_records);
}

void fileCRUD(){
    int n;
    struct student stu;
    do{
        printf("\n1. ADD NEW STUDENT\n2. SEARCH A STUDENT\n3. UPDATE A STUDENT\n4. DELETE A STUDENT\n5. DISPLAY STUDENTS\n");
        printf("\nEnter number : ");
        scanf("%d",&n);
        switch(n){
        case 1:
            stud_input(&stu);
            fileCRUD_add_student(stu);
            break;
        case 2:
            fileCRUD_search_student();
            break;
        case 3:
            fileCRUD_update_student();
            break;
        case 4:
            fileCRUD_delete_student();
            break;
        case 5:
            fileCRUD_display_students();
            break;
        default:
            break;
        }
    }while(1);

}











