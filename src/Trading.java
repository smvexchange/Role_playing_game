public class Trading implements Runnable {
    private final int healingPotionPrice = 20;
    private final int scrollOfPowerPrice = 35;
    Hero hero;
    Hero.HealthPotion healthPotion;
    Hero.ScrollOfPower scrollOfPower;

    public Trading(Hero hero) {
        this.hero = hero;
        this.healthPotion = hero.healthPotion;
        this.scrollOfPower = hero.scrollOfPower;
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
                    """, hero.gold);
            int command = Main.userInput();
            switch (command) {
                case 1 -> {
                    if (hero.gold - healingPotionPrice >= 0) {
                        healthPotion.quantity++;
                        hero.backpack.addItem(new Hero.HealthPotion(1));
                        hero.gold -= healingPotionPrice;
                        System.out.println("Получено Зелье здоровья.\n");
                    } else {
                        System.out.println("У вас недостаточно золота!\n");
                    }
                }
                case 2 -> {
                    if (hero.gold - scrollOfPowerPrice >= 0) {
                        scrollOfPower.quantity++;
                        hero.backpack.addItem(new Hero.ScrollOfPower(1));
                        hero.gold -= scrollOfPowerPrice;
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
