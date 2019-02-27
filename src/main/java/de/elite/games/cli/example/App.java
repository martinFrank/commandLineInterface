package de.elite.games.cli.example;

import de.elite.games.cli.CommandLineInteraction;

public class App {

    public static void main(String[] args) {
        ExampleApplication app = new ExampleApplication();
        CommandLineInteraction commandLineInteraction = new CommandLineInteraction(app, System.in, System.out);
        commandLineInteraction.start();
    }
}
