import java.util.Stack;

//		1.此题主要考察的是栈,所以定义一个辅助栈;
//		2.先把字符串以"/"为分隔符分割成数组,此时数组有"路径"、""、"."、".."这四种情况;
//		3.遍历数组,当s[i].equals("..")并且栈不空时pop,当!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."),即s[i]是路径入栈;
//		4.栈空,返回"/",栈非空,用StringBuffer做一个连接返回即可;
//		5完结。
public class SimplifyPath071 {
	public String simplifyPath(String path) {
		String[] s = path.split("/");
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < s.length; i++) {
			if (s[i].equals("") || s[i].equals(".")) {
				continue;
			} else if (s[i].equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(s[i]);
			}
		}
		if (stack.isEmpty())
			return "/";

		StringBuffer res = new StringBuffer();
		for (int i = 0; i < stack.size(); i++) {
			res.append("/" + stack.get(i));
		}
		return res.toString();
	}

	public static void main(String[] args) {
		SimplifyPath071 obj = new SimplifyPath071();
		long start = System.currentTimeMillis();
		String s = obj.simplifyPath("/a//b////c/d//././/..");
		System.out.println(System.currentTimeMillis() - start + " ms");
	}
}