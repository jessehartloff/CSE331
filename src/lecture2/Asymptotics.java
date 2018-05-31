package lecture2;


public class Asymptotics {

    public static void main(String[] args){
//        howFar(1000L);
        run(5L);
    }

    public static void run(long n){
        System.out.println("n=" + n);

        long startTime = System.currentTimeMillis();
        linear(n);
        System.out.println(elapsedTime(startTime) + "ms: linear");

        startTime = System.currentTimeMillis();
        nlogn(n);
        System.out.println(elapsedTime(startTime) + "ms: nlogn");

        startTime = System.currentTimeMillis();
        squared(n);
        System.out.println(elapsedTime(startTime) + "ms: squared");

        startTime = System.currentTimeMillis();
        cubed(n);
        System.out.println(elapsedTime(startTime) + "ms: cubed");

        startTime = System.currentTimeMillis();
        exponential(n);
        System.out.println(elapsedTime(startTime) + "ms: exponential");

        startTime = System.currentTimeMillis();
        factorial(n);
        System.out.println(elapsedTime(startTime) + "ms: factorial");

    }



    public static void howFar(long timeLimit){

        long startTime = System.currentTimeMillis();
        int i;

        for(i=1; (System.currentTimeMillis() - startTime) < timeLimit; i++) {
            linear(i);}
        System.out.println(i + " iterations: linear");

        startTime = System.currentTimeMillis();
        for(i=1; (System.currentTimeMillis() - startTime) < timeLimit; i++) {
            nlogn(i);}
        System.out.println(i + " iterations: nlogn");

        startTime = System.currentTimeMillis();
        for(i=1; (System.currentTimeMillis() - startTime) < timeLimit; i++) {
            squared(i);}
        System.out.println(i + " iterations: squared");

        startTime = System.currentTimeMillis();
        for(i=1; (System.currentTimeMillis() - startTime) < timeLimit; i++) {
            cubed(i);}
        System.out.println(i + " iterations: cubed");

        startTime = System.currentTimeMillis();
        for(i=1; (System.currentTimeMillis() - startTime) < timeLimit; i++) {
            exponential(i);}
        System.out.println(i + " iterations: exponential");

        startTime = System.currentTimeMillis();
        for(i=1; (System.currentTimeMillis() - startTime) < timeLimit; i++) {
            factorial(i);}
        System.out.println(i + " iterations: factorial");

    }


    private static long elapsedTime(long startTime){
        return System.currentTimeMillis() - startTime;
    }



    public static void linear(long n){
        for (long i = 0; i < n; i++) {
            operation();
        }
    }



    private static void nlogn(long n) {
        if(n>1) {
            linear(n);
            nlogn(n / 2);
            nlogn(n / 2);
        }
    }




    private static void squared(long n) {
        for (long i = 0; i < n; i++) {
            for (long j = 0; j < n; j++) {
                operation();
            }
        }
    }




    private static void cubed(long n) {

        for (long i = 0; i < n ; i++) {
            for (long j = 0; j < n ; j++) {
                for (long k = 0; k < n ; k++) {
                    operation();
                }
            }
        }
    }



    private static void exponential(long n) {
        if(n>0) {
            exponential(n - 1);
            exponential(n - 1);
        }
        else{
            operation();
        }
    }




    private static void factorial(long n) {
        if(n>0) {
            for (long i = 0; i < n; i++) {
                factorial(n - 1);
            }
        }
        else{operation();}
    }




    private static void operation(){

    }



}
