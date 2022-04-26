package function.leetcode;

import java.util.*;

/**
 * F3 字符串中最长字串的长度
 */
public class F3 {

    public int lengthOfLongestSubstring(String s) {
        int r = 0;

        // 字符串转换字符存储至有序序列
        // Set<Character> c = new LinkedHashSet<Character>();
        List<Character> l = new ArrayList<Character>();
        // 方式一
        for (int i = 0; i < s.length(); i++) {
            if (l.contains(s.charAt(i))) {
                while (l.contains(s.charAt(i))) {
                    l.remove(0);
                }
                l.add(s.charAt(i));
            } else {
                l.add(s.charAt(i));
                if (l.size() > r) {
                    r = l.size();
                }
            }
            /*
            if (r > s.length - i) {
                break;
            }
            */
        }

        // 返回
        return r;
    }

    public int fun2(String s) {
        int r = 0;

        int sta = 0;
        int end = 1;

        // 方式二 双指针型窗口滑动
        for (int i = 0; i < s.length(); i++) {// 开始位置
            Set<Character> set = new HashSet<Character>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {// 结束位置

                if (set.contains(s.charAt(j))) {// 包含结束位置
                    // 当前子串是i到j的最大长
                    if (r < j - i) {
                        r = j - i;
                    }
                    break;
                } else if (j == s.length() - 1) {
                    // 当前子串是i到j的最大长
                    if (r < j - i + 1) {
                        r = j - i + 1;
                    }
                    break;
                }

                set.add(s.charAt(j));
            }
        }

        // 返回
        return r;
    }

}
