import java.util.Random;
import java.util.Scanner;

public class Fighting implements Runnable{
    Hero hero;
    Skeleton skeleton;
    Goblin goblin;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    public Fighting(Hero hero, Skeleton skeleton, Goblin goblin) {
        this.hero = hero;
        this.skeleton = skeleton;
        this.goblin = goblin;
    }

    @Override
    public void run() {
        if (random.nextInt(1) == 1) {

        }
    }
}
