class Solution {
    int n;
    int[][] dp;
    public int minimumObstacles(int[][] grid) {
        this.n = grid.length;
        int m = grid[0].length;
        this.dp = new int[n][m];
        return this.minBrick(n-1,m-1,'N',grid);
    }
    private int minBrick(int i,int j,char dontGo,int[][] arr){
        if(i==0&&j==0)return 0;
        else if(dp[i][j]!=0){
            return (dp[i][j] != -1) ? dp[i][j] : 0;
        }else{
            int mini = Integer.MAX_VALUE;
            if(dontGo!='l'&&j-1>=0){
                mini = Math.min(mini,this.minBrick(i,j-1,'r',arr));
            }
            if(dontGo!='u'&&i-1>=0){
                mini = Math.min(mini,this.minBrick(i-1,j,'d',arr));
            }
            if(dontGo!='d'&&i+1<this.n){
                mini = Math.min(mini,this.minBrick(i+1,j,'u',arr));
            }
            this.dp[i][j] = arr[i][j] + mini;
            return (this.dp[i][j] == -1) ? 0 : this.dp[i][j];
        }
    }
}