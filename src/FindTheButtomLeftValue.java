import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindTheButtomLeftValue {
    public static void main(String[] args) {

    }
    public static int findBottomLeftValue(TreeNode root) {
        int ans = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int sz = queue.size();
            for(int i=0;i<sz;i++){
                TreeNode currNode = queue.poll();
                if(i==0)
                    ans = currNode.val;
                if(currNode.left != null)
                    queue.add(currNode.left);
                if(currNode.right != null)
                    queue.add(currNode.right);
            }
        }
        return ans;
    }
}
