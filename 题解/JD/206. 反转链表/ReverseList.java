public class ReverseList {

    /**
     * 题意：给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * 思路：既然是链表，进行循环即可，因为需要反向输出，循环的第一个节点就是最后一个节点，每次循环时，新建一个节点，使此节点的next指针指向循环节点的值。
     *
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

        ListNode res = reverseList(listNode1);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        // 结果链表
        ListNode res = new ListNode();
        // 第一个节点特殊判断，作为新链表最后一个节点的值
        if (head != null) {
            res.val = head.val;
        } else {
            return null;
        }
        while (true) {
            if (head.next != null) {
                head = head.next;
                // 新节点作为父节点，t一直为循环至此的，结果的，第一个节点
                ListNode t = new ListNode();
                t.val = head.val;
                t.next = res;
                // res替换为新的第一个节点
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