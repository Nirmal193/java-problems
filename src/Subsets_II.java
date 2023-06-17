import java.util.*;

public class Subsets_II {
    public static void main(String[] args) {
        int[] input = {1,4,4,4,4};
        List<List<Integer>> ans = subsetsWithDup(input);
        for (List<Integer> l1 : ans) {
            for (Integer n : l1) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        subsetsWithDup(set,ans,new ArrayList<>(),nums,0,nums.length);
        System.out.println(ans.size());
        return ans;
    }
    public static void subsetsWithDup(Set<List<Integer>> set,List<List<Integer>> ans,List<Integer> subs
            ,int[] num,int start,int end){
        if(start > end)
            return;
        if(!set.contains(subs)) {
            ans.add(new ArrayList<>(subs));
            set.add(new ArrayList<>(subs));
        }
        for(int i=start;i<end;i++){
            subs.add(num[i]);
            subsetsWithDup(set,ans,subs,num,i+1,end);
            subs.remove(subs.size()-1);
        }
    }
}
