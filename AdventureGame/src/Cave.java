public class Cave extends BattleLocations{
    public Cave(Player player) {
        super(player, "Cave", Enemy.getEnemyObjByID(0), "food");
    }
}
