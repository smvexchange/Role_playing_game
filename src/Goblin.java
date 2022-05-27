import java.util.Random;

public class Goblin extends Entity implements Fightable{
    public Goblin(String name) {
        super(name);
    }

    public Goblin() {
        super("Гоблин");
        this.experience = 10;
        this.gold = 20;
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
}
