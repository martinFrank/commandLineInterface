package de.elite.games.cli.example;

import de.elite.games.cli.ComandLineInteraction;

public class App {

    public static void main(String[] args) {
        ExampleApplication app = new ExampleApplication();
        ComandLineInteraction comandLineInteraction = new ComandLineInteraction(app, System.in, System.out);
        comandLineInteraction.start();
    }
}
