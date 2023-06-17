public class maxTurbulenceSize {
    public static void main(String[] args) {

    }
    public int maxTurbulenceSize(int[] arr) {
       int maxlen = 1;
       int curlen = 1;
       int prevDiff = 0;
       for(int i=1;i<arr.length;i++){
           int compare = Integer.compare(arr[i - 1], arr[i]);
           if(compare ==  0){
               curlen = 1;
               prevDiff = 0;
           } else if (compare == -prevDiff) {
               curlen++;
           }else
               curlen = 2;
           maxlen = Math.max(maxlen,curlen);
           prevDiff = compare;
       }
       return maxlen;
    }
}
