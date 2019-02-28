package de.elite.games.cli;

import java.util.*;

public class DefaultCommandMapping implements CommandMapping {

    private final Map<String, Command> commands = new HashMap<>();

    public void add(Command command) {
        commands.put(command.getIdentifier(), command);
    }

    @Override
    public List<Command> asList() {
        return new ArrayList(commands.entrySet());
    }

    @Override
    public void addAll(CommandMapping commands) {
        commands.asList().stream().forEach(this::add);
    }

    @Override
    public Optional<Command> findCommand(String identifier) {
        return Optional.ofNullable(commands.get(identifier));
    }
}
