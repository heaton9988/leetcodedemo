import util.Util;

import java.util.Random;

public class Random384_shuffle_FisherYates {
    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public Random384_shuffle_FisherYates(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            int index = randRange(i, array.length);
            swapAt(i, index);
        }
        return array;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Random384_shuffle_FisherYates obj = new Random384_shuffle_FisherYates(new int[]{1, 2, 3});
        for (int i = 0; i < 10; i++) {
            Util.printArr(obj.shuffle());
        }
        int[] a2 = obj.reset();
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}