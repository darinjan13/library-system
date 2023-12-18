import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

    public class Library {
        private final List<Books> books;
        private final List<Borrower> borrowers;

        public Library() {
            this.books = new ArrayList<>();
            this.borrowers = new ArrayList<>();

            Books books1 = new Books("Darin", "Darin", 1);
            addBook(books1);
        }

        public int borrowerLength() {
            return borrowers.size();
        }

        public boolean isBookEmpty() {
            return books.isEmpty();
        }

        public boolean isBorrowerEmpty() {
            return borrowers.isEmpty();
        }

        public boolean isBookExist(Books book) {
            for (Books b : books) {
                if (b.getBookTitle().equals(book.getBookTitle()) && b.getBookAuthor().equals(book.getBookAuthor())) {
                    return true;
                }
            }
            return false;
        }

        public boolean borrowerExists(String name) {
            for (Borrower borrower : this.borrowers) {
                if (borrower.getName().equals(name)) {
                    return true;
                }
            }
            return false;
        }

        public boolean borrowedBookExists(String title) {
            for (Borrower borrower : this.borrowers) {
                if (borrower.getBorrowedBook().getBookTitle().equals(title)) {
                    return true;
                }
            }
            return false;
        }

        public boolean isAuthorExist(String bookAuthor) {
            for (Books b : books) {
                if (b.getBookAuthor().equals(bookAuthor)) {
                    return true;
                }
            }
            return false;
        }
        public boolean addBorrwer(Borrower borrower, Books books1) {
            boolean added = false;
            for (Books book : books) {
                if (book.getBookTitle().equals(books1.getBookTitle())) {
                    if (book.getBookQuantity() > 0){
                        borrower.setBorrowedBook(books1);
                        borrowers.add(borrower);
                        book.decrementQuantity();
                        added = true;
                    } else {
                        return added;
                    }
                }
            }
            return added;
        }

        public String[][] getBorrowers() {
            String[][] booksAndBorrowers = new String[borrowers.size()][4];
            for (int i = 0; i < borrowers.size(); i++) {
                Borrower borrower = borrowers.get(i);
                Books book = borrower.getBorrowedBook();
                booksAndBorrowers[i][0] = book.getBookTitle();
                booksAndBorrowers[i][1] = book.getBookAuthor();
                booksAndBorrowers[i][2] = borrower.getName();
                booksAndBorrowers[i][3] = Integer.toString(borrower.getContact());
            }
            return booksAndBorrowers;
        }

        public List<Borrower> getBorrower() {
            return borrowers;
        }

        public void checkInBook(String bookTitle, String borrowerName) {
            for (int i = 0; i < borrowers.size(); i++) {
                Borrower borrower = borrowers.get(i);
                if (borrower.getBorrowedBook().getBookAuthor().equals(bookTitle) && borrower.getName().equals(borrowerName)) {
                    borrowers.remove(i);
                    for (Books book : books) {
                        if (book.getBookTitle().equals(bookTitle)) {
                            book.incrementQuantity();
                            return;
                        }
                    }
                    System.out.println("Book not found.");
                    return;
                }
            }
        }

        public void addBook(Books book) {
            for (Books b : books) {
                if (b.getBookTitle().equals(book.getBookTitle()) && b.getBookAuthor().equals(book.getBookAuthor())) {
                        b.setBookQuantity(book.getBookQuantity() + b.getBookQuantity());
                    return;
                }
            }
            books.add(book);
        }

        public List<Books> getAllBooks() {

            return books;
        }

        public List<String> getBookTitles() {
            List<Books> books = getAllBooks();
            List<String> titles = new ArrayList<>();
            for (Books book : books) {
                titles.add(book.getBookTitle());
            }
            return titles;
        }

        public Books getBookByTitle(String title) {
            for (Books book : books) {
                if (book.getBookTitle().equals(title)) {
                    return book;
                }
            }
            return null; // return null if no book with the given title is found
        }

    public List<List<String>> getBooks() {
        List<List<String>> allBooks = new ArrayList<>();
        for (Books book : books) {
            List<String> bookDetails = new ArrayList<>();
            bookDetails.add(book.getBookTitle());
            bookDetails.add(book.getBookAuthor());
            bookDetails.add(Integer.toString(book.getBookQuantity()));
            allBooks.add(bookDetails);
        }
        return allBooks;
    }

    public boolean removeBook(String title) {
        return books.removeIf(book -> book.getBookTitle().equals(title));
    }

        public String[][] searchByTitle(String title) {
            List<String[]> booksByAuthorList = new ArrayList<>();
            for (int i = 0; i < books.size(); i++) {
                Books book = books.get(i);
                if (book.getBookTitle().equals(title)) {
                    String[] bookDetails = new String[3];
                    bookDetails[0] = book.getBookTitle();
                    bookDetails[1] = book.getBookAuthor();
                    bookDetails[2] = String.valueOf(book.getBookQuantity());
                    booksByAuthorList.add(bookDetails);
                }
            }
            String[][] booksByAuthor = new String[booksByAuthorList.size()][3];
            for (int i = 0; i < booksByAuthorList.size(); i++) {
                booksByAuthor[i] = booksByAuthorList.get(i);
            }
            return booksByAuthor;
        }

        public String[][] searchByAuthor(String author) {
            List<String[]> booksByAuthorList = new ArrayList<>();
            for (int i = 0; i < books.size(); i++) {
                Books book = books.get(i);
                if (book.getBookAuthor().equals(author)) {
                    String[] bookDetails = new String[3];
                    bookDetails[0] = book.getBookTitle();
                    bookDetails[1] = book.getBookAuthor();
                    bookDetails[2] = String.valueOf(book.getBookQuantity());
                    booksByAuthorList.add(bookDetails);
                }
            }
            String[][] booksByAuthor = new String[booksByAuthorList.size()][3];
            for (int i = 0; i < booksByAuthorList.size(); i++) {
                booksByAuthor[i] = booksByAuthorList.get(i);
            }
            return booksByAuthor;
        }

    public void checkOutBook(Books book) {
        if (book.getBookQuantity() > 0) {
            book.setBookQuantity(book.getBookQuantity() - 1);
        }
    }

    public void checkInBook(Books book) {
        book.setBookQuantity(book.getBookQuantity() + 1);
    }

    public List<Books> getOverdueBooks() {
        List<Books> overdueBooks = new ArrayList<>();
        // logic to get overdue books
        return overdueBooks;
    }
}
