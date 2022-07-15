package function.leetcode;

/**
 * 两两交换链表中的节点
 * 给出一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class F24 {

    public ListNode swapPairs(ListNode head) {
        ListNode la = head;
        ListNode lr = new ListNode();
        ListNode r = lr;
        ListNode b = new ListNode();
        try {
            while (la != null) {
                if (la.getNext() != null) {
                    // 得把链断开,不然就会自循环
                    b = la.getNext();
                    lr.setNext(b);
                    b.setNext(null);
                    lr.getNext().setNext(la);
                } else {
                    lr.setNext(la);
                }
                // 每次走的步长是二
                lr = lr.getNext();
                // 判断最后剩余是否还有两个
                if (la.getNext() != null) {
                    lr = lr.getNext();
                }
                la = la.getNext();// 走一步
                if (la.getNext() != null) {// 还有则再走一步
                    la = la.getNext();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r.getNext();
    }

    public static void main(String[] args) {
        F24 f24 = new F24();
        ListNode l = ListNode.initList("1,2,3,4");
        try {
            ListNode n = f24.swapPairs(l);
            System.out.println(n.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
