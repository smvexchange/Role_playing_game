public class Merchant implements Runnable {
    Hero hero;
    HealthPotion healthPotion;
    ScrollOfPower scrollOfPower;

    public Merchant(Hero hero) {
        this.hero = hero;
        this.healthPotion = hero.healthPotion;
        this.scrollOfPower = hero.scrollOfPower;
    }

    static class HealthPotion extends Stuff {
        public HealthPotion() {
            super("Зелье здоровья", 50);
        }

        public HealthPotion(int quantity) {
            super("Зелье здоровья", 50);
            this.setQuantity(quantity);
        }

        @Override
        void use(Hero hero) {
            if (hero.healthPotion.getQuantity() > 0) {
                if (hero.getHealth() + getIncrement() <= hero.getHealthCap()) {
                    hero.setHealth(hero.getHealth() + getIncrement());
                    setQuantity(getQuantity() - 1);
                    System.out.printf("%s лечится на %d единиц.\n", hero.getName(), getIncrement());
                } else {
                    System.out.printf("%s лечится на %d единиц.\n",
                            hero.getName(), hero.getHealthCap() - hero.getHealth());
                    hero.setHealth(hero.getHealthCap());
                    setQuantity(getQuantity() - 1);
                }
            } else {
                System.out.println("Зелья кончились!");
            }
        }
    }

    static class ScrollOfPower extends Stuff {

        public ScrollOfPower() {
            super("Свиток силы", 5);
        }

        public ScrollOfPower(int quantity) {
            super("Свиток силы", 5);
            this.setQuantity(quantity);
        }

        @Override
        void use(Hero hero) {
            if (hero.scrollOfPower.getQuantity() > 0) {
                hero.setStrength(hero.getStrength() + getIncrement());
                setQuantity(getQuantity() - 1);
                System.out.printf("%s увеличивает силу на %d единиц.\n", hero.getName(), getIncrement());
            } else {
                System.out.println("Свитки кончились!");
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            System.out.printf("""
                    Вы находитесь в торговой лавке.
                    Баланс: %d золота.
                    Что вы хотите?
                    1.Купить Зелье здоровья (20 золота)
                    2.Купить Свиток силы (35 золота)
                    3.Проверить сумку
                    4.Вернуться в город
                    """, hero.getGold());
            int command = Main.userInput();
            switch (command) {
                case 1 -> {
                    int healingPotionPrice = 20;
                    if (hero.getGold() - healingPotionPrice >= 0) {
                        healthPotion.setQuantity(healthPotion.getQuantity() + 1);
                        hero.backpack.addItem(new HealthPotion(1));
                        hero.setGold(hero.getGold() - healingPotionPrice);
                        System.out.println("Получено Зелье здоровья.\n");
                    } else {
                        System.out.println("У вас недостаточно золота!\n");
                    }
                }
                case 2 -> {
                    int scrollOfPowerPrice = 35;
                    if (hero.getGold() - scrollOfPowerPrice >= 0) {
                        scrollOfPower.setQuantity(scrollOfPower.getQuantity() + 1);
                        hero.backpack.addItem(new ScrollOfPower(1));
                        hero.setGold(hero.getGold() - scrollOfPowerPrice);
                        System.out.println("Получен Свиток силы.\n");
                    } else {
                        System.out.println("У вас недостаточно золота!");
                    }
                }
                case 3 -> hero.showItems();
                case 4 -> {
                    return;
                }
                default -> System.out.println("""
                        Неверный ввод данных!
                        Выберите варианты 1, 2, 3 или 4.
                        """);
            }
        }
    }
}
