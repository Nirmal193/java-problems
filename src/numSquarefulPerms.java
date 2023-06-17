import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class numSquarefulPerms {
    public int numSquarefulPerms(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int num : count.keySet()) {
            graph.put(num, new ArrayList<>());
        }

        for (int num1 : count.keySet()) {
            for (int num2 : count.keySet()) {
                int sum = num1 + num2;
                if (isPerfectSquare(sum)) {
                    graph.get(num1).add(num2);
                }
            }
        }

        int[] result = new int[1];
        for (int num : count.keySet()) {
            count.put(num, count.get(num) - 1);
            backtrack(num, nums.length - 1, count, graph, result);
            count.put(num, count.get(num) + 1);
        }

        return result[0];
    }

    private void backtrack(int num, int remaining, Map<Integer, Integer> count,
                           Map<Integer, List<Integer>> graph, int[] result) {
        if (remaining == 0) {
            result[0]++;
            return;
        }

        if (!graph.containsKey(num)) {
            return;
        }

        List<Integer> neighbors = graph.get(num);
        for (int neighbor : neighbors) {
            if (count.get(neighbor) > 0) {
                count.put(neighbor, count.get(neighbor) - 1);
                backtrack(neighbor, remaining - 1, count, graph, result);
                count.put(neighbor, count.get(neighbor) + 1);
            }
        }
    }

    private boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    public static void main(String[] args) {
        numSquarefulPerms solution = new numSquarefulPerms();
        int[] nums = {1, 17, 8};
        int count = solution.numSquarefulPerms(nums);
        System.out.println("Number of squareful arrays: " + count);
    }
}
