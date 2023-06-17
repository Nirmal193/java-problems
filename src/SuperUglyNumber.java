public class SuperUglyNumber {
    int mod = 1000000007;
    public static void main(String[] args) {

    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        long values[] = new long[primes.length];
        int index[] = new int[primes.length];
        long ugly[] = new long[n];
        ugly[0] = 1;
        for(int i=1;i<n;i++){
            long min = Integer.MIN_VALUE;
            for(int j=0;j< primes.length;j++){
                values[j] = (ugly[index[j]] * primes[j]);
                min = Math.min(min,values[j]);
            }
            ugly[i] = min;
            for(int j =0;j< primes.length;j++){
                if(values[j] == min)
                    index[j]++;
            }
        }
        return (int)ugly[n-1];
    }
}
