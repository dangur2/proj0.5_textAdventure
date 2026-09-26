import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Room {

    private final String description;
    private final HashMap<String, Room> roomExit;
    private final List<RoomInteractable> interaction;
    private boolean locked;

    public Room(String description, boolean locked){
        this.description = description;
        this.locked = locked;
        this.roomExit = new HashMap<>();
        this.interaction = new ArrayList<>();
    }
    public boolean isLocked(){
        return locked;
    }
    public void unlock(){
        locked = false;
    }
    public void addInteractable(RoomInteractable ri){
        this.interaction.add(ri);
    }
    public void removeInteractables(List<RoomInteractable> list){
        interaction.removeAll(list);
    }
    public List<RoomInteractable> getInteractable(){
        return List.copyOf(interaction);
    }
    public Enemy getEnemy(){
        for(RoomInteractable ri : interaction){
            if(ri instanceof Enemy e){
                return e;
            }
        }
        return null;
    }
    public boolean hasInteraction(){
        return !interaction.isEmpty();
    }

    public void setExit(String direction, Room room){
        roomExit.put(direction, room);
    }
    public Room getExitInTheDirection(String direction){
        return roomExit.get(direction);
    }
    public String getRoomDesc(){
        return description;
    }
    
}
