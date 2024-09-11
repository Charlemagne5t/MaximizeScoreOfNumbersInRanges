import java.util.Arrays;

class Solution {
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        int n = start.length;
        if (n == 2) {
            return start[1] - start[0] + d;
        }


        long max = ((long) start[n - 1] + (long) start[0] + (long) d) / (n - 1);
        int res = 0;
        long l = 0;
        long r = max;
        long mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (check(mid, start, d)) {
                res = (int) mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }

    // 0 2 9 9 -> 0 2 9 11
    boolean check(long target, int[] start, int d) {
        long prev = start[0];
        for (int i = 1; i < start.length; i++) {
            if (start[i] - prev < target) {
                if (target - (start[i] - prev) > d) {
                    return false;
                } else {
                    prev = prev + target;
                }
            } else prev = start[i];


        }
        return true;
    }
}