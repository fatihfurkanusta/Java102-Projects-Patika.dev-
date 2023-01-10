public class Armor {
    private int id;
    private int defence;
    private int cost;
    private String armorName;

    public Armor(int id, String armorName, int defence, int cost) {
        this.id = id;
        this.defence = defence;
        this.cost = cost;
        this.armorName = armorName;
    }

    public static Armor[] armor(){
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor(1,"Light Armor",1,15);
        armorList[1] = new Armor(2,"Medium Armor",3,25);
        armorList[2] = new Armor(3,"Heavy Armor",5,40);
        return armorList;
    }
    public static Armor getArmorObjByID(int id){
        for(Armor a: Armor.armor()){
            if(a.getId()==id){
                return a;
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

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }
}
