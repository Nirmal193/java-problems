import java.util.Arrays;

public class BeautifulArrangements {
    static int count;
    public static void main(String[] args) {
        count = 0;
        countArrangement(3);
    }
    public static int countArrangement(int n){
        int arr[] = new int[n];
        for(int i = 1;i<=n;i++)
            arr[i-1] = i;
        permute(arr,0);
        System.out.println(count);
        return count;
    }
    public static void permute(int[] arr,int l){
        if(l == arr.length-1){
            System.out.println(Arrays.toString(arr));
            int i;
            for(i =1;i<=arr.length;i++){
                if(arr[i-1] %i !=0 && i% arr[i-1]!=0)
                    break;
            }
            if(i==arr.length+1)
                count++;
        }
        for(int j=l;j<arr.length;j++){
            swap(arr,j,l);
            permute(arr,l+1);
            swap(arr,j,l);
        }
    }
    public static void swap(int arr[],int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
