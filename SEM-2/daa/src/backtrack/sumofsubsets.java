package backtrack;

import java.util.ArrayList;
import java.util.List;

public class sumofsubsets {
    List<ArrayList<Integer>> output;
    int m,n;
    int[] arr;
    public sumofsubsets(int[] arr,int m){
        output = new ArrayList<>();
        this.arr = arr;
        this.m = m;
        this.n = arr.length;
        this.function(0,sum(this.arr),-1,new ArrayList<>());
        for (ArrayList<Integer> list: output) {
            System.out.println(list.toString());
        }
    }
    private void function(int cSum,int rSum,int k,ArrayList<Integer> x){
        if(cSum==this.m){
            if(k<n-1){
                for(int i = k;i<n-1;i++)x.add(0);
            }
            output.add(x);
        }else if(k+1<n){
            if(cSum+arr[k+1]<=m){
                ArrayList<Integer> newX1 = new ArrayList<>(x);
                newX1.add(1);
                function(cSum+arr[k+1],rSum-arr[k+1],k+1,newX1);
            }
            if(cSum+rSum-arr[k+1]>=m){
                ArrayList<Integer> newX0 = new ArrayList<>(x);
                newX0.add(0);
                function(cSum,rSum-arr[k+1],k+1,newX0);
            }
        }
    }
    private int sum(int[] arr){
        int sum = 0;
        for(int x : arr){
            sum+=x;
        }
        return sum;
    }
}
