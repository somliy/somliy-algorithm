public class Main {
    public static void main(String[] args) {
        int target = 1;
        boolean res = isPerfectSquare(target);
        System.out.print(res);
    }

    public static boolean isPerfectSquare(int num) {
        double tmp = num * 1.0;
        int left = 0, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < tmp / mid) {
                left = mid + 1;
            } else if (mid > tmp / mid) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}