import java.util.*;

class Main {
    public static void main(String[] args) {
        Heap<Integer> h = new Heap<>();
        int[] arr = new int[] { 7, 8, 9, 5, 11, 12, 14, 13, 10 };
        for (int i : arr) {
            h.add(i);
        }
        System.out.println(h.getMin());
        System.out.println(h.minHeap.toString());
        System.out.println(h.getMin());
        System.out.println(h.minHeap.toString());
        System.out.println(h.getMin());
        System.out.println(h.minHeap.toString());
    }
}

// min heap
class Heap<T extends Comparable<T>> {
    ArrayList<T> minHeap = new ArrayList<>();
    ArrayList<T> maxHeap = new ArrayList<>();

    public T getMin() {
        if (minHeap.isEmpty())
            return null;
        else {
            T node = minHeap.get(0);
            minHeap.set(0, minHeap.get(minHeap.size() - 1));
            minHeap.remove(minHeap.size() - 1);
            int len = minHeap.size() - 1;
            int pointer = 0;
            while (pointer < len && left(pointer) < len || right(pointer) < len) {
                if (left(pointer) < len && right(pointer) < len) {
                    if (minHeap.get(left(pointer)).compareTo(minHeap.get(right(pointer))) < 0) {
                        swap(pointer, left(pointer), true);
                        pointer = left(pointer);
                    } else {
                        swap(pointer, right(pointer), true);
                        pointer = right(pointer);
                    }
                } else {
                    if (left(pointer) < len) {
                        swap(pointer, left(pointer), true);
                        pointer = left(pointer);
                    }
                    break;
                }
            }
            return node;
        }
    }

    public void add(T o) {
        minHeap.add(o);
        maxHeap.add(o);
        heapify(minHeap.size() - 1, true);
        heapify(maxHeap.size() - 1, false);
        System.out.println("MIN Heap : " + minHeap.toString());
        System.out.println("MAX Heap : " + maxHeap.toString());
    }

    private void heapify(int pointer, boolean isMinHeap) {
        int parentI = parent(pointer);
        while (pointer > 0) {
            if (isMinHeap) {
                if (minHeap.get(pointer).compareTo(minHeap.get(parentI)) < 0) {
                    swap(pointer, parentI, isMinHeap);
                    pointer = parentI;
                } else
                    break;
            } else {
                if (maxHeap.get(pointer).compareTo(maxHeap.get(parentI)) > 0) {
                    swap(pointer, parentI, isMinHeap);
                    pointer = parentI;
                } else
                    break;
            }
            parentI = parent(pointer);
        }
    }

    private void swap(int i1, int i2, boolean isMinHeap) {
        T temp;
        if (isMinHeap) {
            temp = minHeap.get(i1);
            minHeap.set(i1, minHeap.get(i2));
            minHeap.set(i2, temp);
        } else {
            temp = maxHeap.get(i1);
            maxHeap.set(i1, maxHeap.get(i2));
            maxHeap.set(i2, temp);
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }
}