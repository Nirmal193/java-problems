import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IsValidSerialization {
    public static void main(String[] args) {
        String preOrder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(isValidSerialization(preOrder));
    }
    public static boolean isValidSerialization(String preorder) {
        String[] tree = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for(int i=0;i<tree.length;i++){
            stack.push(tree[i]);
            while(stack.size()>=3 && stack.peek().equals("#")){
                String top1 = stack.pop();
                String top2 = stack.pop();
                if(top1.equals("#") && top2.equals("#")){
                    if(stack.peek().equals("#"))
                        return false;
                    stack.pop();
                    stack.push("#");
                }else {
                    stack.push(top2);
                    stack.push(top1);
                    break;
                }
            }
        }
        if(stack.size() == 1 && stack.peek().equals("#"))
            return true;
        return false;
    }

}
