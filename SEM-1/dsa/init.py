import listproblems as l1
import listproblems2 as l2


folderPointer = [" PYTHON PROBLEMS "]
def printCurrentDirectory(dir):
    folderPointer.append(dir)
    print()
    print("->".join(folderPointer))
    print()

while True:
    print("->".join(folderPointer))
    print("""
    ENTER 1 -> List problems 1
    ENTER 2 -> List problems 2
    ENTER 3 -> Array problems
""")
    n = int(input("ENTER : "))
    if(n==1):
        printCurrentDirectory(" LIST PROBLEMS 1 ")
        while True:
            print("""
    ENTER 1 -> problem 1
    ENTER 2 -> problem 2
    ENTER 3 -> problem 3
    ENTER 4 -> problem 4
    ENTER 5 -> problem 5
    ENTER 6 -> problem 6
    ENTER 7 -> problem 7
    ENTER 8 -> problem 8
    ENTER 9 -> problem 9
    ENTER 10 -> problem 10
    ENTER 11 -> problem 11
    ENTER 12 -> problem 12
    ENTER 13 -> problem 13
    ENTER 14 -> problem 14
    ENTER 15 -> problem 15
    ENTER 16 -> problem 16
    ENTER 17 -> problem 17
    
              

    ENTER 1000 -> to go HOME screen
""")
            n = int(input('ENTER : '))
            if(n!=1000):
                printCurrentDirectory(" PROBLEM "+str(n))
            if(n==1):
                l1.prob1()
            elif(n==2):
                l1.prob2()
            elif(n==3):
                l1.prob3()
            elif(n==4):
                l1.prob4()
            elif(n==5):
                l1.prob5()
            elif(n==6):
                l1.prob6()
            elif(n==7):
                l1.prob7()
            elif(n==8):
                l1.prob8()
            elif(n==10):
                l1.prob10()
            elif(n==11):
                l1.prob11()
            elif(n==12):
                l1.prob12()
            elif(n==13):
                l1.prob13()
            elif(n==14):
                l1.prob14()
            elif(n==15):
                l1.prob15()
            elif(n==16):
                l1.prob16()
            elif(n==17):
                l1.prob17()
            elif(n==1000):
                break
            else:
                print("INVALID INPUT!")
            folderPointer.pop()
    elif(n==2):
        printCurrentDirectory(" LIST PROBLEMS 2 ")
        while True:
            print("""
    ENTER 1 -> problem 1
    ENTER 2 -> problem 2
    ENTER 3 -> problem 3
    ENTER 4 -> problem 4
    ENTER 5 -> problem 5


    ENTER 1000 -> to go HOME screen
""")
            n = int(input('ENTER : '))
            if(n!=1000):
                printCurrentDirectory(" PROBLEM "+str(n))
            if(n==1):
                l2.prob1()
            elif(n==2):
                l2.prob2()
            elif(n==3):
                l2.prob3()
            elif(n==4):
                l2.prob4()
            elif(n==5):
                l2.prob5()
            elif(n==1000):
                break
            else:
                print("INVALID INPUT!")
            folderPointer.pop()
    elif(n==3):
        pass
    else:
        print("INVALID INPUT !")
    folderPointer.pop()