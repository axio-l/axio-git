public class Foo {
    public int i,j;

    public Foo (int x, int y) {
        this.i = x;
        this.j = y;
    }

    public static void switcheroo (Foo a, Foo b) {
        Foo temp = a;
        a = b;
        b = temp;
    }

    public static void fliperoo (Foo a, Foo b) {
        Foo temp = new Foo(a.i, a.j);
        a.i = b.i;
        a.j = b.j;
        b.i = temp.i;
        b.j = temp.j;
    }

    public static void swaperoo (Foo a, Foo b) {
        Foo temp = a;
        a.i = b.i;
        a.j = b.j;
        b.i = temp.i;
        b.j = temp.j;
    }

    public static void main (String[] args) {
        Foo foobar = new Foo(10, 20);
        Foo baz = new Foo(30, 40);
        switcheroo(foobar, baz);
        fliperoo(foobar, baz);
        swaperoo(foobar, baz);
    }
}
