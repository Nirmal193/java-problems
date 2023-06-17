import java.util.*;

public class PartitionKEqualSubsets {
    public static void main(String[] args) {
        int arr[] = {4,3,2,3,5,2,1};
        System.out.println(canPartitionKSubsets(arr,4));
    }
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum%k != 0)
            return false;
        int noOfPartitions = sum/k;
        Arrays.stream(nums).boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
        int groups[] = new int[k];
        return solve(nums,k,groups,0,noOfPartitions);
    }
    public static boolean solve(int[] nums, int k,int groups[],int index,int target){
        if(index == nums.length)
            return true;
        for(int i=0;i<groups.length;i++){
            if(groups[i] + nums[index] <= target) {
                groups[i] += nums[index];
                if(solve(nums,k,groups,index+1,target))
                    return true;
                groups[i] -= nums[index];
            }
            if(groups[i] == 0)
                break;
        }
        return false;
    }
}
