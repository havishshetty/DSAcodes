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
    public static int getheight(Node root){
        if(root==null){
            return 0;
        }
        return(Math.max(root.left.val,root.right.val)+1);
    }
    public static int countnodes(Node root){
        int count=0;
        if(root==null){
            return 0;
        }
        // countnodes(root.left);
        // count++;
        // countnodes(root.right);
        // return count;
        int left=countnodes(root.left);
        int right=countnodes(root.right);
        return left+right+1;

    }
    public static int sumnodes(Node root){
        if(root==null){
            return 0;
        }
        int left=sumnodes(root.left);
        int right=sumnodes(root.right);
        return left+right+root.val;
    }

    public static int diameter(Node root){
        //number of nodes between the longest part
        //find the maximum between the right diameter ,left diamter and the selfdiameter
        //another way of doing this is by creating a class called info which conatins diamter and height as attributes similar to flag in postorder where you create a node and flag for the Flagnode
        if(root==null){
            return 0;
        }
        int leftdia=diameter(root.left);
        int leftheight=getheight(root.left);
        int rightdia=diameter(root.right);
        int rightheight=getheight(root.right);
        int selfdia=rightheight+leftheight+1;
        return Math.max(selfdia,Math.max(rightdia,leftdia));
    }
    public static boolean isidentical(Node root,Node subroot){
        //to check if subtree is present in a tree
        if(root==null||subroot==null){
            return true;
        }
        else if(root==null||subroot==null||root.val!=subroot.val){
            return false;
        }
        if(!isidentical(root.left, subroot.left)){
            return false;
        }
        if(!isidentical(root.right, subroot.right)){
            return false;
        }
        return true;

    }
    public static boolean issubtree(Node root,Node subroot){
        if(root==null){
            return false;
        }
        if(root.val==subroot.val){
            if(isidentical(root, subroot)){
                return true;
            }
        }
        return issubtree(root.left,subroot.left)||issubtree(root.right,subroot.right);
    }
    //top view use a hashmap
    //horizontal distance 
    //use a queue with the class Info which has node and Horizontal distance HD of root is 0\
    static class Info{
        int hd;
        Node root;
        Info(int hd,Node root){
            this.hd=hd;
            this.root=root;
        }
    
    public static void topview(Node root){
        int min=0,max=0;
        Queue <Info> q=new LinkedList<>();
        HashMap<Integer,Node> hm=new HashMap<>();
        Info curr;
        q.add(new Info(0,root));

        while(!q.isEmpty()){
            curr=q.poll();
            if(!hm.containsKey(curr.hd)){
                hm.put(curr.hd,curr.root);
            }
            if(curr.root.left!=null){
                q.add(new Info (curr.hd,curr.root.left));
                min=Math.min(curr.hd-1,min);
            }
            if(curr.root.right!=null){
                q.add(new Info (curr.hd,curr.root.right));
                max=Math.max(curr.hd+1,max);
            }

        }
        for(int i=min;i<max;i++){
            System.out.println(hm.get(i));
        }


    }
 public static ArrayList<Integer> kthLevel(Node root, int k) {
    ArrayList<Integer> al = new ArrayList<>();
    int level = 0; // Starting level from 0
    if (k < 0 || root == null) {
        return al;
    }
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
        int size = q.size(); // Store the size of the current level
        level++;
        if (level == k) {
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                al.add(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            return al; // Return the result once we reach the k-th level
        } else {
            // Traverse nodes at the current level without adding them to the result
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }
    return al; // Return empty list if k is greater than the height of the tree
}

//LCA
//Basically make an array of the paths from the root to the node the last common one between the both the path1 and path2 is the LCA
public static Node LCA(Node root,int n1,int n2){

    ArrayList<Node> p1=new ArrayList<>();
    ArrayList<Node> p2=new ArrayList<>();
    getpath(root,n1,p1);
    getpath(root,n2,p2);
    int i;
    for(i=0;i<p1.size()&& i<p2.size();i++){
        if(p1.get(i)!=p2.get(i)){
            break;
        }


    }
    return p1.get(i-1);


}

public static boolean getpath(Node root,int n,ArrayList<Node> p){
    if(root==null){
        return false;
    }
    p.add(root);
    if(root.val==n){
        return true;
    }
    boolean foundleft=getpath(root.left, n, p);
    boolean foundright=getpath(root.right, n, p);
    if(foundleft||foundright){
        return true;
    }
    p.remove(p.size()-1);
    return false;



}


    }

}