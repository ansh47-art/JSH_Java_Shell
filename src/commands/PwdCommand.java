package commands;

import shell.Shell;

public class PwdCommand implements Command {
    private final Shell sh;

    public PwdCommand(Shell sh) {
        this.sh = sh;
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 0) {
            System.out.println("Error: pwd does not accept arguments!");
            return;
        }

        System.out.println(sh.getCurrentDirectory());
    }

}