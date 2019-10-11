import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FreqStack {
    int autoIncreId = 0;
    HashMap<Integer, LinkedList<Integer>> value2indexList = new HashMap<>(); // to maintain the value of maxCount
    HashMap<Integer, HashMap<Integer, LinkedList<Integer>>> count2value2indexList = new HashMap<>(); // [occurTimes, [elementValue, elementPositionIndexList]]
    int maxCount = 0;

    public FreqStack() {
    }

    public void push(int x) {
        LinkedList<Integer> indexes = value2indexList.getOrDefault(x, new LinkedList<Integer>());
        value2indexList.put(x, indexes);
        indexes.add(autoIncreId);
        int newCount = indexes.size();
        if (newCount > maxCount) {
            maxCount = newCount;
        }

        LinkedList<Integer> lastIndexList = null;
        if (newCount - 1 > 0) {
            HashMap<Integer, LinkedList<Integer>> value2indexListOld = count2value2indexList.get(newCount - 1);
            lastIndexList = value2indexListOld.remove(new Integer(x));
        }
        HashMap<Integer, LinkedList<Integer>> value2indexList = count2value2indexList.getOrDefault(newCount, new HashMap<Integer, LinkedList<Integer>>(20000));
        count2value2indexList.put(newCount, value2indexList);
        if (lastIndexList != null) {
            value2indexList.put(x, lastIndexList);
        }
        LinkedList<Integer> indexList = value2indexList.getOrDefault(x, new LinkedList<>());
        value2indexList.put(x, indexList);
        indexList.add(autoIncreId);
        autoIncreId++;
    }

    public int pop() {
        HashMap<Integer, LinkedList<Integer>> value2indexList = this.count2value2indexList.get(maxCount);
        int maxIndex = -1;
        int valueOfMaxIndex = 0;

        for (Map.Entry<Integer, LinkedList<Integer>> entry : value2indexList.entrySet()) {
            LinkedList<Integer> indexList = entry.getValue();
            if (indexList.getLast() > maxIndex) {
                maxIndex = indexList.getLast();
                valueOfMaxIndex = entry.getKey();
            }
        }

        this.value2indexList.get(valueOfMaxIndex).removeLast();

        LinkedList<Integer> indexList = value2indexList.get(valueOfMaxIndex);
        indexList.removeLast();
        value2indexList.remove(valueOfMaxIndex);

        if (maxCount - 1 > 0) {
            count2value2indexList.get(maxCount - 1).put(valueOfMaxIndex, indexList);
        }
        if (value2indexList.size() == 0) {
            maxCount--;
        }
        return valueOfMaxIndex;
    }

    public static void main(String[] args) {
        FreqStack fs = new FreqStack();
        fs.push(4);
        fs.push(0);
        fs.push(9);
        fs.push(3);
        fs.push(4);
        fs.push(2);

        System.out.println(fs.pop());
        fs.push(6);
        System.out.println(fs.pop());
        fs.push(1);
        System.out.println(fs.pop());
        fs.push(1);
        System.out.println(fs.pop());
        fs.push(4);
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
    }
}