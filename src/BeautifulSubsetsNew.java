
import java.util.*;
public class BeautifulSubsetsNew {

    public static int beautifulSubsets(int[] A, int k) {
        List<Map<Integer, Integer>> count = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            count.add(new HashMap<>());
        }
        for (int a : A) {
            count.get(a % k).merge(a, 1, Integer::sum);
        }
        int res = 1;
        for (int i = 0; i < k; i++) {
            int prev = 0;
            int dp0 = 1, dp1 = 0;
            List<Integer> sortedKeys = new ArrayList<>(count.get(i).keySet());
            Collections.sort(sortedKeys);
            for (int a : sortedKeys) {
                int v = (int) Math.pow(2, count.get(i).get(a));
                if (prev + k == a) {
                    int temp = dp0;
                    dp0 = dp0 + dp1;
                    dp1 = temp * (v - 1);
                } else {
                    int temp = dp0;
                    dp0 = dp0 + dp1;
                    dp1 = (temp + dp1) * (v - 1);
                }
                prev = a;
            }
            res *= dp0 + dp1;
        }
        return res - 1;
    }
}
