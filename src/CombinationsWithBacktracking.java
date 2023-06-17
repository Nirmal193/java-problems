import java.util.ArrayList;
import java.util.List;

public class CombinationsWithBacktracking {
    public static void main(String[] args) {
        List<List<Integer>> ans = combine(2,3);
        for(int i=0;i<ans.size();i++){
            for(int j=0;j<ans.get(i).size();j++){
                System.out.println(ans.get(i).get(j));
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> combine(int n,int k){
        List<List<Integer>> ans = new ArrayList<>();
        combine(ans,new ArrayList<Integer>(),1,n,k);
        return ans;
    }
    public static void combine(List<List<Integer>> combs,List<Integer> comb,
                               int start,int n,int k){
        if(k==0){
            combs.add(new ArrayList<>(comb));
            return;
        }
        for(int i=start;i<=n;i++){
            comb.add(i);
            combine(combs,comb,i+1,n,k-1);
            comb.remove(comb.size()-1);
        }
    }
}
