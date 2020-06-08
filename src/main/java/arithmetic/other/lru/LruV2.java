package arithmetic.other.lru;

public class LruV2<K, V> {

    private final int cap;
    private int size = 0;
    private final Node<K, V> head = new Node<K,V>();

    public LruV2(int cap) {
        this.cap = cap;
    }

    public void put(K key, V value) {
        Node<K, V> node = head.next;
        while (node != null) {
            if (node.key == key) {
                //移除之前的
                node.before.next = node.next;
                break;
            }
            node = node.next;
        }
        size++;
        if (size > cap) {
            //移除最后一个
            node = head.next;
            while (node.next != null) {
                node = node.next;
            }
            node.before.next = null;
        }
        Node<K, V> newNode = new Node<K, V>(key, value);
        if (head.next != null) {
            head.next.before = newNode;
        }

        newNode.next = head.next;


        head.next = newNode;
        newNode.before = head;
    }


    public static class Node<K, V> {
        private K key;
        private V value;
        public Node<K, V> before;
        public Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
