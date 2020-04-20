public class CanCompleteCircuit134_2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int total = 0;
        int curr = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            total += gas[i] - cost[i];
            curr += gas[i] - cost[i];
            if (curr < 0) {
                res = i + 1;
                curr = 0;
            }
        }
        return total < 0 ? -1 : res;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        CanCompleteCircuit134_2 obj = new CanCompleteCircuit134_2();
        long start = System.currentTimeMillis();

        Object v = obj.canCompleteCircuit(gas, cost);
        System.out.println(v);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}