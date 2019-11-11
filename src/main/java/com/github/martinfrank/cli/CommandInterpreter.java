package com.github.martinfrank.cli;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CommandInterpreter {

    private static final String COMMAND_SEPARATOR = " ";
    private static final String COMMAND_PROMPT = "$>";
    private final CommandProvider commandProvider;
    private Scanner scanner;
    private final PrintStream output;
    private boolean isRunning = true;

    public CommandInterpreter(CommandProvider commandProvider) {
        this.commandProvider = commandProvider;
        scanner = new Scanner(System.in); //hei - it's a COMMAND LINE interpreter
        this.output = System.out; // what else should we read/write from?
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        while (isRunning) {
            output.print(COMMAND_PROMPT);
            String line = scanner.nextLine();
            List<String> words = Arrays.asList(line.split(COMMAND_SEPARATOR));
            String identifier = words.get(0);
            List<String> parameters = words.subList(1, words.size());

            Optional<Command> command = commandProvider.getCommands().findCommand(identifier);
            if (command.isPresent()) {
                Response response = command.get().execute(parameters);
                if (response.failed()) {
                    output.println(response);
                }
            } else {
                output.println("command '" + identifier + "' not found");
            }
        }
    }

    public void stop() {
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }

}
