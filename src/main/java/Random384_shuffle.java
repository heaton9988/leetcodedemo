import util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Random384_shuffle {
    private int[] array;
    private int[] original;

    private Random rand = new Random();

    private List<Integer> getArrayCopy() {
        List<Integer> asList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            asList.add(array[i]);
        }
        return asList;
    }

    public Random384_shuffle(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }

    public int[] shuffle() {
        List<Integer> aux = getArrayCopy();
        for (int i = 0; i < array.length; i++) {
            int removeIdx = rand.nextInt(aux.size());
            array[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
        }
        return array;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Random384_shuffle obj = new Random384_shuffle(new int[]{1, 2, 3});
        for (int i = 0; i < 10; i++) {
            Util.printArr(obj.shuffle());
        }
        int[] a2 = obj.reset();
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}