package lecture2;

import java.math.BigInteger;

public class RepeatedSquaring{

    public static long slow(int a, int b){
        if(b == 0){
            return 1;
        }else{
            return a * slow(a, b-1);
        }
    }

    public static long fast(int a, int b){
        if(b == 1){
            return a;
        }else{
            return (long) Math.pow(fast(a, b/2), 2.0);
        }
    }

    public static void repeatedSquaring(int n){
        BigInteger big = BigInteger.valueOf(2);
        for(int i = 0; i < n; i++){
            big = big.multiply(big);
        }
        System.out.println(big);
    }

    public static void main(String[] args){

//        repeatedSquaring(20);

        int a = 2;
        int b = 16;
        System.out.println(slow(a,b));
        System.out.println(fast(a,b));
    }

}
