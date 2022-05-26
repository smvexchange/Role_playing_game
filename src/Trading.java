public class Trading implements Runnable {
    Hero hero;
    Vendor vendor;
    Hero.HealthPotion healthPotion;
    Hero.ScrollOfPower scrollOfPower;

    public Trading(Hero hero, Vendor vendor) {
        this.hero = hero;
        this.vendor = vendor;
    }

    @Override
    public void run() {
        while (true) {
            System.out.print("""
                    Вы находитесь в торговой лавке.
                    Что вы хотите?
                    1.Купить Зелье здоровья
                    2.Купить Свиток силы
                    3.Проверить сумку
                    4.Вернуться в город
                    """);
            int command = Main.userInput();
            switch (command) {
                case 1 -> {
                    if (hero.gold - vendor.getHealingPotionPrice() >= 0) {
                        hero.backpack.addItem(new Hero.HealthPotion());
                        hero.gold -= vendor.getHealingPotionPrice();
                        System.out.println("Получено Зелье здоровья.\n");
                    } else {
                        System.out.println("У вас недостаточно золота!");
                    }
                }
                case 2 -> {
                    if (hero.gold - vendor.getScrollOfPowerPrice() >= 0) {
                        hero.backpack.addItem(new Hero.ScrollOfPower());
                        hero.gold -= vendor.getScrollOfPowerPrice();
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
