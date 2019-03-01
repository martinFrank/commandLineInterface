package de.elite.games.cli;

import java.util.List;
import java.util.Optional;

public interface CommandList {

    List<Command> asList();

    void addAll(CommandList commands);

    Optional<Command> findCommand(String identifier);

    boolean hasCommands(String... commands);
}
