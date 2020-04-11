package mine;

import util.Util;

public class MaxHeap {
    int[] data;
    int capacity;
    int size;

    public MaxHeap() {
        this.data = new int[10];
        this.capacity = this.data.length;
    }

    public void add(int value) {
        if (size == capacity) {
            throw new RuntimeException("full");
        }
        this.data[size++] = value;
        siftUp();
        Util.printArr(data);
    }

    public int remove() {
        if (size == 0) {
            throw new RuntimeException("empty");
        }
        int ret = data[0];
        data[0] = -1;

        swap(data, 0, size - 1);

        siftDown();
        size--;
        Util.printArr(data);
        return ret;
    }

    public void siftUp() {
        int lastIndex = size - 1;
        int parentIndex;
        while ((parentIndex = getParentIndex(lastIndex)) >= 0 && data[lastIndex] > data[parentIndex]) {
            swap(data, lastIndex, parentIndex);
            lastIndex = parentIndex;
        }
    }

    public void siftDown() {
        if (size <= 1) return;

        int parentIndex = 0;
        while (true) {
            int leftIndex = getLeftIndex(parentIndex);
            int rightIndex = getRightIndex(parentIndex);
            int left = left(parentIndex);
            int right = right(parentIndex);

            if (data[parentIndex] >= left && data[parentIndex] >= right) break;

            if (left > right) {
                swap(data, leftIndex, parentIndex);
                parentIndex = leftIndex;
            } else {
                swap(data, rightIndex, parentIndex);
                parentIndex = rightIndex;
            }
        }
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftIndex(int index) {
        int leftIndex = index * 2 + 1;
        if (leftIndex > size - 1) {
            return -1;
        }
        return leftIndex;
    }

    private int getRightIndex(int index) {
        int rightIndex = index * 2 + 2;
        if (rightIndex > size - 1) {
            return -1;
        }
        return rightIndex;
    }

    private int left(int index) {
        int leftIndex = getLeftIndex(index);
        if (leftIndex < 0) return -1;
        else return data[leftIndex];
    }

    private int right(int index) {
        int rightIndex = getRightIndex(index);
        if (rightIndex < 0) return -1;
        else return data[rightIndex];
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        for (int i = 0; i < 10; i++) {
            maxHeap.add(i + 1);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("result = " + maxHeap.remove());
        }
        for (int i = 0; i < 10; i++) {
            maxHeap.add(i + 1);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("result = " + maxHeap.remove());
        }
    }
}