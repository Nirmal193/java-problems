import java.util.ArrayList;
import java.util.List;

public class SplitStringFibbonacci {
    public static void main(String[] args) {

    }
    public static List<Integer> splitIntoFibonacci(String num) {
        List<Integer> ans  = new ArrayList<>();
        solve(num,0,ans);
        return ans;
    }
    public static boolean solve(String num,int index,List<Integer> ans){
        if(index == num.length() && ans.size() >= 3)
            return true;
        for(int i = index;i<num.length();i++){
            if(num.charAt(index) == 0 && i > index)
                break;
            long number = Long.valueOf(num.substring(index,i+1));
            if(number > Integer.MAX_VALUE)
                break;
            if(ans.size() <= 1 || number ==  (long)ans.get(ans.size()-1) + (long)ans.get(ans.size()-2)) {
                ans.add((int) number);
                if (solve(num, i + 1, ans)) {
                    return true;
                }
                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }
}
