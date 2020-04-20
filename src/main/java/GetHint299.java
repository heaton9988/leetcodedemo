import java.util.HashMap;
import java.util.HashSet;

public class GetHint299 {
    public String getHint(String secret, String guess) {
        int rightall = 0;

        int[] s = new int[10];
        int[] g = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            int ds = secret.charAt(i) - '0';
            int dg = guess.charAt(i) - '0';
            s[ds]++;
            g[dg]++;
            if (ds == dg) {
                rightall++;
            }
        }
        int righterr = 0;
        for (int i = 0; i < 10; i++) {
            righterr += Math.min(s[i], g[i]);
        }

        return rightall + "A" + (righterr - rightall) + "B";
    }

    public static void main(String[] args) {
        GetHint299 obj = new GetHint299();
        long start = System.currentTimeMillis();
        Object v = obj.getHint("1807", "7810");
        System.out.println(v);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}