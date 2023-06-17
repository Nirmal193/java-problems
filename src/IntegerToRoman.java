public class IntegerToRoman {
    public static void main(String[] args) {
        String ans = intToRoman(1994);
        System.out.println(ans);
    }
    public static String intToRoman(int num){
        StringBuilder ans = new StringBuilder("");
        int romanInt[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String romanChar[] =  {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int count = 0;
        while(num>0) {
            while (count < romanInt.length) {
                if (num >= romanInt[count])
                    break;
                count++;
            }
            ans.append(romanChar[count]);
            num -= romanInt[count];
        }
        return String.valueOf(ans);
    }
}
