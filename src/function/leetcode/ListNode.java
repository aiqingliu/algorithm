package function.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ListNode {

    private int val;
    private ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode now = this;
        String s = "[";
        while (now != null) {
            s += now.getVal() + ",";
            now = now.getNext();
        }
        s = s.substring(0, s.length()-1);
        s = s + "]";
        return s;
    }

    /**
     * 传入逗号分割的字符串返回ListNode
     * @param s
     * @return ListNode
     */
    public static ListNode initList (String s) {
        ListNode h = new ListNode();
        ListNode n = h;
        String[] lg = s.split(",");
        for (String l: lg) {
            ListNode e = new ListNode();
            e.setVal(Integer.valueOf(l));
            n.setNext(e);
            n = n.getNext();
        }
        return h.getNext();
    }

    /**
     * 字符串数组转ListNode数组
     * @param s
     * @return
     */
    public static ListNode[] initListGroup (String[] s) {
        if (s == null || s.length <= 0) {
            return null;
        }
        List<ListNode> listNodes = new ArrayList<>();
        for (String se : s) {
            listNodes.add(initList(se));
        }
        ListNode[] listNodeg = new ListNode[s.length];
        return listNodes.toArray(listNodeg);
    }

}
