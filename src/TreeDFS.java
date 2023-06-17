import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class TreeDFS {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        lavelMaker(root,wrapList,0);
        return wrapList;
    }
    public static void lavelMaker(TreeNode root,List<List<Integer>> wrapList,int lavel){
        if(root == null)
            return;
        if(lavel >= wrapList.size())
            wrapList.add(0,new LinkedList<Integer>());
        lavelMaker(root.left,wrapList,lavel+1);
        lavelMaker(root,wrapList,lavel-1);

        wrapList.get(wrapList.size()-lavel-1).add(root.val);
    }
}
