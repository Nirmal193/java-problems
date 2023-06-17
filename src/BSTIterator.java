import java.util.Stack;

public class BSTIterator {
    public Stack<TreeNode> stack;
    TreeNode currNode  = null;
    TreeNode prevNode  = null;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        currNode = root;
    }

    public int next() {
        int ans  = -1;
        while(currNode != null){
            stack.push(currNode);
            currNode = currNode.left;
        }
        TreeNode temp  =stack.pop();
        ans = temp.val;
        prevNode = temp;
        currNode = temp.right;
        return ans;
    }

    public boolean hasNext() {
        return stack.empty();
    }
}
