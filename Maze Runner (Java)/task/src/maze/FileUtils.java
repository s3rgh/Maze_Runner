package maze;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static maze.MenuUtils.DOESNT_EXIST;
import static maze.MenuUtils.INVALID_FORMAT;

public class FileUtils {
    public static void saveMaze(Maze maze, String fileName) {
        var string = new StringBuilder();
        var mazeArray = maze.getMazeArray();
        for (String[] strings : mazeArray) {
            for (int j = 0; j < mazeArray[0].length; j++) {
                string.append(strings[j]);
            }
            string.append("\n");
        }

        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(string.toString().trim());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Maze loadMaze(String fileFromResources) {
        var path = Path.of(fileFromResources);
        String[][] strings = new String[0][];
        int height = 0;
        int width = 0;
        Maze maze = new Maze();
        if (!Files.exists(path)) {
            System.out.printf((DOESNT_EXIST) + "%n", fileFromResources);
        } else {
            try {
                var string = Files.readString(path);
                var linesArray = string.split("\n");
                height = linesArray.length;
                width = linesArray[0].length() / 2;
                strings = new String[height][width];
                for (int i = 0; i < linesArray.length; i++) {
                    for (int j = 0, k = 0; j < width; j++, k+=2) {
                        strings[i][j] = linesArray[i].charAt(k) + "" + linesArray[i].charAt(k + 1);
                    }
                }
            } catch (IOException e) {
                throw new IllegalStateException(INVALID_FORMAT, e);
            }
        }
        maze.setUp(strings);
        maze.setMazeFilled(true);
        return maze;
    }
}
