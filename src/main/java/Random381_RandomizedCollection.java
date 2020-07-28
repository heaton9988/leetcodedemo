import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class Random381_RandomizedCollection {
    ArrayList<Integer> lst;
    HashMap<Integer, Set<Integer>> idx;
    java.util.Random rand = new java.util.Random();

    public Random381_RandomizedCollection() {
        lst = new ArrayList<Integer>();
        idx = new HashMap<Integer, Set<Integer>>();
    }

    public boolean insert(int val) {
        if (!idx.containsKey(val)) idx.put(val, new LinkedHashSet<Integer>());
        idx.get(val).add(lst.size());
        lst.add(val);
        return idx.get(val).size() == 1;
    }

    public boolean remove(int val) {
        if (!idx.containsKey(val) || idx.get(val).size() == 0) return false;
        int remove_idx = idx.get(val).iterator().next();
        idx.get(val).remove(remove_idx);
        int last = lst.get(lst.size() - 1);
        lst.set(remove_idx, last);
        idx.get(last).add(remove_idx);
        idx.get(last).remove(lst.size() - 1);

        lst.remove(lst.size() - 1);
        return true;
    }

    public int getRandom() {
        return lst.get(rand.nextInt(lst.size()));
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Random381_RandomizedCollection randomSet = new Random381_RandomizedCollection();
        // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        System.out.println(randomSet.insert(1));

        // 返回 false ，表示集合中不存在 2 。
        System.out.println(randomSet.remove(2));

        // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        System.out.println(randomSet.insert(2));

        // getRandom 应随机返回 1 或 2 。
        System.out.println(randomSet.getRandom());

        // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        System.out.println(randomSet.remove(1));

        // 2 已在集合中，所以返回 false 。
        System.out.println(randomSet.insert(2));

        // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
        System.out.println(randomSet.getRandom());
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}