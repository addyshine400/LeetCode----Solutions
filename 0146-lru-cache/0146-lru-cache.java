class LRUCache {

// STEP 1: Node class banao
// Har node mein key, value, previous aur next node ka reference hoga
class Node {
    int key;
    int value;
    Node prev;
    Node next;

    // STEP 2: Node ka constructor
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

// STEP 3: HashMap aur Doubly Linked List ke variables
private Map<Integer, Node> map;
private Node head;
private Node tail;
private int capacity;

// STEP 4: LRUCache ka constructor
public LRUCache(int capacity) {

    // Maximum capacity store karo
    this.capacity = capacity;

    // Empty HashMap banao
    map = new HashMap<>();

    // STEP 5: Dummy head aur tail nodes banao
    head = new Node(0, 0);
    tail = new Node(0, 0);

    // STEP 6: Head aur tail ko connect karo
    head.next = tail;
    tail.prev = head;
}

// STEP 7: Kisi existing node ko Linked List se remove karo
private void remove(Node node) {

    // Previous node ko next node se connect karo
    node.prev.next = node.next;

    // Next node ko previous node se connect karo
    node.next.prev = node.prev;
}

// STEP 8: Node ko head ke just baad insert karo
// Head ke paas wala node Most Recently Used (MRU) hoga
private void addToHead(Node node) {

    // Node ka next, current first node hoga
    node.next = head.next; //c.next=A

    // Node ka previous, head hoga
    node.prev = head; //c.prev=head

    // Current first node ka previous, new node hoga
    head.next.prev = node; //A.prev=C

    // Head ka next, new node hoga
    head.next = node; // head.next=c
}

// STEP 9: Least Recently Used node ko remove karo
private Node removeLRU() {

    // Tail se just pehle wala node LRU hai
    Node node = tail.prev;

    // Us node ko Linked List se remove karo
    remove(node);

    // Removed node return karo
    return node;
}

// STEP 10: Key ki value find karo
public int get(int key) {

    // Agar key HashMap mein nahi hai
    if (!map.containsKey(key)) {
        return -1;
    }

    // STEP 11: HashMap se corresponding node nikalo
    Node node = map.get(key);

    // STEP 12: Node ko current position se remove karo
    remove(node);

    // STEP 13: Node ko head par insert karo
    // Kyunki ab ye most recently used hai
    addToHead(node);

    // STEP 14: Node ki value return karo
    return node.value;
}

// STEP 15: Key-value pair insert ya update karo
public void put(int key, int value) {

    // CASE 1: Key pehle se present hai
    if (map.containsKey(key)) {

        // Existing node nikalo
        Node node = map.get(key);

        // Uski value update karo
        node.value = value;

        // Existing position se remove karo
        remove(node);

        // Most recently used position par le jao
        addToHead(node);

    } else {

        // CASE 2: Key present nahi hai

        // STEP 16: Check karo ki cache full hai ya nahi
        if (map.size() == capacity) {

            // STEP 17: Least Recently Used node remove karo
            Node lru = removeLRU();

            // STEP 18: Uski key HashMap se bhi remove karo
            map.remove(lru.key);
        }

        // STEP 19: Naya node banao
        Node node = new Node(key, value);

        // STEP 20: HashMap mein key aur node store karo
        map.put(key, node);

        // STEP 21: Naye node ko head par insert karo
        // Naya node most recently used hoga
        addToHead(node);
    }
}

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */