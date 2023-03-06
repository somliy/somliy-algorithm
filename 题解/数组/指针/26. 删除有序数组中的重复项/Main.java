import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int res = removeDuplicates(arr);
        System.out.print(res);
    }

    public static int removeDuplicates(int[] nums) {
        int slow = 0, index = nums[0] - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != index) {
                nums[slow++] = nums[i];
                index = nums[i];
            }
        }
        return slow;
    }
}