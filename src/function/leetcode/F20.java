package function.leetcode;

import java.util.*;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 *
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class F20 {

    Map<Character, Integer> cMap = new HashMap<>();

    public F20() {
        cMap.put('(', 1);
        cMap.put(')', 11);
        cMap.put('[', 2);
        cMap.put(']', 12);
        cMap.put('{', 3);
        cMap.put('}', 13);
    }

    public boolean fun1(String s) {
        boolean r = false;
        try {
            // 采用弹栈方式,最后站内没有元素
            if (s == null || s.length() <= 0) {
                return r;
            }
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (stack.empty()) {
                    stack.push(s.charAt(i));
                } else if (cMap.get(stack.peek()) + 10 == cMap.get(s.charAt(i))) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
            if (stack.empty()) {
                r = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public boolean fun2(String s) {
        boolean r = false;
        try {
            // 采用弹栈方式,最后站内没有元素
            if (s == null || s.length() <= 0) {
                return r;
            }
            if (s.length() % 2 == 1) {// 长度是奇数
                return r;
            }
            Stack<Character> stack = new Stack<>();
            stack.push(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                if (stack.empty()) {// 当进栈后就只会在遍历结束时才会弹空
                    break;
                } else if (cMap.get(stack.peek()) + 10 == cMap.get(s.charAt(i))) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
            if (stack.empty()) {
                r = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public boolean fun3(String s) {
        boolean r = false;
        try {
            // 采用弹栈方式,最后站内没有元素
            if (s == null || s.length() <= 1) {// 长度不足
                return r;
            }
            if (s.length() % 2 == 1) {// 长度是奇数
                return r;
            }
            Map<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put(']', '[');
            map.put('}', '{');

            int low = 0;
            int m = 0;
            int i = 0;
            for (i = 0; i < s.length(); i++) {
                if (m == low && m-(i-m-1) < 0) {// 初始位置越界,后挪
                    low = i;
                    m = i;
                } else if (s.charAt(i) == map.get(s.charAt(m-(i-m-1)))) {// 当前位置 和 对称位置 字符比较
                    if (m-(i-m-1) == low) {// 对称位置抵达下界
                        low = i;
                        m = i;
                    }
                    continue;
                } else if (s.charAt(i) != map.get(s.charAt(m-(i-m-1))) && (s.length() - m) < (m - low)) {// 不等 同时 ？ 则是false
                    break;
                } else {// 当不对称时中位后移
                    m = i;
                }
            }
            if (i == s.length()) {
                r = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public boolean fun4(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {// 如果是右边界则左边界应当有对应
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {// 左边界直接进栈
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

}
