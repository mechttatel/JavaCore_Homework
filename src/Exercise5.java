import java.util.Scanner;

public class Exercise5 extends Exercise {

    public void run() {
        int digit = scanner.nextInt();
        String binary = Integer.toBinaryString(Math.abs(digit));
        boolean result = binary.lastIndexOf("1") == 0;
        System.out.println(result);
    }
}
