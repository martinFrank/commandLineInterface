package com.github.martinfrank.cli.example.command;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.Response;
import com.github.martinfrank.cli.example.ExampleApplication;

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
