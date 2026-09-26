import java.util.List;
import java.util.Scanner;

public class Battle {
    private final Player player;
    private final GameEngine ge;
    private final Enemy currentEnemy;

    public Battle(GameEngine ge, Player player, Enemy enemy){
        this.player = player;
        this.ge = ge;
        this.currentEnemy = enemy;
    }
    
    public void fight(){
        List<String> menuChoices = List.of("a","b");
        Scanner ans = new Scanner(System.in);
        boolean run = false;
        
        while(currentEnemy.getHealth() > 0 && run == false){
            System.out.println("\nInside the room you encounter a "+currentEnemy.getName()+"!");
            System.out.println("A) Attack B) run");
            String playerChoice = ans.nextLine().toLowerCase();
            if(menuChoices.contains(playerChoice)){
                switch(playerChoice){
                    case "a" -> {
                        playerAttack();
                    }
                    case "b" -> {
                        System.out.println("You hastily run from the monster!");
                        player.move_back();
                        ge.set_current_state(GameState.EXPLORING);
                        run = true;
                    }
                }
            }
        }
    }

    private void playerAttack() {
        int currentAttack = player.get_dmg();
        currentEnemy.take_damage(currentAttack);
        System.out.println("\nYou attack the " + currentEnemy.getName() + " and deal " + currentAttack + " damage! It now has " + currentEnemy.getHealth() + " health left!");
        if (currentEnemy.getHealth() > 0) {
            monster_attack();
        } else {
            monster_death();
        }
    }

    private void monster_death() {
        System.out.println("You defeated the "+currentEnemy.getName()+"!");
    }

    private void monster_attack() {
        int monsterAttack = currentEnemy.getDmg();
        player.take_damage(monsterAttack);
        System.out.println("\nThe "+currentEnemy.getName()+" attacks you and deals "+monsterAttack+" damage! You now have "+player.get_health()+" health left!");
        if (player.get_health() < 1) {
            ge.set_current_state(GameState.GAME_OVER);
        }
    }
}
