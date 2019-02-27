package de.elite.games.cli.example;

import de.elite.games.cli.Command;
import de.elite.games.cli.CommandLineInterpreter;
import de.elite.games.cli.Response;

import java.util.List;
import java.util.Set;

public class ExampleApplication implements CommandLineInterpreter {

    private ExampleCommandInterpreter commandLineInterpreter;

    ExampleApplication() {
        commandLineInterpreter = new ExampleCommandInterpreter(this);
    }

    boolean exampleMethod(List<String> parameter) {
        System.out.println("i could do some actual work now if i were not a mere example, parameter " + parameter);
        return true;
    }

    @Override
    public Set<Command> getCommands() {
        return commandLineInterpreter.getCommands();
    }

    @Override
    public Response executeCommand(String identifier, List<String> parameter) {
        return commandLineInterpreter.executeCommand(identifier, parameter);
    }

}
