package de.elite.games.cli.example.command;

import de.elite.games.cli.Command;
import de.elite.games.cli.Response;
import de.elite.games.cli.example.ExampleApplication;

import java.util.List;

public class ExecuteExampleMethodCommand extends Command<ExampleApplication> {

    public ExecuteExampleMethodCommand(ExampleApplication exampleApplication) {
        super(exampleApplication, "exampleCommand");
    }

    @Override
    public Response execute(List<String> parameter) {
        boolean wasSuccessful = getApplication().exampleMethod(parameter);
        return wasSuccessful ? Response.success() : Response.fail("couldn't invoke method");
    }
}
