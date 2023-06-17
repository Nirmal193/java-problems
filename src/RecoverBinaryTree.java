import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinaryTree {
    public static void main(String[] args) {

    }
    public static void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        solve(root,null,list);

    }
    public static void solve(TreeNode root, TreeNode prev, List<TreeNode> list){
        if(root == null)
            return;
        solve(root.left,root,list);
        if (prev.val > root.val){
            list.add(prev);
        }
        solve(root.right,root,list);
    }
}
