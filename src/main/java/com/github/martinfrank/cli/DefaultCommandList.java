package com.github.martinfrank.cli;

import java.util.*;

public class DefaultCommandList implements CommandList {

    private final Map<String, Command> commands = new HashMap<>();

    public void add(Command command) {
        commands.put(command.getIdentifier(), command);
    }

    @Override
    public List<Command> asList() {
        List<Command> list = new ArrayList<>(commands.values());
        list.sort(Comparator.comparing(Command::getIdentifier));
        return list;
    }

    @Override
    public void addAll(CommandList commands) {
        commands.asList().forEach(this::add);
    }

    @Override
    public Optional<Command> findCommand(String identifier) {
        return Optional.ofNullable(commands.get(identifier));
    }

    @Override
    public boolean hasCommands(String... commands) {
        for (String command : commands) {
            if (!findCommand(command).isPresent()) {
                return false;
            }
        }
        return true;
    }
}
