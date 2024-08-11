public class dp{

    // Recursive (Exponential Time Complexity)
    public static int countstairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2; 
        }
        return countstairs(n-1) + countstairs(n-2);
    }

    // Memoization (Top-Down Dynamic Programming)
    public static int memcountstairs(int n, int[] dp) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2; 
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = memcountstairs(n-1, dp) + memcountstairs(n-2, dp);
        return dp[n];
    }

    // Tabulation (Bottom-Up Dynamic Programming)
    public static int tabcountstairs(int n, int[] dp) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2; 
        }
        for (int i = 2; i < dp.length; i++) {
            if (dp[i] != 0) {
                dp[i] = memcountstairs(i-1, dp) + memcountstairs(i-2, dp);
            }
        }
        return dp[n];
    }

    //KNAPSACK PROBLEMS

    public static int knapsack(int val[],int wt[],int w,int n ){
        if(w==0||n==0){
         return 0;   
        }
        if(wt[n-1]<=w){//0 based indexing //valid 

            //include
            int ans1=val[n-1]+knapsack(val,wt,w-wt[n-1],n-1);
            //exclude
            int ans2=knapsack(val,wt,w,n-1);

            return Math.max(ans1,ans2);

        }
        else{//not valid
            return knapsack(val,wt,w,n-1);
        }

    }

    public static int mem01knapsack(int val[],int wt[],int w,int n,int dp[][]){// 2 variables n and w so make a 2d array
        //store answer then return it
        if(w==0||n==0){
         return 0;   
        }
        if(dp[n][w]!=-1){
            return dp[n][w];
        }
        if(wt[n-1]<=w){//0 based indexing //valid 

            //include
            int ans1=val[n-1]+knapsack(val,wt,w-wt[n-1],n-1,dp);
            //exclude
            int ans2=knapsack(val,wt,w,n-1,dp);

            dp[n][w]=Math.max(ans1,ans2);
            return dp[n][w];
        }
        else{//not valid
           dp[n][w]= knapsack(val,wt,w,n-1,dp);
           return dp[n][w];
        }
    }

    public static int tab01knapsack(int val[],int wt[],int W){// 2 variables n and w so make a 2d array
        //store answer then return it
        int n=val.length;
        int dp[][]=new int[n+1][w+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<dp.length;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int v=val[i-1];
                int w=wt[i-1];
                //valid
                if(w<=j){
                    int inc=val[i-1]+dp[i-1][j-w];
                    int exc=dp[i-1][w];
                    dp[i][j]=Math.max(inc,exc);

                }
                else{
                    int exc=dp[i-1][w];
                    dp[i][j]=exc;
                }


            }
        }
        return dp[n][W];
    }


    public static int knapsack01(int wt[],int v[],int n,int W){
        if(W==0 ||n==0){
            return 0;
        }
        if(wt[n-1]<=W){
            //include
            int ans1=val[n-1]+knapsack01(wt, v, n-1, W-wt[n-1]);
            int ans2=val[n-1]+knapsack01(wt, v, n-1, W);
            return Math.max(ans1,ans2);
            
        }
        else{
            return knapsack(wt,v,n-1,W);
        }
    }


    //target sum subset(0/1 knapsack)

    public boolean targetsum(int arr[],int sum){
        int n=arr.length;
        boolean dp[][]=new boolean[n+1][sum+1];
//val and weight are same in this question
//i = items & j= target sum
        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int v=arr[i-1];
                //include
                if(v<=j && dp[i-1][j-v]==true){
                    dp[i][j]=true;
                }
                //exclude
                else if(dp[i-1][j]==true){
                    dp[i][j]=true;
                }

            }
        }
        return dp[n][sum];


    }

    public static int tabunboundedknapsack(int val[],int wt[],int W){// 2 variables n and w so make a 2d array
        //store answer then return it
        int n=val.length;
        int dp[][]=new int[n+1][w+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<dp.length;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int v=val[i-1];
                int w=wt[i-1];
                //valid
                if(w<=j){
                    int inc=val[i-1]+dp[i][j-w];//only chnage i-1 becomes i
                    int exc=dp[i-1][w];
                    dp[i][j]=Math.max(inc,exc);

                }
                else{
                    int exc=dp[i-1][w];
                    dp[i][j]=exc;
                }


            }
        }
        return dp[n][W];
    }


    //rod cutting like a knapsack problem unbounded
