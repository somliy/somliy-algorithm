import java.util.Random;

public class FindKthLargest {

    private static final Random RANDOM = new Random();


    /**
     * 题意：
     * 解析：
     *
     * @param args arg
     */
    public static void main(String[] args) {
//        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
        int[] nums = new int[]{-1, -1};
        int kthLargest = findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int target = len - k;

        while (true) {
            int res = find(nums, left, right);
            if (res == target) {
                return nums[res];
            } else if (res > target) {
                right = res - 1;
            } else {
                left = res + 1;
            }
        }
    }

    public static int find(int[] nums, int left, int right) {
        swap(nums, left, left + RANDOM.nextInt(right - left + 1));
        int i = left + 1;
        int j = right;
        int index = nums[left];

        while (true) {
            while (i <= right && nums[i] < index) {
                i++;
            }
            while (j > left && nums[j] > index) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, left, j);
        return j;
    }


    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
