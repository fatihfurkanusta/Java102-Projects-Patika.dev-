import java.util.Comparator;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) {
        TreeSet<Book> myobj = new TreeSet<>();

        myobj.add(new Book("Simyacı",188,"Paulo Coelho", "1988"));
        myobj.add(new Book("LOTR",1346,"J. R. R. Tolkien", "1954"));
        myobj.add(new Book("Suç ve Ceza",705,"Dostoyevski", "1866"));
        myobj.add(new Book("Sefiller",1724,"Victor Hugo", "1862"));
        myobj.add(new Book("Goriot Baba", 288,"Balzac", "1835"));



        System.out.println("Kitap ismine göre sıralama : \n");
        int j=1;
        for(Book i : myobj){

            System.out.println(j+". "+"Book Name: " + i.getBookName() +
                    "\t\tPage Number: " + i.getPageNumb() +
                    "\t\tAuthor Name: " + i.getAuthorName() +
                    "\t\tDate: " + i.getReleaseDate());
            j++;
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------------------------------");

        TreeSet<Book> myobj2 = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.getPageNumb() == o2.getPageNumb()) {
                    return o1.getBookName().compareTo(o2.getBookName());
                }
                return o1.getPageNumb() - o2.getPageNumb();
            }
        });

        myobj2.addAll(myobj);

        System.out.println("Sayfa sayısına göre sıralama : \n");

        int k=1;
        for(Book i : myobj2){
            System.out.println(k+". "+"Book Name: " + i.getBookName() +
                    "\t\tPage Number: " + i.getPageNumb() +
                    "\t\tAuthor Name: " + i.getAuthorName() +
                    "\t\tDate: " + i.getReleaseDate());
            k++;
        }
    }
}