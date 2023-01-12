public class Book implements Comparable<Book>{
    private String bookName;
    private int pageNumb;
    private String authorName;
    private String releaseDate;

    public Book(String bookName, int pageNumb, String authorName, String releaseDate) {
        this.bookName = bookName;
        this.pageNumb = pageNumb;
        this.authorName = authorName;
        this.releaseDate = releaseDate;
    }
    @Override
    public int compareTo(Book o) {
        return getBookName().compareTo(o.getBookName());
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageNumb() {
        return this.pageNumb;
    }

    public void setPageNumb(int pageNumb) {
        this.pageNumb = pageNumb;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String writerName) {
        this.authorName = authorName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }



}
