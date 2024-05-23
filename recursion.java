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

    public static int tilling(int n){
        if(n==0||n==1){
            return 1;
        }
        int horizontal=2*tilling(n-2);
        int vertical=2*tilling(n-1);
        return horizontal+vertical;
    }

    public static void removedup(String s,int idx,StringBuilder sb,boolean map[]){
        if(idx==s.length()){
            System.out.println(sb);
            return;
        }
        char curr=s.charAt(idx);
        if(map[curr-'a']==true){//duplicate
            removedup(s, idx+1, sb, map);

        }
        else{
            map[curr='a']=true;
            removedup(s, idx+1, sb.append(s.charAt(curr)), map);
        }

    }

    public static int frndpair(int n){
        if(n==1||n==2){
            return n;
        }
        int single=frndpair(n-1);
        int doubleway=frndpair(n-2);
        int pairway=doubleway*(n-1);//(n-1) ppl to choose from
        return single+pairway;

    }

    public static int nfibnumber(int n){
        if(n==0||n==1){
            System.out.println(n);
            return n;
        }
        int fibnm1=nfibnumber(n-1);
        int fibnm2=nfibnumber(n-2);
        int number=fibnm1+fibnm2;
        System.out.println(number);
        return fibnm1+fibnm2;

    }

    public static void noconsecutive1(int n,int lastplace,StringBuilder str){
        if(n==0){
            System.out.println(n);
            return;
        }
        if(lastplace==0){
            noconsecutive1(n-1, 0,str.append(0));
            noconsecutive1(n-1, 1,str.append(1));
        }
        else{
            noconsecutive1(n-1, 0,str.append(0));
        }
    }

    public static void tofh(int n,String src,String aux,String dst){
        if(n==1){
            System.out.println("Tranferred "+n+" disk from "+src+" to "+dst);
            return;
        }
        tofh(n-1, src, aux, dst);
        System.out.println("Tranferred "+n+" disk from "+src+" to "+dst);
        tofh(n-1, aux, src, dst);

    }
    



}