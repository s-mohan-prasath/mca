package backtracking;

class PatternMatching {
    public static void main(String[] args){
        new PatternMatching().isMatch("acdcb","a*c?b");
    }
    int sLen,pLen;
    String s,p;
    public boolean isMatch(String s, String p) {
        sLen = s.length();
        pLen = p.length();
        this.s = s;
        this.p = p;
        return wildCard(0,0);
    }
    private boolean wildCard(int i,int j){
        if(sLen==i && pLen ==j)return true;
        else{
            if(j==pLen)return false;
            else{
                if(p.charAt(j)==s.charAt(i) || p.charAt(j)=='?'){
                    return wildCard(i+1,j+1);
                }
                else if(p.charAt(j)=='*'){
                    int incre = 0;
                    boolean out = false;
                    while(i+incre<=sLen && !out){
                        out = out||wildCard(i+incre,j+1);
                        incre++;
                    }
                    return out;
                }
                else return false;
            }
        }
    }
}