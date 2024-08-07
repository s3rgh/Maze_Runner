package maze;

public class MenuUtils {
    public static final String FULL_MENU = """
            === Menu ===
            1. Generate a new maze
            2. Load a maze
            3. Save the maze
            4. Display the maze
            5. Find the escape
            0. Exit.""";

    public static final String SHORT_MENU = """
            === Menu ===
            1. Generate a new maze
            2. Load a maze
            0. Exit.""";

    public static final String INCORRECT_OPTION = "Incorrect option. Please try again";
    public static final String DOESNT_EXIST = "The file %s does not exist";
    public static final String INVALID_FORMAT = "Cannot load the maze. It has an invalid format";
    public static final String ENTER_SIZE = "Enter the size of a new maze";
    public static final String BYE = "Bye!";
}
