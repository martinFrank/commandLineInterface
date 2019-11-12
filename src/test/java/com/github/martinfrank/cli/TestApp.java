package com.github.martinfrank.cli;

import com.github.martinfrank.cli.command.ExitCommand;
import com.github.martinfrank.cli.command.FaultyCommand;

public class TestApp implements CommandProvider, CommandInterpreterProvider {

    private final CommandInterpreter testCommandInterpreter;
    private final DefaultCommandList commandList;

    public TestApp() {
        testCommandInterpreter = new CommandInterpreter(this);
        commandList = new DefaultCommandList();
        commandList.add(new ExitCommand(this));
        commandList.add(new FaultyCommand(this));
    }

    @Override
    public CommandList getCommands() {
        return commandList;
    }

    @Override
    public void stopCli() {
        testCommandInterpreter.stop();
    }

    @Override
    public void startCli() {
        testCommandInterpreter.start();
    }

    @Override
    public CommandInterpreter getCommandInterpreter() {
        return testCommandInterpreter;
    }

}
