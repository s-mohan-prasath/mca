public class Recursion {
    public Recursion(){

    }
    public int climbStair(int i,int n){
        if(i==n)return 1;
        else if(i>n)return 0;
        else{
            return climbStair(i+1,n) + climbStair(i+2,n);
        }
    }
}
