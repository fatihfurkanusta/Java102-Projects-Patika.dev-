public class River extends BattleLocations{
    public River(Player player) {
        super(player, "River", Enemy.getEnemyObjByID(2), "Water");
    }
}
