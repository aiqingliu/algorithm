package function.leetcode;

import java.util.List;

/**
 * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class F19 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    ListNode head = new ListNode();

    public F19() {

    }

    public F19(int length){
        if (length < 1) {

        } else {
            head.val = 1;
            ListNode eac = head;
            for (int i = 2; i <= length; i++) {
                ListNode e = new ListNode();
                e.val = i;
                eac.next = e;
                eac = eac.next;
            }
        }
        int l = getListNodeLength(head);
        ListNode q = head;
        for (int p = 0; p < l; p++) {
            System.out.println(q.val);
            q = q.next;
        }
    }

    public ListNode fun1(int n) {
        try {
            // n和链表等长
            int l = getListNodeLength(head);
//          System.out.println("链长：" + l);
            // 链表为空或截取为零
            if (head == null || n == 0) {
//            return head;
            }
            /*
            // 当n=1时
            else if (n == 1) {// 处理n=1的情况
                ListNode end;
                end = head;
                if (end.next == null) {
                    head = null;
//                return head;
                } else {
                    while (end.next.next != null) {
                        end = end.next;
                    }
                    end.next = null;
//                return head;
                }
            }
            */
            else if (n == l) {// 处理n=l的情况
                if (head.next != null) {
                    head = head.next;
                } else {
                    head = null;
                }
//            return head;
            } else {// 可以处理l>n>0的情况
                int i = 1;
                ListNode end;
                end = head;
                while (i < (l-n)) {
                    end = end.next;
                    i++;
                }
                if (end != null) {
                    // 限制了长度,所以不成立
                }
                if (end.next != null) {// 当l>n>0时end.next != null
                    end.next = end.next.next;
                } else {// 当n=0时end.next == null

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return head;
    }

    public int getListNodeLength(ListNode head) {
        int l = 0;
        if (head == null) {
            return l;
        }
        l = 1;
        ListNode s = head;
        while(s.next != null) {
            s = s.next;
            l++;
        }
        return l;
    }
}
