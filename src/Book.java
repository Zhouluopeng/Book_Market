/**
 * {@code @저우뤄펑}
 *
 * @version 1.0
 */
public class Book {
    private final String ISBN;
    private final String name;
    private final double price;
    private final String author;
    private final String category;
    private final String publishTime;

    public Book(String ISBN, String name, double price, String author, String category, String publishTime) {
        this.ISBN = ISBN;
        this.name = name;
        this.price = price;
        this.author = author;
        this.category = category;
        this.publishTime = publishTime;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", name='" + name + '\'' +
                ", price=" + "$" + price +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", publishTime='" + publishTime + '\'' +
                '}';
    }
}
