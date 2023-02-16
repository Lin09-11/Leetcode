package leetcode.栈;

import 栈.Stack;

import java.util.HashMap;

/**
 * @author lin
 * @creat 2022--12--20:01
 *
 * https://leetcode.cn/problems/valid-parentheses/
 */
public class $_20_有效的括号 {
    private static HashMap<Character, Character> map = new HashMap<>();
    static {
        // key - value
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) { // 去查找map里面有没有这个key---左括号
                stack.push(c);
            } else { // 右括号
                if (stack.isEmpty()) return false;

                if (c != map.get(stack.pop())) //看栈顶弹出的符号根右括号比较是否一样
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') { // 左括号
                stack.push(c);
            } else { // 右括号
                //如果栈是空的，说明括号无效
                if (stack.isEmpty()) return false;

                //如果栈不为空，则出栈
                char left = stack.pop();
                //如果左右符号不匹配，则说明括号无效
                if (left == '(' && c != ')') return false;
                if (left == '{' && c != '}') return false;
                if (left == '[' && c != ']') return false;
            }
        }
        return stack.isEmpty();
    }

    //方法1：
    public boolean isValid2(String s) {
        while (s.contains("{}")
                || s.contains("[]")
                || s.contains("()")) {
            s = s.replace("{}", "");
            s = s.replace("()", "");
            s = s.replace("[]", "");
        }
        //如果为空，则表示匹配
        return s.isEmpty();
    }
}
