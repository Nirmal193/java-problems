public class deleteNode {
    public static TreeNode lostNode = null;

    public deleteNode(int[] arr) {
    }

    public static void main(String[] args) {

    }
    public static void find(TreeNode root,int key){
        if(root == null)
            return;
        if(root.val == key){
            lostNode = root;
            return;
        }
        if(root.val < key)
            find(root.left,key);
        if(root.val > key)
            find(root.right,key);
    }
    public static TreeNode deleteNode(TreeNode root,int key){
        if (root == null)
            return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key); // Recursively delete from the left subtree
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key); // Recursively delete from the right subtree
        } else {
            // Case 1: Deleting a leaf node or a node with one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Case 2: Deleting a node with two children
            TreeNode successor = findSuccessor(root.right); // Find the successor node
            root.val = successor.val; // Replace the value of the current node with the successor value
            root.right = deleteNode(root.right, successor.val); // Recursively delete the successor node
        }

        return root;
    }
    private static TreeNode findSuccessor(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }
    public static TreeNode test(TreeNode root,int key){
        if(root == null)
            return null;
        if(key< root.val)
            root.left = test(root.left,key);
        else if(key > root.val)
            root.right = test(root.right,key);
        else{
            if(root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            TreeNode successer = findSuccessor(root.right);
            root.val = successer.val;;
            root.right = deleteNode(root.right, successer.val);
            }
        return root;
        }
}
