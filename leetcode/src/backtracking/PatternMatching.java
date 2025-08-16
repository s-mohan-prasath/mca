package backtracking;

class PatternMatching {
    int sLen,pLen;
    String s,p;
    public static void main(String[] args){
        long start1 = System.nanoTime();
        System.out.println(new PatternMatching().isMatch("bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaababbab","b*b*ab**ba*b**b***bba"));
        long end1 = System.nanoTime();
        long duration1 = end1-start1;
        System.out.println(duration1/1_000_000_000.0 + " seconds to complete");

        long start2 = System.nanoTime();
        System.out.println(new PatternMatching().isDpMatch("bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaababbab","b*b*ab**ba*b**b***bba"));
        long end2 = System.nanoTime();
        long duration2 = end2-start2;
        System.out.println(duration2/1_000_000_000.0 + " seconds to complete");
    }
    int[][] dp;
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        sLen = s.length();
        pLen = p.length();
        dp = new int[sLen][pLen];
        return match(0,0);
    }
    public boolean isDpMatch(String s, String p) {
        this.s = s;
        this.p = p;
        sLen = s.length();
        pLen = p.length();
        dp = new int[sLen][pLen];
        return match2(0,0);
    }
    private boolean match(int i,int j){
        if(i==sLen && j==pLen)return true;
        else{
            if(j==pLen)return false;
            if(i==sLen){
                while(j<pLen){
                    if(p.charAt(j++)!='*')return false;
                }
                return true;
            }
            else{
                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
                    return match(i+1,j+1);
                }else if(p.charAt(j)=='*'){
                    int incre = 0;
                    boolean out = false;
                    while(i+incre<=sLen && !out){
                        out = out || match(i+incre,j+1);
                        incre++;
                    }
                    return out;
                }else{
                    return false;
                }
            }
        }
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
                    dp[i][j]= match(i+1,j+1) ? 1 : -1;
                    return dp[i][j]==1;
                }else if(p.charAt(j)=='*'){
                    int incre = 0;
                    boolean out = false;
                    while(i+incre<=sLen && !out){
                        out = out || match(i+incre,j+1);
                        incre++;
                    }
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
