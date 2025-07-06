package divide_and_conquer;

import jdk.jfr.Description;

import java.util.Arrays;
@Description("This algorithm will not give you the correct answer")
public class quick_sort {
    int[] a;
    int n;
    public quick_sort(int[] a) {
        this.a = a;
        this.n = a.length;
        QuickSort(0, n - 1);
        System.out.println(Arrays.toString(a));
    }
    private void QuickSort(int p,int q) {
        int j = Partition(p,q);
        if(p<j-1)QuickSort(p,j-1);
        if(j+1<q)QuickSort(j+1,q);
    }
    private int Partition(int m,int p){
        /**
         *  m - low
         *  p - high
         */
        int pivot = m;
        int ele = a[pivot];
        int i = m+1;
        int j = p;
        while(i<j){
            while(j>m && a[pivot]<a[j])j--;
            while(i<p && a[pivot]>a[i])i++;
            if(i<j){
                int x = a[i];
                a[i] = a[j];
                a[j] = x;
            }
        }
        if(i!=j && j>m){
            a[m] = a[j];
            a[j] = ele;
        }
        return j;
    }
}
