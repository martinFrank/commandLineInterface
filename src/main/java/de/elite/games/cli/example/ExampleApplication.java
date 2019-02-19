package de.elite.games.cli.example;

import de.elite.games.cli.Command;
import de.elite.games.cli.CommandLineInterpreter;
import de.elite.games.cli.Response;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ExampleApplication implements CommandLineInterpreter<ExampleApplication> {


    private Set<Command<ExampleApplication>> commands = new HashSet<>();

    ExampleApplication() {
        commands.add(new ExecuteExampleMethodCommand());
    }

    boolean exampleMethod(List<String> parameter) {
        System.out.println("i could do some actual work now if i were not a mere example, parameter " + parameter);
        return true;
    }

    @Override
    public Set<Command<ExampleApplication>> getCommands() {
        return commands;
    }

    @Override
    public Response executeCommand(String identifier, List<String> parameter) {
        Optional<Command<ExampleApplication>> command = commands.stream().filter(cmd -> cmd.isIdentifier(identifier)).findFirst();
        if (command.isPresent()) {
            return command.get().execute(this, parameter);
        }
        return Response.fail("executeCommand failed", "identifier '" + identifier + "' matches to no command");
    }

}
