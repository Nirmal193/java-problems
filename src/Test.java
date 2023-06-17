public class Test {
    public static void main(String[] args) {
        System.out.println(010+0);
    }
    public boolean findTree(TreeNode parent,TreeNode child){
        String parentTree  = "";
        String childTree = "";
        serialise(parent,parentTree);
        serialise(child,childTree);
        for(int i=0;i<parentTree.length();i++){
            int x = 0;
            if(parentTree.charAt(i) == childTree.charAt(0)){
                int y  =i;
                while(x<childTree.length() && childTree.charAt(x) == parentTree.charAt(y)){
                    x++;
                    y++;
                }
                if(x == childTree.length())
                    return true;
            }
        }
        return false;
    }
    public void serialise(TreeNode root,String ans){
        if(root == null)
            return ;
        ans += root.val;
        serialise(root,ans+="(");
        serialise(root,ans+=")");
    }
//    public boolean solve(TreeNode parent,TreeNode child){
//        int childSize = getTreeSize(child);
//    }
//    public boolean findTree(TreeNode parent,TreeNode child,TreeNode temp,int matched){
////        if(parent == null)
////            return true;
////        if(parent.val == child.val)
////            findTree(parent.left,child,child.left,matched+1);
////        else
////            findTree(parent)
//    }
}
