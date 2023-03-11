import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    /**
     * 题意：
     * 解析：
     *
     * @param args arg
     */
    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(15);

        TreeNode treeNode3 = new TreeNode(20, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(3, treeNode2, treeNode3);
        List<List<Integer>> lists = levelOrder(treeNode1);
        System.out.println(lists);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                int val = poll.val;
                tmp.add(val);

                TreeNode left = poll.left;
                if (left != null) {
                    queue.add(left);
                }
                TreeNode right = poll.right;
                if (right != null) {
                    queue.add(right);
                }
            }
            result.add(tmp);
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
