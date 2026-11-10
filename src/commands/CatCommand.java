package commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import shell.Shell;

public class CatCommand implements Command{
    private final Shell sh;

    public CatCommand (Shell sh) {
        this.sh = sh;
    }

    @Override
    public void execute (String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: cat <file_name> [file_name ...]");
            return;
        }

        for (String fileName : args) {
            Path filePath = sh.getCurrentDirectory().resolve(fileName).normalize();

            try {
                String content = Files.readString(filePath);
                System.out.println(content);
            } 
            catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}