public class CanCompleteCircuit134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        outer:
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                int idx = (i + j) % len;
                sum += gas[idx] - cost[idx];
                if (sum < 0) {
                    continue outer;
                }
            }
            return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        CanCompleteCircuit134 obj = new CanCompleteCircuit134();
        long start = System.currentTimeMillis();

        Object v = obj.canCompleteCircuit(gas, cost);
        System.out.println(v);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}