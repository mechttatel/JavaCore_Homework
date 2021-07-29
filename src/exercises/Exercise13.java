package exercises;

public class Exercise13 extends Exercise {

    @Override
    public void run() {
        System.out.print("Введите число: ");
        int digit = scanner.nextInt();

        System.out.println("Результат - " + sqrt(digit));
    }

    public double sqrt(double digit) {
        if (digit < 0) {
            throw new IllegalArgumentException("Expected non-negative number, got " + digit);
        }

        return Math.sqrt(digit);
    }
}
