public class CA1LabPractice {
    public CA1LabPractice(){

    }
    public void g1setAprob1(int[] arr){
        boolean peakAchieved = false;
        int i,len;
        len = arr.length;
        if(len==1 || len==0 || len == 2){
            System.out.println("Not a Mountain Array");
            return;
        }
        i = 1;
        if(arr[i-1]>arr[i]){
            System.out.println("Not a Mountain Array");
            return;
        }
        while(i<len){
            if(peakAchieved){
                if(arr[i]>=arr[i-1]){
                    System.out.println("Not a Mountain Array");
                    return;
                }
            }
            else if(arr[i]<arr[i-1]){
                peakAchieved = true;
            }
            else if(arr[i]==arr[i-1]){
                System.out.println("Not a Mountain Array");
                return;
            }
            i++;
        }
        System.out.println("It is a Mountain array");
        return;
    }

    public void g1setAprob2(String passwd){
        int len = getLenOfString(passwd);
        boolean len6 = len >= 6;
        boolean containDigit = false;
        boolean containLowerCase = false;
        boolean containUpperCase = false;
        boolean containSpecialChar = false;

        if(!len6){
            System.out.println("Password should contain atleast 6 characers");
        }
        else{
            int i = 0;
            while(i<len){
                char c = passwd.charAt(i);
                int code = (int)c;
                if(code>=65 && code<=90)containUpperCase=true;
                else if(code>=97 && code<=122)containLowerCase=true;
                else if(code>=48 && code<=57)containDigit=true;
                else if(!containSpecialChar){
                    char[] arr = {'!','@','#','$','%','^','&','*','(',')','-','+'};
                    for(char x:arr){
                        if(c==x){
                            containSpecialChar=true;
                            break;
                        }
                    }
                }
                i++;
            }
        if (!containDigit) {
            System.out.println("Password should contain atleast one digit");
        } else if (!containLowerCase) {
            System.out.println("Password should contain atleast one Lower Case");
        } else if (!containUpperCase) {
            System.out.println("Password should contain atleast one Upper Case");
        } else if (!containSpecialChar) {
            System.out.println("Password should contain atleast one Special Character");
        } else {
            System.out.println("Strong Password");
        }
        }
    }

    public void g2setAprob2(String mess){
        int i,len,code;
        char c;
        String encrypted = "";
        len = getLenOfString(mess);
        i = 0;
        while(i<len){
            c = mess.charAt(i);
            code = (int)c;
            if(code==65 || code==66 || code==67 || code == 97 || code == 98){
                code+=23;
            }else if(code>67 && code<=90){
                code-=3;
            }else if(code>98 && code<=122){
                code-=2;
            }
            encrypted+=Character.toString((char)code);
            i++;
        }
        System.out.println(encrypted);
    }
    //helper functions
    private int getLenOfString(String str){
        int i = 0;
        try{
            while(true){
                str.charAt(i);
                i++;
            }
        }catch(Exception e){
            return i;
        }
    }
}
