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

    
    
}
