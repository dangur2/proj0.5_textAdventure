
public class GameEngine {

    private GameState currentState = GameState.MAIN_MENU;
    private final Player player;
    private boolean running = true;

    public GameEngine(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void set_current_state(GameState currState) {
        this.currentState = currState;
    }

    public GameState get_current_state() {
        return currentState;
    }

    public void stop(){
        running = false;
    }

    public void update() {
        while (running) {
            switch (currentState) {
                case MAIN_MENU -> {
                    MainMenu me = new MainMenu(this);
                    me.ui();
                }
                case EXPLORING -> {
                    Exploring ex = new Exploring(this, player);
                    ex.adventuring();
                }
                case GAME_OVER -> {
                    GameOver go = new GameOver();
                    go.death();
                    stop();
                }
            }
        }
    }

}
