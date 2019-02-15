package de.elite.games.cli.example;

import de.elite.games.cli.Response;

import java.util.List;

class ExecuteExampleMethodCommand extends ExampleCommand {

    public ExecuteExampleMethodCommand(ExampleApplication app) {
        super(app, "exampleCommand");
    }

    @Override
    public Response execute(List<String> parameter) {
        return getApp().doAnExample(parameter);
    }
}
