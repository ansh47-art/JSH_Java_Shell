package shell;

import java.util.Arrays;
import java.util.Scanner;
import parser.CommandParser;

public class Shell {
    public void start() {

        Scanner sc = new Scanner(System.in);
        CommandParser par = new CommandParser();

        System.out.println("Welcome to JSH!");
        System.out.println("Type 'exit' to close the shell");
        System.out.println();

        while (true) {
            System.out.print("JSH> ");

            String command = sc.nextLine().trim();

            if (command.isEmpty()) {
                continue;
            }

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Closing shell...");
                break;
            }

            String[] parts = par.parse(command);

            String commandName = parts[0];
            String[] arguments = Arrays.copyOfRange(parts, 1, parts.length);

            System.out.println("Entered Command = " + commandName);
            System.out.println("Entered Argument = " + Arrays.toString(arguments));
            System.out.println();
        }

    }
}