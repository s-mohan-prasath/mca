def prob1():
    Rno = [1,2,3,4,5]
    Name = ["Anu", "Bina","Charu","Deepak","Emily"]
    N = 5
    Students_list = [Rno,Name,N]

    print('i) Prints the items present in Student_list');

    for x in Name:
        print(x);

    print('ii) Retrieve name of second, third and fourth student in the list using both positive indexing and negative indexing .');

    print("Negative indexing");
    print(Name[1:-1]);

    print("iii) Retrieve the third in the list")
    print("Roll No : ",Students_list[0][2]," Name : ",Students_list[1][2])

    print("iv) Append roll no 5 at the end of the Rno.");

    print("v) Append \"Akash\" as the first Name.");
    Name = ["Akash"]+Name

    print("vi) Insert number 0 at the 1st position to the level Rno in Students_list using insert method");
    Rno.insert(0,0);

    print("vii) Delete N from Student_list using delete method")
    del Students_list[2]
    print(Students_list)

    print("viii) Remove Bina from the level name from Student_List");
    del Students_list[0][1];
    del Students_list[1][1];
    print(Students_list)

    print("ix) Use pop() method to delete 5 from the level Rno from Student_List")
    Rno.pop()

    print("x) Add one more level which contains Dept Details of the students at the end of Students List");

    DeptDetails = ["G1",'G2','G3',"G1",'G2'];
    Students_list.append(DeptDetails)
    print(Students_list)

    print("xi.	Extract the second name from Students list")
    print(" Name : ",Students_list[1][1])

    print("xii.	Extract the second rollno in Students_list.");
    print(" Roll No : ",Students_list[0][1])

def prob2():
    print("""
    2.	Reverse a list in Python using 
        i.	Using the list function reverse()
        ii.	Using negative slicing
    """)
    
    list1 = [100,200,300,400,500]
    list2 = [100,200,300,400,500]
    print("i.	Using the list function reverse()")
    list1.reverse();
    print(list1)
    print("ii.	Using negative slicing")
    print(list2[::-1])

def prob3():
    print("""
    3.	Add item 7000 after 6000 in the following Python List
    list1 = [10, 20, 300, 400, 5000, 6000, 500, 30, 40]
    """)
    list1 = [10, 20, 300, 400, 5000, 6000, 500, 30, 40]
    list1.insert(6,7000);
    print("value 7000 inserted -> ",list1)

def prob4():
    print("4.You have given a Python list. Replace 20 with 200. ")
    list1 = [5, 10, 15, 20, 25, 50, 20]
    for i in range(0,len(list1)):
        if(list1[i]==20):
            list1[i]=200;
    print("Modified list -> ",list1)

def prob5():
    print("""
    5. Write a python program that accepts employee name, salary, and company name from the user
    """)
    name = input("Enter the Employee Name : ")
    salary = int(input("Enter the Employee Salary : "))
    company = input("Enter the Employee Company Name : ")
    print("Printing Employee Details")
    print("Name :",name)
    print("Salary :",salary)
    print("Company :",company)

def prob6():
    print("""
6.	Create a list with the elements 2, 4, 6, 8, 10, 12. Remove item present at index 2 using pop() method.
""")
    list = [2,4,6,8,10,12]
    list.pop(2)
    print("List after popping item at index 2 -> ",list)

def prob7():
    print("""
7.Create a list with the elements 2, 4, 6, 8, 10, 12. Remove item from index 2 to 5 using del()method
""")
    list = [2,4,6,8,10,12]
    del list[2:6]
    print("List after deleting items from index 2 to 5 -> ",list)

def prob8():
    L = [12,73,55,35,45,90,55]
    print("i)",min(L))
    print("ii)",max(L))
    print("iii)",L*3)
    L.sort()
    print("iv)")
    print("v)",L)
    L.sort(reverse=True)
    print("vi)")
    print("vii)",L)
    L1 = [20,50,40,100]
    print("viii)",L1)
    L.extend(L1)
    print("ix)",L)
    print("x)",L)
    print("xi)",12 in L)
    print("xii)",12 not in L)
    print("xiii)",L[1:7:2])
    print("xiv)",L.count(0))
    L.clear()
    print("xv)")
    print("xvi)",L)

def prob10():
    print("""
    10.Write a Python program to remove duplicates from a list.
""")
    lit = a = [10,20,30,20,10,50,60,40,80,50,40]
    lit = list(set(lit))
    print(lit)
def prob11():
    print("""
    11. Write a Python program to remove and print every third number from a list
of numbers until the list becomes empty.
""")
    nums = [10,20,30,40,50,60,70,80,90]
    n = len(nums)
    i = 0
    while(n!=0):
        i=(i+2)%n
        print(nums[i])
        nums.pop(i)
        newLen = len(nums)
        n = newLen


def prob12():
    print("""
    12.Write a Python program to concatenate all elements in a list into a string and
return it.
""")
    lit = [2,50,12,9]
    result = "".join(map(lambda x : str(x),lit))
    print(result)

def prob13():
    print("""
    13. Write a Python program to filter the positive numbers from a list.
Sample Input
""")
    nums = [34, 1, 0, -23]
    print("Original numbers in the list :",nums)
    result = list(filter(lambda x : x>0,nums))
    print("Positive numbers in the list :",result)

def prob14():
    print("""
    14. Write a Python function that takes a list of words and returns the longest one
""")
    word = ["PHP", "Java", "Python"]
    n = len(word)
    max_len = len(word[0])
    max_str = word[0]
    for i in range(1,n):
        current_i_max_len = len(word[i]) 
        if(current_i_max_len > max_len):
            max_len = current_i_max_len
            max_str = word[i]
    print(max_str)

def prob15():
    print("""
    15. Write a Python program to sum all the items in a list.
""")
    nums = [1,2,1.1,3]
    print("The sum of numbers in the list : ",sum(nums))

def prob16():
    print("""
    16.Write a Python program to find the longest list in a given list.
""")
    nums =[[1,2,3],[5,6,7,8],[1,4,5,6,7],[7,8,9]]
    n = len(nums)
    max_len = len(nums[0])
    max_list = nums[0]
    for i in range(1,n):
        current_i_max_len = len(nums[i]) 
        if(current_i_max_len > max_len):
            max_len = current_i_max_len
            max_list = nums[i]
    print("The longest list is",max_list)

def prob17():
    nums=[2,3,6,5]
    c = input("Enter the character to be printed: ")
    for x in nums:
        print(c*x)