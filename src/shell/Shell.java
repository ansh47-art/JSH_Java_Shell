package shell;

import java.util.Scanner;

public class Shell {
    public void start() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to JSH!");
        System.out.println("type 'exit' to close the shell");
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

            System.out.println("Entered Command = " + command);
            System.out.println();
        }

    }
}