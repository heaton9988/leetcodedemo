package base;

import util.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Java Program sort an integer array using radix sort algorithm.
 * input: [180, 50, 10, 30, 10, 29, 60, 0, 17, 24, 12]
 * output: [0, 10, 10, 12, 17, 24, 29, 30, 50, 60, 180]
 *
 * Time Complexity of Solution:
 *   Best Case O(k*n); Average Case O(k*n); Worst Case O(k*n),
 *   where k is the length of the longest number and n is the
 *   size of the input array.
 *
 *   Note: if k is greater than log(n) then an n*log(n) algorithm would be a
 *         better fit. In reality we can always change the radix to make k
 *         less than log(n).
 *
 */
public class RadixSort {
    public static void radixSort(int[] input) {
        final int RADIX = 10;

        // declare and initialize bucket[]
        List<Integer>[] bucket = new ArrayList[RADIX];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }

        // sort
        boolean maxLength = false;
        int tmp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;

            // split input between lists
            for (Integer i : input) {
                tmp = i / placement;
                bucket[tmp % RADIX].add(i);
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }

            // empty lists into input array
            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : bucket[b]) {
                    input[a++] = i;
                }
                bucket[b].clear();
            }

            // move to next digit
            placement *= RADIX;
        }
    }

    public static void main(String[] args) {
        int[] input = {181, 51, 11, 33, 11, 39, 60, 2, 27, 24, 12};
        Util.printArr(input);
        radixSort(input);
        Util.printArr(input);
    }
}