import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Hero extends Entity implements Fightable {
    Backpack backpack;

    public Hero(String name) {
        super(name);
        this.backpack = new Backpack();
    }

    @Override
    public void attack(Entity enemy) {
        Random random = new Random();
        if (agility * 3 > random.nextInt(100)) {
            if (random.nextInt(3) == 1) {
                enemy.health -= strength * 2;
                System.out.println(name + " наносит критический удар на " + (strength * 2) + " единиц.");
            } else {
                enemy.health -= strength;
                System.out.println(name + " наносит удар на " + strength + " единиц.");
            }
        } else {
            System.out.println(name + " промахивается.");
        }
    }

    public void showItems() {
        if (backpack.listItems.isEmpty()) {
            System.out.println("{ Empty }");
        }
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
        void use(Hero hero) {
            hero.health += 20;
            quantity--;
        }
    }

    static class ScrollOfPower extends Stuff {

        public ScrollOfPower() {
            super("ScrollOfPower");
            quantity++;
        }

        @Override
        void use(Hero hero) {
            hero.strength += 20;
            quantity--;
        }
    }
}
