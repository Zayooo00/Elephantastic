package Project;

import java.util.Scanner;

public class Input {
    private static final Scanner readInput = new Scanner(System.in);

    public static void GetEnter() {
        ReadInput();
    }

    public static String GetString() {
        return ReadInput();
    }

    public static int GetInt() {
        int number = -1;
        String line = ReadInput();
        try {
            number = Integer.parseInt(line);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        return number;
    }

    public static double GetDouble() {
        double number = -1.0;
        String line = ReadInput();
        try {
            number = Double.parseDouble(line);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        return number;
    }

    private static String ReadInput() {
        String line = "";
        try {
            line = readInput.nextLine();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return line;
    }
}
