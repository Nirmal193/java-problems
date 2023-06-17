import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        combine(4,2);
    }
    public static List<List<Integer>> combine(int n,int k){
        List<List<Integer>> ans = new ArrayList<>();
        if(n<k) return ans;
        Integer[] cur = new Integer[k];
        for(int i=0;i<k;i++)
            cur[i] = 0;
        int i =0;
        while(i >= 0){
            cur[i]++;
            if(cur[i] > n)
                i--;
            else if (i ==k-1)
                ans.add(new ArrayList<>(Arrays.asList(cur)));
            else {
                ++i;
                cur[i] = cur[i-1];
            }
        }
        return ans;
    }
}
