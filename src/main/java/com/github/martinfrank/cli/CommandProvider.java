package com.github.martinfrank.cli;

public interface CommandProvider {

    CommandList getCommands();

    void stopCli();

    void startCli();

    CommandInterpreter getCommandInterpreter();

    void setCommandInterpreter(CommandInterpreter commandInterpreter);
}
