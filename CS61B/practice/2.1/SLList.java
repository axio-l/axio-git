public class SLList {

    public class IntNode {
        public int item;
        public IntNode next;
        //public int k;

        public IntNode(int f, IntNode r) {
            item = f;
            next = r;
            //k += 1;
        }
    }

    //prevent it from using outside this SLList class
    //the first item is at sentinel.next
    private IntNode sentinel;  //this basically adds an empty cell before everything
    private int size;

    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x)  {
        size = size + 1;
        sentinel.next = new IntNode(x, sentinel.next);
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {

        /*
        if (first == null) {
            first = new IntNode (x, null);
            return;
        }
        */

        size += 1;
        IntNode p = sentinel;

        while (p.next != null) {
           p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    /*
    private static int size(IntNode p) {
        if (p.next == null) {
            return 1;
        }

        return 1 + size(p.next);
    }
     */

    public int size() {
        return size;
    }

    public static void main(String[] args) {

        SLList L = new SLList();
        L.addFirst(15);
        L.addFirst(5);
        L.addLast(7);
        L.addLast(9);
        int c = L.getFirst();
        int b = L.size();
        System.out.println(b);
    }
}
