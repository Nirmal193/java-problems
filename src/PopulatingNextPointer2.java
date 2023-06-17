import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextPointer2 {
    public static void main(String[] args) {

    }
    public Node connect(Node root) {
        Node head = root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while(!queue.isEmpty()){
            int sz = queue.size();
            Node prev = null;
            for(int i =0 ;i<sz;i++){
                Node currNode = queue.peek();
                if(currNode.left != null){
                    queue.add(currNode.left);
                }
                if(currNode.right != null){
                    queue.add(currNode.right);
                }
                if(prev != null){
                    prev.next = currNode;
                }
                if(i == sz-1) {
                    currNode.next = null;
                }
                prev = currNode;
                queue.remove();
            }
        }
        return root;
    }
}
