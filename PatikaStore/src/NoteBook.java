public class NoteBook extends Brand{
    private String productName;
    private int price;
    private String ram;
    private int stockAmount;
    private String memoryInfo;
    private String screenSize;

    public NoteBook(String kind, int id, String brandName, String productName, int price,String ram, int stockAmount, String memoryInfo, String screenSize) {
        super(kind, id, brandName, productName);
        this.price = price;
        this.ram = ram;
        this.stockAmount = stockAmount;
        this.memoryInfo = memoryInfo;
        this.screenSize = screenSize;
    }


    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public String getMemoryInfo() {
        return memoryInfo;
    }

    public void setMemoryInfo(String memoryInfo) {
        this.memoryInfo = memoryInfo;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }
}
