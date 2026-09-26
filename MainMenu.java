import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private final GameEngine ge;
    public MainMenu(GameEngine ge){
        this.ge = ge;
    }

    
    public void ui(){
        boolean mainMenu = true;
        Scanner ans = new Scanner(System.in);
        GameMap gm = new GameMap();
        List<String> menu_choices = List.of("a","b","c");

        System.out.println("Welcome to my Adventure game, try to explore all the rooms!");
        while(mainMenu){
            System.out.println("\nTo continue, please select one of the options below");
            System.out.println("A) Explore B) View map C) Exit");
            String player_choice = ans.nextLine().toLowerCase();
            if(menu_choices.contains(player_choice)){
                switch(player_choice){
                    case "a" -> {
                        System.out.println("\nYou set out to explore!");
                        ge.set_current_state(GameState.EXPLORING);
                        mainMenu = false;
                    }
                    case "b" -> {
                        System.out.println("The map looks as following.");
                        gm.print_map();
                    }
                    case "c" -> ge.stop();
                }
            }
        }
    }
}
