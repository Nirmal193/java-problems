public class ClosestDesertPrice {
    static int ans  = 0;
    public static void main(String[] args) {
        int[] toppings = {3};
        int[] baseCosts = {3};
        int target = 9;
        System.out.println(closestCost(baseCosts,toppings,target));
    }
    public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int res = 0;
        for(int i =0;i<baseCosts.length;i++){
            ans = 0;
            solve(toppingCosts,target,0,baseCosts[i]);
            res = Math.max(res,ans);
        }
        return res;
    }
    public static void solve(int[] toppingCosts,int target,int index,int price){
        if(price <= target)
            ans = Math.max(ans,price);
        if(price > target || index >= toppingCosts.length)
            return;
        solve(toppingCosts,target,index+1,price+toppingCosts[index]);
        solve(toppingCosts,target,index+1,price+toppingCosts[index]*2);
        solve(toppingCosts,target,index+1,price);
    }
}
