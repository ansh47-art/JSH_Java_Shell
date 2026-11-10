package commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import shell.Shell;

public class RmCommand implements Command {
    private final Shell sh;

    public RmCommand (Shell sh) {
        this.sh = sh;
    }

    @Override
    public void execute (String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: rm <file_name> [file_name ...]");
            return;
        }

        for (String fileName : args) {
            Path filePath = sh.getCurrentDirectory().resolve(fileName).normalize();

            try {
                if (Files.isDirectory(filePath)) {
                    System.out.println("Error: rm right now cannot delete directory!");
                    continue;
                }
                Files.delete(filePath);
            }
            catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}