public class Enemy {
    private int id;
    private String enemyName;
    private int damage;
    private int health;
    private int money;
    private int orjHealth;

    public Enemy(int id, String enemyName, int damage, int health, int money) {
        this.id = id;
        this.enemyName = enemyName;
        this.damage = damage;
        this.health = health;
        this.orjHealth = health;
        this.money = money;
    }

    public static Enemy[] enemies(){
        Enemy[] enemies= new Enemy[4];
        enemies[0] = new Enemy(1,"Zombie",3,10,4);
        enemies[1] = new Enemy(2,"Vampire",4,14,7);
        enemies[2] = new Enemy(3,"Ayı",7,20,12);
        enemies[3] = new Enemy(4,"Snake",5,12,0);
        return enemies;
    }
    public static Enemy getEnemyObjByID(int id){
        for(Enemy e: Enemy.enemies()){
            if(e.getId()==id){
                return e;
            }
        }
        return null;
    }

    public int getOrjHealth() {
        return orjHealth;
    }

    public void setOrjHealth(int orjHealth) {
        this.orjHealth = orjHealth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public int getDamage() {
        if(damage<0){
            return 0;
        }
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return Math.max(this.health, 0);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
