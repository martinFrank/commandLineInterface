package de.elite.games.cli.example;

import de.elite.games.cli.DefaultCommandLineInterpreter;

public class ExampleInterpreter extends DefaultCommandLineInterpreter {

    ExampleInterpreter(ExampleApplication app) {
        registerCommand(new ExecuteExampleMethodCommand(app));
        //TODO - add some more commands
    }

}
