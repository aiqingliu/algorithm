package function.leetcode;

/**
 * 合并有序链表数组
 */
public class F22 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode h = null;// 头

        // 方式一:一一合并
        for (int i = 0; i < lists.length; i++) {
            // 合并
            h = merge(h, lists[i]);
        }
        System.out.println(h.toString());
        return h;
        // 方式二:一同合并
    }

    public ListNode merge(ListNode head, ListNode n) {
        if (head == null) {
            head = n;
            return head;
        }
        ListNode h = new ListNode();
        ListNode now = h;
        ListNode p = head;
        ListNode q = n;
        while (p != null && q != null) {// 两条链都没走完时
            // 比较当前节点
            if (p.getVal() <= q.getVal()) {
                now.setNext(p);
                p = p.getNext();
            } else {
                now.setNext(q);
                q = q.getNext();
            }
            now = now.getNext();
        }
        now.setNext((p == null ? q : p));
        return h.getNext();
    }

    public ListNode mergeKLists1(ListNode[] lists) {

        ListNode head = new ListNode();// 头
        // 方式一:一一合并
        if (lists != null) {
            head = lists[0];
        }
        for (int i = 1; i < lists.length; i++) {
            // 合并
            head = merge1(head, lists[i]);
        }
        System.out.println(head.toString());
        return head;
    }

    public ListNode merge1(ListNode head, ListNode n) {
        ListNode h = new ListNode();
        ListNode now = h;
        ListNode p = head;
        ListNode q = n;
        while (p != null && q != null) {// 两条链都没走完时
            // 比较当前节点
            if (p.getVal() <= q.getVal()) {
                now.setNext(p);
                p = p.getNext();
            } else {
                now.setNext(q);
                q = q.getNext();
            }
            now = now.getNext();
        }
        now.setNext((p == null ? q : p));
        head = h.getNext();
        return head;
    }

    public static void main(String[] args) {
        String[] sg = new String[]{"2,3,5","1,2,4"};
        ListNode[] listNodes = ListNode.initListGroup(sg);
        F22 f22 = new F22();
        f22.mergeKLists1(listNodes);
    }
}
