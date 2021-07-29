public class Exercise1 extends Exercise {

    public void run() {
        boolean arg1 = scanner.nextBoolean();
        boolean arg2 = scanner.nextBoolean();
        boolean arg3 = scanner.nextBoolean();
        boolean arg4 = scanner.nextBoolean();

        boolean result = !(arg1 && arg2 && arg3 && arg4);
        System.out.println(result);
    }
}
