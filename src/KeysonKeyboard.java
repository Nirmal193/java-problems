public class KeysonKeyboard {
    public static void main(String[] args) {
        minSteps(10);
    }
    public static int minSteps(int n){
        int ans  = solve(1,n,1,1);
        System.out.println(ans);
        return ans;
    }


    public static int solve(int step,int n,int current,int copied){
        if(current > n || step>n)
            return Integer.MAX_VALUE-90;
        if(current == n)
            return step;
     return Math.min(solve(step+1,n,current+copied,copied)
             ,solve(step+2,n,current+current,current));
    }




}
