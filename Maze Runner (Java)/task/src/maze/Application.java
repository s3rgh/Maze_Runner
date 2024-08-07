package maze;

import java.util.Scanner;

import static maze.FileUtils.loadMaze;
import static maze.FileUtils.saveMaze;
import static maze.MazeUtils.*;
import static maze.MenuUtils.*;

public class Application {

    public void play() {
        Maze maze = new Maze();
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            if (maze.isMazeFilled()) {
                System.out.println(FULL_MENU);
                input = scanner.nextLine();
                if (input.equals("0")) {
                    System.out.println(BYE);
                    break;
                } else if (input.equals("1")) {
                    maze = fillMaze();
                    printMaze(maze);
                } else if (input.equals("2")) {
                    maze = loadMaze(scanner.nextLine());
                } else if (input.equals("3")) {
                    saveMaze(maze, scanner.nextLine());
                } else if (input.equals("4")) {
                    printMaze(maze);
                } else if (input.equals("5")) {
                    dfsMaze(maze);
                } else {
                    System.out.println(INCORRECT_OPTION);
                }
            } else {
                System.out.println(SHORT_MENU);
                input = scanner.nextLine();
                if (input.equals("0")) {
                    System.out.println(BYE);
                    break;
                } else if (input.equals("1")) {
                    maze = fillMaze();
                    printMaze(maze);
                } else if (input.equals("2")) {
                    maze = loadMaze(scanner.nextLine());
                } else {
                    System.out.println(INCORRECT_OPTION);
                }
            }
        }
    }
}
