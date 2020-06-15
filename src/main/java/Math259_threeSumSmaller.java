import java.util.*;

public class Math259_threeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        HashSet<Pair> pairs = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
//            if (nums[i] >= target && nums[i + 1] > 0) break;
            for (int j = i + 1; j < n - 1; j++) {
                int sumIJ = nums[i] + nums[j];
//                if (sumIJ >= target && nums[j + 1] > 0) break;
                for (int k = j + 1; k < n; k++) {
                    int sum = sumIJ + nums[k];
                    if (sum < target) {
                        pairs.add(new Pair(nums[i], nums[j], nums[k]));
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(pairs);
        return pairs.size();
    }

    class Pair {
        int x, y, z;

        Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return "{" + x + "," + y + "," + z + '}';
        }

        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y && z == pair.z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }
    }

    public static void main(String[] args) {
        Object o = new Math259_threeSumSmaller().threeSumSmaller(new int[]{ -2, 0, 1, 1, 2}, 1);
        System.out.println(o);
    }
}