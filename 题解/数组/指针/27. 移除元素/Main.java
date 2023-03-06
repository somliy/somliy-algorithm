import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 2, 3};
        int val = 3;
        int res = removeElement(arr, val);
        System.out.print(res);
    }

    public static int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[slow++] = nums[i];
            }
        }
        return slow;
    }
}