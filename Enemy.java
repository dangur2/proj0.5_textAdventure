public class Enemy implements RoomInteractable{
    private String name;
    private int health;
    private int dmg;
    
    public Enemy(String name, int health, int dmg){
        this.name = name;
        this.health = health;
        this.dmg = dmg;
    }

    public String getName() {
        return name;
    }

    public Enemy getCurrentEnemy(){
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void take_damage(int health) {
        this.health -= health;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    @Override
    public boolean trigger(Player player, GameEngine ge) {
        Battle battle = new Battle(ge, player, this);
        battle.fight();
        return this.getHealth() <= 0;
    }

}
