import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {
    public static void main(String[] args) {
        int arr[] = {3,1,1};
        System.out.println(deleteAndEarn(arr));
    }
    public static int deleteAndEarn(int[] nums) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int[] frequency = new int[maxNum + 1];
        for (int num : nums) {
            frequency[num] += num;
        }

        // Step 2: Initialize variables
        int prev = 0;
        int curr = 0;

        // Step 3: Iterate through each element
        for (int i = 1; i <= maxNum; i++) {
            // Step 4: Calculate maximum points for the current element
            int points = Math.max(curr, prev + frequency[i]);

            // Step 5: Update variables for the next iteration
            prev = curr;
            curr = points;
        }

        // Step 6: Return the maximum number of points
        return curr;
    }
}
