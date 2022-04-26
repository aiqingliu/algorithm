package function.leetcode;

public class F7 {

    public int fun1(int x) {
        x = -2147483648;
        int r = 0;
        StringBuffer sb = new StringBuffer();
        String s = "";
        if (x < 0) {
            sb.append((x + "").replace("-",""));
            sb.append("-");
        } else {
            sb.append(x + "");
        }
        // 字符串翻转
        s = sb.reverse().toString();
        // 判断数值范围
        if (Long.valueOf(s) < Integer.MIN_VALUE || Long.valueOf(s) > Integer.MAX_VALUE) {
            return 0;
        }
        // 转数值
        r = Integer.valueOf(s);
        // 返回结果
        return r;
    }

    public int fun2(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
