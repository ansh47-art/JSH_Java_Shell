package commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import shell.Shell;


public class MvCommand implements Command {
    private final Shell sh;

    public MvCommand (Shell sh) {
        this.sh = sh;
    }

    @Override
    public void execute (String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: mv <source> <destination>");
            return;
        }

        Path sourcePath = sh.getCurrentDirectory().resolve(args[0]).normalize();
        Path destinationPath = sh.getCurrentDirectory().resolve(args[1]).normalize();

        if (Files.isDirectory(destinationPath)) {
            destinationPath = destinationPath.resolve(sourcePath.getFileName());
        }

        try {
            Files.move(sourcePath, destinationPath);
        }
        catch (IOException e) {
            System.out.println("Error in moving file: " + e.getMessage());
        } 
    }
}