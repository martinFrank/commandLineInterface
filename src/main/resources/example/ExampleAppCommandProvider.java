package de.elite.games.cli.example;

import de.elite.games.cli.CommandList;
import de.elite.games.cli.CommandProvider;
import de.elite.games.cli.DefaultCommandList;
import de.elite.games.cli.example.command.CountCommand;
import de.elite.games.cli.example.command.ExecuteExampleMethodCommand;

public class ExampleAppCommandProvider implements CommandProvider {

    private final DefaultCommandList commands;

    ExampleAppCommandProvider(ExampleApplication exampleApplication) {
        super();
        commands = new DefaultCommandList();
        commands.add(new ExecuteExampleMethodCommand(exampleApplication));
        commands.add(new CountCommand(exampleApplication));

    }

    @Override
    public CommandList getCommands() {
        return commands;
    }
}
