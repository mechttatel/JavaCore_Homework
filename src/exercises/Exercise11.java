package exercises;

import utils.ex11.ComplexNumber;

public class Exercise11 extends Exercise {

    @Override
    public void run() {
        System.out.println("Введите re первого числа");
        double re = scanner.nextDouble();
        System.out.println("Введите im первого числа");
        double im = scanner.nextDouble();

        ComplexNumber a = new ComplexNumber(re, im);

        System.out.println("Введите re второго числа");
        re = scanner.nextDouble();
        System.out.println("Введите im второго числа");
        im = scanner.nextDouble();

        ComplexNumber b = new ComplexNumber(re, im);

        System.out.println("Проверка equals: " + a.equals(b));
        System.out.println("Проверка hashCode: " + (a.hashCode() == b.hashCode()));
    }
}
