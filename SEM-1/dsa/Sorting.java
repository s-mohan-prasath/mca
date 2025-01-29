public class Sorting {
    public void radix_sort(int[] arr, int size) {

    }

    public void heap_sort(int[] heap, int size) {
        // BUILD MAX_HEAP
        for (int k = size / 2 - 1; k >= 0; k--)
            heapify(heap, k, size);
        for (int k = size - 1; k >= 0; k--) {
            // SWAP
            int temp = heap[0];
            heap[0] = heap[k];
            heap[k] = temp;
            heapify(heap, 0, --size);
        }
    }

    private void heapify(int[] heap, int i, int size) {
        int largestI = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < size && heap[l] > heap[largestI])
            largestI = l;
        if (r < size && heap[r] > heap[largestI])
            largestI = r;
        if (largestI != i) {
            int temp = heap[i];
            heap[i] = heap[largestI];
            heap[largestI] = temp;
            heapify(heap, largestI, size);
        }
    }

}
