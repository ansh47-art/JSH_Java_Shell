package parser;

public class CommandParser {
    public String[] parse(String input) {

        if (input == null || input.trim().isEmpty()) {
            return new String[0];
        }

        String[] parts = input.trim().split("\\s+");

        return parts;
    }
}
