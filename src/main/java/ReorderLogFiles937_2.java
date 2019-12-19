import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles937_2 {
    public String[] reorderLogFiles(String[] logs) {
        if (logs.length < 2) {
            return logs;
        }
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String[] split1 = str1.split(" ", 2);
                String[] split2 = str2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                if (!isDigit1 && !isDigit2) {
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0) {

                        return cmp;
                    }
                    return split1[0].compareTo(split2[0]);
                }
                return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
            }
        });
//        quickSort(logs, 0, logs.length - 1);
        return logs;
    }

//    private void quickSort(String[] list, int low, int high) {
//        if (low < high) {
//            int pi = partition(list, low, high);
//            quickSort(list, low, pi - 1);
//            quickSort(list, pi + 1, high);
//        }
//    }

//    private int partition(String[] list, int low, int high) {
//        String pivot = list[high];
//        int i = low - 1;
//        for (int j = low; j < high; j++) {
//            if (compareOrder(list[j], pivot) <= 0) {
//                i++;
//                swap(list, i, j);
//            }
//        }
//        swap(list, i + 1, high);
//        return i + 1;
//    }

//    private int compareOrder(String str1, String str2) {
//        String[] split1 = str1.split(" ", 2);
//        String[] split2 = str2.split(" ", 2);
//        boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
//        boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
//        if (!isDigit1 && !isDigit2) {
//            int cmp = split1[1].compareTo(split2[1]);
//            if (cmp != 0) {
//
//                return cmp;
//            }
//            return split1[0].compareTo(split2[0]);
//        }
//        return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
//    }

//    private void swap(String[] list, int i, int j) {
//        String temp = list[i];
//        list[i] = list[j];
//        list[j] = temp;
//    }

    public static void main(String[] args) {
        ReorderLogFiles937_2 obj = new ReorderLogFiles937_2();
        long start = System.currentTimeMillis();
        String[] results = obj.reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"});
//        String[] results = obj.reorderLogFiles(new String[]{"a1 9 2 3 1", "zo4 4 7"});
        for (String s : results) {
            System.out.println(s);
        }
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}