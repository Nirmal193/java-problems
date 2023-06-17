public class mergeStones {
    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 1};
        System.out.println(mergeStones(arr,2));
    }
    public static int mergeStones(int[] stones, int k) {
        int n = stones.length;
        int[][][] memo = new int[n][n][k + 1];
        return mergeHelper(stones, 0, n - 1, 1, k, memo);
    }

    private static int mergeHelper(int[] stones, int left, int right, int piles, int k, int[][][] memo) {
        if (left == right) {
            return (piles == 1) ? 0 : -1; // If piles is not 1, merging is not possible
        }
        if (piles == 1) {
            int cost = mergeHelper(stones, left, right, k, k, memo);
            return (cost == -1) ? -1 : cost;
        }
        if (memo[left][right][piles] != 0) {
            return memo[left][right][piles];
        }

        int minCost = Integer.MAX_VALUE;
        for (int mid = left; mid < right; mid += k - 1) {
            int leftCost = mergeHelper(stones, left, mid, 1, k, memo);
            int rightCost = mergeHelper(stones, mid + 1, right, piles - 1, k, memo);
            if (leftCost != -1 && rightCost != -1) {
                int totalCost = leftCost + rightCost + sum(stones, left, right);
                minCost = Math.min(minCost, totalCost);
            }
        }
        memo[left][right][piles] = (minCost == Integer.MAX_VALUE) ? -1 : minCost;
        return memo[left][right][piles];
    }

    private static int sum(int[] stones, int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += stones[i];
        }
        return sum;
    }

}
