package de.elite.games.cli.example;

import de.elite.games.cli.CommandLineInterface;

public class App {

    public static void main(String[] args) {
        ExampleApplication app = new ExampleApplication();
        CommandLineInterface commandLineInterpreter = new CommandLineInterface(app, System.in, System.out);
        commandLineInterpreter.start();
    }
}
