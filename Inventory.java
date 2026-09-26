
import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> inventory = new ArrayList<>();

    public Inventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public boolean containsItem(String item){
        for(Item x : inventory){
            if(x.getName().equals(item)){
                return true;
            }
        }
        return false;
    }
    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public void viewInventory() {
        if (!inventory.isEmpty()) {
            System.out.println("Your inventory contains the following:");
            int x = 0;
            for (Item item : inventory) {
                System.out.println(x+". "+item.getName());
                x++;

            }
        } else {
            System.out.println("Your inventory is currently empty!");
        }
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
}
