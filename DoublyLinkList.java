public class DoublyLinkList {

    private Node head;
    private Node tail;

    private class Node{
        private int data;
        private Node next;
        private Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public DoublyLinkList(){
        this.head = null;
        this.tail = null;
    }

    public static void main(String args[]){
        DoublyLinkList ls = new DoublyLinkList();
        
        ls.insertback(1);
        ls.insertback(2);
        ls.insertback(3);
        ls.insertfront(0);

        ls.printListForward();
        ls.printListBackward();      
        
        ls.deleteFront();
        ls.deleteLast();
        ls.deleteLast();
        ls.deleteLast();

        ls.printListForward();
    }

    private void deleteLast() {
        if(tail == null){
            return;
        }
        else if(head == tail){
            head = tail = null;
        }
        else{
            Node temp = tail.prev;
            tail = temp;
            tail.next = null;
        }
    }

    private void deleteFront() {
        if(head == null){
            return;
        }else if(head == tail){
            head = tail = null;
        }else{
            Node temp = head.next;
            head = temp;
            head.prev = null;
        }
    }

    private void printListBackward() {
        Node curr = tail;
        if(tail == null){
            return;
        }else{
            while(curr != null){
                System.out.print(curr.data + " ");
                curr = curr.prev;
            }
            System.out.println();
        }
    }

    private void insertfront(int i) {
        Node newNode = new Node(i);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
    }

    private void insertback(int i) {
        Node newNode = new Node(i);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
    }

    private void printListForward() {
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
