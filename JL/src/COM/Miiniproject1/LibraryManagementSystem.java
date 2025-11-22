package COM.Miiniproject1;
import java.io.*;
import java.util.*;
class Book {
    private String id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }
    public void setIssued(boolean issued) { this.isIssued = issued; }

    @Override
    public String toString() {
        return "Book ID: " + id +
                " | Title: " + title +
                " | Author: " + author +
                " | Status: " + (isIssued ? "Issued" : "Available");
    }
}
class Member {
    private String memberId;
    private String name;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Member ID: " + memberId + " | Name: " + name;
    }
}
class InvalidReturnException extends Exception {
    public InvalidReturnException(String message) {
        super(message);
    }
}
class Library {
    private HashMap<String, Book> books = new HashMap<>();
    private HashMap<String, Member> members = new HashMap<>();
    private HashMap<String, String> issuedBooks = new HashMap<>(); // bookId → memberId
    private PrintWriter logWriter;

    public Library() throws IOException {
        logWriter = new PrintWriter(new FileWriter("library_log.txt", true));
    }
    public void addBook(Book book) {
        books.put(book.getId(), book);
        logOperation("Book added: " + book.getTitle());
        System.out.println(" Book added successfully!");
    }
    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
        logOperation("Member added: " + member.getName() + " (ID: " + member.getMemberId() + ")");
        System.out.println(" Member added successfully!");
    }

    public void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("👤 No members registered yet.");
        } else {
            System.out.println("\n------ Library Members ------");
            for (Member m : members.values()) {
                System.out.println(m);
            }
        }
    }

    // ---------- Issue Book ----------
    public void issueBook(String bookId, String memberId) throws Exception {
        Book book = books.get(bookId);
        if (book == null)
            throw new Exception(" Book not found!");
        if (book.isIssued())
            throw new Exception(" Book already issued!");
        if (!members.containsKey(memberId))
            throw new Exception(" Member not found! Please register first.");

        book.setIssued(true);
        issuedBooks.put(bookId, memberId);
        logOperation("Book issued: " + book.getTitle() + " to " + members.get(memberId).getName());
        System.out.println(" Book issued successfully to " + members.get(memberId).getName());
    }

    // ---------- Return Book ----------
    public void returnBook(String bookId, int lateDays) throws InvalidReturnException {
        if (!issuedBooks.containsKey(bookId))
            throw new InvalidReturnException(" Invalid return! Book was not issued.");

        Book book = books.get(bookId);
        String memberId = issuedBooks.get(bookId);
        Member member = members.get(memberId);

        book.setIssued(false);
        issuedBooks.remove(bookId);

        double fee = calculateLateFee(lateDays);
        logOperation("Book returned: " + book.getTitle() + " by " + member.getName() + " | Late fee: ₹" + fee);
        System.out.println("Book returned successfully by " + member.getName());
        System.out.println("Late fee: ₹" + fee);
    }

    private double calculateLateFee(int lateDays) {
        return lateDays * 5.0; // ₹5 per day
    }

    private void logOperation(String message) {
        logWriter.println(new Date() + " - " + message);
        logWriter.flush();
    }

    // ---------- Display All Books ----------
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println(" No books available in the library.");
        } else {
            System.out.println("\n------ Library Books ------");
            for (Book b : books.values()) {
                System.out.println(b);
            }
        }
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        try {
            Library library = new Library();
            Scanner sc = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("\n=====  Library Management Menu =====");
                System.out.println("1. Add Book");
                System.out.println("2. Add Member");
                System.out.println("3. Issue Book");
                System.out.println("4. Return Book");
                System.out.println("5. Display All Books");
                System.out.println("6. Display All Members");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");

                int choice;
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println(" Invalid input! Please enter a number.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();
                        library.addBook(new Book(id, title, author));
                        break;

                    case 2:
                        System.out.print("Enter Member ID: ");
                        String memberId = sc.nextLine();
                        System.out.print("Enter Member Name: ");
                        String memberName = sc.nextLine();
                        library.addMember(new Member(memberId, memberName));
                        break;

                    case 3:
                        System.out.print("Enter Book ID to issue: ");
                        String bookId = sc.nextLine();
                        System.out.print("Enter Member ID: ");
                        String issueMemberId = sc.nextLine();
                        try {
                            library.issueBook(bookId, issueMemberId);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 4:
                        System.out.print("Enter Book ID to return: ");
                        String returnId = sc.nextLine();
                        System.out.print("Enter number of late days: ");
                        int days;
                        try {
                            days = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println(" Please enter a valid number.");
                            break;
                        }
                        try {
                            library.returnBook(returnId, days);
                        } catch (InvalidReturnException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 5:
                        library.displayBooks();
                        break;

                    case 6:
                        library.displayMembers();
                        break;

                    case 7:
                        running = false;
                        System.out.println(" Exiting Library System. ");
                        break;

                    default:
                        System.out.println(" Invalid choice! Try again.");
                }
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Error initializing library log file.");
        }
    }
}
