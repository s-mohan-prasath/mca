package divide_and_conquer;

public class merge_sort {
    int[] a,b;
    int n;
    public merge_sort(int n,int[] arr){
        a = arr;
        this.n = n;
        b = new int[n];
        MergeSort(0,n-1);
    }
    private void MergeSort(int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            MergeSort(low,mid);
            MergeSort(mid+1,high);
            Merge(low,mid,high);
        }
    }
    private void Merge(int low, int mid, int high) {
        int x = low,y = mid+1,i = low;
        while(x<=mid && y<=high){
            if(a[x]<a[y]){
                b[i] = a[x];
                x++;
            }
            else {
                b[i] = a[y];
                y++;
            }
            i++;
        }
        if(x>mid){
            while(y<=high){
                b[i] = a[y];
                i++;
                y++;
            }
        }else{
            while(x<=mid){
                b[i] = a[x];
                i++;
                x++;
            }
        }
        for(int l = low;l<=high;l++)a[l] = b[l];
    }
}