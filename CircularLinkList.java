public class CircularLinkList {
    
    Node last;

    private class Node{
        private int data;
        private Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String args[]){
        CircularLinkList ls = new CircularLinkList();
        ls.insertEnd(1);
        ls.insertEnd(2);
        ls.insertEnd(3);
        ls.insertEnd(4);
        ls.insertEnd(5);
        ls.insertStart(0);

        ls.printList();

        ls.removeLast();
        ls.removeFirst();
        ls.removeFirst();
        ls.removeFirst();
        ls.removeFirst();
        ls.removeFirst();

        ls.printList();

    }

    private void removeFirst() {
        Node first = last.next;
        if(last.next == last){
            last = null;
        }else{
            last.next = first.next;
        }
        first.next = null;
        
    }

    private void removeLast() {
        Node curr = last.next;
        while(curr.next != last){
            curr = curr.next;
        }
        curr.next = last.next;
        last = curr;
    }

    private void printList() {
        if(last == null){
            return;
        }else{
            Node curr = last.next;
            while(curr != last){
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.print(curr.data + " ");
            System.out.println();
        }
    }

    private void insertStart(int i) {
        Node newNode = new Node(i);
        if(last == null){
            last = newNode;
            last.next = last;
        }else{
            newNode.next = last.next;
            last.next = newNode;
        }
    }

    private void insertEnd(int i) {
        Node newNode = new Node(i);
        if(last == null){
            last = newNode;
            last.next = last;
        }else{
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }
}
