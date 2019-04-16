package de.elite.games.cli;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CommandLineInterpreter implements CommandProvider {

    private static final String COMMAND_SEPARATOR = " ";
    private static final String COMMAND_PROMPT = "$>";
    private final CommandProvider commandProvider;
    private final CommandLineInterpreterCommandProvider interpreterCommands;
    private final InputStream input;
    private final PrintStream output;
    private boolean isRunning = true;

    public CommandLineInterpreter(CommandProvider commandProvider, InputStream input, PrintStream output) {
        interpreterCommands = new CommandLineInterpreterCommandProvider(this);
        if (commandProvider == null || interpreterCommands.hasCommandInCommon(commandProvider)) {
            throw new RuntimeException("CommandProvider interface of " + commandProvider + " is not properly implemented");
        }
        this.commandProvider = commandProvider;
        this.input = input;
        this.output = output;
    }

    @Override
    public CommandList getCommands() {
        return interpreterCommands.getCommands();
    }

    public void start() {
        Scanner scanner = new Scanner(input);
        showHelp();
        while (isRunning) {
            output.print(COMMAND_PROMPT);
            String line = scanner.nextLine();
            List<String> words = Arrays.asList(line.split(COMMAND_SEPARATOR));
            String identifier = words.get(0);
            List<String> parameters = words.subList(1, words.size());

            Optional<Command> command = getAllCommands().findCommand(identifier);
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

    public void stop() {
        isRunning = false;
    }

    public void showHelp() {
        CommandList commands = getAllCommands();
        output.println("help - these commands are available:");
        commands.asList().forEach(c -> output.printf(" - %s%n", c.getIdentifier()));
    }

    private CommandList getAllCommands() {
        CommandList commands = new DefaultCommandList();
        commands.addAll(commandProvider.getCommands());
        commands.addAll(interpreterCommands.getCommands());
        return commands;
    }


}
