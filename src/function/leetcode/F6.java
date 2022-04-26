package function.leetcode;

public class F6 {

    public String fun1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuffer r = new StringBuffer();
        // 根据输入直接计算字符位置
        int m = 2 * numRows - 2;// 这个是摩
        // 根据numRows每间隔m对称
        for (int i = 1; i <= numRows; i++) {// 按照每一行的出现顺序,从第一行开始(依次找出第1行、第二行、第三行...)
            for (int j = i; j <= s.length();) {// 按第i行的会出现的字符位置,同时算出是否有它的对称位置的出现
                //if (j%m == i) {
                r.append(s.charAt(j-1));
                //}
                // 第i行如果时最上或最底部一行则没有对称位置字符
                // 对称位置字符没有超出字符位置
                if (i != 1 && i != numRows && (j - i + 2*numRows - i) <= s.length()) {
                    r.append(s.charAt(j - i + 2*numRows - i - 1));
                }
                j += m;
            }
        }
        return r.toString();
    }
}
