package COM.Day3;

class Author {
    private String name;
    private String email;
    private char gender;

    // Parameterized Constructor
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    // To display Author details
    public String toString() {
        return "Author Name: " + name + "\nEmail: " + email + "\nGender: " + gender;
    }
}

class Book {
    private String name;
    private Author author;  // Author object
    private double price;
    private int qtyInStock;

    // Parameterized Constructor
    public Book(String name, Author author, double price, int qtyInStock) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    // Setters
    public void setPrice(double price) {
        this.price = price;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    // To display Book details
    public String toString() {
        return "Book Name: " + name + "\n" + author.toString() +
                "\nPrice: " + price + "\nQuantity in Stock: " + qtyInStock;
    }
}

public class AuthorDemo {
    public static void main(String[] args) {
        // Create Author object
        Author a = new Author("J.K. Rowling", "jkrowling@gmail.com", 'F');

        // Create Book object with Author
        Book b = new Book("Harry Potter", a, 499.99, 100);

        // Display book details including author
        System.out.println("----- Book Details -----");
        System.out.println(b.toString());
    }
}
