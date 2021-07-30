import exercises.*;

import java.util.Scanner;

public class Main {

    private final Exercise[] exercises;

    public Main() {
        exercises = new Exercise[] {
                new Exercise1(),
                new Exercise2(),
                new Exercise3(),
                new Exercise4(),
                new Exercise5(),
                new Exercise6(),
                new Exercise7(),
                new Exercise8(),
                new Exercise9(),
                new Exercise10(),
                new Exercise11(),
                new Exercise12(),
                new Exercise13(),
                new Exercise14(),
                new Exercise15(),
        };
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.chooseExercise();
    }

    private void chooseExercise() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет, введи номер задачи от 1 до 15");
        System.out.println("Для закрытия приложения введите 0");

        while (true) {
            try {
                int exerciseOrder = scanner.nextInt();

                if (exerciseOrder == 0) {
                    System.out.println("Пока!");
                    System.exit(0);
                }

                System.out.println("Задача №" + exerciseOrder);
                exercises[exerciseOrder - 1].run();
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Пожалуйста, введите корректные данные");
            }
            finally {
                System.out.print("\nВведите номер задачи: ");
            }
        }
    }
}
