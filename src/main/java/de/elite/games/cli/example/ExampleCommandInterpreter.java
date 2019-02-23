package de.elite.games.cli.example;

import de.elite.games.cli.BaseCommandLineInterpreter;
import de.elite.games.cli.Command;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ExampleCommandInterpreter extends BaseCommandLineInterpreter<ExampleApplication> {

    ExampleCommandInterpreter(ExampleApplication exampleApplication) {
        super(exampleApplication);
    }

    @Override
    public Set<Command<ExampleApplication>> getCommands() {
        return new HashSet<>(Collections.singleton(new ExecuteExampleMethodCommand()));
    }
}
