public class HashTable {
    
    private HashNode[] buckets;
    private int size;
    private int numberOfBuckets;

    private class HashNode{
        private Integer key;
        private String value;
        private HashNode next;

        public HashNode(Integer key, String value){
            this.key = key;
            this.value = value;
        }
    }

    public HashTable(){
        this(10);
    }

    public HashTable(int capacity){
        this.numberOfBuckets = capacity;
        buckets = new HashNode[capacity];
        this.size = 0;
    }

    public static void main(String args[]){
        HashTable ht = new HashTable();
        ht.put(0, "value 0");
        ht.put(1, "value1");
        ht.put(2,"value2");
        ht.put(3, "value4");
        ht.put(13, "value13");
        ht.put(23, "value23");
        ht.put(13, "value13again");

        System.out.println(ht.get(13));
        System.out.println(ht.remove(13));

    }

    public void put(Integer key, String value){
        int keyIndex = getKeyIndex(key);
        HashNode head = buckets[keyIndex];
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                break;
            }
            head = head.next;
        }
        size++;
        head = buckets[keyIndex];
        HashNode newnode = new HashNode(key, value);
        newnode.next = head;
        buckets[keyIndex] = newnode; //Try to remeber
    }

    private int getKeyIndex(Integer key) {
        return key % numberOfBuckets;
    }

    public String get(Integer key){
        int keyIndex = getKeyIndex(key);
        HashNode head = buckets[keyIndex];
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
        
    }

    public String remove(Integer key){
        int keyIndex = getKeyIndex(key);
        HashNode head = buckets[keyIndex];
        HashNode prev = null;
        while(head != null){
            if(head.key.equals(key)){
                break;
            }
            prev = head;
            head = head.next;
        }
        if(head == null){return null;}
        size--;
        if(prev!= null){
            prev.next = head.next;
        }else{
            buckets[keyIndex] = head.next;
        }
        return head.value;
    }
}
