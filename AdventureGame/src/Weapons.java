public class Weapons {
    private int id;
    private String name;
    private int damage;
    private int cost;

    public Weapons(int id, String name, int damage, int cost){
        this.id=id;
        this.name=name;
        this.damage=damage;
        this.cost=cost;
    }

    public static Weapons[] weapons(){
        Weapons[] weaponList = new Weapons[3];
        weaponList[0] = new Weapons(1,"Revolver",2,5);
        weaponList[1] = new Weapons(2,"Sword",3,35);
        weaponList[2] = new Weapons(3,"Rifle",7,45);
        return weaponList;
    }

    public static Weapons getWeaponObjByID(int id){
        for(Weapons w: Weapons.weapons()){
            if(w.getId()==id){
                return w;
            }
        }
        return null;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
