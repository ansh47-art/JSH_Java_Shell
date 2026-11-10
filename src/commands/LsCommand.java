package commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import shell.Shell;

public class LsCommand implements Command {
    private final Shell sh;

    public LsCommand (Shell sh) {
        this.sh = sh;
    }

    @Override
    public void execute (String[] args) {
        if (args.length != 0) {
            System.out.println("Usage: ls");
            return;
        }

        Path currentPath = sh.getCurrentDirectory();

        try (Stream <Path> paths = Files.list(currentPath)) {

            paths.forEach((path) -> {
                System.out.println(path.getFileName());
            });
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}