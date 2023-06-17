import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class ListOfTreeNodes {
    public static void main(String[] args) {

    }
    public List<TreeNode> allPossibleFBT(int n) {
        return solve(0,n);
    }
    public List<TreeNode> solve(int start,int end){
        List<TreeNode> res = new ArrayList<>();
        if(start>end) {
            res.add(null);
            return res;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> leftSubtrees = solve(start,i-1);
            List<TreeNode> rightSubtrees = solve(i+1,end);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}

