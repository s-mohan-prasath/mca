
def prob1(arr,x):
    n = len(arr)
    for _ in range(n):
        if(arr[_] == x):
            return _
    return -1

def prob2(arr):
    n = len(arr)
    if(n==0):
        print("Empty array")
    else:
        maxi = arr[0]
        mini = arr[0]
        for x in arr:
            if(x>maxi):
                maxi = x
            if(x<mini):
                mini = x
    print("Max and Min are: ",maxi,mini)

def prob3(arr,n,k):
    k %=n
    for _ in range(k):
        j = 0
        while(j<n-1):
            temp = arr[j]
            arr[j] = arr[j+1]
            arr[j+1] = temp
            j+=1
    print("Reversed Array :",arr)

def prob4(arr):
    n = len(arr)
    sum1 = 0
    sum2 = 0
    for i in range(n//2):
        sum1 += arr[i]
        sum2 += arr[n-i-1]
    if(sum1 == sum2):
        print("Smallest Balance Number is",0)
    else:
        diff = abs(sum1 - sum2)
        print("Smallest Balance Number is",diff)

def prob5(arr):
    sum = 0
    for x in arr:
        sum += x
    print(sum)

