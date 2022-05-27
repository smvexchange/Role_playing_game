import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя вашего героя:");
        Hero hero = new Hero(scanner.nextLine());
        while (true) {
            System.out.print("""
                    Вы находитесь в городе.
                    Куда вы хотите пойти?
                    1. К торговцу
                    2. В тёмный лес
                    3. В пещеру с драконами
                    4. На выход
                    """);
            int command = userInput();
            switch (command) {
                case 1 -> new Trading(hero).run();
                case 2 -> new Fighting(hero, "forest").run();
                case 3 -> new Fighting(hero, "cave").run();
                case 4 -> {
                    return;
                }
                default -> System.out.print("Выберите варианты 1, 2, 3 или 4.\n\n");
            }

            if (hero.health <= 0) {
                break;
            }
        }
    }

    public static int userInput() {
        Scanner scanner = new Scanner(System.in);
        int command = 0;
        try {
            command = scanner.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Неверный ввод данных! Необходимо ввести целое число.");
        }
        return command;
    }
}
