import java.util.*;
public class greedy{
    //activity selection type 
    //sort according to end
    //select activyt which finishes first
    //then starttime >= endtime of prev activity


    //end time sorted
    public static ArrayList<Integer> activityselect(int start[],int end[]){
        int count=0;
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(0);//number indicate activity number
        int lastend=end[0];
        for(int i=1;i<end.length;i++){
            if(start[i]>=lastend){
                ans.add(i);
                count++;
                lastend=end[i];
            }
        }
        System.out.println(count);
        return ans;
    }

    //end time is not sorted
    public static ArrayList<Integer> activityselect1(int start[],int end[]){
        //create an new 2d array with index start and end;
        int activity [][]=new int [start.length][3]; //3 cols for activity(idx) start and end
        for(int i=0;i<start.length;i++){
            activity[i][0]=i;
            activity[i][1]=start[i];
            activity[i][2]=end[i];
        }
        //do a lambda fucntion
        Arrays.sort(activity,Comparator.comparingDouble(o->o[2]));//based on end col
        int count=0;
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(activity[0][0]);//number indicate activity number
        int lastend=activity[0][2];
        for(int i=1;i<end.length;i++){
            if(activity[i][1]>=lastend){
                ans.add(i);
                count++;
                lastend=activity[i][2];
            }
        }
        System.out.println(count);
        return ans;
    }

    //fractional knapsack uses greedy 0/1 knapsack DP

    public static int fractionalkp(int w[],int v[],int capacity){
        int ans=0;
        // W/V ratio V should be more and W should be less

        int arr[][]=new int[w.length][2];
        for(int i=0;i<w.length;i++){
            arr[i][0]=i;
            arr[i][1]=w[i]/v[i];
        }
        Arrays.sort(arr,Comparator.comparingDouble((o-> o[1])));
        //int curr=0;
        for(int i=0;i<w.length;i++){
            int idx=arr[i][0];
            if(w[idx]<=capacity){
                capacity-=w[i];
                ans+=v[idx];
            }
            else{
                ans=ans+(arr[i][0]*capacity);
                break;
            }
        }
        return ans;
    }
      

    public static void main(String[] args) {
        int start[]={1,3,0,5,8};
        int end[]={2,4,6,7,9};

        
    }
}