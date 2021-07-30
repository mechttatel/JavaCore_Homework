package utils.ex10;

public class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        switch (direction) {
            case UP:
                direction = Direction.LEFT;
                break;
            case DOWN:
                direction = Direction.RIGHT;
                break;
            case LEFT:
                direction = Direction.DOWN;
                break;
            case RIGHT:
                direction = Direction.UP;
                break;
        }

        System.out.println("Робот повернулся влево");
    }

    public void turnRight() {
        switch (direction) {
            case UP:
                direction = Direction.RIGHT;
                break;
            case DOWN:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.UP;
                break;
            case RIGHT:
                direction = Direction.DOWN;
                break;
        }

        System.out.println("Робот повернулся вправо");
    }

    public void stepForward() {
        switch (direction) {
            case UP:
                y++;
                break;
            case DOWN:
                y--;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }

        System.out.println("Робот шагает вперед (" + x + ", " + y + ")");
    }

    /*
        Решил не париться с кучей свитчей и сделать немного ленивое решение
        Сначала проверяем робота по оси X, если координата меньше или больше заданного значения,
        робот крутится вправо, пока не встанет на нужное направление и пойдет вперед, пока не дойдет
        до указанной координаты

        по оси Y такая же логика
    */

    public void moveTo(int x, int y) {
        if (this.x < x) {
            while (direction != Direction.RIGHT) {
                turnRight();
            }

            while (this.x < x) {
                stepForward();
            }
        }

        if (this.x > x) {
            while (direction != Direction.LEFT) {
                turnRight();
            }

            while (this.x > x) {
                stepForward();
            }
        }

        if (this.y < y) {
            while (direction != Direction.UP) {
                turnRight();
            }

            while (this.y < y) {
                stepForward();
            }
        }

        if (this.y > y) {
            while (direction != Direction.DOWN) {
                turnRight();
            }

            while (this.y > y) {
                stepForward();
            }
        }

        System.out.println("Робот пришел!!!");
    }
}
