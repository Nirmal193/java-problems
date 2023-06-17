public class Champagne {
    public static void main(String[] args) {
        System.out.println(solve(26,6,1));
    }
    public static double solve(int poured,int query_row,int query_glass){
        double tower[][] = new double[query_row+1][query_row+1];
        tower[0][0] = poured;
        for(int i=0;i<query_row;i++){
            for(int j=0;j<=i;j++){
                double overflow = (tower[i][j]-1)/2;
                if(overflow>0){
                    tower[i+1][j] += overflow;
                    tower[i+1][j+1] += overflow;
                }
            }
        }
        for(int i=0;i<=query_row;i++) {
            for (int j = 0; j <=query_row; j++) {
                System.out.print(tower[i][j] + "   ->  ");
            }
            System.out.println();
        }
        return Math.min(1, tower[query_row][query_glass]);
    }
}
