package function.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串""。
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class F14 {

    public String fun1(String[] strs) {
        String r = "";
        try {
            if (strs == null || strs.length == 0) {
                return "";
            } else if (strs.length == 1){
                return strs[0];
            }
            boolean flag = true;
            int i = 0;
            int a = strs[0].length();
            int b = strs.length;
            // 找第一个和其他不一样的
            for (i = 0; i < strs[0].length(); i++) {// 第一个string
                flag = true;
                // 剩余string
                for (int j = 1; j < strs.length; j++) {
//                    System.out.println(i + "/" + j);
                    if (strs[j].length() <= i) {// 越界
                        flag = false;
                        break;
                    }
                    else if (strs[0].charAt(i) == strs[j].charAt(i)) {// 相同next
                        continue;
                    } else {// 不同
                        flag = false;
                        break;
                    }
                }
                // 失败出现
                if (!flag) {
                    break;
                } else {
                    r = r + strs[0].charAt(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("exception");
        }
        return r;
    }

    public String fun2(String[] strs) {
        String r = "";
        try {
            if (strs == null || strs.length == 0) {
                return "";
            } else if (strs.length == 1){
                return strs[0];
            }
            boolean flag = true;
            int i = 0;
            int a = strs[0].length();
            int b = strs.length;
            int l = 0;
            int h = strs[0].length();
            // 找第一个和其他不一样的
            for (i = 0; i < a; i++) {// 第一个string
                flag = true;
                // 剩余string
                for (int j = 1; j < b; j++) {

                    if (a > strs[j].length()) {
                        a = strs[j].length();
                    }
//                    System.out.println(i + "/" + j);
                    if (strs[j].length() <= i) {// 越界
                        flag = false;
                        break;
                    }
                    else if (strs[0].charAt(i) == strs[j].charAt(i)) {// 相同next
                        continue;
                    } else {// 不同
                        flag = false;
                        break;
                    }
                }
                // 失败出现
                if (!flag) {
                    break;
                } else {
                    r = r + strs[0].charAt(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("exception");
        }
        return r;
    }

    public String fun3(String[] strs) {
        String r = "";
        try {
            if (strs == null || strs.length == 0) {
                return "";
            } else if (strs.length == 1){
                return strs[0];
            }

            int m = strs[0].length();

            for (int i = 0; i < strs.length; i++) {
                if (m > strs[i].length()) {
                    m = strs[i].length();
                }
            }

            return fun_1(strs, m, 0, strs.length-1);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("exception");
        }
        return r;
    }

    public String fun4(String[] strs) {
        String r = "";
        try {
            if (strs == null || strs.length == 0) {
                return "";
            } else if (strs.length == 1){
                return strs[0];
            }
            return fun_1(strs, 0, strs.length-1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("exception");
        }
        return r;
    }

    public String fun_1(String[] strs, int l, int h) {

        if (h - l < 2) {
            int a = strs[l].length() > strs[h].length() ? strs[h].length() : strs[l].length();
            for (int i = 0; i < a; i++) {
                if (strs[l].charAt(i) == strs[h].charAt(i)) {
                    continue;
                } else {
                    return strs[l].substring(0, i);
                }
            }
            return strs[l].substring(0, a);
        } else {
            String s1 = fun_1(strs, l, (l+h)/2);
            String s2 = fun_1(strs, (l+h+1)/2, h);
            String[] s = {s1, s2};
            return fun_1(s, 0, 1);
        }
    }

    public String fun_1(String[] strs, int m, int l, int h) {

        if (h - l < 2) {
            for (int i = 0; i < m; i++) {
                if (strs[l].charAt(i) == strs[h].charAt(i)) {
                    continue;
                } else {
                    return strs[l].substring(0, i);
                }
            }
            return strs[l].substring(0, m);
        } else {
            String s1 = fun_1(strs, m, l, (l+h)/2);
            String s2 = fun_1(strs, m, (l+h+1)/2, h);
            String[] s = {s1, s2};
            m = m > s1.length() ? s1.length() : m;
            m = m > s2.length() ? s2.length() : m;
            return fun_1(s, m, 0, 1);
        }
    }
}
