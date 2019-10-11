import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FreqStack2 {
    Map<Integer, Integer> value2freq = new HashMap<>();
    Map<Integer, Stack<Integer>> freq2stack = new HashMap<>();
    int maxFreq = 0;

    public FreqStack2() {
    }

    public void push(int x) {
        int freq = value2freq.getOrDefault(x, 0) + 1;
        value2freq.put(x, freq);
        if (freq > maxFreq) {
            maxFreq = freq;
        }
        Stack<Integer> stack = freq2stack.get(freq);
        if (stack == null) {
            stack = new Stack<>();
            freq2stack.put(freq, stack);
        }
        stack.push(x);
    }

    public int pop() {
        Stack<Integer> stack = freq2stack.get(maxFreq);
        Integer topValue = stack.pop();
        if (stack.size() == 0) {
            maxFreq--;
        }
        value2freq.put(topValue, value2freq.get(topValue) - 1);
        return topValue;
    }

    public static void main(String[] args) {
        FreqStack2 fs = new FreqStack2();
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