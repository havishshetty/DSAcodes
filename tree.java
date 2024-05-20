import java.util.*;
public class tree{
    static class Node{
        int val;
        Node left;
        Node right; 
    
    Node(int val){
        this.val=val;
        this.right=null;
        this.left=null;
    }
}
    static class FlagNode{
        Node node;
        int flag;
    
    FlagNode(Node node,int flag){
        this.node=node;
        this.flag=flag;
    }
}

static class buildbinarytree{
    public static Node buildtree(int val){
        Scanner sc=new Scanner(System.in);
        //stop when val=-1
        int x;
        if(val!=-1){
            Node temp= new Node(val);
            System.out.println("Enter the left child");
            x=sc.nextInt();
            temp.left=buildtree(x);
            System.out.println("Enter the right child");
            x=sc.nextInt();
            temp.right=buildtree(x);
            return temp;

        }
        return null;

    
    }
} 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int val;
        System.out.println("Creating a tree");
        System.out.println("Enter the root");
        val=sc.nextInt();
        Node root=buildbinarytree.buildtree(val);
        // FlagNode flagroot=buildbinarytree.buildtree(val);

        System.out.println("Level Order: ");
        levelorder(root);
        System.out.println("Recursive InOrder: ");
        inorder(root);
        System.out.println("Recursive PreOrder: ");
        preorder(root);
        System.out.println("Recursive PostOrder: ");
        postorder(root);
        System.out.println("Iterative InOrder: ");
        iterinorder(root);
        System.out.println("Iterative PreOrder: ");
        iterpreorder(root);
        System.out.println("Iterative PostOrder: ");
        //iterpostorder(flagroot);

    }

    public static void levelorder(Node root){
        if(root==null){
            return;
        }
        Queue <Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr=q.poll();
            System.out.println(curr.val+" ");
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }

        }
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
    public static void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }
    public static void iterinorder(Node root){
        if (root == null) {
            return;
        }
        boolean done=false;
        Stack <Node> s=new Stack<>();
        Node curr=root;
        while(!done){
            while(curr!=null){
                s.push(curr);
                curr=curr.left;
            }
            if(!s.isEmpty()){
                curr=s.pop();
                System.out.println(curr.val);
                curr=curr.right;
            }
            else{
                done=true;
            }
        }


       
    }
    public static void iterpostorder(Node root){
        
        //use a flag when it shows -1 it means right subtree done
        if (root == null) {
            return;
        }
        Stack<FlagNode> s=new Stack<>();
        Node curr=root;
        while(true){
            while(curr!=null){
            s.push(new FlagNode(curr,1));
            curr=curr.left;
            }
            while(!s.isEmpty() && s.peek().flag<0){
                curr=s.pop().node;
                System.out.print(curr.val + " ");
            }
            if(s.isEmpty()){
                return;
            }
            curr=s.peek().node;
            curr=curr.right;
            s.peek().flag=-1;
        }
        

     
    }
    public static void iterpreorder(Node root){
        if(root==null){
            return;
        }
        Stack <Node> s=new Stack<>();
        Node curr;
        s.push(root);
        while(!s.isEmpty()){
            curr=s.pop();
            System.out.println(curr.val);
            if(curr.left!=null){
                s.push(curr.left);
            }
            if(curr.right!=null){
                s.push(curr.right);
            }
        }

        
    }

}