import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxIpAddress {
    public static void main(String[] args) {
        System.out.println("Most Frequent IP!");
        getMostFrequentIp(new String[]{"10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20", "10.0.0.3 - GET 2020-08-24","10.0.0.3 - GET 2020-08-24","10.0.0.3 - GET 2020-08-24","10.0.0.4 - GET 2020-08-24"});
    }
    public static void getMostFrequentIp(String logs[]){
        HashMap<String,Integer> map = new HashMap<>();
        for(String log : logs){
            String[] arr = log.split(" ");
            map.put(arr[0],map.getOrDefault(arr[0],0)+1);
        }
        String ip = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println(ip);
    }
}
