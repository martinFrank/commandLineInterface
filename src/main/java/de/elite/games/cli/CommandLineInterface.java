package de.elite.games.cli;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class CommandLineInterface implements CommandLineInterpreter<CommandLineInterface> {

    private static final String COMMAND_SEPARATOR = " ";
    private final CommandLineInterpreter cli;
    private final InputStream input;
    private final PrintStream output;
    private boolean isRunning = true;

    public CommandLineInterface(CommandLineInterpreter<?> cli, InputStream input, PrintStream output) {
        if (cli == null || hasPredefinedCommands(cli.getCommands())) {
            throw new RuntimeException("CommandLineInterpreter interface of " + cli + " is not properly implemented");
        }
        this.cli = cli;
        this.input = input;
        this.output = output;
    }

    private boolean hasPredefinedCommands(Set<? extends Command<?>> commands) {
        return !Collections.disjoint(commands, getCommands());
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
                    showResponse(response);
                }
            } else {
                showHelp();
            }
        }
    }

    private boolean isExecutableCommand(String identifier) {
        for (Command cmd : getAllCommands()) {
            if (cmd.isIdentifier(identifier)) {
                return true;
            }
        }
        return false;
    }

    private void showHelp() {
        Set<Command<?>> commands = getAllCommands();
        output.println("help - these commands are availible:");
        commands.forEach(c -> output.printf(" - %s\n", c.getIdentifier()));
    }

    private void showResponse(Response response) {
        output.println(response);
    }

    @Override
    public Set<Command<CommandLineInterface>> getCommands() {
        Set<Command<CommandLineInterface>> cliCommands = new HashSet<>();
        cliCommands.add(new Command<CommandLineInterface>("exit") {
            @Override
            public Response execute(CommandLineInterface commandLineInterface, List<String> parameter) {
                isRunning = false;
                return Response.success();
            }
        });
        cliCommands.add(new Command<CommandLineInterface>("help") {
            @Override
            public Response execute(CommandLineInterface commandLineInterface, List<String> parameter) {
                showHelp();
                return Response.success();
            }
        });
        return cliCommands;
    }

    private Set<Command<?>> getAllCommands() {
        Set<Command<?>> commands = mapCommands(cli.getCommands());
        commands.addAll(getCommands());
        return commands;
    }

    private Set<Command<?>> mapCommands(Set commands) {
        Set<Command<?>> mappedCommands = new HashSet<>();
        for (Object o : commands) mapCommand(o).ifPresent(mappedCommands::add);
        return mappedCommands;
    }

    private Optional<Command<?>> mapCommand(Object o) {
        return (o instanceof Command<?>) ? Optional.of((Command<?>) o) : Optional.empty();
    }

    @Override
    public Response executeCommand(String identifier, List<String> parameter) {
        Optional<Command<CommandLineInterface>> cmd = getCommands().stream().filter(command -> command.isIdentifier(identifier)).findAny();
        if (cmd.isPresent()) {
            return cmd.get().execute(this, parameter);
        } else {
            return cli.executeCommand(identifier, parameter);
        }
    }


}
