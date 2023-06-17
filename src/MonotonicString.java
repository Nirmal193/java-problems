public class MonotonicString {
    public static void main(String[] args) {
        String s = "00110";
        System.out.println(minFlipsMonoIncr(s));
    }
    public static int minFlipsMonoIncr(String s){
        int zero = 0,one = 0,ans =0;
        int length = s.length();
        for(int i=0;i<length;i++){
            if(s.charAt(i) == '1')
                one++;
            else{
                if(one !=0){
                    ans = Math.min(ans+1,one);
                }
                zero++;
            }
        }
        return ans;
    }
}
