package de.elite.games.cli;

import de.elite.games.cli.example.ExampleApplication;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
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

    @Test
    public void testAllCommands() throws UnsupportedEncodingException {
        InputStream is = new ByteArrayInputStream("help\nexampleCommand\ncount 1 3\nexit".getBytes(Charset.defaultCharset()));
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (PrintStream ps = new PrintStream(baos, true, Charset.defaultCharset().toString())) {
            ExampleApplication app = new ExampleApplication();
            CommandLineInterpreter commandLineInterface = new CommandLineInterpreter(app, is, ps);
            commandLineInterface.start();
            Assert.assertTrue(app.getCountResult().contains("[1, 2, 3]"));
        }
        //no exception - thats good, test passed
    }
}
