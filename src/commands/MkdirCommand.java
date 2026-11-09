package commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;



public class MkdirCommand implements Command {
    @Override
    public void execute (String[] args) {
        if (args.length == 0) {
            System.out.println("Error: Directory name is required!");
            return;
        }

        for (String dirName : args) {
            Path path = Path.of(dirName);

            try {
                Files.createDirectory(path);
            } 
            catch (IOException e) {
                System.out.println("Error occured in creating directory: " + dirName);
            }
        }
    }
}