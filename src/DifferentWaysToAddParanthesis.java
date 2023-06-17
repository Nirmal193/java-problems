import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParanthesis {
    public static void main(String[] args) {
        String str = "2-1-1";
        List<Integer> ans = diffWaysToCompute(str);
        ans.stream().forEach(System.out::println);
    }
    public static List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }
    public static List<Integer> solve(String expression){
       List<Integer> ans = new ArrayList<>();
       if(expression.matches("\\d+")){
           ans.add(Integer.parseInt(expression));
           return ans;
       }
       for(int i=0;i<expression.length();i++){
           char c = expression.charAt(i);
           if (c == '+' || c == '-' || c == '*'){
               String left = expression.substring(0,i);
               String right = expression.substring(i+1);
               List<Integer> leftResults = solve(left);
               List<Integer> rightResults = solve(right);
               for(int x :leftResults){
                   for(int y:rightResults){
                       if(c == '+')
                           ans.add(x+y);
                       else if(c == '-')
                           ans.add(x-y);
                       else if(c== '*')
                           ans.add(x*y);
                   }
               }
           }
       }
       return ans;
    }

}
