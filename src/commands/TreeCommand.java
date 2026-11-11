package commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import shell.Shell;

public class TreeCommand implements Command {
    private final Shell sh;

    public TreeCommand (Shell sh) {
        this.sh = sh;
    }

    private void displayTree(Path root, String in) {
        try (Stream <Path> paths = Files.list(root)) {
            paths.forEach(path -> {
                System.out.println(in + "|-- " + path.getFileName());

                if (Files.isDirectory(path)) {
                    displayTree(path, in + "    ");
                }
            });
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void execute (String[] args) {
        if (args.length != 0) {
            System.out.println("Usage: tree");
            return;
        }

        Path root = sh.getCurrentDirectory();

        System.out.println(root.getFileName());

        displayTree(root, "");
    }
}