package commands;

import shell.Shell;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;

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
                System.out.println("Error: " + fileName + " already exists!");
            }
        }
    }
}