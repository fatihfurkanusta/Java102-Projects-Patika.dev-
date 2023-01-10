import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public abstract class BattleLocations extends Location{
    private Enemy enemy;
    private String award;
    private int maxEnemyOfGroup = 3;
    private int randomEnemy;
    private String randomAward;
    int selectEnemy;

    public BattleLocations(Player player, String name,Enemy enemy,String award) {
        super(player, name);
        this.enemy=enemy;
        this.award=award;
    }

    @Override
    void onLocation() {
        int enemyNumber = randomEnemyNumber();
        System.out.println("You are coming to "+getName());
        if(Objects.equals(getName(), "Forest")){
            selectEnemy = 1;
            System.out.println("\n** You came to a dark and foggy forest.**");
            System.out.println("** You see a group of vampires nearby. ** ");
            System.out.println("** There are "+enemyNumber+" vampires in here.** ");
        }
        else if(Objects.equals(getName(), "Cave")){
            selectEnemy = 0;
            System.out.println("\n** You came to a dark and smelly cave.**");
            System.out.println("** Bear growls is echo in the cave. ** ");
            System.out.println("** There are "+enemyNumber+" zombies in here.** ");
        }else if(Objects.equals(getName(),"River")){
            selectEnemy = 2;
            System.out.println("\n** You came to a noisy and flowing river.");
            System.out.println("\n** There are "+enemyNumber+" bears in here.** ");
        }else if(Objects.equals(getName(),"Mine")){
            selectEnemy = 3;
            System.out.println("\n** You came to a very very old mine.");
            System.out.println("\n** There are "+enemyNumber+" snakes in here.** ");
        }

        System.out.println("\tPress 1 to attack.\n\tPress 2 to get out the forest.");
        System.out.print("Your choice : ");
        int selected = input.nextInt();
        if (selected==1){
            attackEnemies(enemyNumber);

        }

    }
    public void attackEnemies(int enemyNumber){
        Enemy enemy = Enemy.enemies()[selectEnemy];

        for(int i = 0 ; i < enemyNumber ; i++){
            enemy.setHealth(enemy.getOrjHealth());

            playerStats();
            enemyStats(enemy);

            while(getPlayer().getHealthy()>0 && enemy.getHealth()>0) {
                System.out.println("<A>ttack or <R>un : ");
                String select = input.next().toUpperCase();
                if(select.equals("A")){
                    if(firstHit()){
                        enemy.setHealth(enemy.getHealth()-getPlayer().getDamage());
                        System.out.println("\nYou hit "+getPlayer().getDamage()+" damage to the enemy. Enemy health is "+enemy.getHealth());
                        if(enemy.getHealth()>0){
                            int incomingDamage = getPlayer().getDefence() - enemy.getDamage();
                            if(incomingDamage < 0 ){
                                incomingDamage*=-1;
                            }
                            getPlayer().setHealthy(getPlayer().getHealthy()-incomingDamage);
                            System.out.println("Enemy hit "+incomingDamage+" damage to you. Your health is "+getPlayer().getHealthy());
                        }
                    }else{
                        int incomingDamage = getPlayer().getDefence() - enemy.getDamage();
                        if(incomingDamage < 0 ){
                            incomingDamage*=-1;
                        }
                        getPlayer().setHealthy(getPlayer().getHealthy()-incomingDamage);
                        System.out.println("\nEnemy hit "+ incomingDamage +" damage to you. Your health is "+getPlayer().getHealthy());
                        if(getPlayer().getHealthy()>0){
                            enemy.setHealth(enemy.getHealth()-getPlayer().getDamage());
                            System.out.println("You hit "+getPlayer().getDamage()+" damage to the enemy. Enemy health is "+enemy.getHealth());
                        }
                    }
                }else{
                    break;
                }
            }

            if(getPlayer().getHealthy()<=0){
                System.out.println("!!!!!!! You dead.!!!!!!!");
                setDead(true);
            }
        }
        if(enemy.getHealth()<=0){
            System.out.println("\n******* Congrats! You won the battle and "+enemy.getMoney()+" $ and element. *******");
            getPlayer().setMoney(getPlayer().getMoney()+enemy.getMoney());
            if(Objects.equals(getName(), "Forest")){
                getPlayer().setWood(true);
            }
            else if(Objects.equals(getName(), "Cave")){
                getPlayer().setFood(true);
            }else if(Objects.equals(getName(),"River")){
                getPlayer().setWater(true);
            }

        }
    }
    boolean firstHit(){
        double randomNumber = Math.random() * 100;
        return randomNumber<=50;
    }
    public void playerStats(){
        getPlayer().printInfo();
    }
    public void enemyStats(Enemy enemy){

        System.out.println("Enemy Info -->" +
                "\t Damage:"+enemy.getDamage()+
                "\t Health: "+enemy.getHealth()+
                "\t Award: "+enemy.getMoney());
    }

    public int randomEnemyNumber(){
        Random r = new Random();
        return r.nextInt(this.maxEnemyOfGroup)+1;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

}
