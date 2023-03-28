public class LinkedlistInsert {

    Node1 head;

    static class Node1{
        int data;
        Node1 next;
        
        Node1(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static LinkedlistInsert insert(LinkedlistInsert list, int data) {
        Node1 new_node = new Node1(data);
        
        if(list.head == null){
            list.head = new_node;
        }else{
            Node1 last = list.head;
            while(last.next != null){
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public static void printlist(LinkedlistInsert list){
        Node1 currNode = list.head;
        while(currNode != null){
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public static void main(String args[]){
        LinkedlistInsert nd = new LinkedlistInsert();
        nd = insert(nd,1);
        nd = insert(nd,2);
        nd = insert(nd,3);
        nd = insert(nd,4);
        printlist(nd);
    }
}
