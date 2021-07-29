public class Exercise3 extends Exercise {

    /*
        Полученное число переводим в двоичную сс в String, после чего из этой строки получаем массив символов
        Так как индексирование в массиве идет справа, а позицию бита мы вводим слева, то высчитываем нужный индекс
        После чего тернарным оператором заменяем значение на обратное и переводим обратно в строку и в число
    */

    public void run() {
        System.out.print("Введите число: ");
        int digit = scanner.nextInt();

        System.out.print("Введите позицию заменяемого бита: ");
        int position = scanner.nextInt();

        char[] charArrayOfBinaryDigit = Integer.toBinaryString(digit).toCharArray();

        int index = charArrayOfBinaryDigit.length - position;
        charArrayOfBinaryDigit[index] = charArrayOfBinaryDigit[index] == '1' ? '0' : '1';

        String newBinaryDigit = new String(charArrayOfBinaryDigit);
        int result = Integer.parseInt(newBinaryDigit, 2);
        System.out.println("Результат - " + result);
    }
}
