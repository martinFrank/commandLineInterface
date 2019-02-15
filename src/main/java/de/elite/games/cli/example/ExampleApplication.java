package de.elite.games.cli.example;

import de.elite.games.cli.Command;
import de.elite.games.cli.CommandLineInterpreter;
import de.elite.games.cli.Response;

import java.util.List;
import java.util.Set;

public class ExampleApplication implements CommandLineInterpreter {


    private final ExampleInterpreter exampleInterpreter;

    public ExampleApplication() {
        exampleInterpreter = new ExampleInterpreter(this);
    }

    @Override
    public Set<Command> getCommands() {
        return exampleInterpreter.getCommands();
    }

    @Override
    public Response executeCommand(String identifier, List<String> parameter) {
        return exampleInterpreter.executeCommand(identifier, parameter);
    }

    Response doAnExample(List<String> parameter) {
        System.out.println("i could do some actual work now, parameter " + parameter);
        return Response.success();
    }
}
