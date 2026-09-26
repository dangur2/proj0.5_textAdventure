
import java.util.Map;
import java.util.Scanner;

public class Exploring {

    private final GameEngine ge;
    private final Player player;
    private final HandleInteraction hi;

    public Exploring(GameEngine ge, Player player) {
        this.ge = ge;
        this.player = player;
        hi = new HandleInteraction(player, ge);
    }

    public void adventuring() {
        boolean adventuring = true;
        Map<String, String> menu_choice = Map.of("w", "north", "d", "east", "s", "south", "a", "west");
        Scanner ans = new Scanner(System.in);

        while (adventuring) {
            if (player.get_room().hasInteraction()) {
                hi.handle();
            }
            System.out.println("\nTo continue, please select one of the options below");
            System.out.println("W) North D) East S) South A) West Q) View inventory E) Retreat");

            String player_answer = ans.nextLine().toLowerCase();
            if (menu_choice.containsKey(player_answer)) {
                player.moveRoom(menu_choice.get(player_answer));
            } else if (player_answer.equals("q")) {
                player.getInventory().viewInventory();
            } else if (player_answer.equals("e")) {
                System.out.println("You retreat to the menu");
                ge.set_current_state(GameState.MAIN_MENU);
                adventuring = false;
            }
        }
    }
}
