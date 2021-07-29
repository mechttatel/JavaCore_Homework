public class Exercise4 extends Exercise {

    /*
        Так как char можно преобразовать к int, просто прибавил к char введенное целое число
        после чего преобразовал явным приведением к char
        Для использования символа обратного слеша использовал экранирование
     */

    @Override
    public void run() {
        System.out.print("Введите расстояние от \\ : ");
        int margin = scanner.nextInt();

        char result = (char) ('\\' + margin);

        System.out.println("Результат - " + result);
    }
}
