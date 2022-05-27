import java.util.Random;

public class Fighting implements Runnable {
    Hero hero;
    String location;

    public Fighting(Hero hero, String location) {
        this.hero = hero;
        this.location = location;
    }

    @Override
    public void run() {
        while (true) {
            Entity enemy;
            Random random = new Random();
            if (location.equals("forest")) {
                if (random.nextInt(2) == 1) {
                    enemy = new Skeleton();
                } else {
                    enemy = new Goblin();
                }
            } else {
                enemy = new Dragon();
            }
            System.out.println("Перед вами " + enemy.name + ". Бой начинается!");
            boolean isAlive = true;
            int count = 1;
            while (isAlive) {
                System.out.printf("-------[Ход %d]-------\n", count);
                System.out.print("""
                        Ваш ход:
                        1. Атаковать
                        2. Выпить Зелье здоровья
                        3. Прочитать Свиток силы
                        """);
                switch (Main.userInput()) {
                    case 1 -> hero.attack(enemy);
                    case 2 -> hero.healthPotion.use(hero);
                    case 3 -> hero.scrollOfPower.use(hero);
                    default -> System.out.println("Выберите варианты 1, 2, 3");
                }
                ((Fightable) enemy).attack(hero);
                if (enemy.health > 0 && hero.health > 0) {
                    System.out.println("*******Результат хода*******");
                    System.out.printf("Здоровье %s %d единиц.\n", enemy.name, enemy.health);
                    System.out.printf("Здоровье %s %d единиц.\n", hero.name, hero.health);
                    System.out.println("****************************");

                    count++;
                } else if (enemy.health <= 0) {
                    System.out.println("*******Результат хода*******");
                    System.out.printf("%s побеждает\n", hero.name);
                    System.out.printf("Получено %d золота и %d опыта\n", enemy.gold, enemy.experience);
                    System.out.println("****************************");
                    hero.gold += enemy.gold;
                    hero.experience += enemy.experience;
                    isAlive = false;
                } else {
                    System.out.println("*******Результат хода*******");
                    System.out.printf("%s погибает\n", hero.name);
                    System.out.println("****************************");
                    isAlive = false;
                }
            }
            if (hero.health > 0) {
                if (hero.experience >= hero.levelCap) {
                    hero.level++;
                    hero.healthCap += 5;
                    hero.health = hero.healthCap;
                    hero.levelCap *= 2;
                    hero.strength += 5;
                    hero.agility += 5;
                    System.out.printf("%s достиг уровня %d!\n", hero.name, hero.level);
                    System.out.println("****************************");
                }
                System.out.print("Куда дальше?\n1. Вернуться в город\n2. Продолжить бой\n");
                if (location.equals("forest")) {
                    System.out.println("3. Отправиться в пещеру с драконами");
                } else {
                    System.out.println("3. Отправиться в темный лес");
                }
                int command = Main.userInput();
                switch (command) {
                    case 1 -> {
                        return;
                    }
                    case 2 -> {
                        if (location.equals("cave")) {
                            location = "forest";
                        }
                    }
                    case 3 -> {
                        if (location.equals("forest")) {
                            location = "cave";
                        }
                    }
                }
            } else {
                break;
            }
        }
    }
}

