import java.util.HashMap;
import java.util.Map;

public class Hero extends Entity implements Fightable {
    Backpack backpack;

    public Hero(String name) {
        super(name);
        this.backpack = new Backpack();
    }

    @Override
    public void attack() {

    }

    public void showItems() {
        System.out.println(backpack.listItems);
    }

    static class Backpack {
        Map<String, Integer> listItems = new HashMap<>();

        public void addItem(Stuff item) {
            if (listItems.containsKey(item.description)) {
                listItems.put(item.description, listItems.get(item.description) + 1);
            } else {
                listItems.put(item.description, item.quantity);
            }
        }
    }

    static class HealthPotion extends Stuff {
        public HealthPotion() {
            super("HealthPotion");
            quantity++;
        }

        @Override
        void use() {
            quantity--;
        }
    }

    static class ScrollOfPower extends Stuff {

        public ScrollOfPower() {
            super("ScrollOfPower");
            quantity++;
        }

        @Override
        void use() {

            quantity--;
        }
    }
}
