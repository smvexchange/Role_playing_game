import java.util.Random;

public class Skeleton extends Entity implements Fightable{
    public Skeleton(String name) {
        super(name);
    }

    public Skeleton() {
        super("Скелет");
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
