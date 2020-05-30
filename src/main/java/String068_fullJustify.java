import java.util.ArrayList;
import java.util.List;

public class String068_fullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<List<String>> lists = new ArrayList<>();
        int index = 0;
        int countSize = 0;
        lists.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            List<String> currList = lists.get(index);
            int currSize = words[i].length();
            int checkSize = currList.size() + countSize + currSize; // 最少空格的个数 + 之前list里word的个数+当前单词的个数
            if (checkSize <= maxWidth) {
                currList.add(words[i]);
                countSize += words[i].length();
            } else {
                index++;
                ArrayList<String> list = new ArrayList<>();
                list.add(words[i]);
                countSize = words[i].length();
                lists.add(list);
            }
        }

        List<String> res = new ArrayList<>();
        for (int x = 0; x < lists.size(); x++) {
            List<String> list = lists.get(x);
            int listSize = list.size();
            if (x >= lists.size() - 1) {
                StringBuilder sb = new StringBuilder(list.get(0));
                for (int j = 1; j < listSize; j++) {
                    sb.append(' ').append(list.get(j));
                }
                res.add(paddingRight(sb.toString(), maxWidth));
            } else if (listSize == 1) {
                res.add(paddingRight(list.get(0), maxWidth));
            } else {
                StringBuilder sb = new StringBuilder(list.get(0));
                int wordSize = 0;
                for (String s : list) {
                    wordSize += s.length();
                }
                int spaceSize = maxWidth - wordSize;
                int avg = spaceSize / (listSize - 1);
                int spaceLeft = spaceSize - avg * (listSize - 1);

                for (int i = 1; i < listSize; i++) {
                    int loopTimes = avg;
                    if (i <= spaceLeft) {
                        loopTimes++;
                    }
                    for (int l = 0; l < loopTimes; l++) {
                        sb.append(' ');
                    }
                    sb.append(list.get(i));
                }
                res.add(sb.toString());
            }
        }
        return res;
    }

    private String paddingRight(String s, int n) {
        char[] c = new char[n];
        int index = 0;
        for (char ch : s.toCharArray()) {
            c[index++] = ch;
        }
        while (index < n) {
            c[index++] = ' ';
        }
        return new String(c);
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Object o = new String068_fullJustify().fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16);
//        Object o = new String068_fullJustify().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}