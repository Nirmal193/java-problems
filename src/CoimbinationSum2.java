import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoimbinationSum2 {
    public static void main(String[] args) {
        combinationSum3(3,7);
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(ans,k,n,1,new ArrayList<>());
        for(int i=0;i<ans.size();i++){
            System.out.println(Arrays.toString(ans.get(i).toArray()));
        }
        return ans;
    }
    public static void solve(List<List<Integer>> ans, int k,int sum,int index, List<Integer> res){
        if(sum == 0 && k==0){
            ans.add(new ArrayList<>(res));
        }
        if(k == 0 || sum < 0)
            return;
        for(int i=index;i<=9;i++){
            if(sum - i >=0 && !isPresent(res,i)) {
                res.add(i);
                solve(ans,k-1,sum-i,i,res);
                res.remove(res.size()-1);
            }
        }
    }
    public static boolean isPresent(List<Integer> search,int index){
        for(Integer re:search)
            if(re==index)
                return true;
        return false;
    }
}
