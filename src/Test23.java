import java.util.*;

public class Test23 {
    static String ans = "";
    static Set<Character> set ;
    public static void main(String[] args) {
//        int arr[] = {8,1,4,3,2};
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i=0;i<arr.length;i++)
//            map.put(arr[i],i);
//        Arrays.sort(arr);
//        if(serach(arr,4)!=-1){
//            System.out.println(map.get(4));
//        }
        //Resolve
        //Reject
        //ret
        String str1 = "resolve";
        String str2 = "reject";
        set = new HashSet<>();
        solve(str1,str2,0,0);
        char frq[] = ans.toCharArray();
        Arrays.sort(frq);
        String res ="";
        for(char c: frq)
            res += c;
        System.out.println(res);
    }
   static int serach(int arr[],int find){
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid = (start+end)/2;
            if(arr[mid] == find)
                return mid;
            else if(arr[mid] < find)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }

    public void method1(){
        for(int i=1;i<=5;i++)
            System.out.println(i);
    }
    public void method2(){
        for(int i=6;i<=10;i++)
            System.out.println(i);
    }

    public static void solve(String str1,String str2,int id1,int id2){
        if(id1 == str1.length() || id2 == str2.length())
            return ;
        if(str1.charAt(id1) == str2.charAt(id2)) {
            if(!set.contains(str1.charAt(id1))){
                ans += str1.charAt(id1);
                set.add(str1.charAt(id1));
            }

            solve(str1, str2, id1 + 1, id2 + 1);
        }
        else {
           solve(str1, str2, id1, id2 + 1);
           solve(str1, str2, id1+1, id2);
        }
       /* for(int i=id1;i<str1.length();i++){
            if(str1.charAt(i) == str2.charAt(id2)) {
                ans += str1.charAt(i);
                 solve(str1,str2,i+1,id2+1);
            }
        }*/
    }
}
