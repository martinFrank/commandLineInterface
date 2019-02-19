package de.elite.games.cli;

import java.util.List;
import java.util.Set;

public interface CommandLineInterpreter<M> {

    Set<Command<M>> getCommands();

    Response executeCommand(String identifier, List<String> parameter);

}
