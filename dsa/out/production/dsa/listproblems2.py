import math
def prob1():
    print("NOT SOLVED")
    # arr = [50,3,10,7,40,80]
    # maxiList = []
    # n = len(arr)
    # for i in range(n):
    #     count = 1
    #     lastMax = arr[i]
    #     for j in range(i+1,n):
    #         if(lastMax<arr[j]):
    #             count+=1
    #     maxiList.append(count)
    # maxiList.sort(reverse=True)
    # print(maxiList[0])

def prob2():
    l1 = [2,3,5,8]
    l2 = [10,12,14,16,18,20]
    l = []
    n = len(l1)
    m = len(l2)
    i = 0
    j = 0
    a = l1[i]
    b = l2[j]
    while (a!=None or b!=None):
        if(a == None):
            l.append(b)
            j += 1
        elif(b == None):
            l.append(a)
            i +=1
        else:
            if(a<b):
                l.append(a)
                i+=1
            else:
                l.append(b)
                j+=1
        a = l1[i] if i<n else None
        b = l2[j] if j<m else None
    x = n+m
    if(x%2 == 0):
        mid1 = x//2
        mid2 = mid1 - 1
        print("Median ",(l[mid1]+l[mid2])/2)
    else:
        mid = x//2
        print("Median :",l[mid])
    print(l)

def prob3():
    arr = [1, 3, -2, 5, -1, 2, -1, -6, 8, -5, 9]
    n = len(arr)
    if(n == 0):
        print(0)
        return
    if(n == 1):
        print(arr[0])
        return
    i = 0
    maxi = arr[i]
    sum = maxi
    i = 1
    while (i<n):
        if(sum <=0):
            maxi = max(maxi,arr[i])
            sum = maxi
        else:
            sum += arr[i]
            maxi = max(maxi,sum)
        i+=1
    print(maxi)

def prob4():
    l = [1,2,3,4,5]
    n = len(l)
    if(n==1 or n==0):
        print(l)
    else:
        print(l[1:]+l[0:1])

def prob5():
    l = [7,10,4,3,20,15]
    k = 3
    l.sort()
    print(l[k-1])
    
    