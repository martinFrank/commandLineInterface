package de.elite.games.cli;

import de.elite.games.cli.command.ExitCommand;
import de.elite.games.cli.command.HelpCommand;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CommandLineInteractionInterpreter implements CommandLineInterpreter {

    private final Set<Command> cliCommands;

    CommandLineInteractionInterpreter(CommandLineInteraction commandLineInterface) {
        super();
        cliCommands = new HashSet<>();
        cliCommands.add(new HelpCommand(commandLineInterface));
        cliCommands.add(new ExitCommand(commandLineInterface));
    }

    @Override
    public Set<Command> getCommands() {
        return cliCommands;
    }

    boolean hasCommandInCommon(CommandLineInterpreter cip) {
        return !Collections.disjoint(cip.getCommands(), getCommands());
    }

}
