package exercises;

import utils.ex10.Direction;
import utils.ex10.Robot;

public class Exercise10 extends Exercise {

    @Override
    public void run() {
        System.out.println("Классы, требуемые для этого задания, находятся по пути utils/ex10");

        System.out.print("Введите начальную координату робота по оси X: ");
        int startX = scanner.nextInt();

        System.out.print("Введите начальную координату робота по оси Y: ");
        int startY = scanner.nextInt();

        System.out.println("Выберите начальное направление:");
        System.out.println("1 - вверх");
        System.out.println("2 - вправо");
        System.out.println("3 - вниз");
        System.out.println("4 - влево");

        int directionDigit = scanner.nextInt();
        Direction direction;

        switch (directionDigit) {
            case 1:
                direction = Direction.UP;
                break;
            case 2:
                direction = Direction.RIGHT;
                break;
            case 3:
                direction = Direction.DOWN;
                break;
            case 4:
                direction = Direction.LEFT;
                break;
            default:
                throw new IllegalArgumentException();
        }

        Robot robot = new Robot(startX, startY, direction);

        System.out.println("Робот создан и готов!");
        System.out.print("Введите координату назначения по оси X: ");
        int moveToX = scanner.nextInt();

        System.out.print("Введите начальную назначения по оси Y: ");
        int moveToY = scanner.nextInt();

        robot.moveTo(moveToX, moveToY);
    }
}
