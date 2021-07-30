package exercises;

import utils.ex15.Pair;

public class Exercise15 extends Exercise {

    @Override
    public void run() {
        System.out.println("Классы, требуемый для этого задания, находится в папке utils/ex15\n");
        Pair<Integer, String> pair = Pair.of(1, "hello");

        Integer i = pair.getFirst(); // 1
        System.out.println("pair.getFirst() = " + i);

        String s = pair.getSecond(); // "hello"
        System.out.println("pair.getSecond() = " + s);

        Pair<Integer, String> pair2 = Pair.of(1, "hello");

        boolean mustBeTrue = pair.equals(pair2); // true!
        System.out.println("pair.equals(pair2) = " + mustBeTrue);

        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println("pair.hashCode() == pair2.hashCode() = " + mustAlsoBeTrue);
    }
}
