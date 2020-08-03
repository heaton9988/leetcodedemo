import java.util.*;

public class UnionFind305_numIslands2_hash {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> land2id = new HashMap<Integer, Integer>();
        int num_islands = 0;
        int island_id = 0;

        int[] lastPos = null;
        for (int[] pos : positions) {
            if (lastPos != null && pos[0] == lastPos[0] && pos[1] == lastPos[1]) {
                ans.add(num_islands);
                continue;
            }
            lastPos = pos;
            int r = pos[0], c = pos[1];
            Set<Integer> overlap = new HashSet<Integer>();

            if (r - 1 >= 0 && land2id.containsKey((r - 1) * n + c)) {
                overlap.add(land2id.get((r - 1) * n + c));
            }
            if (r + 1 < m && land2id.containsKey((r + 1) * n + c)) {
                overlap.add(land2id.get((r + 1) * n + c));
            }
            if (c - 1 >= 0 && land2id.containsKey(r * n + c - 1)) {
                overlap.add(land2id.get(r * n + c - 1));
            }
            if (c + 1 < n && land2id.containsKey(r * n + c + 1)) {
                overlap.add(land2id.get(r * n + c + 1));
            }

            if (overlap.isEmpty()) {
                ++num_islands;
                land2id.put(r * n + c, island_id++);
            } else if (overlap.size() == 1) {
                land2id.put(r * n + c, overlap.iterator().next());
            } else {
                int root_id = overlap.iterator().next();
                for (Map.Entry<Integer, Integer> entry : land2id.entrySet()) {
                    int k = entry.getKey();
                    int id = entry.getValue();
                    if (overlap.contains(id)) {
                        land2id.put(k, root_id);
                    }
                }
                land2id.put(r * n + c, root_id);
                num_islands -= (overlap.size() - 1);
            }
            ans.add(num_islands);
        }

        return ans;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        UnionFind305_numIslands2_hash obj = new UnionFind305_numIslands2_hash();
        System.out.println(obj.numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}}));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}