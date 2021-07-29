package exercises;

public class Exercise1 extends Exercise {

    /*
        x - количество true из всех boolean

        Сначала проверяем, есть ли среди 4 элементов хотя бы один истинный
        После чего идет проверка на true всех элементов
        Тем самым уже установлены рамки (1 <= x < 4)

        Далее оператором XOR попарно проверяем каждый элемент, что сводит формулу к
        x == 2

        Скажу честно, сидел над этой задачей дольше всего и подсмотрел в интернете,
        очень интересная задачка на логику. Все остальные делал самостоятельно.
     */

    public void run() {

        System.out.println("Введите 4 boolean типа построчно");

        boolean arg1 = scanner.nextBoolean();
        boolean arg2 = scanner.nextBoolean();
        boolean arg3 = scanner.nextBoolean();
        boolean arg4 = scanner.nextBoolean();

        boolean result = (arg1 || arg2 || arg3 || arg4) &&
                !(arg1 && arg2 && arg3 && arg4) &&
                !(arg1 ^ arg2 ^ arg3 ^ arg4);

        System.out.println("Результат - " + result);
    }
}
