import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    int exit=0;



    public void start(){
        Scanner input = new Scanner(System.in);

        System.out.println("\n*************** Welcome to Adventure Game ***************");
        System.out.print("Enter the player name : ");
        String playerName = input.nextLine();

        Player player = new Player(playerName);
        System.out.println(player.getName()+ ". Are you ready to this adventure?");
        System.out.println("Collect all of elements and win the game.");
        player.selectChar();

        while(true){
            location = null;
            player.printInfo();
            System.out.println("\nSelect a region : ");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("\t\tPress 1 for Safe House. ---> Your health will renewed in Safe House. If you have 3 elements (Food, Wood, Water), came to house and win the game.");
            System.out.println("\t\tPress 2 for Tool Store. ---> You can buy weapon or armor in Tool Store. ");
            System.out.println("\t\tPress 3 for Cave. ---> You can battle to zombies and if you win, you earn $ and food. ");
            System.out.println("\t\tPress 4 for Forest. ---> You can battle to vampires and if you win, you earn $ and wood. ");
            System.out.println("\t\tPress 5 for River. ---> You can battle to bears and if you win, you earn $ and water. ");
            System.out.println("\t\tPress 6 for Mine. ---> You can battle to snakes and if you win, you earn random element or money. ");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("\t\tPress 0 for Exit.");
            System.out.print("Your choice : ");
            int selectedChar = input.nextInt();

            switch (selectedChar) {
                case 0 -> exit = 1;
                case 1 -> location = new SafeHouse(player);
                case 2 -> location = new ToolStore(player);
                case 3 -> {
                    if (!player.isFood()) {
                        location = new Cave(player);
                        break;
                    }
                    System.out.println("\nNo more enemies in here.");
                }
                case 4 -> {
                    if (!player.isWood()) {
                        location = new Forest(player);
                    } else {
                        System.out.println("\nNo more enemies in here.");
                    }
                }
                case 5 -> {
                    if (!player.isWater()) {
                        location = new River(player);

                    } else {
                        System.out.println("\nNo more enemies in here.");
                    }
                }
                case 6 -> location = new Mine(player);
                default -> System.out.print("Your input is invalid.");
            }
            if(exit==1){
                System.out.println("Game is closed.");
                break;
            }
            if(location!=null){

                location.onLocation();

                if(player.isWin()){
                    System.out.println("\t\t\tCongrats!! You win the Game ............");
                    break;
                }

                if(location.isDead()) {
                    System.out.println("GAME OVER!!");
                    break;
                }


            }
        }
    }
}
