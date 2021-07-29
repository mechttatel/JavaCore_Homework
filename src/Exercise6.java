import java.util.Locale;

public class Exercise6 extends Exercise {

    @Override
    public void run() {
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
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(true);
    }
}
