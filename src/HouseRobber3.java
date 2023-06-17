import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class HouseRobber3 {
    public static void main(String[] args) {

    }

    public int robed(TreeNode root) {
        List<Integer> houses = transformTree(root);
        int dp[] = new int[houses.size()];
        dp[0] = houses.get(0);
        dp[1] = Math.max(houses.get(0),houses.get(1));
        for(int i=2;i<houses.size();i++){
            dp[i] = Math.max(houses.get(i) + dp[i-2],dp[i-1]);
        }
        return dp[houses.size()-1];
    }

    public List<Integer> transformTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int sz = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode curr = queue.poll();
                temp.add(curr.val);
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            ans.add(temp);
        }
        return ans.stream().map(x -> x.stream().collect(Collectors.summingInt(Integer::intValue)))
                .collect(Collectors.toList());
    }
    public int rob(TreeNode root) {
        int ans[] = robsub(root);
        return Math.max(ans[0],ans[1]);
    }
    public int[] robsub(TreeNode root){
        if(root == null)
            return new int[2];
        int left[] = robsub(root.left);
        int right[] = robsub(root.right);
        int result[] = new int[2];
        result[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        result[1] = root.val + left[0] + right[0];
        return result;
    }
}
