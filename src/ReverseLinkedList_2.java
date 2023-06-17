import java.util.List;

public class ReverseLinkedList_2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {

    }
    public ListNode reverseBetween(ListNode head, int left, int right){
        if(left == right || right < left)
            return head;
        ListNode falseNode = new ListNode(-1);
        falseNode.next = head;
        head = falseNode;
        ListNode lastNode  = head;
        ListNode start = head,end = null;
        ListNode curr = head;
        int count = 1;
        ListNode prev = null;
        ListNode next = null;
        while(curr!=null){
            if(count==left-1)
                start=curr;
            if(count == right+1)
                end = curr;
            curr = curr.next;
            count++;
        }
        curr = start.next;
        ListNode startNode = curr;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev =curr;
            curr = next;
            if(curr == end) {
                start.next = prev;
                break;
            }
        }
        startNode.next = end;
        return lastNode;
    }
}
