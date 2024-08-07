package maze;

import java.util.*;

import static maze.MenuUtils.ENTER_SIZE;

public class MazeUtils {
    public static final String WALL = "██";
    public static final String PATH = "  ";
    public static final String VISITED = "//";
    public static final String ENTRANCE = "  ";
    public static final String EXIT = "  ";

    public static Maze fillMaze() {
        var size = readSize();
        Maze maze = new Maze();
        maze.setUp(new String[size][size]);
        Random random = new Random();
        Stack<int[]> stack = new Stack<>();
        var mazeArray = maze.getMazeArray();

        // filling walls
        for (int i = 0; i < mazeArray.length; i++) {
            for (int j = 0; j < mazeArray[0].length; j++) {
                mazeArray[i][j] = WALL;
            }
        }

        int[] start = {1, 1};
        mazeArray[start[0]][start[1]] = PATH;
        stack.push(start);

        while (!stack.isEmpty()) {
            int[] current = stack.peek();
            List<int[]> neighbors = new ArrayList<>();
            // neighbour of current cell
            if (current[0] >= 3 && mazeArray[current[0] - 2][current[1]].equals(WALL)) {
                neighbors.add(new int[]{current[0] - 2, current[1]});
            }
            if (current[0] <= size - 4 && mazeArray[current[0] + 2][current[1]].equals(WALL)) {
                neighbors.add(new int[]{current[0] + 2, current[1]});
            }
            if (current[1] >= 3 && mazeArray[current[0]][current[1] - 2].equals(WALL)) {
                neighbors.add(new int[]{current[0], current[1] - 2});
            }
            if (current[1] <= size - 4 && mazeArray[current[0]][current[1] + 2].equals(WALL)) {
                neighbors.add(new int[]{current[0], current[1] + 2});
            }

            if (!neighbors.isEmpty()) {
                // choose random neighbour
                int[] next = neighbors.get(random.nextInt(neighbors.size()));
                // make path
                mazeArray[next[0]][next[1]] = PATH;
                mazeArray[(current[0] + next[0]) / 2][(current[1] + next[1]) / 2] = PATH;
                stack.push(next);
            } else {
                stack.pop();
            }
        }

        // setup entrance and exit
        mazeArray[1][0] = ENTRANCE;
        mazeArray[size - 4][size - 1] = EXIT;
        maze.setMazeFilled(true);

        return maze;
    }

    public static void printMaze(Maze maze) {
        var mazeArray = maze.getMazeArray();
        for (String[] strings : mazeArray) {
            for (int j = 0; j < mazeArray[0].length; j++) {
                System.out.print(strings[j]);
            }
            System.out.println();
        }
    }

    public static void dfsMaze(Maze maze) {

        var mazeArray = maze.getMazeArray();
        var solver = new MazePathSolver(mazeArray);
        solver.findExit(1, 0);
        printMaze(maze);
        System.out.println();
    }

    private static int readSize() {
        System.out.println(ENTER_SIZE);
        Scanner scanner = new Scanner(System.in);
        var str = scanner.nextLine();
        return Integer.parseInt(str);
    }
}
