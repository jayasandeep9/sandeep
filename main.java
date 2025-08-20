import java.util.*;

// Book class
class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
         author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("You borrowed: " + title);
        } else {
            System.out.println("Sorry, " + title + " is already borrowed.");
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("You returned: " + title);
        } else {
            System.out.println(title + " was not borrowed.");
        }
    }

    @Override
    public String toString() {
        return title + " by " + author + (isBorrowed ? " (Borrowed)" : " (Available)");
    }
}

// Library class
class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Add book
    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " added to library.");
    }

    // Show all books
    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("Books in library:");
        for (Book book : books) {
            System.out.println(" - " + book);
        }
    }

    // Find book by title
    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}

// Main program
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Adding sample books
        library.addBook(new Book("Java Programming", "James Gosling"));
        library.addBook(new Book("Data Structures", "Mark Allen Weiss"));
        library.addBook(new Book("Clean Code", "Robert C. Martin"));

        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Show all books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Add a new book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;
                case 2:
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    Book bookToBorrow = library.findBook(borrowTitle);
                    if (bookToBorrow != null) {
                        bookToBorrow.borrowBook();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    Book bookToReturn = library.findBook(returnTitle);
                    if (bookToReturn != null) {
                        bookToReturn.returnBook();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter book title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String newAuthor = scanner.nextLine();
                    library.addBook(new Book(newTitle, newAuthor));
                    break;
                case 5:
                    System.out.println("Exiting Library System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