// weight= length and val=price over here
    public static int rodcutting(int length[],int price[],int totRod){
        int n=length.length;
        int dp[][]=new int [n+1][totRod+1];

        for(int i=0;i<n;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<totRod;i++){
            dp[0][j]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<totRod+1;j++){
                int l=length[i-1];
                int p=price[i-1];
                int c=totRod;
                //valid
                if(l<=j){
                    dp[i][j]=Math.max(p+dp[i][j-l],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[n][totRod];
    }

//LCS Longest Common Subsequence

    public static int lcsrecursion(String m,String n,int n1,int n2){
        if(n1==0 || n2==0){
            return 0;
        }
        if(m.charAt(n1)==n.charAt(n2)){
            return lcs(m,n,n1-1,n2-1) +1;
        }
        else{
            int ans1=lcs(m,n,n1-1,n2);
            int ans2=lcs(m,n,n1,n2-1);

            return Math.max(ans1,ans2);
        }

    }

    public static int lcstab(String m,String n,int n1,int n2){
        if(n1==0 || n2==0){
            return 0;
        }
        int dp[][]=new dp[n1+1][n2+1];

        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<n1+1;i++){
            for(int j=1;j<n2+1;j++) {
                if(m.charAt(i-1)==m.charAt(j-i)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    int a1=dp[i-1][j];
                    int a2=dp[i][j-1];
                    dp[i][j]=Math.max(a1,a2);
                }
            }
        }
        return dp[n1][n2];


    }
     
    
public static int lcsubstringtab(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        if(n1==0 || n2==0){
            return 0;
        }
        int dp[][]=new dp[n+1][m+1];
        int ans=0;
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++) {
                if(str1.charAt(i-1)==str2.charAt(j-i)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans=Math.max(ans,dp[i][j]);
                }
                else{ 
                    dp[i][j]=0;
                }
            }
        }
        return ans;
    }

    public static int lcs(int []arr1,int[]arr2){
        int n=arr1.length;
        int m=arr2.length;
        int dp[][]=new int[n+1][m+1];

        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<m+1;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr1[i-1]==arr2[j-1]){
                 dp[i][j]=dp[i-1][j-1]+1;   
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][w];
    }



    public static int lis(int arr[]){
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            hs.add(arr[i]);
        }
        int arr2[]=new int[hs.size()];
        int i=0;
        for(int num:set){
            arr2[i]=num;
            i++;
        }
        Arrays.sort(arr2);

        return lcs(arr,arr2);
    }


    public static boolean wildcard(String p,String s){
        int n=s.length();
        int m=p.length();

        boolean [][] dp=new int[n+1][m+1];

        dp[0][0]=true;
        for(int i=1;i<n+1;i++){
            dp[i][0]=false;
        }

        for(int j=1;j<m+1;i++){
            if(p.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
            }
            else{
                dp[0][j]=false;
            }
        }
        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //case ->ith ==jth || jth==?
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j-1] || dp[i][j-1];
                }
                else{
                    dp[i][j]=false;
                }
            }
        }
            return dp[n][m];
    }

    //catalan number 
     //recursion

     public static int catalanrecur(int n){
        if(n==0||n==1){
            return 1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=catalanrecur(i)*catalanrecur(n-i-1);
        }
        return ans;
     }

     //memoization

     public static int catalanmem(int n,int []dp){
        if(n==0||n==1){
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=catalanmem(i,dp)*catalanmem(n-i-1,dp);
        }
        return dp[n]=ans;
     }

     public static int catalantab(int n){
        int dp[]=new int[n+1];

        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<n+1;i++){//Ci being calculated
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]+dp[i-j-1];//Ci=Cj*Cj-i-1
            }
        }
        return dp[n];
     }

     //Counting Trees
     //find number of BST in N nodes
       

     public static int countBST(int n){
        int dp[]=new int [n+1];

        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                int left=dp[j];
                int right=dp[i-j-1];
                dp[i]+=left*right;
            }
        }
        return dp[n];
     }


     //Mountains ranges
     //the upstroke cant be less than downstrokes

     public static int mountainrange(int n){
        int dp[]=new int[n+1];

        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                
                dp[i]+=dp[j]+dp[i-j-1];
            }
        }
        return dp[n];
     }

     //Matrix Basics
     //Matrix Chain Multiplication

     //arr[]1,2,3,4,3
     //find min cost
      



    public static void main(String args[]) {
        int n = 5;
        
        // Recursive
        System.out.println("Recursive: " + countstairs(n));

        // Memoization
        int[] ways = new int[n + 1];
        System.out.println("Memoization: " + memcountstairs(n, ways));

        // Tabulation
        int[] tabWays = new int[n + 1];
        System.out.println("Tabulation: " + tabcountstairs(n, tabWays));
    }
}
