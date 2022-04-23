import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static LoggerSingleton logger = LoggerSingleton.getInstance();

    public static void main(String[] args) {
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка:");
        Scanner scanner = new Scanner(System.in);
        int sizeList = inputNumber(scanner);

        System.out.print("Введите верхнюю границу для значений:");
        int maxValueList = inputNumber(scanner);

        logger.log("Создаём и наполняем список");
        System.out.print("Вот случайный список: ");
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < sizeList; i++) {
            list.add(random.nextInt(maxValueList));
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        int maxValueFilter = inputNumber(scanner);

        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(maxValueFilter);
        List<Integer> newList;
        newList = filter.filterOut(list);

        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список: ");
        for (Integer integer : newList) {
            System.out.print(integer + " ");
        }
        System.out.println();
        logger.log("Завершаем программу");
    }

    static int inputNumber(Scanner scanner) {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Введите корректное значение");
                logger.log("Введено некорректное значение");
            }
        }
        return input;
    }
}
