public class TargetSum {
    static int count;
    public static void main(String[] args) {
        count = 0;
        int nums[] = {1,1,1,1,1};
        findTargetSumWays(nums,3);
    }
        public static int findTargetSumWays(int[] nums, int target) {
            int sum  = 0;
            for(int i=0;i<nums.length;i++)
                sum += nums[i];
            if(sum == target)
                return 1;
            if(sum < target)
                return 0;
            solve(nums,target,0,0,0);
            System.out.println(count);
            return count;
        }
    public static void solve(int []nums,int target,int sum,int index,int c){
        if(sum == target && c == nums.length)
            count++;
        if(index == nums.length)
            return;
        for(int i = index;i<nums.length;i++){
            solve(nums,target,sum+nums[i],i+1,c+1);
            solve(nums,target,sum-nums[i],i+1,c+1);
        }
    }
}
