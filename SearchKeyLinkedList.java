public class SearchKeyLinkedList {
    Nodee head;
    
    static class Nodee{
        int data;
        Nodee next;

        Nodee(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    public static void main(String args[]){
        SearchKeyLinkedList list = new SearchKeyLinkedList();
        list = insert(list,10);
        list = insert(list,20);
        list = insert(list,30);
        list = insert(list,40);
        list = insert(list,50);
        printList(list);
        int pos = searchKey(list,50);
        System.out.println("Found at Position: " + pos+1);

    }

    private static int searchKey(SearchKeyLinkedList list, int key) {
        Nodee curr = list.head;
        int count =0;
        while(curr != null){
            if(curr.data == key){
                return count;
            }
            count++;
            curr = curr.next;
        }
        return -1;
    }

    private static void printList(SearchKeyLinkedList list) {
        Nodee curr = list.head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private static SearchKeyLinkedList insert(SearchKeyLinkedList list, int i) {
        Nodee nd = new Nodee(i);
        if(list.head == null){
            list.head = nd;
        }else{
            Nodee curr = list.head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = nd;
        }
        return list;
    }
}
