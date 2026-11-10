package commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import shell.Shell;

public class RmdirCommand implements Command {
    private final Shell sh;

    public RmdirCommand (Shell sh) {
        this.sh = sh;
    }

    @Override 
    public void execute (String[] args) {
        if (args.length == 0) {
            System.out.println("Error: rmdir needs atleast an argument!");
            return;
        }

        for (String dirName : args) {
            Path dirPath = sh.getCurrentDirectory().resolve(dirName).normalize();

            try {
                if (!Files.isDirectory(dirPath)) {
                    System.out.println("Error: directory doesn't exist!");
                    continue;
                }
                Files.delete(dirPath);
            }
            catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}