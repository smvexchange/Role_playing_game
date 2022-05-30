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
            Creature enemy;
            if (location.equals("forest")) {
                if ((int) (Math.random() * 3) == 1) {
                    enemy = new Skeleton();
                } else {
                    enemy = new Goblin();
                }
            } else {
                enemy = new Dragon();
            }
            System.out.println("Перед вами " + enemy.getName() + ". Бой начинается!");
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
                ((Fighter) enemy).attack(hero);
                if (enemy.getHealth() > 0 && hero.getHealth() > 0) {
                    System.out.println("*******Результат хода*******");
                    System.out.printf("Здоровье %s %d единиц. Сила %d единиц. Ловкость %d единиц.\n",
                            enemy.getName(), enemy.getHealth(), enemy.getStrength(), enemy.getAgility());
                    System.out.printf("Здоровье %s %d единиц. Сила %d единиц. Ловкость %d единиц.\n",
                            hero.getName(), hero.getHealth(), hero.getStrength(), hero.getAgility());
                    System.out.println("****************************");
                    count++;
                    if (hero.isBuff() && hero.getBuffDuration() > 1) {
                        hero.setBuffDuration(hero.getBuffDuration() - 1);
                    } else if (hero.isBuff() && hero.getBuffDuration() == 1) {
                        hero.setBuff(false);
                        hero.setBuffDuration(hero.getBuffDuration() - 1);
                        hero.setStrength(hero.getStrength() - hero.scrollOfPower.getIncrement());
                    }
                } else if (enemy.getHealth() <= 0 && hero.getHealth() > 0) {
                    System.out.println("*******Результат хода*******");
                    System.out.printf("%s побеждает.\n", hero.getName());
                    System.out.printf("Получено %d золота и %d опыта.\n", enemy.getGold(), enemy.getExperience());
                    System.out.println("****************************");
                    hero.setGold(hero.getGold() + enemy.getGold());
                    hero.setExperience(hero.getExperience() + enemy.getExperience());
                    isAlive = false;
                } else {
                    System.out.println("*******Результат хода*******");
                    System.out.printf("%s погибает.\n", hero.getName());
                    System.out.println("****************************");
                    isAlive = false;
                }
            }
            if (hero.getHealth() > 0) {
                if (hero.getExperience() >= hero.getLevelCap()) {
                    int increment = 3;
                    hero.setLevel(hero.getLevel() + 1);
                    hero.setHealthCap(hero.getHealthCap() + increment);
                    hero.setHealth(hero.getHealthCap());
                    hero.setLevelCap(hero.getLevelCap() * 2);
                    hero.setStrength(hero.getStrength() + increment);
                    hero.setAgility(hero.getAgility() + increment);
                    System.out.printf("%s достиг уровня %d! Сила, ловкость и здоровье увеличены на %d единиц.\n",
                            hero.getName(), hero.getLevel(), increment);
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

