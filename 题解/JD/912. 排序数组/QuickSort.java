import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private static final Random RANDOM = new Random();

    /**
     * 题意：给你一个整数数组 nums，请你将该数组升序排列。
     * 解析：快速排序。
     * 快速排序是采用二分的思维方式，选中数组中的一个数字，以它为标准，左放比它小的数字，右边放大于它的数字，那么这个数字的位置就可以确定了，然后左边的数字、右边的数字重复这一操作，最终排序的数组为一个数字，那么排序也就完成了。
     * 即每次只排一个数字。
     * 优化：选取数字标准的时候，可以从数组中随机挑取，这样会加快排序速度。
     *
     * @param args arg
     */
    public static void main(String[] args) {
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
        // 递归处理
        quickSortFun(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSortFun(int[] nums, int left, int right) {
        // left，right分表代表着需要排序数组的区间，若不满足下属要求，说明已经不需要排序了
        if (left >= right) {
            return;
        }
        // 从数组中随机挑取一个数组与最左边的数字交换，即最左边为此次排序的标准
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, randomIndex, left);

        // 为何+1，是因为left数字为此次排序标准数，不参与排序，只需要最后放到它应该在的地方即可
        int i = left + 1;
        int j = right;
        int index = nums[left];
        while (true) {
            // 从左到右，比标准数小的话直接跳过，相等是不跳过的（原因如下），i是可以到达right的，
            while (i <= right && nums[i] < index) {
                i++;
            }
            // 从右到左，比标注数大的话直接跳过，相等是不跳过的（原因如下），j不允许到达left
            while (j > left && nums[j] > index) {
                j--;
            }
            // 限制左右循环不允许相遇（相遇说明排序完成了）
            if (i >= j) {
                break;
            }
            // i，j分别停留在了大于、小于标准数的位置，交换两个数字使数组满足要求
            // 相等的元素通过交换，等概率分到数组的两边
            swap(nums, i, j);
            i++;
            j--;
        }
        // 最终停留位置与标准数交换，那么标准数已经放到最终位置
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
