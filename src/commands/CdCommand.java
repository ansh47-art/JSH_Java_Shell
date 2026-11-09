package commands;

import shell.Shell;
import java.nio.file.Path;
import java.nio.file.Files;


public class CdCommand implements Command {
    private final Shell sh;

    public CdCommand (Shell sh) {
        this.sh = sh;
    }

    @Override
    public void execute (String[] args) {
        if (args.length > 1 || args.length == 0) {
            if (args.length > 1) {
                System.out.println("Error: cd can't have more than one argument!");
                return;
            }
            else {
                System.out.println("Error: cd requires an argument!");
                return;
            }
        }

        Path updatedPath = sh.getCurrentDirectory().resolve(args[0]).normalize();

        if (!Files.isDirectory(updatedPath)) {
            System.out.println("Error: Directory does not exist!");
            return;
        }

        sh.setCurrentDirectory(updatedPath);
    }
}