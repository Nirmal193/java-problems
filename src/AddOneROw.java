public class AddOneROw {
    public static void main(String[] args) {

    }

    class Solution {
        public int depth = 0;
        public int val = 0;

        public TreeNode addOneRow(TreeNode root, int v, int d) {
            TreeNode re = root;
            if (d == 1) {
                re = new TreeNode(v);
                re.left = root;
                return re;
            }
            val = v;
            depth = d;
            dfs(re, 0);
            return re;
        }

        void dfs(TreeNode node, int currentDepth) {
            if (node == null) {
                return;
            }
            if (currentDepth == depth - 2) {
                TreeNode left = node.left;
                TreeNode right = node.right;
                node.left = new TreeNode(val);
                node.left.left = left;
                node.right = new TreeNode(val);
                node.right.right = right;
                return;
            } else {
                dfs(node.left, currentDepth + 1);
                dfs(node.right, currentDepth + 1);
            }
        }
    }
}
