import java.util.*;

class Main{
    public static void main(String[] args){
        System.out.println("Hello!");
    }
    public static int[] prevEles(int[] arr){
        int len = arr.length;
        int[] prev = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<len;i++){
            if(stack.isEmpty())prev[i]=-1;
            else{
                while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])stack.pop();
                if(stack.isEmpty())prev[i]=-1;
                else{
                    prev[i] = stack.peek();
                    stack.push(i);
                }
            }
            stack.push(i);
        }
        return prev;
    }
    public static int[] nextEles(int[] arr){
        int len = arr.length;
        int[] next = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i = len-1;i>=0;i--){
            if(stack.isEmpty())next[i]=-1;
            else{
                while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])stack.pop();
                if(stack.isEmpty())next[i]=-1;
                else{
                    next[i] = stack.peek();
                    stack.push(i);
                }
            }
            stack.push(i);
        }
        return next;
    }
    public static void maxRectangleInHistogramBrute(int[] arr){
        // BRUTE FORCE
        int maxArea = 0,x,y;
        int len  = arr.length;
        for(int i = 0;i<len;i++){
            // MOVE LEFT
            x = i;
            while(x>=0 && arr[x]>=arr[i])x--;
            // MOVE RIGHT
            y = i;
            while(y<len && arr[y]>=arr[i])y++;
            maxArea = max(maxArea,arr[i]*(y-x-1));
        }
        return maxArea;
    }
    public static void maxRectangleInHistogram(int[] arr){
        int maxArea = 0,x,y;
        int len  = arr.length;
        int[] next=nextEles(arr),prev=prevEles(arr);
        for(int i = 0;i<len;i++){
            x = prev[i];
            y = next[i]==-1 ? len : next[i];
            maxArea = max(maxArea,arr[i]*(y-x-1));
        }
        return maxArea;
    }
    public static int max(int a,int b){
        return (a>b)?a:b;
    }
}
