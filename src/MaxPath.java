public class MaxPath {
    public static void main(String[] args) {
        int arr[] = {2,4,5,8,10};
        int arr2[] = {4,6,8,9};
        System.out.println(solve(arr,arr2));
    }
    public static long solve(int A[],int B[]){
        long res = 0, a = 0, b = 0;
        int i = 0, j = 0;
        while(i < A.length && j < B.length)
        {
            if(A[i] < B[j]) a += A[i++];
            else if(A[i] > B[j]) b += B[j++];
            else
            {
                res += Math.max(a, b) + A[i];
                a = b = 0;
                ++i; ++j;
            }
        }
        while(i < A.length) a += A[i++];
        while(j < B.length) b += B[j++];
        res += Math.max(a, b);
        return res;
    }
}
