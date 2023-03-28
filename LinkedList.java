class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedList{
    public static void main(String args[]){

        Node head = new Node(10);
        Node Second = new Node(1);
        Node Third = new Node(24);
        Node Fourth = new Node(13);
        head.next = Second;
        Second.next = Third;
        Third.next = Fourth;

        Node currNode = head;
        while(currNode != null){
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
    }
}