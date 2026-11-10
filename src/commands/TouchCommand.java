package commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import shell.Shell;

public class TouchCommand implements Command {
    private final Shell sh;

    public TouchCommand (Shell sh) {
        this.sh = sh;
    }

    @Override
    public void execute (String[] args) {
        if (args.length == 0) {
            System.out.println("Error: touch needs argument!");
            return;
        }

        for (String fileName : args) {
            Path currentPath = sh.getCurrentDirectory().resolve(fileName).normalize();

            try {
                Files.createFile(currentPath);
            }
            catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}