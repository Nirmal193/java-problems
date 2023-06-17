public class BinaryTreeCameras {
    public int ans = 0 ;
    public static void main(String[] args) {

    }
    public int minCameraCover(TreeNode root) {
        ans = 0;
        int state = dfs(root);
        if(state == 0)
            ans++;
        return ans;
    }
    public int dfs(TreeNode root){
        if(root == null)
            return 2;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left == 0 || right == 0 ) {
            ans++;
            return 1;
        } else if (left == 1 || right ==1) {
            return 2;
        }else
            return 0;

    }
}
