package com.github.martinfrank.cli.example;

import com.github.martinfrank.cli.CommandList;
import com.github.martinfrank.cli.CommandProvider;
import com.github.martinfrank.cli.DefaultCommandList;
import com.github.martinfrank.cli.example.command.CountCommand;
import com.github.martinfrank.cli.example.command.ExecuteExampleMethodCommand;

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
