public class GoodNUmbersd {
    public static void main(String[] args) {
        System.out.println(rotatedDigits(10));
    }
    public static int rotatedDigits(int n){
        long mod = (long) 1e9 + 7;
        long count1 = power(5,(n+1)/2,mod);
        long count2 = power(4,n/2,mod);
        long totalCount = (count1*count2)%mod;
        return (int)totalCount;
    }
    private static long power(long base,long exponent,long modulus){
        if(exponent == 0)
            return 1;
        long result = 1;
        while(exponent > 0){
            if(exponent%2 ==1 ){
                result = (result*base)%modulus;
            }
            base = (base*base)%modulus;
            exponent /= 2;
        }
        return result;
    }
}
