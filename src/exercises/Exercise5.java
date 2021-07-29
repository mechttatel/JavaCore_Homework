package exercises;

public class Exercise5 extends Exercise {

    /*
        Так как степень двойки в двоичном виде это всегда 1
        и любое количество нулей после, и чтобы проверить на степень я преобразовал
        число в двоичный вид, а дальше с помощью метода lastIndexOf у String
        проверил, чтобы единичка в значении была только одна и только на первой позиции
     */

    public void run() {
        System.out.println("Введите число для проверки на степень двойки: ");
        int digit = scanner.nextInt();

        String binary = Integer.toBinaryString(Math.abs(digit));
        boolean result = binary.lastIndexOf("1") == 0;

        System.out.println("Результат - " + result);
    }
}
