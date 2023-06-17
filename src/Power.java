public class Power {
    public static void main(String[] args) {
        System.out.println(pow(10,6));
    }
    public static int pow(int x,int y){
        int temp;
        if(y==0)
            return 1;
        temp = pow(x,y/2);
        if(y%2==0)
            return temp*temp;
        else
            return x*temp*temp;
    }
}
