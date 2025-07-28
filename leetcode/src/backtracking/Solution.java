package backtracking;
class Solution {
    int sLen,pLen;
    String s,p;
    int[][] dp ;
    public static void main(String[] args){
        System.out.println(new Solution().isMatch("c","*?*"));
    }
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        sLen = s.length();
        pLen = p.length();
        dp = new int[sLen+1][pLen+1];
        return match2(0,0);
    }
    private boolean match2(int i,int j){
        if(i==sLen && j==pLen)return true;
        else if(dp[i][j]!=0){
            return dp[i][j] == 1;
        }
        else{
            if(j==pLen)return false;
            if(i==sLen){
                boolean out = true;
                while(j<pLen){
                    if(p.charAt(j++)!='*'){
                        out = false;
                        break;
                    }
                }
                dp[i][j] = out ? 1 : -1;
                return out;
            }
            else{
                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
                    dp[i][j]= match2(i+1,j+1) ? 1 : -1;
                    return dp[i][j]==1;
                }else if(p.charAt(j)=='*'){
                    boolean out = false;
                    out = match2(i+1,j) || match2(i,j+1);
                    dp[i][j] = out ? 1:-1;
                    return out;
                }else{
                    dp[i][j] = -1;
                    return false;
                }
            }
        }
    }
}
