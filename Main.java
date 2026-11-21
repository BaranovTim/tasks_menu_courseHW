
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "Выберите операцию:\n" +
                    "0. Выход из программы\n" +
                    "1. Добавить дело\n" +
                    "2. Показать дела\n" +
                    "3. Удалить дело по номеру\n" +
                    "4. Удалить дело по названию\n" +
                    "Ваш выбор:"
            );

            String option = scanner.nextLine();

            switch (option) {
                case "0":
                    System.out.println("Программа завершена.");
                    return;

                case "1":
                    add_task(tasks, scanner);
                    break;

                case "2":
                    break;

                case "3":
                    delete_task_id(tasks, scanner);
                    break;

                case "4":
                    delete_task_name(tasks, scanner);
                    break;

                default:
                    System.out.println("Неверная операция.");
                    break;
            }

            show_tasks(tasks);
        }
    }

    public static void add_task(ArrayList<String> tasks, Scanner scanner) {
        System.out.println("Введите название задачи:");
        String task = scanner.nextLine();

        if (tasks.contains(task)) {
            System.out.println("Такая задача уже существует");
        } else {
            tasks.add(task);
            System.out.println("Добавлено!");
        }
    }

    public static void show_tasks(ArrayList<String> tasks) {
        System.out.println("Ваш список дел:");

        if (tasks.isEmpty()) {
            System.out.println("Список дел пуст.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public static void delete_task_id(ArrayList<String> tasks, Scanner scanner) {
        System.out.println("Введите номер для удаления:");
        int id;

        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Введите корректный номер.");
            return;
        }

        if (id < 1 || id > tasks.size()) {
            System.out.println("Дела с таким номером нет.");
        } else {
            tasks.remove(id - 1);
            System.out.println("Удалено!");
        }
    }

    public static void delete_task_name(ArrayList<String> tasks, Scanner scanner) {
        System.out.println("Введите задачу для удаления:");
        String name = scanner.nextLine();

        if (tasks.remove(name)) {
            System.out.println("Удалено!");
        } else {
            System.out.println("Дела с таким названием нет.");
        }
    }
}
