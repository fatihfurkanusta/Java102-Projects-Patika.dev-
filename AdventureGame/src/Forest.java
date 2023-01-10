import java.util.Scanner;

public class Forest extends BattleLocations{

    public Forest(Player player) {
        super(player, "Forest", Enemy.getEnemyObjByID(1), "Wood");
    }

}
