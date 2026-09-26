public class lockedDoor implements RoomInteractable{

    @Override
    public boolean trigger(Player player, GameEngine ge) {
        
        if(player.getInventory().containsItem("key")){
            System.out.println("You unlock the door");
            return true;
        }
        System.out.println("You dont have the correct key to unlock this door");
        player.move_back();
        return false;
    }

}