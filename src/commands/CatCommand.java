package commands;

import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import shell.Shell;

public class CatCommand implements Command{
    private final Shell sh;

    public CatCommand (Shell sh) {
        this.sh = sh;
    }

    @Override
    public void execute (String[] args) {
        if (args.length == 0) {
            System.out.println("Error: cat needs atleast one argument!");
            return;
        }

        for (String fileName : args) {
            Path filePath = sh.getCurrentDirectory().resolve(fileName).normalize();

            try {
                String content = Files.readString(filePath);
                System.out.println(content);
            } 
            catch (IOException e) {
                System.out.println("Error: " + fileName + " doesn't exist in the current dir!");
            }
        }
    }
}