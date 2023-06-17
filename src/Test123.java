import java.util.Stack;


//“(){([])}”
//        ")("
public class Test123 {
    public static void main(String[] args) {
        String str  ="({)}";
        System.out.println(baanacedBraket(str));
    }
    public static boolean baanacedBraket(String s){
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else if(!stack.empty()){
                if(s.charAt(i) == ')' && stack.peek() == '(')
                    stack.pop();
                else if(s.charAt(i) == '}' && stack.peek() == '{')
                    stack.pop();
                else if(s.charAt(i) == ']' && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            }
        }
        if(!stack.empty())
            return false;
        else
            return true;
    }
}
