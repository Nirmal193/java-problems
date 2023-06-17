public class RemoveSubTree {
    static boolean headNode;
    public static void main(String[] args) {

    }
    public static TreeNode pruneTree(TreeNode root) {
        solve(root,null,0);
        if(headNode)
            return null;
        else
            return root;
    }
    public static boolean solve(TreeNode root,TreeNode parent,int isleft){
        if(root == null)
            return true;
        boolean left = solve(root.left,root,1);
        boolean right = solve(root.right,root,2);
        if(left && right && root.val != 1){
            if(isleft == 0){
                 headNode = true;
                 return false;
            }
            else if(isleft == 1)
                parent.left = null;
            else if(isleft == 2)
                parent.right = null;
        }
        if(root.val == 1)
            return false;
        return true;
    }
}
