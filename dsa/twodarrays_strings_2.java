import java.util.*;

public class twodarrays_strings_2 {
    public twodarrays_strings_2() {
    }
    //TODO: RECODE THE ALGORITHM TO SATISFY FOR THE NXM ARRAY INPUT RATHER THAN ONLY SATISFYING FOR THE NXN INPUTS
    public int prob1(int[][] arr) {
        /*
         * Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise,
         * return false.
         * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the
         * same elements.
         */
        int i, j, k, mid, iter, startI, startJ, x, mid2, row, col, prev;
        row = arr.length;
        col = arr[0].length;
        x = Math.abs(row - col);
        iter = row + col + x - 3;
        mid = row - 1;
        mid2 = mid + x;
        startI = row - 2;
        startJ = 0;
        k = 0;
        while (k < iter - x) {
            i = startI;
            j = startJ;
            prev = arr[i][j];
            while (i < row) {
                if (prev != arr[i][j]) {
                    System.out.println("Given Matrix is not Toeptliz Matrix");
                    return 0;
                }
                System.out.printf("i = %d, j = %d, val = %d\n", i, j, arr[i][j]);
                i++;
                j++;
            }
            if (k >= mid2 - 1) {
                row--;
            }
            if (k < mid - 1) {
                startI--;
            } else {
                startJ++;
            }
            System.out.printf("\n");
            k++;
        }
        System.out.println("Given Matrix is a Toeplitz Matrix");
        return 1;
    }
    //TODO: COMPLETE PROBLEM 2
    public void prob2(){

    }
    public int[][] prob3(int r, int c, int[][] arr){
        int x=0,y=0;
        int n = arr.length;
        int m = arr[0].length;
        if(n*m != r*c)return arr;
        int[][] output = new int[r][c];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                    output[x][y] = arr[i][j];
                    y++;
                    if(y==c){
                        y = 0;
                        x++;
                    }
            }
        }
        return output;
    }
    public void prob4(String str){
        String[] alphabets = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        prob4Recursion(0,str.length(),str,"",alphabets);
    }
    public void prob5(){
        // Group the anagrams in the list
//        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        String[] arr = {"a"};
        ArrayList<ArrayList<String>> output = new ArrayList<>();
        ArrayList<String> temporyPass = new ArrayList<String>();
        int i,j,len;
        len = arr.length;
        for(i=0;i<len;i++){
            if(!isPresentInArrayList(arr[i],temporyPass)){
                ArrayList<String> tmp = new ArrayList<String>();
                tmp.add(arr[i]);
                temporyPass.add(arr[i]);
                for(j=i+1;j<len;j++){
                        if (checkAnagram(arr[i], arr[j])) {
                            tmp.add(arr[j]);
                            temporyPass.add(arr[j]);
                        }
                }
                output.add(tmp);
            }
        }
        printArrayListString(output);
    }

    private void prob4Recursion(int i,int len,String str,String s,String[] alphabets){
        if(i==len){
            System.out.printf("%s ",s);
        }
        else{
            String ch = str.substring(i,i+1);
            char[] arr = alphabets[Integer.parseInt(ch)].toCharArray();
            for(char c : arr){
                prob4Recursion(i+1,len,str,s+c,alphabets);
            }
        }
    }
    private boolean checkAnagram(String s1,String s2){
        int[] alp = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int i,len1,len2;

        len1 = s1.length();

        for(i = 0;i<len1;i++){
            char c = s1.charAt(i);
            alp[c-97]+=1;
        }

        len2 = s2.length();

        for(i = 0;i<len2;i++){
            char c = s2.charAt(i);
            alp[c-97]-=1;
        }

        for(i = 0;i<26;i++){
            if(alp[i]!=0){
                return false;
            }
        }
        return true;
    }
    private void printArrayListInteger(ArrayList<ArrayList<Integer>> arr) {
        for (ArrayList<Integer> x : arr) {
            System.out.println(x.toString());
        }
    }
    private void printArrayListString(ArrayList<ArrayList<String>> arr) {
        for (ArrayList<String> x : arr) {
            System.out.println(x.toString());
        }
    }
    private void printArray(int[][] arr){
        for(int[] x : arr){
            System.out.println(Arrays.toString(x));
        }
    }
    private boolean isPresentInArrayList(String target,ArrayList<String> arr){
        for(String s : arr){
            if(s.equals(target))return true;
        }return false;
    }
}