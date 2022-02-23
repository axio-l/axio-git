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

    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(null, null, null);
        last = sentinel.next;
        size = 0;

        for (int i = 0; i < other.size() ; i += 1) {
            addLast((myType) other.get(i));
        }
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
        if (size == 0) {
            return null;
        } else if (size == 1) {
            myType x = sentinel.next.item;
            sentinel.next.item = null;
            size -= 1;
            return x;
        }
        remove = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        remove.next = null;
        remove.prev = null;
        size -= 1;
        return remove.item;
    }

    public myType removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            myType x = last.item;
            last.item = null;
            size -= 1;
            return x;
        }
        remove = last;
        last.next.prev = last.prev;
        last.prev.next = last.next;
        remove.next = null;
        remove.prev = null;
        last = sentinel.prev;
        size -= 1;
        return remove.item;
    }

    public myType getRecursive(int index) {
        if (size == 0 || index + 1 > size) {
            return null;
        }
        if (getTool) {
            getNode = sentinel.next;
            getTool = false;
        }
        if (index == 0) {
            getTool = true;
            return getNode.item;
        }
        getNode = getNode.next;
        index -= 1;
        return getRecursive(index);
    }

    public myType get(int index) {
        if (size == 0 || index > size) {
            return null;
        }
        getNode = sentinel.next;
        while (index > 0) {
            index -= 1;
            getNode = getNode.next;
        }
        return getNode.item;
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
        //L.removeFirst();
        //L.removeLast();
        //L.get(5);
        LinkedListDeque<Integer> Q = new LinkedListDeque<>(L);
        //System.out.println(L.removeFirst());
        //System.out.println(L.removeLast());

    }


}
