public class InsertInList {
    Nnode head;

    static class Nnode{
        int data;
        Nnode next;
        Nnode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public InsertInList insert(InsertInList ls, int data){
        Nnode new_node = new Nnode(data);
        if(ls.head == null){
            ls.head = new_node;
        }else{
            Nnode curr = ls.head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = new_node;
        }
        return ls;
    }

    public void printList(InsertInList ls){
        Nnode curr = ls.head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public void insertFirst(InsertInList ls, int data){
        Nnode new_node = new Nnode(data);
        new_node.next = ls.head;
        ls.head = new_node;
    }

    private void deleteLast(InsertInList ls) {
        Nnode last = ls.head;
        Nnode prev = null;
        while(last.next != null){
            prev = last;
            last = last.next;
        }
        prev.next = null;
    }

    private void deleteFirst(InsertInList ls) {
        if(ls.head == null){
            return;
        }else{
            Nnode newHead = ls.head.next;
            ls.head = newHead;
        }
    }

    private void insertAtPos(InsertInList ls, int pos, int data) {
        int count = 0;
        Nnode new_node = new Nnode(data);
        Nnode curr = ls.head;
        if(pos == 0){
            new_node.next = ls.head;
            ls.head = new_node;
            return;
        }
        Nnode prev = null;
        while(pos != count){
            count++;
            prev = curr;
            curr = curr.next;
        }
        prev.next = new_node;
        new_node.next = curr;
    }

    private void length(InsertInList ls) {
        Nnode curr = ls.head;
        int count = 0;
        while(curr.next != null){
            count++;
            curr = curr.next;
        }
        System.out.println("Length: " + (count+1));
    }

    private void insertLast(InsertInList ls, int data) {
        Nnode new_node = new Nnode(data);
        Nnode curr = ls.head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = new_node;
    }

    private void deleteAtPos(InsertInList ls, int pos) {
        int count = 0;
        if(count == pos){
            Nnode newHead = ls.head.next;
            ls.head = newHead;
        }else{
            Nnode curr = ls.head;
            Nnode prev = curr;
            while(count != pos){
                count++;
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
        }
    }

    public static void main(String args[]){
        System.out.println("hi");
        InsertInList ls = new InsertInList();
        ls.insert(ls, 1);
        ls.insert(ls, 2);
        ls.insert(ls, 3);
        ls.insert(ls, 4);
        ls.printList(ls); System.out.println();
        ls.insertFirst(ls, 0);
        ls.printList(ls); System.out.println();
        ls.insertLast(ls,5);
        ls.printList(ls); System.out.println();
        ls.length(ls);
        ls.insertAtPos(ls,2,7);
        ls.printList(ls); System.out.println();
        ls.insertAtPos(ls,0,-1);
        ls.printList(ls); System.out.println();
        ls.length(ls);
        ls.insertAtPos(ls,8,6);
        ls.printList(ls); System.out.println();
        ls.deleteFirst(ls);
        ls.printList(ls); System.out.println();
        ls.deleteLast(ls);
        ls.printList(ls); System.out.println();
        ls.length(ls);
        ls.deleteAtPos(ls,2);
        ls.printList(ls); System.out.println();
    }
   
}