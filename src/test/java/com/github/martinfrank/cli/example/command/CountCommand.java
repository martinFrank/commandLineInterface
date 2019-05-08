package com.github.martinfrank.cli.example.command;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.Response;
import com.github.martinfrank.cli.example.ExampleApplication;

import java.util.List;

public class CountCommand extends Command<ExampleApplication> {

    public CountCommand(ExampleApplication exampleApplication) {
        super(exampleApplication, "count");
    }

    @Override
    public Response execute(List<String> parameter) {
        return getApplication().count(parameter) ? Response.success() : Response.fail("error executing count command");
    }
}
