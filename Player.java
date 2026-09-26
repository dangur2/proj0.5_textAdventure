import java.util.ArrayList;

public class Player {

   Room currentRoom;
   private int health;
   private final int dmg;
   private final Inventory inventory;
   private Room lastRoom;

   public Player(Room currentRoom, int health, int dmg) {
      this.currentRoom = currentRoom;
      this.health = health;
      this.dmg = dmg;
      inventory = new Inventory(new ArrayList<>());
   }
   public void move_back(){
      this.currentRoom = lastRoom;
      System.out.println("You retrace your steps to your previous room.");
   }

   public Inventory getInventory(){
      return inventory;
   }

   public void take_damage(int health) {
      this.health -= health;
   }
   public void set_room(Room room) {
      this.currentRoom = room;
   }

   public int get_health() {
      return health;
   }

   public int get_dmg() {
      return dmg;
   }

   public void moveRoom(String direction) {
      Room nextRoom = currentRoom.getExitInTheDirection(direction);

      if(nextRoom == null){
         return; 
      }
      if(nextRoom.isLocked()){
         if(inventory.containsItem("key")){
            nextRoom.unlock();
            System.out.println("You unlock the door with the key you found.");
         } else {
            System.out.println("You dont have the key to enter this room.");
            return;
         }
      }
      this.lastRoom = currentRoom;
      this.currentRoom = nextRoom;
      System.out.println("You walk " + direction+", "+currentRoom.getRoomDesc());

   }
   public Room get_room() {
      return currentRoom;
   }

   public String get_room_desc() {
      return currentRoom.getRoomDesc();
   }
}
