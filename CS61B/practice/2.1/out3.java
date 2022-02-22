public class out3 {
    public static void main(String[] args) {
        System.out.println(Library.totalBooks);
        //System.out.println(Book.lastBookTitle());
        //System.out.println(Book.getTitle());

        Book goneGirl = new Book("Gone Girl");
        Book fightclub = new Book("Fight Club");

        System.out.println(goneGirl.title);
        System.out.println(Book.lastBookTitle());
        System.out.println(fightclub.lastBookTitle());
        System.out.println(goneGirl.last.title);

        Library libraryA = new Library(1);
        Library libraryB = new Library(2);
        libraryA.addBook(goneGirl);

        System.out.println(libraryA.index);
        System.out.println(libraryA.totalBooks);

        libraryA.totalBooks = 0;
        libraryB.addBook(fightclub);
        libraryB.addBook(goneGirl);

        System.out.println(libraryB.index);
        System.out.println(Library.totalBooks);
        System.out.println(goneGirl.library.books[0].title);

    }
}
