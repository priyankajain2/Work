public class AddTwoList {
    Pont head;

    static class Pont{
        int data;
        Pont next;

        Pont(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String args[]){
        AddTwoList ls = new AddTwoList();
        AddTwoList ls1 = new AddTwoList();
        AddTwoList ls2 = new AddTwoList();

        ls = insert(ls,1);
        ls = insert(ls,7);
        ls = insert(ls,2);
        ls = insert(ls,3);
        ls = insert(ls,4);

        ls1 = insert(ls1,2);
        ls1 = insert(ls1,4);
        ls1 = insert(ls1,2);
        ls1 = insert(ls1,3);
        ls1 = insert(ls1,4);

        printList(ls);
        printList(ls1);

        //System.out.println(18/10);
        //System.out.println(18%10);
        ls2 = addList(ls,ls1,ls2);
        printList(ls2);
    }

    private static AddTwoList addList(AddTwoList ls, AddTwoList ls1,AddTwoList ls2) {
        int carryOn = 0;
        Pont node = ls.head;
        Pont node1 = ls1.head;
        while(node != null && node1 != null){
            int sum = node.data + node1.data + carryOn;
            if(sum < 10){
                ls2.insert(ls2, sum);
                carryOn = 0;
            }else{
                carryOn = sum/10;
                ls2.insert(ls2, sum%10);
            }
            node = node.next;
            node1 = node1.next;
        }
        return ls2;
    }

    private static void printList(AddTwoList ls) {
        Pont curr = ls.head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private static AddTwoList insert(AddTwoList ls, int i) {
        Pont curr = ls.head;
        Pont newNode = new Pont(i);
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
