package assignments;

public class strings_25_02_2025 {
    public void qn1(char c,String sent){
        int count = 0;
        int len = sent.length();
        for(int i = 0;i<len;i++){
            if(sent.charAt(i)==c)count++;
        }
        System.out.println("Frequency of the character in the given string is "+count);
    }
    public void qn2(String sent){
        String[] words = sent.split(" ");
        int count=0;
        for(String word:words){
            if(qn2_palin(word))count++;
        }
        System.out.println("Number of Palindromes in the given string is "+count);
    }
    public void qn3(String substr,String str){
        int i = 0;
        int len = str.length();
        int count = 0;
        while(i<len){
            int k = str.indexOf(substr);
            if(k==-1)break;
            else{
                i=k+1;
                count++;
                k = str.indexOf(substr);
            }
        }

    }
    private boolean qn2_palin(String str){
        int len = str.length();
        int[] ascii = new int[128];
        for(int i = 0;i<len;i++){
            ascii[i]++;
        }
        char c;
        int odd = 0;
        for(int i = 65;i<128;i++){
            c=str.charAt(i);
            if(ascii[c]%2!=0)odd++;
        }
        if(odd>1)return false;
        return true;
    }
}
