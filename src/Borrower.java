public class Borrower {
    private final String name;
    private Books Book;
    private final int contact;

    public Borrower(String name, int contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public Books getBorrowedBook() {
        return Book;
    }

    public void setBorrowedBook(Books book) {
        this.Book = book;
    }
    public int getContact() {
        return contact;
    }
}