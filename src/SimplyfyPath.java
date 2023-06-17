import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class SimplyfyPath {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(findPath(str));
    }
    public static String findPath(String path){
        StringBuilder ans = new StringBuilder("/");
        Stack<String> stack = new Stack<String>();
        int count = 0;
        StringBuilder temp = new StringBuilder("");
        while(count<path.length()){
            while(count < path.length() && path.charAt(count) == '/')
                count++;
            while(count < path.length() && path.charAt(count) != '/')
                temp.append(path.charAt(count++));
            if(String.valueOf(temp).equals("..")){
                if(!stack.empty())
                    stack.pop();}
            else{
                if(!temp.isEmpty() && !String.valueOf(temp).equals("."))
                 stack.push(String.valueOf(temp));
            }
            temp = new StringBuilder("");
        }
        ArrayList<String> x = new ArrayList<String>();
        while(!stack.empty())
            x.add(stack.pop());
        for(int i=0;i<x.size();i++){
            ans.append(x.get(x.size()-i-1));
            if(i != x.size()-1)
            ans.append('/');
        }
        return String.valueOf(ans);
    }
}
