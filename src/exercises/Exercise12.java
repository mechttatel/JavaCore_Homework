package exercises;

import utils.ex12.CheckLabels;
import utils.ex12.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Exercise12 extends Exercise {
    @Override
    public void run() {
        System.out.println("Классы, требуемый для этого задания, находится в папке utils/ex12\n");

        System.out.println("Введите массив запрещенных слов");
        System.out.println("Слова вводятся построчно, для завершения ввода введите 0");

        List<String> keywords = new ArrayList<>();
        String inputWord = scanner.next();
        while (!Objects.equals(inputWord, "0")) {
            keywords.add(inputWord);
            inputWord = scanner.next();
        }
        System.out.println("Ввод завершен");

        System.out.print("Введите максимальную длину комментария: ");
        int maxLength = scanner.nextInt();

        CheckLabels checkLabels = new CheckLabels(keywords.toArray(new String[0]), maxLength);

        System.out.println("Введите комментарий для проверки:");
        String comment = scanner.next();
        Label resultLabel = checkLabels.checkLabels(comment);

        System.out.println("Результат - " + resultLabel.name());
    }
}
