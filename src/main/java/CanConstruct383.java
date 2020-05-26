public class CanConstruct383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int count[] = new int[26];
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Object o = new CanConstruct383().canConstruct("aa", "ab");
        System.out.println(o);
    }
}