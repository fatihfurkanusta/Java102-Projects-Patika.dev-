public class SafeHouse extends NormalLocation{


    SafeHouse(Player player){
        super(player,"House");
    }
    @Override
    void onLocation(){
        System.out.println("\t\t----------- Welcome to Safe House -----------");
        if(getPlayer().isWater() && getPlayer().isWood() && getPlayer().isFood()){
            getPlayer().setWin(true);
        }else{
            getPlayer().setHealthy(getPlayer().getOrjHealth());
            System.out.println("Your health is renewed. -> Health : "+getPlayer().getHealthy());
        }
    }
}
