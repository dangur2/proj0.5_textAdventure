


public class Main {

    public static void main(String[] args) {
        RoomCreator rc = new RoomCreator();
        rc.createRooms();
        Player player = new Player(rc.getRoom(1), 100, 10);
        GameEngine ge = new GameEngine(player);

        ge.update();
    }
}
