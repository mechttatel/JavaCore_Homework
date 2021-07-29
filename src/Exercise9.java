import java.util.Arrays;

public class Exercise9 extends Exercise {

    @Override
    public void run() {
        String[] text = scanner.nextLine().split("\n");
        System.out.println(Arrays.toString(text));
    }
}
