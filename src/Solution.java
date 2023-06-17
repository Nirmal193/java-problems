class Solution {
    public static void main(String[] args) {
        System.out.println(minSteps(10));
    }
    public static int minSteps(int n) {
        return minStepsRecursive(1, 0, n);
    }

    private static int minStepsRecursive(int current, int clipboard, int target) {
        // Base cases
        if (current > target) {
            return Integer.MAX_VALUE; // Invalid state, return a large value
        }
        if (current == target) {
            return 0; // Target achieved, no more operations needed
        }

        // Recursive cases
        int copyAndPaste = 1 + minStepsRecursive(current + clipboard, current, target);
        int paste = 1 + minStepsRecursive(current + clipboard, clipboard, target);

        return Math.min(copyAndPaste, paste);
    }
}
