import java.util.*;

public class SubTreeSum {
    public static void main(String[] args) {

    }
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        sum(root,map);
        int key = Collections.max(map.entrySet(),Map.Entry.comparingByValue()).getKey();
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(map.get(key) == entry.getValue())
                ans.add(entry.getKey());
        }
        int res[] = new int[ans.size()];
        for(int i=0;i<ans.size();i++)
            res[i] = ans.get(i);
        return res;
    }
    public static int sum(TreeNode root, Map<Integer,Integer> tracker){
        if(root == null)
            return 0;
        int leftsum = sum(root.left,tracker);
        int rightsum = sum(root.right,tracker);
        int currentSum = leftsum + rightsum + root.val;
        tracker.put(currentSum,tracker.getOrDefault(currentSum,0)+1);
        return currentSum;
    }
}
