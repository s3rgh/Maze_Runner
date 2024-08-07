package maze;

public class Maze {
    private boolean isMazeFilled;
    private String[][] mazeArray;

    public Maze() {
        this.isMazeFilled = false;
    }

    public Maze setUp(String[][] mazeArray) {
        this.mazeArray = mazeArray;
        return this;
    }

    public boolean isMazeFilled() {
        return isMazeFilled;
    }

    public void setMazeFilled(boolean mazeFilled) {
        this.isMazeFilled = mazeFilled;
    }

    public String[][] getMazeArray() {
        return mazeArray;
    }
}
