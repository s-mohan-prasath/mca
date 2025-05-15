package greedy;

import java.util.Arrays;

public class prims {
    int n;
    int mincost;
    int[][] t;
    int[] near;

    static class Edge{
        int v1,v2;
        public Edge(int v1,int v2){
            this.v1=v1;
            this.v2=v2;
        }

        @Override
        public String toString() {
            return "("+v1+","+v2+")";
        }
    }
    public prims(Edge[] edges,int[][] cost, int n){
        mincost=0;
        t = new int[n-1][2];
        near = new int[n];
        this.function(edges,cost,n);
        System.out.println("mincost: "+mincost);
        System.out.println("Edges are : ");
        for(int[] edge : t){
            System.out.println(Arrays.toString(edge));
        }
    }
    private void function(Edge[] E,int[][] cost,int n){
        Edge e1 = null;
        for(Edge e:E){
            if(e1==null)e1 = e;
            else if(cost[e1.v1][e1.v2]>cost[e.v1][e.v2])e1 = e;
        }
        int k = this.t[0][0] = e1.v1;
        int l = this.t[0][1] = e1.v2;
        // initializing nearby array
        for(int i = 0;i<n;i++){
            if(cost[i][k] > cost[i][l])near[i] = l;
            else near[i] = k;
        }
        System.out.println("near 0 : "+Arrays.toString(near));
        mincost += cost[k][l];
        near[k] = near[l] = -1;
        for(int i = 1;i<n-1;i++){
            // choosing vertex which connects with the constructing spanning tree (t)
            Integer minJ = null;
            for(int j = 0;j<n;j++){
                if(near[j]==-1)continue;
                else if(minJ==null)minJ = j;
                else if(cost[j][near[j]] < cost[minJ][near[minJ]]){
                    minJ = j;
                }
            }
            System.out.println("Choosing a vertex with minimum cost : "+minJ+ " with cost = "+cost[minJ][near[minJ]]);
            t[i][0] = minJ;
            t[i][1] = near[minJ];
            mincost += cost[minJ][near[minJ]];
            near[minJ] = -1;

            for(int m = 0;m<n;m++){
                if(near[m]!=-1 && cost[m][near[m]]>cost[m][minJ])near[m] = minJ;
            }
            System.out.println("near "+i+" : "+Arrays.toString(near));
        }
    }
}