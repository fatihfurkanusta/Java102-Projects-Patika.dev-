import java.util.ArrayList;

public class Book {
    private String name;
    private int pageNumber;
    private String authorName;
    private int publishDate;

    public Book(String name, int pageNumber, String authorName, int publishDate) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }

    public static ArrayList<Book> bookList() {
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Suç ve Ceza",705,"Dostoyevski",1866));
        bookList.add(new Book("Simyacı",188,"Paulo Cohelho",1825));
        bookList.add(new Book("Kumarbaz",192,"Dostoyevski",1866));
        bookList.add(new Book("Harry Potter ve Felsefe Taşı",274,"JK Rowling",1997));
        bookList.add(new Book("Harry Potter ve Sırlar Odası",314,"JK Rowling",1998));
        bookList.add(new Book("Harry Potter ve Melez Prens",596,"JK Rowling",2005));

        return bookList;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }
}
