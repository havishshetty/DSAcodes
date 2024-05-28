import java.util.*;
class stack {

    public static boolean isEmpty(int top){
        return(top==-1);
    }
    public static boolean isFull(int top,int data[]){
        return(top==data.length-1);
    }
    public static int push(int top,int data[],int item){
        if(isFull(top,data)){
            System.out.println("Stack Overflow");            
        }
        else{
        ++top;
        data[top]=item;
        System.out.println("The element pushed is: "+item);
    }
        return top;       
    }
    public static int[] nextgreater(int nums[]){
        int n=nums.length;
        int [] nge=new int[n];
        Stack<Integer> s=new Stack<>();
        //using circular index concept as well
        for(int i=2*n-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=nums[i%n]){
                s.pop();
            }
            if(!s.isEmpty()){
                nge[i%n]=s.peek();
            }
            else{
                nge[i%n]=-1;
            }
            s.push(nums[i%n]);
        }
        return nge;
    }
    public static int pop(int top,int data[]){
        if(isEmpty(top)){
            System.out.println("Stack Underflow");
            
        }else{
        System.out.println("The element popped is: "+data[top]);
        top--;}
        return top;
    } 
    public static void display(int top,int data[]){
        System.out.print("The elements of the stack: ");

        for(int i=0;i<=top;i++){
            System.out.print(" "+data[i]);
        }
        if(data.length==0){
            System.out.println("Stack is empty");
        }
    }
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        int top=-1;
        int data[]=new int[100];
        //initialize(top, data);
        while(true){
        System.out.print("""
            \nMenu
            1)Push
            2)Pop
            3)Display
            4)Exit
            Enter your choice:""");
            int choice;
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter the element to push: ");
                    int item=sc.nextInt();
                    top=push(top, data, item);
                    break;
                case 2:
                    top=pop(top, data);
                    break;
                case 3:
                    display(top, data);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Wrong Choice");
                
            }
        }
              
    }   
    
}
