import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permuteUnique {
    public static void main(String[] args) {
        int arr[] = {1,2,2};
        List<List<Integer>> ans = permuteUnique(arr);
        for(int i=0;i<ans.size();i++){
            for(int j=0;j<ans.get(i).size();j++){
                System.out.print(ans.get(i).get(j)+"->");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        Arrays.sort(nums);
        generatePermute(nums,used,new ArrayList<>(),result);
        return result;
    }
    public static void generatePermute(int nums[],boolean used[],List<Integer> tempList,List<List<Integer>> result){
        if(tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        else {
            for(int i=0;i<nums.length;i++){
                if(used[i] || (i>0 && nums[i] == nums[i-1] && !used[i-1]))
                    continue;
                used[i] = true;
                tempList.add(nums[i]);
                generatePermute(nums,used,tempList,result);
                tempList.remove(tempList.size()-1);
                used[i] = false;
            }
        }
    }
}
