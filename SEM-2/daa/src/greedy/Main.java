package greedy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        exe_prims();
//        knapsack kp = new knapsack(5,new int[]{10,15,20,12},new int[]{1,2,3,12});
    }
    private static void exe_prims(){
        prims.Edge[] edges = new prims.Edge[6];
        edges[0] = new prims.Edge(0, 1);
        edges[1] = new prims.Edge(0, 4);
        edges[2] = new prims.Edge(1, 4);
        edges[3] = new prims.Edge(1, 3);
        edges[4] = new prims.Edge(2, 4);
        edges[5] = new prims.Edge(2, 3);

        int [][] cost = new int[5][5];

        for(int[] c : cost){
            Arrays.fill(c, Integer.MAX_VALUE);
        }

        cost[0][1] = cost[1][0] = 1;
        cost[0][4] = cost[4][0] = 10;
        cost[1][4] = cost[4][1] = 12;
        cost[1][3] = cost[3][1] = 8;
        cost[2][3] = cost[3][2] = 7;
        cost[2][4] = cost[4][2] = 6;

        prims prim = new prims(edges,cost,5);

    }
}
