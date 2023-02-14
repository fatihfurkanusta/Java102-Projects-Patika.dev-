import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BookListManager {
    Book book;

    public BookListManager() {
    }

    public void run(){
        System.out.println("Kitap adı ve yazarına göre sıralama : ");
        Book.bookList().stream().map(i -> {
            Map<String,String> m = new HashMap<>();
            m.put(i.getName(), i.getAuthorName());
            return m;
        }).forEach(System.out::println);
        System.out.println("------------------------------------------");
        System.out.println("Sayfa sayısı 100'den büyük olan kitaplar : ");
        Book.bookList().stream().filter(i -> i.getPageNumber()>100).map(i -> {
            ArrayList<Book> book = new ArrayList<>();
            book.add(i);
            return book;
        }).forEach(book -> {
            for(int i=0; i<book.size();i++){
                System.out.printf("Kitap adı : %-35s Sayfa Numarası : %-10d Yazar Adı : %-20s Yayınlanma Tarihi : %-12d\n",book.get(i).getName(),book.get(i).getPageNumber(),book.get(i).getAuthorName(),book.get(i).getPublishDate());
            }
        });
    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
