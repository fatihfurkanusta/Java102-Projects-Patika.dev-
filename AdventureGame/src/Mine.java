import java.util.Random;

public class Mine extends BattleLocations{
    public Mine(Player player) {
        super(player, "Mine", Enemy.getEnemyObjByID(3),"Random");
    }



    @Override
    void onLocation(){
        int enemyNumber = randomEnemyNumber();
        System.out.println("You are coming to "+getName());
        selectEnemy = 3;
        System.out.println("\n** You came to a very very old mine.");
        System.out.println("\n** There are "+enemyNumber+" snakes in here.** ");
        System.out.println("\tPress 1 to attack.\n\tPress 2 to get out the forest.");
        System.out.print("Your choice : ");
        int selected = input.nextInt();
        if (selected==1){
            attackEnemies(enemyNumber);
            addRandomAward();

        }

    }

    public void addRandomAward() {
        Random r = new Random();
        double numb = r.nextDouble(100);
        System.out.println(numb);

        if (numb >= 0 && numb <= 12.5) {
            getPlayer().setMoney(getPlayer().getMoney()+1);
            System.out.println("You earn the 1 $");

        } else if (numb > 12.5 && numb <= 20) {
            getPlayer().setMoney(getPlayer().getMoney()+5);
            System.out.println("You earn the 1 $");

        } else if (numb > 20 && numb <= 25) {
            getPlayer().setMoney(getPlayer().getMoney()+10);
            System.out.println("You earn the 10 $");

        } else if (numb > 25 && numb <= 32.5) {
            Weapons selectedWeapon = Weapons.getWeaponObjByID(1);
            this.getPlayer().getInventory().setWeapon(selectedWeapon);
            System.out.println("You earn the revolver.");

        } else if (numb > 32.5 && numb <= 37) {
            Weapons selectedWeapon = Weapons.getWeaponObjByID(2);
            this.getPlayer().getInventory().setWeapon(selectedWeapon);
            System.out.println("You earn the sword.");

        } else if (numb > 37 && numb <= 40) {
            Weapons selectedWeapon = Weapons.getWeaponObjByID(3);
            this.getPlayer().getInventory().setWeapon(selectedWeapon);
            System.out.println("You earn the rifle.");

        } else if (numb > 40 && numb <= 47.5) {
            Armor selectedArmor = Armor.getArmorObjByID(1);
            this.getPlayer().getInventory().setArmor(selectedArmor);
            System.out.println("You earn the light armor.");

        } else if (numb > 47.5 && numb <= 52) {
            Armor selectedArmor = Armor.getArmorObjByID(2);
            this.getPlayer().getInventory().setArmor(selectedArmor);
            System.out.println("You earn the medium armor.");

        } else if (numb > 52 && numb <= 55) {
            Armor selectedArmor = Armor.getArmorObjByID(3);
            this.getPlayer().getInventory().setArmor(selectedArmor);
            System.out.println("You earn the heavy armor.");
        } else {
            System.out.println("You earn nothing.");
        }
    }
}
