package de.elite.games.cli.example;

import de.elite.games.cli.CommandLineInterpreter;
import de.elite.games.cli.CommandMapping;
import de.elite.games.cli.DefaultCommandMapping;
import de.elite.games.cli.example.command.CountCommand;
import de.elite.games.cli.example.command.ExecuteExampleMethodCommand;

public class ExampleCommandInterpreter implements CommandLineInterpreter {

    private final DefaultCommandMapping commands;

    ExampleCommandInterpreter(ExampleApplication exampleApplication) {
        super();
        commands = new DefaultCommandMapping();
        commands.add(new ExecuteExampleMethodCommand(exampleApplication));
        commands.add(new CountCommand(exampleApplication));

    }

    @Override
    public CommandMapping getCommands() {
        return commands;
    }
}
