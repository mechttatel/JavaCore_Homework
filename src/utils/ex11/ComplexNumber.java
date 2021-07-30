package utils.ex11;

import java.util.Objects;

public class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double a, double b) {
        this.re = a;
        this.im = b;
    }

    /*
        Первым делом проверяются ссылки на объекты
        Если ссылки указывают на одну ячейку памяти - объекты равны

        Дальше идем проверка сравниваемого объекта на null и соответствие классу
        После чего объект для сравнения приводится к типу комплексного числа
        И с помощью метода compare у класса Double сравниваются значения полей комплексных чисел
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.re, re) == 0 && Double.compare(that.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }
}
