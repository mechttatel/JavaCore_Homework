package exercises;

import java.util.Locale;

public class Exercise6 extends Exercise {

    /*
        Алгоритм работает по принципу
        1. Идем сначала слова и ищем первую букву
        2. После идем с конца слова и ищем последнюю букву, после запоминаем ее и выходим из цикла
        3. Если правый край (endPosition) встретился с левым (i), буквы кончились, ошибки не было, значит все сходится)
        4. А если букве не нашлась пара или буквы не равны, выбрасываем false
   */

    @Override
    public void run() {
        System.out.println("Введите слово для проверки на палиндром:");
        String inputString = scanner.next();
        char[] chars = inputString.toLowerCase(Locale.ROOT).toCharArray();
        int endPosition = inputString.length();

        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isLetter(chars[i])) {
                char charToEqual = 0;

                while (endPosition > 0) {
                    endPosition--;
                    if (Character.isLetter(chars[endPosition])) {
                        charToEqual = chars[endPosition];
                        break;
                    }
                }

                if (endPosition <= i) {
                    System.out.println(true);
                    return;
                }

                if (charToEqual == 0 || chars[i] != charToEqual) {
                    System.out.println("Результат - " + false);
                    return;
                }
            }
        }

        System.out.println(true);
    }
}
