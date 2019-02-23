package de.elite.games.cli;

import java.util.List;
import java.util.Optional;

public abstract class BaseCommandLineInterpreter<M> implements CommandLineInterpreter<M> {

    private final M m;

    public BaseCommandLineInterpreter(M m) {
        this.m = m;
    }

    public M getApplication() {
        return m;
    }

    @Override
    public Response executeCommand(String identifier, List<String> parameter) {
        Optional<Command<M>> command = getCommands().stream().filter(cmd -> cmd.isIdentifier(identifier)).findFirst();
        if (command.isPresent()) {
            return command.get().execute(m, parameter);
        }
        return Response.fail("executeCommand failed", "identifier '" + identifier + "' matches to no command");
    }
}
