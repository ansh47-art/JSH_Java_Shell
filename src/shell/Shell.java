package shell;


import commands.Command;
import commands.MkdirCommand;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import parser.CommandParser;

public class Shell {
    private HashMap <String, Command> hm;

    public Shell() {
        hm = new HashMap <> ();
        hm.put("mkdir", new MkdirCommand());
    }

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

            String commandName = parts[0].toLowerCase();
            String[] arguments = Arrays.copyOfRange(parts, 1, parts.length);

            if (hm.containsKey(commandName)) {
                Command cmd = hm.get(commandName);
                cmd.execute(arguments);
            }
            else {
                System.out.println("Error: Unknown Command!");
            }
        }
        
        sc.close();
    }
}