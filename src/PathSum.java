import java.util.HashMap;
import java.util.Map;

public class PathSum {
    public static int ans = 0;
    public static void main(String[] args) {

    }
    public static int pathSum(TreeNode root, int targetSum) {
        if(root ==null)
            return 0;
        int count = dfs(root,0,targetSum);
        int leftCount = pathSum(root,targetSum);
        int rightCount = pathSum(root,targetSum);
        return count+ leftCount + rightCount;
    }
    public static int dfs(TreeNode root,int currentSum,int targetSum){
        if(root == null)
            return 0;
        int count = 0;
        currentSum += root.val;
        if(targetSum == currentSum)
            count++;
        count += dfs(root.left,currentSum,targetSum);
        count += dfs(root.right,currentSum,targetSum);
        return count;
    }
    public static int wrapper(TreeNode root,int targetSum){
        Map<Long,Integer> map = new HashMap<>();
        map.put(0L,1);
        solve(root,0,targetSum,map);
        return ans;
    }
    public static void solve(TreeNode root, long currentSum,
                       int targetSum, Map<Long,Integer> map){
        if(root == null)
            return;
        currentSum += root.val;
        //Things to be calculated for handling the negative values..
        long removeSum = currentSum - targetSum;
        if(map.containsKey(removeSum)){
            ans += map.get(removeSum);
        }
        map.put((long)currentSum,map.getOrDefault(currentSum,0)+1);
        solve(root.left,currentSum,targetSum,map);
        solve(root.right,currentSum,targetSum,map);
    }
}
