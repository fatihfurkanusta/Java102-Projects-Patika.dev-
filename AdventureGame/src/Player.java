import java.util.Scanner;

public class Player {
    private int damage;
    private int defence;
    private int healthy;
    private int money;
    private String charName;
    private String name;
    private int orjHealth;
    private boolean wood=false;
    private boolean water=false;
    private boolean food=false;
    private boolean win;

    private Inventory inventory;

    Scanner input = new Scanner(System.in);

    public Player(String name) {

        this.name = name;
        this.inventory = new Inventory();
    }

    public boolean isWood() {
        return wood;
    }

    public void setWood(boolean wood) {
        this.wood = wood;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public int getOrjHealth() {
        return orjHealth;
    }

    public void setOrjHealth(int orjHealth) {
        this.orjHealth = orjHealth;
    }

    public int getDefence() {
        return defence + this.inventory.getArmor().getDefence();
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getDamage() {
        return this.damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        if(healthy <0){
            this.healthy=0;
        }
        return this.healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    void selectChar(){
        Character[] charList = {new Samurai(),new Bowman(), new Knight()};
        int pressCount=1;

        System.out.println("\nChoice your character : ");
        System.out.println("------------------------------------------------------------------------");
        for(Character character : charList){
            System.out.println("Press "+pressCount+" for "+character.getName()+" : \t" +
                    "Damage : "+character.getDamage()+
                    "\t\tHealthy : "+character.getHealthy()+
                    "\t\tMoney : "+character.getMoney());
            pressCount++;
        }
        System.out.println("------------------------------------------------------------------------");
        System.out.print("Your choice : ");
        int selectedChar = input.nextInt();

        switch (selectedChar) {
            case 2 -> initPlayer(charList[1]);
            case 3 -> initPlayer(charList[2]);
            default -> initPlayer(charList[0]);
        }
        System.out.println(this.charName +" is a good choice.");
    }
    void initPlayer(Character character){

        this.setDamage(character.getDamage());
        this.setHealthy(character.getHealthy());
        this.setOrjHealth(character.getHealthy());
        this.setMoney(character.getMoney());
        this.setCharName(character.getName());

    }

    public void printInfo(){
        String a;
        String b;
        String c;

        if(isFood()){
            a = "X";
        }else{
            a = "-";
        }
        if(isWood()){
            b = "X";
        }else{
            b = "-";
        }
        if(isWater()){
            c = "X";
        }else{
            c = "-";
        }
        System.out.println("\nCharacter Info -->" +
                "\t Weapon: "+this.getInventory().getWeapon().getName()+
                "\t Armor: "+this.getInventory().getArmor().getArmorName()+
                "\t Damage:"+this.getDamage()+
                "\t Defence: "+this.getDefence()+
                "\t Health: "+this.getHealthy()+
                "\t Money: "+this.getMoney()+
                "\t Food: "+a+
                "\t Wood: "+b+
                "\t Water: "+c);
    }

}
