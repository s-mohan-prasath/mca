package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nqueens {
    List<int[]> output;
    int n;
    public nqueens(int n){
        output = new ArrayList<>();
        this.n = n;
        this.function(0,new int[n]);
        for(int[] arr : output){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(output.size() + " solutions found");
    }
    public void function(int k,int[] arr){
        for(int i = 0;i<n;i++){
            if(canPlace(k,i,arr)){
                if(k==n-1){
                    arr[k] = i;
                    output.add(arr);
                    break;
                }
                else{
                    int[] newArr = arr.clone();
                    newArr[k] = i;
                    function(k+1,newArr);
                }
            }
        }
    }
    private boolean canPlace(int i, int j,int[] arr) {
        for(int m = 0;m<i;m++){
            if(arr[m]==j || (Math.abs(i-m)==Math.abs(j-arr[m])))return false;
        }
        return true;
    }

}
