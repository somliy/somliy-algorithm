import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {

    /**
     * @param args arg
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode res1 = reverseList(listNode1);
        System.out.println(res1.val);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode res = new ListNode();
        if (head != null) {
            res.val = head.val;
        } else {
            return null;
        }
        while (true) {
            if (head.next != null) {
                head = head.next;
                ListNode t = new ListNode();
                t.val = head.val;
                t.next = res;
                res = t;
            } else {
                break;
            }
        }
        return res;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}