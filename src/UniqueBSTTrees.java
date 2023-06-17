import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBSTTrees {

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    private static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = generateTrees(start, i - 1);
            List<TreeNode> rightSubtrees = generateTrees(i + 1, end);
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
    public static List<TreeNode> generateTree(int start,int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> leftSubtrees = generateTrees(start,i-1);
            List<TreeNode> rightSubTrees = generateTrees(i+1,end);
            for(TreeNode left:leftSubtrees){
                for(TreeNode right : rightSubTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
    public static void solve(int curr,int n,List<TreeNode> ans,TreeNode tree,TreeNode currNode){
        if(curr == n){
            if(isBST(tree))
                ans.add(tree);
            return;
        }
        for(int i=1;i<=n;i++){
            if(tree == null){
                tree = new TreeNode(i);
                solve(1,n,ans,tree,tree);
                tree = null;
            }else{
                if(currNode !=null && i== currNode.val)
                    continue;
                if( i <= currNode.val){
                    TreeNode temp =  new TreeNode(i);
                    currNode.left = temp;
                    if(isBST(tree))
                        solve(curr+1,n,ans,tree,temp);
                }else{
                    TreeNode temp = new TreeNode(i);
                    currNode.right = temp;
                    if(isBST(tree))
                        solve(curr+1,n,ans,tree,temp);
                }
            }

        }
    }
    static boolean isBST(TreeNode root)
    {
        return isBSTUtil(root, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }
    static boolean isBSTUtil(TreeNode node, int min, int max)
    {
        if (node == null)
            return true;
        if (node.val < min || node.val > max)
            return false;
        return (
                isBSTUtil(node.left, min, node.val - 1)
                        && isBSTUtil(node.right, node.val + 1, max));
    }

    public static void main(String[] args) {
        List<TreeNode> list = generateTrees(3);
        System.out.println(list.size());
    }
}
