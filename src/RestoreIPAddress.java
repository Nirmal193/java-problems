import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
    public static void main(String[] args) {
        String str = "0000";
        restoreIpAddresses(str);
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        solve(ans,"",0,s,0,0);
        System.out.println(ans.size());
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
        return ans;
    }
    public static void solve(List<String> ans,String res,int number,String s,int index,int count){
        if(number >255 || count>3)
            return;
        if(index == s.length()){
            ans.add(res);
            return;
        }
        int digit = Integer.parseInt(String.valueOf(s.charAt(index)));
        if(index != 0)
            solve(ans,res+=s.charAt(index),number*10 + digit,s,index+1,count);
        res = res.substring(0,res.length()-1);
        if(res.length()!=0 || (res.length()!=0 && res.charAt(res.length()-1)!='.'))
            solve(ans,res+=".",0,s,index,count+1);
    }
}
