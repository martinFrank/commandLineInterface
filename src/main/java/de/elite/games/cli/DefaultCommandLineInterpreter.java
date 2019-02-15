package de.elite.games.cli;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class DefaultCommandLineInterpreter implements CommandLineInterpreter {

    private Set<Command> commands = new HashSet<>();

    @Override
    public Set<Command> getCommands() {
        return commands;
    }

    @Override
    public Response executeCommand(String identifier, List<String> parameter) {
        Optional<Command> command = commands.stream().filter(cmd -> cmd.isIdentifier(identifier)).findFirst();
        if (command.isPresent()) {
            return command.get().execute(parameter);
        }
        return Response.fail("executeCommand failed", "identifier '" + identifier + "' matches to no command");
    }

    public void registerCommand(Command command) {
        commands.add(command);
    }
}
