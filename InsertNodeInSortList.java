public class InsertNodeInSortList {
    
    Nod head;
    
    static class Nod{
        int data;
        Nod next;
        
        Nod(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String args[]){
        InsertNodeInSortList ls = new InsertNodeInSortList();
        ls = insert(ls,1);
        ls = insert(ls,8);
        ls = insert(ls,10);
        ls = insert(ls,16);
        ls = insertInBtw(ls,0);
        printList(ls);
    }

    private static InsertNodeInSortList insertInBtw(InsertNodeInSortList ls, int i) {
        Nod currPtr = ls.head;
        Nod nextPtr = currPtr.next;
        Nod newNode = new Nod(i);
        boolean flag = false;
        while(flag != true){
            if(newNode.data < currPtr.data){
                newNode.next = currPtr;
                ls.head = newNode;
                flag = true;
            }
            else if(currPtr.next == null){
                currPtr.next = newNode;
                flag = true;
                return ls;
            }else if(currPtr.data < newNode.data && nextPtr.data > newNode.data){
                Nod temp = currPtr.next;
                currPtr.next = newNode;
                newNode.next = temp;
                flag = true;
            }
            currPtr = currPtr.next;
            nextPtr = nextPtr.next;
        }
        return ls;
    }

    private static void printList(InsertNodeInSortList ls) {
        Nod curr = ls.head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private static InsertNodeInSortList insert(InsertNodeInSortList ls, int i) {
        Nod curr = ls.head;
        Nod newNode = new Nod(i);
        if(ls.head == null){
            ls.head = newNode;
        }else{
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
        return ls;
    }
}
