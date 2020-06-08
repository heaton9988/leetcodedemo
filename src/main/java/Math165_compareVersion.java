public class Math165_compareVersion {
    public int compareVersion(String version1, String version2) {
        int l = 0, r = 0;
        while (l < version1.length() || r < version2.length()) {
            int left = 0;
            while (l < version1.length() && version1.charAt(l) != '.') {
                left = left * 10 + (version1.charAt(l) - '0');
                l++;
            }
            if (l < version1.length()) l++;
            int right = 0;
            while (r < version2.length() && version2.charAt(r) != '.') {
                right = right * 10 + (version2.charAt(r) - '0');
                r++;
            }
            if (r < version2.length()) r++;
            if (left > right) return 1;
            if (left < right) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        Object o = new Math165_compareVersion().compareVersion("1.01", "1.001.0");
//        Object o = new Math165_compareVersion().compareVersion("1.0.1", "1");
        Object o = new Math165_compareVersion().compareVersion("7.5.2.4", "7.5.3");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}