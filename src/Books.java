public class Books {
    String title, author, borrowerName;
    int quantity;

    public Books(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public Books(String title, String author, String borrowerName, int quantity) {
        this.title = title;
        this.author = author;
        this.borrowerName = borrowerName;
        this.quantity = quantity;
    }
}
