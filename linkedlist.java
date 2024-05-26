public class linkedlist {
    public static class Node{
        int data;
        Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
    }
    
    public static Node head;
    public static Node tail;

    public static void FUCN(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
        return;
    }

    public static void addlast(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
            return;
        }
        tail.next=newnode;
        tail=newnode;
    }

    public static void print(){
        if(head==null){
            System.out.println("Empty");
            return;
        }
        Node curr=head;
        while(curr!=null){
            System.out.println(curr.data+" -> ");
            curr=curr.next;
        }
        return;
    }

    public static void addanywhere(int idx,int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        int i=0;
        Node temp=head;
        Node prev=null;
        while(i<idx-1){
            i++;
            prev=temp;
            temp=temp.next;
        }
        prev.next=newnode;
        newnode.next=temp;
    }

    public static int size(){
        int sizeofll=0;
        if(head==null){
            return sizeofll;
        }
        Node curr=head;
        while(curr!=null){
            sizeofll++;
            curr=curr.next;
        }
        return sizeofll;

    }
    public static int removefirst(){
        if(head==null){
            return -1;
        }
        int val=head.data;
        head=head.next;
        return val;
    }

    public static void removelast(){
        if(head==null){
            return ;
        }
        Node prev=head;
        while(prev.next!=null){
            prev=prev.next;
        }
        prev.next=null;
        tail=prev;
    }

    public static void itersearch(int val){
        Node temp=head;
        int flag=0;
        while(temp!=null){
            if(temp.data==val){
                flag=1;
            }
            temp=temp.next;
        }
    }
    public static void reversell(){
        Node prev=null;
        Node curr=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public void deletenthfromend(int n){
        //first find size
        int size=0;
        Node curr=head;
        while(curr!=null){
            curr=curr.next;
            size++;
        }
        if(n==size){//first node
            head=head.next;

        }
        Node temp=head;
        int key=size-n;
        int i=0;
        while(i<key){
            i++;
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return;
    }

    public static boolean isPalin(){
        //find middle node using slow fast concept(helper function)
        //then divide into two ll
        //if the reverse of second half is equal to first half then true
        if(head==null ||  head.next==null){
            return true;
        }
        Node middle=helper(head);

        Node curr=middle;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;

        }
        Node right=prev;
        Node left=head;
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            right=right.next;
            left=left.next;
        }
        return true;
    }

    public static Node helper(Node head){
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    
    
}
