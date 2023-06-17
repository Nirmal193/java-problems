import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindFibbonacciSeries {
    public static void main(String[] args) {

    }
    public int lenLongestFibSubseq(int[] arr) {
        int length = arr.length;
        int ans  = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<length;i++)
            set.add(arr[i]);
        int dp[] = new int[length];
        dp[0] = 1;
        for(int i=0;i<length-2;i++){
            for(int j=i+1;j<length-1;j++){
                int num1 = arr[i];
                int num2 = arr[j];
                int sum = num2+num1;
                int l = 2;
                while(set.contains(sum)){
                    int temp = sum;
                    sum += num2;
                    num2 = sum;
                    l++;
                    ans = Math.max(ans,l);
                }
            }
        }
        return (ans>=3) ? ans : 0;
    }
}
