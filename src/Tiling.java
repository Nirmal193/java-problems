public class Tiling {
    public static void main(String[] args) {
        System.out.println(solve(3));
    }
    public static int solve(int n){
        int mod = (int)1e9+7;
        int dp[] = new int[n+1];
        dp[0] =dp[1]= 1;
        dp[2] = 2;
        for(int i = 3;i<=n;i++){
            dp[i] = (2*dp[i-1] + dp[i-3])%mod;
        }
        return dp[n];
    }
}
