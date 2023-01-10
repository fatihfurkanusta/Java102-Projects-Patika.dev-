public class Inventory {
    private Weapons weapon;
    private Armor armor;

    public Inventory() {
        this.weapon = new Weapons(-1,"Punch",0,0);
        this.armor = new Armor(-1,"Nothing", 0,0);

    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armors) {
        if(getArmor().getId()<armors.getId()){
            this.armor = armors;
        }
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapons weapons) {
        if(getWeapon().getId()<weapons.getId()){
            this.weapon = weapons;
        }
    }
}
