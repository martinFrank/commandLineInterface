package de.elite.games.cli;

import java.util.List;
import java.util.Objects;

public abstract class Command<M> {

    private final String identifier;

    public Command(String identifier) {
        this.identifier = identifier;
    }

    public abstract Response execute(M invoked, List<String> parameter);

    public String getIdentifier() {
        return identifier;
    }

    public boolean isIdentifier(String ident) {
        return identifier.equals(ident);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return Objects.equals(identifier, command.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }
}
