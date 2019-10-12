import java.util.Stack;

public class ValidParentheses020 {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack();
		if (s.trim().equals("")) {
			return true;
		}

		for (char curr : s.toCharArray()) {
			if (stack.isEmpty()) {
				stack.push(curr);
			} else {
				char pop = stack.peek().charValue();
				if (pop == '(' && curr == ')') {
					stack.pop();
					continue;
				} else if (pop == '{' && curr == '}') {
					stack.pop();
					continue;
				} else if (pop == '[' && curr == ']') {
					stack.pop();
					continue;
				} else {
					stack.push(curr);
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses020 obj = new ValidParentheses020();
		long start = System.currentTimeMillis();
		boolean b = obj.isValid("");
		System.out.println(System.currentTimeMillis() - start + " ms");
	}
}