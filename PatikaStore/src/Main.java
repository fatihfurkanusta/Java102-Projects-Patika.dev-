import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Brand> pro = new ArrayList<>();

        pro.add(new MobilePhone("Phone",11, "Iphone", "14 Pro Max", 10000, 0, 5, "128 GB", "4 inch", "1000 mhz", "16 GB", "Black"));
        pro.add(new MobilePhone("Phone",11, "Samsung", "11 Pro Max", 10000, 0, 5, "128 GB", "4 inch", "1000 mhz", "16 GB", "Black"));
        pro.add(new MobilePhone("Phone",11, "Xaomi", "11 Pro Max", 10000, 0, 5, "128 GB", "4 inch", "1000 mhz", "16 GB", "Black"));
        pro.add(new MobilePhone("Phone",11, "Nokia", "11 Pro Max", 10000, 0, 5, "128 GB", "4 inch", "1000 mhz", "16 GB", "Black"));
        pro.add(new NoteBook("NoteBook",20,"Monster","model 1",15000,"16",12,"500 GB SSD","10 inch"));
        pro.add(new NoteBook("NoteBook",20,"Samsung","model 2",15000,"16",12,"500 GB SSD","10 inch"));
        pro.add(new NoteBook("NoteBook",20,"Xaomi","model 3",15000,"16",12,"500 GB SSD","10 inch"));

        while(true){
            System.out.println("--------------------------------------------------------");
            System.out.println("PatikStore Ürün Yönetim Paneli ! ");
            System.out.println("1 - NoteBook İşlemleri");
            System.out.println("2 - MobilePhone İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Seçiminiz : ");
            int answ = input.nextInt();

            int exit=1;
            switch (answ){
                case 1:
                    printNotebook(pro);
                    break;
                case 2:
                    printPhone(pro);
                    break;
                case 3 :
                    sortingBrand(pro);
                    break;
                case 0:
                    exit = 0;
                    break;
                default:
                    System.out.println("Geçersiz giriş yaptınız!");
            }
            if(exit == 0){
                System.out.println("Çıkış Yaptınız.");
                break;
            }
        }
    }
    public static void printNotebook(ArrayList<Brand> pro){
        List<NoteBook> noteBook = new ArrayList<>();

        for(int i=0; i<pro.size();i++){
            if(Objects.equals(pro.get(i).getKind(), "NoteBook")){
                noteBook.add((NoteBook) pro.get(i));
            }
        }

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-3s|  %-29s|  %-9s|  %-9s|  %-12s| %-10s|  %-9s| %n","ID","ÜRÜN ADI","FİYAT","MARKA","DEPOLAMA","EKRAN","RAM");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

        for(int i = 0 ; i < noteBook.size() ;i++){
            String productName = noteBook.get(i).getBrandName()+" "+noteBook.get(i).getProductName();
            String brandName = noteBook.get(i).getBrandName();
            int price = noteBook.get(i).getPrice();
            String memoryInfo = noteBook.get(i).getMemoryInfo();
            String screenSize = noteBook.get(i).getScreenSize();
            String ram = noteBook.get(i).getRam();


            System.out.printf("| %-3d|  %-29s|  %-9d|  %-9s|  %-12s|  %-9s|  %-9s| %n",i+1,productName,price,brandName,memoryInfo,screenSize,ram);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

    }
    public static void printPhone(ArrayList<Brand> pro){
        List<MobilePhone> phone = new ArrayList<>();

        for(int i=0; i<pro.size();i++){
            if(Objects.equals(pro.get(i).getKind(), "Phone")){
                phone.add((MobilePhone) pro.get(i));
            }
        }

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-3s|  %-29s|  %-9s|  %-9s|  %-9s| %-10s| %-10s|  %-9s|  %-9s| %n","ID","ÜRÜN ADI","FİYAT","MARKA","DEPOLAMA","EKRAN","PİL","RAM","RENK");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i = 0 ; i < phone.size() ;i++){
            String productName = phone.get(i).getBrandName()+" "+phone.get(i).getProductName();
            String brandName = phone.get(i).getBrandName();
            int price = phone.get(i).getPrice();
            String memoryInfo = phone.get(i).getMemoryInfo();
            String screenSize = phone.get(i).getScreenSize();
            String batteryPower = phone.get(i).getBatteryPower();
            String ram = phone.get(i).getRam();
            String color = phone.get(i).getColor();

            System.out.printf("| %-3d|  %-29s|  %-9d|  %-9s|  %-9s|  %-9s|  %-9s|  %-9s|  %-9s|  %n",i+1,productName,price,brandName,memoryInfo,screenSize,batteryPower,ram,color);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

    }

    public static void sortingBrand(ArrayList<Brand> pro){
        Set<Brand> brand = new TreeSet<>(new Comparator<Brand>() {
            @Override
            public int compare(Brand o1, Brand o2) {
                return o1.getBrandName().compareTo(o2.getBrandName());
            }
        });

        brand.addAll(pro);

        System.out.println("---- Markalar --------------------");
        int count=1;
        for(Brand i : brand){
            System.out.println(count+". "+i.getBrandName());
            count++;
        }
        System.out.println();
    }
}