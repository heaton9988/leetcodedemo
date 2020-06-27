import java.util.ArrayList;
import java.util.List;

public class Backtracking282_addOperators {
    public ArrayList<String> answer;
    public String nums;
    public long target;

    public List<String> addOperators(String num, int target) {
        if (num.length() == 0) {
            return new ArrayList<String>();
        }
        this.target = target;
        this.nums = num;
        this.answer = new ArrayList<String>();
        this.recurse(0, 0, 0, 0, new ArrayList<String>());
        return this.answer;
    }

    public void recurse(int index, long preVal, long currVal, long preResult, ArrayList<String> ops) {
        // Done processing all the digits in num
        if (index == nums.length()) {
            // If the final value == target expected AND
            // no operand is left unprocessed
            if (preResult == this.target && currVal == 0) {
                StringBuilder sb = new StringBuilder();
                ops.subList(1, ops.size()).forEach(v -> sb.append(v));
                this.answer.add(sb.toString());
            }
            return;
        }

        // Extending the current operand by one digit
        currVal = currVal * 10 + Character.getNumericValue(nums.charAt(index));
        String strCurrVal = Long.toString(currVal);

        if (currVal > 0) { // To avoid cases where we have 1 + 05 or 1 * 05 since 05 won't be a valid operand. Hence this check
            // NO OP recursion
            recurse(index + 1, preVal, currVal, preResult, ops);
        }

        // ADDITION
        ops.add("+");
        ops.add(strCurrVal);
        recurse(index + 1, currVal, 0, preResult + currVal, ops);
        ops.remove(ops.size() - 1);
        ops.remove(ops.size() - 1);

        if (ops.size() > 0) {
            // SUBTRACTION
            ops.add("-");
            ops.add(strCurrVal);
            recurse(index + 1, -currVal, 0, preResult - currVal, ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);

            // MULTIPLICATION
            ops.add("*");
            ops.add(strCurrVal);
            recurse(index + 1, currVal * preVal, 0, preResult - preVal + (currVal * preVal), ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object o = new Backtracking282_addOperators().addOperators("123", 15);
        System.out.println(System.currentTimeMillis() - start + " ms");
        System.out.println(o);
    }
}