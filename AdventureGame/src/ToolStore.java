import java.nio.file.Watchable;

public class ToolStore extends NormalLocation {
    Weapons weapons;

    ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    void onLocation() {
        System.out.println("\t\t----------------- Welcome to Tool Store -----------------");

        menu();
    }

    void menu() {
        boolean menu = true;
        while(menu){
            System.out.println("= Menu =");
            System.out.println("\t\tPress 1 for Weapons.");
            System.out.println("\t\tPress 2 for Armors.");
            System.out.println("\t\tPress 0 for Exit.");
            System.out.print("Your choice : ");
            int selected = input.nextInt();
            while (selected < 0 || selected > 3) {
                System.out.println("Your input is invalid. Try again.");
                selected = input.nextInt();
            }
            switch (selected) {
                case 1 -> {
                    printWeapons();
                    buyWeapon();
                }
                case 2 -> {
                    printArmors();
                    buyArmor();
                }
                default -> {
                    System.out.println("You didn't buy anything.");
                    menu=false;
                }
            }
        }
    }

    public void buyWeapon() {
        System.out.print("Your choice : ");
        int selected = input.nextInt();
        while (selected < 0 || selected > Weapons.weapons().length) {
            System.out.println("Your input is invalid. Try again.");
            selected = input.nextInt();
        }
        if(selected!=0){
            Weapons selectedWeapon = Weapons.getWeaponObjByID(selected);

            if (selectedWeapon!=null){
                if (selectedWeapon.getCost() > this.getPlayer().getMoney()){
                    System.out.println("Your money is not enough to buy this.");
                }
                else {
                    System.out.println("You buy a "+selectedWeapon.getName());
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getCost();
                    this.getPlayer().setMoney(balance);
                    System.out.println("You have "+this.getPlayer().getMoney()+" $");

                    this.getPlayer().getInventory().setWeapon(selectedWeapon);

                }
            }
        }
    }

    public void printWeapons() {
        System.out.println("Weapons :");
        for (Weapons w : Weapons.weapons()) {
            System.out.println("\t Press " + w.getId() + " for buy the  " + w.getName() + " : \t" +
                    "Damage : " + w.getDamage() +
                    "\tCost : " + w.getCost() + " $");
        }
        System.out.println("Press 0 for Exit.");
    }

    public void printArmors(){
        System.out.println("    Armors :");
        for (Armor a : Armor.armor()) {
            System.out.println("\t Press " + a.getId() + " for buy the  " + a.getArmorName() + " : \t" +
                    "Damage : " + a.getDefence() +
                    "\tCost : " + a.getCost() + " $");
        }
        System.out.println("Press 0 for Exit.");
    }
    public void buyArmor() {
        System.out.print("Your choice : ");
        int selected = input.nextInt();
        while (selected < 0 || selected > Armor.armor().length) {
            System.out.println("Your input is invalid. Try again.");
            selected = input.nextInt();
        }
        if(selected!=0){
            Armor selectedArmor = Armor.getArmorObjByID(selected);

            if (selectedArmor!=null){
                if (selectedArmor.getCost() > this.getPlayer().getMoney()){
                    System.out.println("Your money is not enough to buy this.");
                }
                else {
                    System.out.println("You buy a "+selectedArmor.getArmorName());
                    int balance = this.getPlayer().getMoney() - selectedArmor.getCost();
                    this.getPlayer().setMoney(balance);
                    System.out.println("You have "+this.getPlayer().getMoney()+" $");

                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }


    }

}
