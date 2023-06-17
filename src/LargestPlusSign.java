public class LargestPlusSign {
    public static void main(String[] args) {

    }
    public class MatNode{
        int left;
        int right;
        int upper;
        int down;
        public MatNode(int left,int upper,int right,int down){
            this.left = left;
            this.right = right;
            this.upper = upper;
            this.down = down;
        }
    }
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int matrix[][] = new int[n][n];
        for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               matrix[i][j] = 1;
           }
        }
        for(int i=0;i<mines[0].length;i++) {
            matrix[mines[0][i]][mines[1][i]] = 0;
        }
      MatNode dp[][] = new MatNode[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                if (matrix[i][j] == 1)
                    dp[i][j] = new MatNode(1, 1, 1, 1);
                else
                    dp[i][j] = new MatNode(0,0,0,0);
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j] == 1)
                    dp[i][j] = new MatNode(
                      dp[i][j-1].left+1,
                            dp[i-1][j].upper+1,
                            1,1
                    );
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                if(matrix[i][j] == 1)
                    dp[i][j] = dp[i][j] = new MatNode(
                            dp[i][j].left,dp[i][j].upper,
                            dp[i][j+1].right+1,
                            dp[i+1][j].down+1
                    );
            }
        }
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                System.out.println(matrix[i][j]);
            }
            System.out.println();
        }
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                System.out.print("[" + dp[i][j].left+","+dp[i][j].upper+","+dp[i][j].right+","+dp[i][j].down+"]");
            }
            System.out.println();
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               ans = Math.max(Math.min(Math.min(dp[i][j].left,dp[i][j].right),Math.min(dp[i][j].down,dp[i][j].upper)),ans);
            }
        }
        return ans;
    }
}
