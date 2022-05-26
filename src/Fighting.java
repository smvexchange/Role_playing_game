import java.util.Random;
import java.util.Scanner;

public class Fighting implements Runnable {
    Hero hero;
    Skeleton skeleton;
    Goblin goblin;
    Dragon dragon;

    public Fighting(Hero hero, Skeleton skeleton, Goblin goblin) {
        this.hero = hero;
        this.skeleton = skeleton;
        this.goblin = goblin;
    }

    public Fighting(Hero hero, Dragon dragon) {
        this.hero = hero;
        this.dragon = dragon;
    }

    @Override
    public void run() {
        if (dragon == null) {
            Random random = new Random();
            if (random.nextInt(2) == 1) {
                System.out.println("Перед вами "+ skeleton.name + ". Бой начинается!");
                boolean isAlive = true;
                while (isAlive) {
                    System.out.println("""
                            Ваш ход:
                            1. Атаковать
                            2. Выпить Зелье здоровья
                            3. Прочитать Свиток силы
                            """);



                }
            }
        }
    }


}
