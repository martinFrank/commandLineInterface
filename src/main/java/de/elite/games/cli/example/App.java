package de.elite.games.cli.example;

import de.elite.games.cli.CommandLineInterpreter;

public class App {

    public static void main(String[] args) {
        ExampleApplication app = new ExampleApplication();
        CommandLineInterpreter commandLineInterface = new CommandLineInterpreter(app, System.in, System.out);
        commandLineInterface.start();
    }
}
