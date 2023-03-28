public class ReverseLinkedList {
    Nodde head;
    static class Nodde{
        int data;
        Nodde next;

        Nodde(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String args[]){
        ReverseLinkedList list = new ReverseLinkedList();
        list = insert(list,10);
        list = insert(list,20);
        list = insert(list,30);
        list = insert(list,40);
        list = insert(list,50);
        printList(list);
        list = reverseList(list);
        printList(list);
    }

    private static ReverseLinkedList reverseList(ReverseLinkedList list) {
        Nodde curr = list.head;
        Nodde prev = null;
        Nodde next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        list.head = prev;
        return list;
    }

    private static void printList(ReverseLinkedList list) {
        Nodde curr = list.head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private static ReverseLinkedList insert(ReverseLinkedList list, int i) {
        Nodde nd = new Nodde(i);
        if(list.head == null){
            list.head = nd;
        }else{
            Nodde curr = list.head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = nd;
        }
        return list;
    }
}
