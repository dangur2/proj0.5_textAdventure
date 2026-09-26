public class Trap implements RoomInteractable{

    private final int dmg;

    public Trap(int dmg){
        this.dmg = dmg;
    }

    public int getDmg(){
        return dmg;
    }

    @Override
    public boolean trigger(Player player, GameEngine ge) {
        player.take_damage(getDmg());
        System.out.println("This room contains a spike trap, it hits you for "+getDmg()+" damage, you now have "+player.get_health()+" health left!");
        return false;
    }
    
}
