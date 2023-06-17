import java.util.ArrayList;
import java.util.List;

public class BeautifulSubsets {
    static int count;
    public static void main(String[] args) {
        count= 0;
        int nums[] = {1};
        beautifulSubsets(nums,1);
        System.out.println(count);
    }
    public static int beautifulSubsets(int[] nums, int k) {
        generateSubset(nums,new ArrayList<>(),0,k);
        return 0;
    }
    public static void generateSubset(int[] nums, List<Integer> temp, int index,int k){
        if(index == nums.length) {
            if(temp.size()!=0)
                count++;
            return;
        }
        temp.add(nums[index]);
        if(isPossible(temp,nums[index],k))
            generateSubset(nums,temp,index+1,k);
        temp.remove(temp.size()-1);
        generateSubset(nums,temp,index+1,k);
    }
    public static boolean isPossible(List<Integer> nums,int num,int k){
        for(int i=0;i<nums.size()-1;i++){
            if(Math.abs(num-nums.get(i))==k)
                return false;
        }
        return true;
    }
}
