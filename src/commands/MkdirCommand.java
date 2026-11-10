package commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import shell.Shell;



public class MkdirCommand implements Command {
    private final Shell sh;

    public MkdirCommand (Shell sh) {
        this.sh = sh;
    }

    @Override
    public void execute (String[] args) {
        if (args.length == 0) {
            System.out.println("Error: Directory name is required!");
            return;
        }

        for (String dirName : args) {
            Path path = sh.getCurrentDirectory().resolve(dirName).normalize();

            try {
                Files.createDirectory(path);
            } 
            catch (IOException e) {
                System.out.println("Error: " + dirName + " already exists!");
            }
        }
    }
}