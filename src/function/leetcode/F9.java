package function.leetcode;

/**
 * F9 判断数值是否时回文类型
 */
public class F9 {

    public boolean fun1(int x) {
        // 小于零不是回文
        if (x < 0) {
            return false;
        }
        // 数字翻转等于原数
        int b = x;
        int a = 0;
        int d = 0;
        // -231 <= x <= 231 - 1 所以不用判断越界
        while(x>0) {
            d = x%10;
            x = x/10;
            a = a*10 + d;
        }
        if (a == b) {
            return true;
        } else {
            return false;
        }
    }

    public boolean fun2(int x) {
        // 小于零不是回文
        if (x < 0) {
            return false;
        }
        // 数字翻转等于原数
        StringBuffer a = new StringBuffer(""+x);
        StringBuffer b = new StringBuffer((new StringBuffer(""+x)).reverse().toString());


        if (a.toString().equals(b.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean fun3(int x) {
        // 小于零不是回文
        if (x < 0) {
            return false;
        }
        // 数字翻转等于原数
        String a = new String(""+x);
        String b = new String();
        int index = a.length()-1;
        while(index>=0) {
            b = b + a.charAt(index);
            index--;
        }

        if (a.equals(b)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean fun4(int x) {
        // 小于零不是回文
        if (x < 0) {
            return false;
        }
        // 数字翻转等于原数
        String a = new String(""+x);
        int index = 0;
        int l = a.length();
        while(index<l) {
            if (a.charAt(index) == a.charAt(l-index-1)) {
                index++;
            } else {
                return false;
            }
        }

        return true;
    }
}
