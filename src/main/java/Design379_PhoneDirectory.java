public class Design379_PhoneDirectory {
    int[] next;
    int head = 0;
    int isNotAValid = -2;

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    public Design379_PhoneDirectory(int maxNumbers) {
        next = new int[maxNumbers];
        for (int i = 0; i < maxNumbers; i++) {
            next[i] = i + 1;
        }
        next[maxNumbers - 1] = -1;
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        if (head == -1) return -1;
        int result = head;
        head = next[head];
        next[result] = isNotAValid;
        return result;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        return next[number] != isNotAValid;
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        if (next[number] != isNotAValid) return;
        next[number] = head;
        head = number;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Design379_PhoneDirectory directory = new Design379_PhoneDirectory(3);

// 可以返回任意未分配的号码，这里我们假设它返回 0。
        directory.get();

// 假设，函数返回 1。
        directory.get();

// 号码 2 未分配，所以返回为 true。
        directory.check(2);

// 返回 2，分配后，只剩一个号码未被分配。
        directory.get();

// 此时，号码 2 已经被分配，所以返回 false。
        directory.check(2);

// 释放号码 2，将该号码变回未分配状态。
        directory.release(2);

// 号码 2 现在是未分配状态，所以返回 true。
        directory.check(2);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}