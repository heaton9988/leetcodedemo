public class String395_longestSubstring_2 {
    public int longestSubstring(String s, int k) {
        char[] arr = s.toCharArray();
        return check(arr, 0, arr.length - 1, k);
    }

    public int check(char[] arr, int start, int end, int k) {
        if (end - start + 1 < k) {
            return 0;
        }
        int[] freqs = new int[26];
        for (int i = start; i <= end; i++) {
            freqs[arr[i] - 'a']++;
        }
        boolean f = true;
        for (int i = 0; i < freqs.length; i++) {
            if (freqs[i] != 0 && freqs[i] < k) {
                f = false;
                break;
            }
        }
        if (f) {
            return end - start + 1;
        }
        while (end - start + 1 >= k && freqs[arr[start] - 'a'] < k) {
            start++;
        }
        while (end - start + 1 >= k && freqs[arr[end] - 'a'] < k) {
            end--;
        }
        if (end - start + 1 < k) {
            return 0;
        }
        for (int i = start + 1; i <= end - 1; i++) {
            if (freqs[arr[i] - 'a'] < k) {
                return Math.max(check(arr, start, i - 1, k), check(arr, i + 1, end, k));
            }
        }
        return check(arr, start, end, k);
    }

    public static void main(String[] args) {
        Object o = new String395_longestSubstring_2().longestSubstring("ababbcaab", 2);
        System.out.println(o);
    }
}