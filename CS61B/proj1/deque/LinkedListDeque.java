package deque;

public class LinkedListDeque<myType> {

    public class Node {
        public Node prev;
        public myType item;
        public Node next;

        public Node(Node pre, myType cur, Node nex) {
            prev = pre;
            item = cur;
            next = nex;
        }
    }

    private Node sentinel;
    private int size;
    private Node last;
    private Node remove;
    private Node getNode;
    private boolean getTool = true;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(null, null, null);
        last = sentinel.next;
        size = 0;
    }

    public LinkedListDeque(myType x) {
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(null, x, null);
        last = sentinel.next;
        size = 1;
    }

    public void addFirst(myType item) {
        size += 1;
        if (last.item == null) {
            last.item = item;
            return;
        }
        sentinel.next = new Node(null, item, sentinel.next);
        sentinel.next.prev = sentinel;
        sentinel.next.next.prev = sentinel.next;
        last.next = sentinel;
        sentinel.prev = last;
    }

    public void addLast(myType item) {
        size += 1;
        if (last.item == null) {
            last.item = item;
            return;
        } else {
            last.next = new Node(last, item, last.next);
        }
        last = last.next;
        sentinel.prev = last;
        last.next = sentinel;
        sentinel.next.prev = sentinel;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        while (sentinel.next.item != null) {
            System.out.print(sentinel.next.item + " ");
            sentinel = sentinel.next;
        }
        System.out.println("\n");
        sentinel = sentinel.next;
    }

    public myType removeFirst() {
        size -= 1;
        if (size == 0) {
            return null;
        }
        remove = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        remove.next = null;
        remove.prev = null;
        return remove.item;
    }

    public myType removeLast() {
        size -= 1;
        if (size == 0) {
            return null;
        }
        remove = last;
        last.next.prev = last.prev;
        last.prev.next = last.next;
        remove.next = null;
        remove.prev = null;
        last = sentinel.prev;
        return remove.item;
    }

    public myType get(int index) {
        if (size == 0) {
            return null;
        }
        if (getTool) {
            getNode = sentinel.next;
            getTool = false;
        }
        if (index == 0) {
            return sentinel.next.item;
        }
        getNode = getNode.next;
        index -= 1;
        return get(index);
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>(6);
        L.addFirst(7);
        L.addFirst(8);
        L.addFirst(9);
        L.addLast(5);
        L.addLast(4);
        L.addLast(3);
        L.printDeque();
        L.removeFirst();
        L.removeLast();
        L.get(2);






        System.out.println(L.removeFirst());
        System.out.println(L.removeLast());

    }


}
