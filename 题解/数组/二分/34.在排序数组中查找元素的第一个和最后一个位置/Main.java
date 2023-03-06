public class Main {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 10};
        int target = 8;
        int[] ints = searchRange(nums, target);
        System.out.print(ints[0] + "," + ints[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int leftBorder = searchRangeLeft(nums, target);
        int rightBorder = searchRangeRight(nums, target);
        // 情况一
        if (leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1, -1};
        }
        // 情况三
        if (rightBorder - leftBorder > 1) {
            return new int[]{leftBorder + 1, rightBorder - 1};
        }
        // 情况二
        return new int[]{-1, -1};
    }

    public static int searchRangeLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2; // 记录一下leftBorder没有被赋值的情况
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (target <= nums[middle]) {
                right = middle - 1;
                leftBorder = right;
            } else {
                left = middle + 1;
            }
        }
        return leftBorder;
    }

    public static int searchRangeRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2; // 记录一下rightBorder没有被赋值的情况
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] <= target) {
                left = middle + 1;
                rightBorder = left;
            } else {
                right = middle - 1;
            }
        }
        return rightBorder;
    }
}