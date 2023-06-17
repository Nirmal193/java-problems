import java.util.HashMap;
import java.util.Map;

public class nextGreaterBalancedNumber {
    static int ans  = Integer.MAX_VALUE;
    public static void main(String[] args) {
        System.out.println(nextBeautifulNumber(19090));
    }
    public static int nextBeautifulNumber(int n){
        int arr[] = new int[10];
        for(int i=1;i<=6;i++)
            arr[i] = i;
        find(arr,0L,n);
        return ans;
    }
    public static void find(int arr[],long num,int n){
        if(num>n && check(arr)){
            if(ans>num) ans = (int)num;
            return;
        }
        if(num>100*n) return;
        for(int i=1;i<=6;i++){
            if(arr[i]!=0) {
                arr[i]--;
                find(arr,num*10+i,n);
                arr[i]++;
            }
        }
    }
    public static boolean check(int arr[]){
        for(int i=1;i<=6;i++){
            if(arr[i]!=0 && arr[i]!=i)
                return false;
        }
        return true;
    }
    public static void generate(HashMap<Integer,Integer> freq,long number,int digit){
        if(digit >=7)
            return;
        if(isPossible(freq))
            System.out.println(number);
        for(int i=1;i<=9;i++){
            number = number * 10 + i;
            freq.put(i,freq.get(i)+1);
            generate(freq,number,String.valueOf(number).length());
            freq.put(i,freq.get(i)-1);
        }
    }
    public static boolean isPossible(HashMap<Integer,Integer> freq){
        for(Map.Entry<Integer,Integer> map:freq.entrySet()){
            if(map.getValue()!=0 && map.getKey() != map.getValue())
                return false;
        }
        return true;
    }

}
