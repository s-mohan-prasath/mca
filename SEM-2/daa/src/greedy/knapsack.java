package greedy;

import java.util.Arrays;

public class knapsack {
    int[] profits,weights;float[] x;
    public knapsack(int m,int[] profits, int[] weights) {
        this.profits = profits;
        this.weights = weights;
        this.x = new float[profits.length];
        this.function(m,profits.length);
    }
    public void function(int m,int n){
        int i = 0;
        int U = m;
        int maxProfit = 0;
        for(;i<n;i++){
            if(weights[i]<=U){
                x[i] = 1.0f;
                maxProfit+=profits[i];
                U-=weights[i];
            }else{
                break;
            }
        }
        if(i<n){
            x[i] = ((float)U)/weights[i];
            maxProfit += x[i] * profits[i];
        }
        System.out.println(Arrays.toString(x));
        System.out.println("Maximum profit: "+maxProfit);
    }
}
