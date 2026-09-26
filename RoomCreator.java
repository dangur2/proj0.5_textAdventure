import java.util.ArrayList;

public class RoomCreator {
    ArrayList<Room> roomList = new ArrayList<>();
    public void createRooms(){
        Room roomA = new Room("You enter an empty and cold room", false);
        Room roomB = new Room("You enter the starter room", false);
        Room roomC = new Room("You enter a room filled with litter and scrap", false);
        Room roomD = new Room("You enter a small waterfilled room", false);
        Room roomE = new Room("You enter a fogged filled cavern", false);
        Room roomF = new Room("You enter a dimly lit room", true);
        Room roomG = new Room("You enter a oval, dark room filled with fauna", false);
        Room roomH = new Room("You enter a small corridor with no way forward", false);

        roomA.setExit("south", roomB);
        roomA.setExit("east", roomE);

        roomB.setExit("north", roomA);
        roomB.setExit("south", roomC);
        roomB.setExit("east", roomD);

        roomC.setExit("north", roomB);

        roomD.setExit("west", roomB);
        roomD.setExit("east", roomG);

        roomE.setExit("west", roomA);
        roomE.setExit("east", roomF);

        roomF.setExit("south", roomG);
        roomF.setExit("west", roomE);

        roomG.setExit("east", roomH);
        roomG.setExit("west", roomD);
        roomG.setExit("north", roomF);

        roomH.setExit("west", roomG);

        roomE.addInteractable(new Trap(10));
        roomD.addInteractable(new Enemy("guard dog", 30, 10));
        roomA.addInteractable(new Item("rock"));
        roomC.addInteractable(new Item("key"));

        roomList.add(roomA);
        roomList.add(roomB);
        roomList.add(roomC);
        roomList.add(roomD);
        roomList.add(roomE);
        roomList.add(roomF);
        roomList.add(roomG);
        roomList.add(roomH);
    }
    public Room getRoom(int roomNumber){
        return roomList.get(roomNumber);
    }
}
