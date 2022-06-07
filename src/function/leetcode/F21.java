package function.leetcode;

/**
 * 合并两个有序链表
 */
public class F21 {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
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
    }

    private ListNode l1 = new ListNode();
    private ListNode l2 = new ListNode();
    private ListNode l3 = new ListNode();

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 判断空链情况
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        // 两条链都存在的情况,将1链并入2链
        else {
            ListNode now = new ListNode();
            ListNode head = now;
            while(list1 != null || list2 != null) {
                // 1.做比较
                if (list1 == null || (list2 != null && list1.getVal() >= list2.getVal())) {
                    now.setNext(list2);
                    // list2向后挪动
                    list2 = list2.getNext();
                } else if(list2 == null || (list1 != null && list1.getVal() < list2.getVal())) {
                    now.setNext(list1);
                    // list1向后挪动
                    list1 = list1.getNext();
                }

                // 2.2now向后挪动
                now = now.getNext();
            }
            return head.getNext();
        }
    }

    public ListNode initList(String s) {
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

    public void initList(String s1, String s2) {
        l1 = initList(s1);
        l2 = initList(s2);
    }

    public void test(String s1, String s2) {
        initList(s1, s2);
        l3 = mergeTwoLists(l1, l2);
        while (l3 != null) {
            if (l3.getNext() != null) {
                System.out.print(l3.getVal() + ",");
            } else {
                System.out.print(l3.getVal());
            }
            l3 = l3.getNext();
        }
    }
}