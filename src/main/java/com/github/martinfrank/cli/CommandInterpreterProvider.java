package com.github.martinfrank.cli;

public interface CommandInterpreterProvider {

    void stopCli();

    void startCli();

    CommandInterpreter getCommandInterpreter();

}
