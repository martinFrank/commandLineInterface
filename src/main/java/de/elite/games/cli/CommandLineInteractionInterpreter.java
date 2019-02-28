package de.elite.games.cli;

import de.elite.games.cli.command.ExitCommand;
import de.elite.games.cli.command.HelpCommand;

import java.util.Collections;

public class CommandLineInteractionInterpreter implements CommandLineInterpreter {

    private final DefaultCommandMapping commandMapping;

    CommandLineInteractionInterpreter(CommandLineInterface commandLineInterface) {
        super();
        commandMapping = new DefaultCommandMapping();
        commandMapping.add(new HelpCommand(commandLineInterface));
        commandMapping.add(new ExitCommand(commandLineInterface));

    }

    @Override
    public CommandMapping getCommands() {
        return commandMapping;
    }

    boolean hasCommandInCommon(CommandLineInterpreter cip) {
        return !Collections.disjoint(cip.getCommands().asList(), getCommands().asList());
    }

}
