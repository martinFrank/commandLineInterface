package de.elite.games.cli.example;

import de.elite.games.cli.Command;
import de.elite.games.cli.CommandLineInterpreter;
import de.elite.games.cli.example.command.ExecuteExampleMethodCommand;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ExampleCommandInterpreter implements CommandLineInterpreter {

    private final Set<Command> commands;

    ExampleCommandInterpreter(ExampleApplication exampleApplication) {
        super();
        commands = new HashSet<>(Collections.singleton(new ExecuteExampleMethodCommand(exampleApplication)));

    }

    @Override
    public Set<Command> getCommands() {
        return commands;
    }
}
