public class IsAnagram242 {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (char c : t.toCharArray()) {
            count[c]--;
        }
        for (int num : count) {
            if (num != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Object o = new IsAnagram242().isAnagram("aba", "baa");
        System.out.println(o);
    }
}