package de.elite.games.cli.example;

import de.elite.games.cli.Command;
import de.elite.games.cli.Response;

import java.util.List;

class ExecuteExampleMethodCommand extends Command<ExampleApplication> {

    ExecuteExampleMethodCommand() {
        super("exampleCommand");
    }

    @Override
    public Response execute(ExampleApplication invoked, List<String> parameter) {
        boolean wasSuccessful = invoked.exampleMethod(parameter);
        return wasSuccessful ? Response.success() : Response.fail("couldn't invoke method");
    }
}
