public class Main {
    public static void main(String[] args) {
        int target = 1;
        int mySqrt = mySqrt(target);
        System.out.print(mySqrt);
    }

    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 0, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
            } else if (mid > x / mid) {
                right = mid - 1;
            }
        }
        return right;
    }
}