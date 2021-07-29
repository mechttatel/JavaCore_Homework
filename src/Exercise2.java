public class Exercise2 extends Exercise {

    public void run() {
        System.out.print("Введите год: ");
        int age = scanner.nextInt();

        int result = age / 4 - age / 100 + age / 400;

        System.out.println(result);
    }
}
