package de.elite.games.cli;

import java.util.List;
import java.util.Optional;

public interface CommandMapping {

    List<Command> asList();

    void addAll(CommandMapping commands);

    Optional<Command> findCommand(String identifier);

    boolean hasCommands(String... commands);
}
