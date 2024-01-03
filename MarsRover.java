import java.util.HashSet;
import java.util.Set;

class MarsRover {
    private int x;
    private int y;
    private char direction;
    private int[] boundaries;
    private Set<Point> obstacles;

    public MarsRover(int x, int y, char direction, int[] boundaries, Set<Point> obstacles) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.boundaries = boundaries;
        this.obstacles = obstacles;
    }

    public void move() {
        switch (direction) {
            case 'N':
                if (isWithinBoundaries(x, y + 1)) y++;
                break;
            case 'S':
                if (isWithinBoundaries(x, y - 1)) y--;
                break;
            case 'E':
                if (isWithinBoundaries(x + 1, y)) x++;
                break;
            case 'W':
                if (isWithinBoundaries(x - 1, y)) x--;
                break;
        }
    }

    public void turnLeft() {
        switch (direction) {
            case 'N':
                direction = 'W';
                break;
            case 'W':
                direction = 'S';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case 'N':
                direction = 'E';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'W':
                direction = 'N';
                break;
        }
    }

    public void executeCommand(String command) {
        for (char move : command.toCharArray()) {
            if (move == 'L') turnLeft();
            else if (move == 'R') turnRight();
            else if (move == 'M') move();

            // Stretch Goal 3: Check for obstacles
            if (obstacles != null && obstacles.contains(new Point(x, y))) {
                System.out.println("Boulder encountered at (" + x + ", " + y + "). Command terminated.");
                break;
            }
        }
        printState();
    }

    public void printState() {
        System.out.println("The rover's current coordinates are (" + x + ", " + y + ") and it is facing " + direction);
    }

    private boolean isWithinBoundaries(int newX, int newY) {
        return boundaries == null || (newX >= 0 && newX <= boundaries[0] && newY >= 0 && newY <= boundaries[1]);
    }

    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }

    public static void main(String[] args) {
        Set<Point> obstacles1 = new HashSet<>();
        obstacles1.add(new Point(2, 3));
        obstacles1.add(new Point(4, 1));

        Set<Point> obstacles2 = new HashSet<>();
        obstacles2.add(new Point(1, 2));
        obstacles2.add(new Point(3, 4));

        MarsRover rover1 = new MarsRover(0, 0, 'N', new int[]{5, 5}, obstacles1);
        MarsRover rover2 = new MarsRover(0, 0, 'N', new int[]{5, 5}, obstacles2);

        String commands1 = "MMRMMRMRRM";
        String commands2 = "LMLMLMLMM";

        rover1.executeCommand(commands1);
        rover2.executeCommand(commands2);
    }
}
