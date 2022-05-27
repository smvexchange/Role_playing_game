import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Hero extends Entity implements Fightable {
    Backpack backpack;
    HealthPotion healthPotion;
    ScrollOfPower scrollOfPower;
    int healthCap = 100;
    int level = 1;
    int levelCap = 10;

    public Hero(String name) {
        super(name);
        this.backpack = new Backpack();
        this.healthPotion = new HealthPotion();
        this.scrollOfPower = new ScrollOfPower();
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
            System.out.println("{Empty}");
        } else {
            System.out.println(backpack.listItems);
            System.out.println();
        }
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
        }

        public HealthPotion(int quantity) {
            super("Зелье здоровья");
            this.quantity = quantity;
        }

        @Override
        void use(Hero hero) {
            if (hero.healthPotion.quantity > 0) {
                hero.health += 20;
                quantity--;
                System.out.printf("%s лечится на 20 единиц.\n", hero.name);
            } else {
                System.out.println("Зелья кончились!");
            }
        }
    }

    static class ScrollOfPower extends Stuff {

        public ScrollOfPower() {
            super("Свиток силы");
        }

        public ScrollOfPower(int quantity) {
            super("Свиток силы");
            this.quantity = quantity;
        }

        @Override
        void use(Hero hero) {
            if (hero.scrollOfPower.quantity > 0) {
                hero.strength += 20;
                quantity--;
                System.out.printf("%s увеличивает силу на 20 единиц.\n", hero.name);
            } else {
                System.out.println("Свитки кончились!");
            }
        }
    }
}
