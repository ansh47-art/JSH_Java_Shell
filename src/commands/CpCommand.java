package commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import shell.Shell;


public class CpCommand implements Command {
    private final Shell sh;

    public CpCommand (Shell sh) {
        this.sh = sh;
    }

    @Override
    public void execute (String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: cp <source1> [source2 ...] <destination>");
            return;
        }

        Path destinationPath = sh.getCurrentDirectory().resolve(args[args.length-1]).normalize();

        if (args.length > 2 && !Files.isDirectory(destinationPath)) {
            System.out.println("Error: Destination should be a directory!");
            return;
        }

        for (int i = 0; i < args.length-1; i++) {
            Path sourcePath = sh.getCurrentDirectory().resolve(args[i]).normalize();
            
            try {
                if (Files.isDirectory(destinationPath)) {
                    destinationPath = destinationPath.resolve(sourcePath.getFileName());
                }
                Files.copy(sourcePath, destinationPath);

                destinationPath = sh.getCurrentDirectory().resolve(args[args.length-1]).normalize();
            }
            catch (IOException e) {
                System.out.println("Error in copying file: " + e.getMessage());
            }
        }
    }
}