public class recursion{
    public static void print1ton(int n){
        if(n==1){
            System.out.println(n);
            return ;
        }
        System.out.println(n);
        print1ton(n-1);

    }
    public static void printnto1(int n){
        if(n==1){
            System.err.println(n);
            return;
        }
        printnto1(n-1);
        System.out.println(n);
    }
    public static int factorial(int n){
        if(n==0||n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
    

}