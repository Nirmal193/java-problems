import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicateSubtrees {
    List<TreeNode> ans;
    Set<Integer> set;
    public static void main(String[] args) {

    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        set = new HashSet<>();
        Map<Integer,List<TreeNode>> map = new HashMap<>();
        solve(root,map);
        ans = ans.stream().distinct().collect(Collectors.toList());
        return ans;
    }
    public void solve(TreeNode root,Map<Integer,List<TreeNode>> map){
        if(root == null)
            return;
        if(map.containsKey(root.val)){
            for(TreeNode tree: map.get(root.val))
                if(ifMatched(root,tree) && !set.contains(root.val)) {
                    ans.add(root);
                    set.add(root.val);
                }
            map.get(root.val).add(root);
        }else
            map.put(root.val,new ArrayList<TreeNode>(Arrays.asList(root)));
        solve(root.left,map);
        solve(root.right,map);
    }
    public boolean ifMatched(TreeNode root,TreeNode copy){
        if(root == null && copy == null)
            return true;
        if(root == null ^ copy == null)
            return false;
        if(root.val != copy.val)
            return false;
        return ifMatched(root.left,copy.left) && ifMatched(root.right,copy.right);
    }
}
