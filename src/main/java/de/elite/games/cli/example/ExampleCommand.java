package de.elite.games.cli.example;

import de.elite.games.cli.Command;

public abstract class ExampleCommand extends Command {

    private final ExampleApplication app;

    ExampleCommand(ExampleApplication app, String identifier) {
        super(identifier);
        this.app = app;
    }

    ExampleApplication getApp() {
        return app;
    }
}
