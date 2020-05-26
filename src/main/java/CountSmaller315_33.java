import java.util.ArrayList;
import java.util.List;

public class CountSmaller315_33 {
    private int[] count;
    private Item[] items;

    class Item {
        int val;
        int index;

        Item(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(nums[i], i);
        }
        count = new int[n];

        mergeSort(0, n - 1);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(count[i]);
        }
        return res;
    }

    private void mergeSort(int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        mergeSorted(start, mid, mid + 1, end);
    }

    private void mergeSorted(int lowStart, int lowEnd, int highStart, int highEnd) {
        int n = highEnd - lowStart + 1;
        Item[] sorted = new Item[n];
        int sort = 0;
        int l = lowStart, r = highStart;
        int rightCount = 0;
        while (l <= lowEnd && r <= highEnd) {
            if (items[l].val > items[r].val) {
                rightCount++;
                sorted[sort++] = items[r++];
            } else {
                count[items[l].index] += rightCount;
                sorted[sort++] = items[l++];
            }
        }
        while (l <= lowEnd) {
            count[items[l].index] += rightCount;
            sorted[sort++] = items[l++];
        }
        while (r <= highEnd) {
            rightCount++;
            sorted[sort++] = items[r++];
        }
        System.arraycopy(sorted, 0, items, lowStart, n);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        CountSmaller315_33 obj = new CountSmaller315_33();
        System.out.println(obj.countSmaller(new int[]{5, 2, 6, 1}));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}