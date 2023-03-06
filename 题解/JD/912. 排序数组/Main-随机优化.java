import java.util.Arrays;
import java.util.Random;

public class Main {

    private static final Random RANDOM = new Random();


    /**
     * 题意：
     * 解析：
     *
     * @param args arg
     */
    public static void main(String[] args) {
//        int[] nums = new int[]{5, 2, 3, 1};
        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
        int[] ints = sortArray(nums);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] sortArray(int[] nums) {
        // 快速排序
        return quickSort(nums);
    }

    /**
     * 快速排序
     *
     * @param nums 数组
     * @return 结果
     */
    private static int[] quickSort(int[] nums) {
        quickSortFun(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSortFun(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, randomIndex, left);

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
            //相等的元素通过交换，等概率分到数组的两边
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, left, j);
        quickSortFun(nums, left, j - 1);
        quickSortFun(nums, j + 1, right);
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
