public class binarysearchtree {
    public static class Node{
        Node left;
        Node right;
        int val;
        
        Node(int val){
            this.val=val;
        }
    }

    public static Node createBST(Node root,int item){
        if(root==null){
            root=new Node(item);
            return root;
        }
        if(root.val>item){
            root.left=createBST(root.left,item);
        }
        else if(root.val<item){
            root.right=createBST(root.right,item);
        }
        else{
            System.out.println("No Duplicate elements");
        }
        return root;

    }
    public static Node search(Node root,int item){
        if(root==null){
            return null;
        }
        if(item==root.val){
        return root;
    }
        else if(item>root.val){
            return search(root.right,item);
        }
        else{
            return search(root.left,item);
        }
    }
    //delete in a BST
    //basically replace it wih with inorder successor

    public static Node delete(Node root,int val){
        if(root.val<val){
            root.right=delete(root.right,val);
        }
        else if(root.val>val){
            root.left=delete(root.left,val);
        }
        else{
            //leaf node
            if(root.left==null && root.right==null){
                return null;
            }
            //one child
            else if(root.right==null){
                return root.left;
            }
            else if(root.left==null){
                return root.right;
            }
            //inorder succesor
            else{
                Node IS=findinorder(root.right);
                root.val=IS.val;
                root.right=delete(root.right,IS.val);


            }
            return root;
        }
        return root;



    }
    public static Node findinorder(Node root){
            while(root.left!=null){
                root=root.left;
                  
            }
            return root;
        }

    
}
