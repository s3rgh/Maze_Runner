package maze;

import static maze.MazeUtils.*;

public class MazePathSolver {
    private String[][] maze;
    private int rows;
    private int cols;

    public MazePathSolver(String[][] maze) {
        this.maze = maze;
        this.rows = maze.length;
        this.cols = maze[0].length;
    }

    public boolean findExit(int x, int y) {
        // Проверяем границы и условия выхода
        if (x < 0 || x >= rows || y < 0 || y >= cols) { //Выход за границы
            return false;
        }
        if (maze[x][y].equals(VISITED)) {
            return false; // Уже посещённая клетка
        }
        if (maze[x][y].equals(WALL)) { // Стена
            return false;
        }

        if (maze[x][y].equals(EXIT) && x ==rows - 4 && y == cols - 1) {
            maze[x][y] = VISITED;
            //System.out.println("Exit found at (" + x + ", " + y + ")");
            return true; // Найден выход
        }

        // Помечаем клетку как посещённую
        maze[x][y] = VISITED;

        // Проверяем все четыре направления (вверх, вниз, влево, вправо)
        if (findExit(x - 1, y) || // Вверх
                findExit(x + 1, y) || // Вниз
                findExit(x, y - 1) || // Влево
                findExit(x, y + 1)) { // Вправо
            return true; // Если выход найден
        }

        // Если ни одно направление не привело к выходу, помечаем клетку как непосещённую
        maze[x][y] = PATH;
        return false; // Выход не найден
    }
}

