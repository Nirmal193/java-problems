import java.util.List;

public class Codec {
    public static void main(String[] args) {

    }

//    public String serialize(TreeNode root) {
//
//    }
//
//    public TreeNode deserialize(String data) {
//
//    }
    public static void inorder(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public static void preOrder(TreeNode root,List<Integer> list){
        if(root==null)
            return;
        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }
}
