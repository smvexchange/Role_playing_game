import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя вашего героя:");
        Hero hero = new Hero(scanner.nextLine());
        World world = new World(hero);
        while (true) {
            System.out.println("""
                    Вы находитесь в городе.
                    Куда вы хотите пойти?
                    1. К торговцу
                    2. В тёмный лес
                    3. В пещеру с драконами
                    4. На выход
                    """);
            int command = 0;
            try {
                command = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод данных!\nВыберите варианты 1, 2, 3 или 4.");
            }
            switch (command) {
                case 1 -> new Trading(world.hero, world.vendor).run();
                case 2 -> System.out.println("В разработке");
                case 3 -> System.out.println("В разработке");
                case 4 -> System.out.println("В разработке");
                default -> System.out.print("Неверный ввод данных!\nВыберите варианты 1, 2, 3 или 4.");
            }
        }
    }
}
