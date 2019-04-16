package de.elite.games.cli.example.command;

import de.elite.games.cli.Command;
import de.elite.games.cli.Response;
import de.elite.games.cli.example.ExampleApplication;

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
