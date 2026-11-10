package shell;

import commands.CatCommand;
import commands.CdCommand;
import commands.Command;
import commands.CpCommand;
import commands.HistoryCommand;
import commands.LsCommand;
import commands.MkdirCommand;
import commands.MvCommand;
import commands.PwdCommand;
import commands.RmCommand;
import commands.RmdirCommand;
import commands.TouchCommand;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import parser.CommandParser;

public class Shell {
    private HashMap <String, Command> hm;
    private ArrayList <String> history;
    private Path currentDir;

    public Shell() {
        currentDir = Path.of(System.getProperty("user.dir")).toAbsolutePath().normalize();

        hm = new HashMap <> ();
        history = new ArrayList <> ();
        hm.put("mkdir", new MkdirCommand(this));
        hm.put("pwd", new PwdCommand(this));
        hm.put("cd", new CdCommand(this));
        hm.put("ls", new LsCommand(this));
        hm.put("touch", new TouchCommand(this));
        hm.put("cat", new CatCommand(this));
        hm.put("rm", new RmCommand(this));
        hm.put("rmdir", new RmdirCommand(this));
        hm.put("cp", new CpCommand(this));
        hm.put("mv", new MvCommand(this));
        hm.put("history", new HistoryCommand(this));
    }

    public Path getCurrentDirectory() {
        return currentDir;
    }

    public void setCurrentDirectory(Path path) {
        currentDir = path;
    }

    public void getHistoryOfCommands() {
        Integer i = 1;
        for (String cmd : history) {
            System.out.println(i + ". " + cmd);
            i++;
        }
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

            history.add(command);

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