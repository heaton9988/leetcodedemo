import util.Util;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix302_minArea {
    public int minArea(char[][] image, int x, int y) {
        int rows = image.length, cols = image[0].length;
        int left = searchColumns(image, 0, y, 0, rows, true);
        int right = searchColumns(image, y + 1, cols, 0, rows, false);
        int top = searchRows(image, 0, x, left, right, true);
        int bottom = searchRows(image, x + 1, rows, left, right, false);
        return (right - left) * (bottom - top);
    }

    private int searchColumns(char[][] image, int i, int j, int top, int bottom, boolean whiteToBlack) {
        while (i != j) {
            int k = top, mid = (i + j) / 2;
            while (k < bottom && image[k][mid] == '0') {
                ++k;
            }
            if (k < bottom == whiteToBlack) { // k < bottom means the column mid has black pixel
                j = mid; //search the boundary in the smaller half
            } else {
                i = mid + 1; //search the boundary in the greater half
            }
        }
        return i;
    }

    private int searchRows(char[][] image, int i, int j, int left, int right, boolean whiteToBlack) {
        while (i != j) {
            int k = left, mid = (i + j) / 2;
            while (k < right && image[mid][k] == '0') {
                ++k;
            }
            if (k < right == whiteToBlack) { // k < right means the row mid has black pixel
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Object obj = new Matrix302_minArea().minArea(Util.str2charMatrix("0010,0110,0100"), 0, 2);
        System.out.println(obj);
    }
}