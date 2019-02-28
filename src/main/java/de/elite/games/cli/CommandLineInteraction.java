package de.elite.games.cli;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CommandLineInteraction implements CommandLineInterpreter {

    private static final String COMMAND_SEPARATOR = " ";
    private static final String COMMAND_PROMPT = "$>";
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
    public CommandMapping getCommands() {
        return commandLineInteractionInterpreter.getCommands();
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
        CommandMapping commands = getAllCommands();
        output.println("help - these commands are available:");
        commands.asList().forEach(c -> output.printf(" - %s\n", c.getIdentifier()));
    }

    private CommandMapping getAllCommands() {
        CommandMapping commands = new DefaultCommandMapping();
        commands.addAll(cli.getCommands());
        commands.addAll(commandLineInteractionInterpreter.getCommands());
        return commands;
    }
}
