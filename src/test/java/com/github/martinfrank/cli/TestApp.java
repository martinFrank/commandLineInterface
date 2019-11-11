package com.github.martinfrank.cli;

import com.github.martinfrank.cli.command.ExitCommand;
import com.github.martinfrank.cli.command.FaultyCommand;

public class TestApp implements CommandProvider {

    private final TestCommandInterpreter testCommandInterpreter;
    private final CommandList commandList;

    public TestApp() {
        testCommandInterpreter = new TestCommandInterpreter(this);
        setCommandInterpreter(testCommandInterpreter);
        commandList = new DefaultCommandList();
        ((DefaultCommandList) commandList).add(new ExitCommand(this));
        ((DefaultCommandList) commandList).add(new FaultyCommand(this));
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

    @Override
    public void setCommandInterpreter(CommandInterpreter commandInterpreter) {

    }
}
