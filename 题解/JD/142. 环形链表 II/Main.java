import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {

    /**
     * 题意：给出一个链表，链表包含本身数值和下一个数据的地址。需要判断出此链表存不存在环形结构
     * 解析：若链表有环，那么循环链表的话会永远找不到出口，可以利用这个特性，就像人在操场跑步，只要第一名足够快，第一名和最后一名一定会相遇，在链表中循环也是一样利用套圈会相遇的特点，使用两个循环若相遇（相同值）就是有环，否则无环
     *
     * @param args arg
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;

        ListNode res1 = detectCycle1(listNode1);
        System.out.println(res1.val);

        ListNode res2 = detectCycle2(listNode1);
        System.out.println(res2.val);
    }

    /**
     * 哈希法判断
     * 利用哈希表进行判断是是否存在此节点来判断是否存在环形
     * 每次循环时，首先判断是否在Set中
     * - 若不存在则加入到Set中
     * - 若存在则返回节点
     * - 若节点为空，返回空
     * <p>
     * 复杂度分析：O(N) O(N)
     *
     * @param head 链表
     * @return 结果
     */
    public static ListNode detectCycle1(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (true) {
            if (head == null) {
                return null;
            }
            if (nodeSet.contains(head)) {
                return head;
            }
            nodeSet.add(head);
            head = head.next;
        }
    }

    /**
     * 双指针
     * AB两指针分别一次走2和1的距离，因为有距离差，若存在环形结构，一定会被套圈追上
     * 首先计算出相遇的位置，这个位置可以用公式表示（起点到环形距离为lenA，环形长度为lenB）：
     * ∵ A走的速度快
     * ∴ Sa = 2 * Sb（A走过的距离=2*B走过的距离）
     * ∵ A走的多，在追B时，多走了很多圈
     * ∴ Sa = Sb + n * lenB
     * 整合后
     * ∴ Sb = n * lenB   Sa = 2 * n * lenB
     * 所以AB走的距离都可以用lenB表示。
     * <p>
     * 若从起点出发，最终停留在循环入口处，期间转了m圈用公式表示：
     * Res = lenA + m * lenB ①
     * ∵ n m 都是基于链表的实际数字，圈数与位置没有关系
     * ∵ Sb停留的位置一定在环上，但不一定在起点处，结合上面公式①
     * ∴ Sb + lenA 的位置一定是起点，也就是结果
     * <p>
     * 当B走lenA后，即为答案，问题转换为求lenA
     * Sb = n * lenB
     * 令Sa = 0
     * 当Sa = lenA时，Sb = lenA + n * lenB
     *
     * @param head 链表
     * @return 结果
     */
    public static ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}