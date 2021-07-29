package exercises;

import java.math.BigInteger;

public class Exercise7 extends Exercise {

    @Override
    public void run() {
        int digit = scanner.nextInt();

        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= digit; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        System.out.println(result);
    }
}
