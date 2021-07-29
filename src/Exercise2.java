public class Exercise2 extends Exercise {

    /*
        Так как года не кратные 400 и кратные 100 (100, 200, 300, 500..) не являются високосными,
        нам нужно их вычесть, тем самым составил формулу

        количество лет кратных 4 - количество лет кратных 100 + количество лет кратных 400
    */

    public void run() {
        System.out.print("Введите год: ");
        int age = scanner.nextInt();

        int result = age / 4 - age / 100 + age / 400;

        System.out.println("Результат " + result);
    }
}
