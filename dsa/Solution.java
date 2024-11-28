import java.util.*;
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int distinctCount = 0;
        int len = nums.length;
        long sum,maxSum;
        int ele;
        sum = 0;
        for(int i = 0;i<k;i++){
            ele = nums[i];
            if(map.containsKey(ele)){
                if(map.get(ele)==1)distinctCount--;
                int value = map.get(ele)+1;
                map.put(ele,value);
            }else{
                map.put(ele,1);
                distinctCount+=1;
            }
            sum+=nums[i];
        }
        maxSum = (distinctCount==k) ? sum : 0;
        for(int i = 1;i<=len-k;i++){
            //keys
            int left = nums[i-1];
            int right = nums[k+i-1];
            //values
            if(map.get(left)==1)distinctCount--;
            else if(map.get(left)==2)distinctCount++;
            int leftValue = map.get(left)-1;

            int rightValue;
            if(map.containsKey(right)){
                if(map.get(right)==0){
                    distinctCount++;
                }else if(map.get(right)==1){
                    distinctCount--;
                }
                rightValue = map.get(right) + 1;
            }else{
                rightValue = 1;
                distinctCount++;
            }

            map.put(left,leftValue);
            map.put(right,rightValue);

            sum = sum - left + right;
            System.out.println("Sum : "+sum+" distinct : "+distinctCount+"One count : "+map.get(1));
            if(distinctCount==k){
                maxSum = max2(maxSum,sum);
            }
        }
        return maxSum;
    }
    private long max2(long a, long b){
        return (a>b) ? a:b;
    }
}