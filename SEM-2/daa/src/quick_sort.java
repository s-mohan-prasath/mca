import java.lang.reflect.Array;
import java.util.Arrays;

public class quick_sort {
    int[] arr;
    int len;
    int temp;
    public quick_sort(int[] arr){
        this.arr = arr;
        len = arr.length;
        this.sort(0,len-1);
        System.out.println(Arrays.toString(arr));
    }
    private void sort(int p, int q){
        System.out.printf("p=%d and q=%d\n",p,q);
        if(p<q){
            int j = partition(p,q);
            sort(p,j-1);
            sort(j+1,q);
        }
    }
    private int partition(int p, int q){
        int pivot = p;
        int i = p;
        int j = q;
        while(i<j){
            System.out.printf("i=%d and j=%d\n",i,j);
            while(i<len && arr[pivot]>arr[i])
                i++;
            while(j>=0 && arr[pivot]<arr[j])j--;
            if(i<=j && i>=0 && j<len){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            System.out.printf("i=%d and j=%d\n",i,j);
        }
        arr[pivot] = arr[j];
        arr[j] = temp;
        return j;
    }
}
