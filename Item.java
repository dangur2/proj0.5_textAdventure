public class Item implements RoomInteractable{
    private final String name;

    public Item(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean trigger(Player player, GameEngine ge) {
        System.out.println("In the room you find a "+name+" and put it in your inventory!");
        player.getInventory().addItem(this);
        return true;
    }
}
