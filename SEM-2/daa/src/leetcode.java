import java.util.Arrays;

public class leetcode {
    static int[] nums;
    static int len;
    public static void main(String[] args){
        nums = new int[]{5,10,10,7,6,8,7};
        len =  nums.length;
        Divide(0);
        System.out.println(Arrays.toString(nums));
    }
    private static int Divide(int i){
        int left = getLeft(i);
        int right = getRight(i);
        int value;
        if(left<len){
            value = Divide(left);
            if(value>nums[i]){
                nums[left] = nums[i];
                nums[i] = value;
            }
        }
        if(right<len){
            value = Divide(right);
            if(value>nums[i]){
                nums[right] = nums[i];
                nums[i] = value;
            }
        }
        return nums[i];
    }
    private static int getParent(int i){
        return (i-1)/2;
    }
    private static int getLeft(int i){
        return 2*i+1;
    }
    private static int getRight(int i){
        return 2*i+2;
    }
}
