package interview2;


public class Test {
    public static void main(String[] args) {

    }

    /*
    l1 = 2956
    l2 = 78
    val1 = 5
    val2 = 0
    sum = 6
    carry  = -1
    current = 9766
     */
    public static ListNode solve(ListNode l1,ListNode l2){
//        l1 = reverse(l1);
//        l2 = reverse(l2);
        ListNode current = new ListNode(-1);
        ListNode ans = current.next;
        int carry = -1;
        while(l1!= null || l2 != null || carry != -1){
            int val1 = (l1 == null) ? 0 :l1.val;
            int val2 = (l2 == null) ? 0 :l2.val;
            int sum = val1 + val2;
            if(carry != -1)
                sum = sum + carry;
            current.next = new ListNode(sum%10);
            if(sum>=10)
                carry = sum/10;
            else
                carry = -1;
            if(l1!=null)
                l1 = l1.next;
            if(l2!=null)
                l2 = l2.next;
            current =current.next;
        }
        return ans;
    }
//    public static ListNode reverse(ListNode l1){
//
//    }


    public static TreeNode find(TreeNode root,int k){
        if(root == null)
            return null;
        if(root.val < k)
            return root;
        else
            return find(root.left,k);
    }
}


