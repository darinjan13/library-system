public class Books {
    private String bookTitle;
    private String bookAuthor;
    private int bookQuantity;

    public Books(String bookTitle, String bookAuthor, int bookQuantity) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookQuantity = bookQuantity;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public void incrementQuantity() {
        this.bookQuantity++;
    }
    public void decrementQuantity() {
        this.bookQuantity--;
    }
}
