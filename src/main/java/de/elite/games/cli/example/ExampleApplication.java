package de.elite.games.cli.example;

import de.elite.games.cli.CommandLineInterpreter;
import de.elite.games.cli.CommandMapping;

import java.util.List;

public class ExampleApplication implements CommandLineInterpreter {

    private ExampleCommandInterpreter commandLineInterpreter;

    ExampleApplication() {
        commandLineInterpreter = new ExampleCommandInterpreter(this);
    }

    public boolean exampleMethod(List<String> parameter) {
        System.out.println("i could do some actual work now if i were not a mere example, parameter " + parameter);
        return true;
    }

    @Override
    public CommandMapping getCommands() {
        return commandLineInterpreter.getCommands();
    }

}
