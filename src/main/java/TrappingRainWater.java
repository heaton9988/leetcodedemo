import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A Star/ A* 算法
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int len = height.length;

        int leftToppest[] = new int[len];
        {
            leftToppest[0] = 0;
            int currToppest = 0;
            for (int i = 1; i < len; i++) {
                if (height[i - 1] > currToppest) {
                    currToppest = height[i - 1];
                }
                leftToppest[i] = currToppest;
            }
        }
        int rightToppest[] = new int[len];
        {
            rightToppest[len - 1] = 0;
            int currToppest = 0;
            for (int i = len - 2; i >= 0; i--) {
                if (height[i + 1] > currToppest) {
                    currToppest = height[i + 1];
                }
                rightToppest[i] = currToppest;
            }
        }

        int ret = 0;
        for (int i = 0; i < len; i++) {
            int top = Math.min(leftToppest[i], rightToppest[i]);
            int bottom = height[i];
            if (top > bottom) {
                ret += top - bottom;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] height = null;
        String originStr = "[0,1,0,2,1,0,1,3,2,1,2,1]";
        Pattern p = Pattern.compile("\\[.+?\\]");
        Matcher m = p.matcher(originStr);
        while (m.find()) {
            String find = m.group().replace("[", "").replace("]", "");
            String[] eles = find.split(",");
            height = new int[eles.length];
            for (int i = 0; i < eles.length; i++) {
                height[i] = Integer.parseInt(eles[i]);
            }
        }

        long start = System.currentTimeMillis();

        int result = new TrappingRainWater().trap(height);
        System.out.println(result);

        System.out.println(System.currentTimeMillis() - start + " ms");
    }

    public static String leftPadding(String s, int number) {
        int diff = number - s.length();
        for (int i = 0; i < diff; i++) {
            s = " " + s;
        }
        return s;
    }
}