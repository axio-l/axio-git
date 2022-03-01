package deque;

public class ArrayDeque<myType> {

        private myType[] items;
        private int size;
        private int resize = 2;
        private int length;

        public ArrayDeque() {
            items = (myType []) new Object[8];
            size = 0;
        }

        public ArrayDeque(ArrayDeque other) {
            items = (myType[]) new Object[other.length];
            for (int i = 0; i < other.size() ; i += 1) {
                addLast((myType) other.get(i));
            }
            length = other.length;
        }

        private void resize(int capacity) {
            myType[] a = (myType []) new Object[capacity];
            System.arraycopy(items, 0, a, 0, size);
            items = a;
            length = capacity;
        }

        public void addFirst(myType x) {
            if (size == items.length) {
                resize(items.length * resize);
            }
            myType[] a = (myType []) new Object[items.length];
            System.arraycopy(items, 0, a, 1, size);
            items = a;
            items[0] = x;
            size += 1;
        }

        public void addLast(myType x) {
            if (size == items.length) {
                resize(size * resize);
            }
            items[size] = x;
            size = size + 1;
        }

        public boolean isEmpty() {
            return size == 0;
        }


        public myType getLast() { return items[size - 1]; }

        public myType get(int i) {
            return items[i];
        }

        public int size() {
            return size;
        }

        public myType removeFirst() {
            if (size == 0) {
                return null;
            }
            myType x = items[0];
            if (size * 2 < items.length) {
                resize(items.length / resize);
            }
            myType[] a = (myType []) new Object[items.length];
            System.arraycopy(items, 1, a, 0, size);
            items = a;
            size -= 1;
            return x;
        }

        public myType removeLast() {
            if (size == 0) {
                return null;
            }
            myType x = getLast();
            items[size-1] = null;
            if (size * 2 < items.length) {
                resize(items.length / resize);
            }
            size -= 1;
            return x;
        }

        public void printDeque() {
            int x = 1;
            while (x <= size) {
                System.out.print(items[x-1] + " ");
                x += 1;
            }
            System.out.println();
        }

        public static void main(String[] args ) {
            ArrayDeque<Integer> L = new ArrayDeque<>();
            /*L.addFirst(4);
            L.addFirst(3);
            L.addFirst(2);
            L.addFirst(1);
            L.addLast(5);
            L.addLast(6);
            L.addLast(7);
            L.addLast(8);
            L.addLast(9);
             */
            for (int i = 0; i < 10; i += 1) {
                L.addFirst(i);
            }
            //L.addFirst(0);
            //L.printDeque();
            //System.out.println(L.get(2));
            for (int i = 0; i < 13; i += 1) {
                L.removeFirst();
            }
            for (int i = 0; i < 10; i += 1) {
                L.addFirst(i);
            }
            //ArrayDeque<Integer> Q = new ArrayDeque<>(L);


        }

}
