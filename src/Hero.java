import java.util.HashMap;
import java.util.Map;

public class Hero extends Creature implements Fighter {
    Backpack backpack;
    Merchant.HealthPotion healthPotion;
    Merchant.ScrollOfPower scrollOfPower;
    private int healthCap = 200;
    private int level = 1;
    private int levelCap = 20;

    public Hero(String name) {
        super(name, 0, 100);
        setHealth(healthCap);
        this.backpack = new Backpack();
        this.healthPotion = new Merchant.HealthPotion();
        this.scrollOfPower = new Merchant.ScrollOfPower();
    }

    public int getHealthCap() {
        return healthCap;
    }

    public void setHealthCap(int healthCap) {
        this.healthCap = healthCap;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevelCap() {
        return levelCap;
    }

    public void setLevelCap(int levelCap) {
        this.levelCap = levelCap;
    }

    public void showItems() {
        if (backpack.listItems.isEmpty()) {
            System.out.println("{Empty}");
        } else {
            System.out.println(backpack.listItems);
            System.out.println();
        }
    }

    static class Backpack {
        Map<String, Integer> listItems = new HashMap<>();

        public void addItem(Stuff item) {
            if (listItems.containsKey(item.getDescription())) {
                listItems.put(item.getDescription(), listItems.get(item.getDescription()) + 1);
            } else {
                listItems.put(item.getDescription(), item.getQuantity());
            }
        }
    }
}
