package de.elite.games.cli;

import de.elite.games.cli.command.ExitCommand;
import de.elite.games.cli.command.HelpCommand;

import java.util.Collections;

public class CommandLineInterpreterCommandProvider implements CommandProvider {

    private final DefaultCommandList commandList;

    CommandLineInterpreterCommandProvider(CommandLineInterpreter interpreter) {
        super();
        commandList = new DefaultCommandList();
        commandList.add(new HelpCommand(interpreter));
        commandList.add(new ExitCommand(interpreter));

    }

    @Override
    public CommandList getCommands() {
        return commandList;
    }

    boolean hasCommandInCommon(CommandProvider cip) {
        return !Collections.disjoint(cip.getCommands().asList(), getCommands().asList());
    }

}
