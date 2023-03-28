public class NthNodeFromEnd {

    Nnode head;
    
    static class Nnode{
        int data;
        Nnode next;

        Nnode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String args[]){
        NthNodeFromEnd ls = new NthNodeFromEnd();
        ls = insert(ls,10);
        ls = insert(ls,20);
        ls = insert(ls,30);
        ls = insert(ls,40);
        ls = insert(ls,50);
        ls = insert(ls,60);
        Nnode value = findNthNode(ls,3);
        System.out.println(value.data);
    }

    private static NthNodeFromEnd.Nnode findNthNode(NthNodeFromEnd ls, int key) {
        Nnode value = ls.head;
        int count =0;
        Nnode curr = ls.head;
        while(curr != null){
            count++;
            curr = curr.next;
        }

        int node = count - key; count =0;

        while(count < node){
            value = value.next;
            count++;
        }
        
        return value;
    }

    private static NthNodeFromEnd insert(NthNodeFromEnd ls, int i) {
        Nnode newNode = new Nnode(i);
        if(ls.head == null){
            ls.head = newNode;
        }else{
            Nnode curr = ls.head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }        
        return ls;
    }
}
