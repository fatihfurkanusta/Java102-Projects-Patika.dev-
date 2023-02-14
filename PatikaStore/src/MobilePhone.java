
import java.util.ArrayList;
import java.util.List;
public class MobilePhone extends Brand{
    private int price;
    private int discountRate;
    private int stockAmount;
    private String memoryInfo;
    private String screenSize;
    private String batteryPower;
    private String ram;
    private String color;

    public MobilePhone(String kind, int id, String brandName, String productName, int price, int discountRate, int stockAmount, String memoryInfo, String screenSize, String batteryPower, String ram, String color) {
        super(kind, id, brandName, productName);
        this.price = price;
        this.discountRate = discountRate;
        this.stockAmount = stockAmount;
        this.memoryInfo = memoryInfo;
        this.screenSize = screenSize;
        this.batteryPower = batteryPower;
        this.ram = ram;
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
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

    public String getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(String batteryPower) {
        this.batteryPower = batteryPower;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
