package commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import shell.Shell;

public class FindCommand implements Command {
    private final Shell sh;

    public FindCommand (Shell sh) {
        this.sh = sh;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: find <name>");
            return;
        }

        Path currentDir = sh.getCurrentDirectory();

        boolean[] isFound = {false};

        try (Stream <Path> paths = Files.walk(currentDir)) {
            
            paths.filter(path -> path.getFileName().toString().equals(args[0])).forEach(path -> {
                System.out.println(path);
                isFound[0] = true;
            });

            if (!isFound[0]) {
                System.out.println("No matching files or directories found");
            }
        }
        catch (IOException e) {
            System.out.println("Error in searching: " + e.getMessage());
        }
    }
}