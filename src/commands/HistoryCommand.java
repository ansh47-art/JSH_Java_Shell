package commands;

import shell.Shell;

public class HistoryCommand implements Command{
    private final Shell sh;

    public HistoryCommand (Shell sh) {
        this.sh = sh;
    }

    @Override
    public void execute (String[] args) {
        if (args.length != 0) {
            System.out.println("Usage: history");
            return;
        }

        sh.getHistoryOfCommands();
    }
}