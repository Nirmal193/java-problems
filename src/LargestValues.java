import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues {
    public static void main(String[] args) {

    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int sz = queue.size();
            int temp = -1;
            for(int i=0;i<sz;i++){
                TreeNode currNode = queue.poll();
                temp = Math.max(temp,currNode.val);
                if(currNode.left != null)
                    queue.add(currNode.left);
                if(currNode.right != null)
                    queue.add(currNode.right);
            }
            ans.add(temp);
        }
        return ans;
    }
}
