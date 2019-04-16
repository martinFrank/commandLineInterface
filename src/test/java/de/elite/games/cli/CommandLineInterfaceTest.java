package de.elite.games.cli;

import de.elite.games.cli.example.ExampleApplication;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CommandLineInterfaceTest {

    @Test
    public void testCommands() {

        ExampleApplication app = new ExampleApplication();
        CommandLineInterpreter commandLineInterface = new CommandLineInterpreter(app, System.in, System.out);
        List<Command> exampleAppComands = app.getCommands().asList();
        Assert.assertEquals(2, exampleAppComands.size()); //we added two commands

        List<Command> cliCommands = commandLineInterface.getCommands().asList();
        Assert.assertEquals(2, cliCommands.size()); //two internal

    }
}
