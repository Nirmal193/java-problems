import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {
    public static void main(String[] args) {

    }
    public int widthOfBinaryTree(TreeNode root) {
        int ans = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int sz = queue.size();
            for(int i=0;i<sz;i++){
                TreeNode currNode = queue.poll();
                if(currNode.left != null)
                    queue.add(currNode.left);
                if(currNode.right != null)
                    queue.add(currNode.right);
            }
            ans = Math.max(ans,sz);
        }
        return ans;
    }
}
