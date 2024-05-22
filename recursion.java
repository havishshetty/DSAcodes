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

    public static int sum(int n){
        if(n==1){
            return 1;
        }
        int add=n+sum(n-1);
        return add;
    }

    public static int fibo(int n){//return n fib number
        if(n==0||n==1){
            return n;
        }
        else{
            int fib=fibo(n-1)+fibo(n-2);
            return fib;
        }

    }

    public static boolean issorted(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return issorted(arr,i+1);

    }

    public static int firstocuur(int arr[],int i,int key){
        if(i==arr.length-1){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstocuur(arr,i+1,key);
    }

    public static int lastoccur(int arr[],int i,int key){
        if(arr.length-1==i){
            return -1;
        }
        int isFound=lastoccur(arr,i+1,key);

        if(isFound!=-1){
            return isFound;
        }
        if(arr[i]==key){
            return i;
        }
        return isFound;

    }

    public static int powerxton(int x,int n){
        if(n==1){
            return x;
        }
        if(n==0){
            return 1;
        }

        return x*powerxton(x, n-1);
    }

    public static double optimizedpower(int x,int n){
        double ans=1.0;
        long nn=n;

        if(nn<0){
            nn=n*-1;
        }
        while(nn>0){
            if(nn%2==1){
                ans=ans*x;
                x=x-1;
            }
            else{
                x=x*x;
                nn=nn/2;
            }
        }
        if(n<0) ans=(double)(1.0)/(double)(ans);
        return ans;
    }


}