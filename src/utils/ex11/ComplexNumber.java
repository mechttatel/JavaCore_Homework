package utils.ex11;

import java.util.Objects;

public class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double a, double b) {
        this.re = a;
        this.im = b;
    }

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
