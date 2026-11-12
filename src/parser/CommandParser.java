package parser;

import java.util.ArrayList;

public class CommandParser {
    public String[] parse(String input) {

        if (input == null || input.trim().isEmpty()) {
            return new String[0];
        }

        ArrayList <String> arguments = new ArrayList <> ();
        StringBuilder currentArgument = new StringBuilder();

        boolean insideQuotes = false;
        boolean argumentStarted = false;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '"') {
                insideQuotes = !insideQuotes;
                argumentStarted = true;
            }
            else if (Character.isWhitespace(ch) && !insideQuotes) {
                if (argumentStarted) {
                    arguments.add(currentArgument.toString());
                    currentArgument.setLength(0);
                    argumentStarted = false;
                }
            }
            else {
                currentArgument.append(ch);
                argumentStarted = true;
            }
        }

        if (insideQuotes) {
            throw new IllegalArgumentException("Unclosed Quotation Mark");
        }

        if (argumentStarted) {
            arguments.add(currentArgument.toString());
        }

        return arguments.toArray(new String[0]);
    }
}
