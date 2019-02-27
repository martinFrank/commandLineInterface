package de.elite.games.cli;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class CommandLineInteraction implements CommandLineInterpreter {

    private static final String COMMAND_SEPARATOR = " ";
    private final CommandLineInterpreter cli;
    private final CommandLineInteractionInterpreter commandLineInteractionInterpreter;
    private final InputStream input;
    private final PrintStream output;
    private boolean isRunning = true;

    public CommandLineInteraction(CommandLineInterpreter cli, InputStream input, PrintStream output) {
        commandLineInteractionInterpreter = new CommandLineInteractionInterpreter(this);
        if (cli == null || commandLineInteractionInterpreter.hasCommandInCommon(cli)) {
            throw new RuntimeException("CommandLineInterpreter interface of " + cli + " is not properly implemented");
        }
        this.cli = cli;
        this.input = input;
        this.output = output;
    }

    @Override
    public Set<Command> getCommands() {
        return commandLineInteractionInterpreter.getCommands();
    }

    public void start() {
        Scanner scanner = new Scanner(input);
        showHelp();
        while (isRunning) {
            output.print("$>");
            String line1 = scanner.nextLine();
            List<String> words = Arrays.asList(line1.split(COMMAND_SEPARATOR));
            String identifier = words.get(0);
            List<String> parameters = words.subList(1, words.size());
            Optional<Command> command = findCommand(identifier);
            if (command.isPresent()) {
                Response response = command.get().execute(parameters);
                if (response.failed()) {
                    output.println(response);
                }
            } else {
                showHelp();
            }
        }
    }

    private Optional<Command> findCommand(String identifier) {
        return getAllCommands().stream().filter(c -> c.isIdentifier(identifier)).findAny();
    }

    private Set<Command> getAllCommands() {
        Set<Command> commands = cli.getCommands();
        commands.addAll(commandLineInteractionInterpreter.getCommands());
        return commands;
    }

    public void showHelp() {
        Set<Command> commands = getAllCommands();
        output.println("help - these commands are available:");
        commands.forEach(c -> output.printf(" - %s\n", c.getIdentifier()));
    }

    public void stop() {
        isRunning = false;
    }
}
