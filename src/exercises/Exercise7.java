package exercises;

import java.math.BigInteger;

public class Exercise7 extends Exercise {

    /*
        Задача решается путем динамического программирования, то есть мы запоминаем
        результат каждой итерации и используем его в дальнейшем

        В цикле исходная единица умножается на множество чисел [1, введенное число]
        Как указывалось в задании, результат имеет тип BigInteger,
        чтобы избежать случай выхода за границы
    */

    @Override
    public void run() {
        System.out.print("Введите число: ");
        int digit = scanner.nextInt();

        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= digit; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        System.out.println("Результат - " + result);
    }
}
