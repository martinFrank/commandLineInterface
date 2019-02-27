package de.elite.games.cli;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ComandLineInteraction implements CommandLineInterpreter {

    private static final String COMMAND_SEPARATOR = " ";
    private final CommandLineInterpreter cli;
    private final CommandLineInterfaceInterpreter commandLineInterfaceInterpreter;
    private final InputStream input;
    private final PrintStream output;
    private boolean isRunning = true;

    public ComandLineInteraction(CommandLineInterpreter cli, InputStream input, PrintStream output) {
        commandLineInterfaceInterpreter = new CommandLineInterfaceInterpreter(this);
        if (cli == null || commandLineInterfaceInterpreter.hasCommandInCommon(cli)) {
            throw new RuntimeException("CommandLineInterpreter interface of " + cli + " is not properly implemented");
        }
        this.cli = cli;
        this.input = input;
        this.output = output;
    }

    @Override
    public Set<Command> getCommands() {
        return commandLineInterfaceInterpreter.getCommands();
    }

    @Override
    public Response executeCommand(String identifier, List<String> parameter) {
        return commandLineInterfaceInterpreter.executeCommand(identifier, parameter);
    }

    public void start() {
        Scanner scanner = new Scanner(input);
        showHelp();
        while (isRunning) {
            output.print("$>");
            String command = scanner.nextLine();
            List<String> line = Arrays.asList(command.split(COMMAND_SEPARATOR));
            String identifier = line.get(0);
            List<String> parameters = line.subList(1, line.size());
            if (isExecutableCommand(identifier)) {
                Response response = executeCommand(identifier, parameters);
                if (response.failed()) {
                    output.println(response);
                }
            } else {
                showHelp();
            }
        }
    }

    private boolean isExecutableCommand(String identifier) {
        return getAllCommands().stream().anyMatch(c -> c.isIdentifier(identifier));
    }

    void showHelp() {
        Set<Command> commands = getAllCommands();
        output.println("help - these commands are available:");
        commands.forEach(c -> output.printf(" - %s\n", c.getIdentifier()));
    }

    private Set<Command> getAllCommands() {
        Set<Command> commands = cli.getCommands();
        commands.addAll(getCommands());
        return commands;
    }

    void stop() {
        isRunning = false;
    }
}
