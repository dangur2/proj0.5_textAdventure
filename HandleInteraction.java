
import java.util.ArrayList;
import java.util.List;

public class HandleInteraction {
    private final Player player;
    private final GameEngine ge;

    public HandleInteraction(Player player, GameEngine ge){
        this.player = player;
        this.ge = ge;
    }

    public void handle(){
        List<RoomInteractable> removeList = new ArrayList<>();
        for(RoomInteractable rm : player.get_room().getInteractable()){
            if(rm.trigger(player, ge)){
                removeList.add(rm);
            }
        }
        player.get_room().removeInteractables(removeList);
    }
}
