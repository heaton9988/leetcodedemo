import java.util.*;

public class Random381_RandomizedCollection_2 {
    Random r = new Random();
    List<Integer> list;
    HashMap<Integer, Set<Integer>> map;

    public Random381_RandomizedCollection_2() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        System.out.println("insert " + val);
        Set<Integer> subList = map.computeIfAbsent(val, k -> new HashSet<>());
        subList.add(list.size());
        list.add(val);
        System.out.println("list=" + list);
        return true;
    }

    public boolean remove(int val) {
        System.out.println("remove " + val);
        Set<Integer> set = map.get(val);
        if (set == null || set.size() == 0) return false;

        int listSize = list.size();

        if (val == list.get(listSize - 1)) {
            list.remove(listSize - 1);
            map.get(val).remove(listSize - 1);
        } else {
            int firstIndex = set.iterator().next();

            int lastValue = list.get(list.size() - 1);
            Set<Integer> lastValueSet = map.get(lastValue);

            list.remove(list.size() - 1);
            lastValueSet.remove(list.size());

            list.set(firstIndex, lastValue);
            lastValueSet.add(firstIndex);

            set.remove(firstIndex);
        }

        System.out.println("list=" + list);
        return true;
    }

    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Random381_RandomizedCollection_2 randomSet = new Random381_RandomizedCollection_2();
        System.out.println(randomSet.insert(4));
        System.out.println(randomSet.insert(3));
        System.out.println(randomSet.insert(4));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.insert(4));
        System.out.println(randomSet.remove(4));
        System.out.println(randomSet.remove(3));
        System.out.println(randomSet.remove(4));
        System.out.println(randomSet.remove(4));
        System.out.println(randomSet.getRandom());
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}