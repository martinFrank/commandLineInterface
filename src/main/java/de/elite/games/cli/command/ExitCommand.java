package de.elite.games.cli.command;

import de.elite.games.cli.Command;
import de.elite.games.cli.CommandLineInteraction;
import de.elite.games.cli.Response;

import java.util.List;

public class ExitCommand extends Command<CommandLineInteraction> {

    public ExitCommand(CommandLineInteraction commandLineInteraction) {
        super(commandLineInteraction, "exit");
    }

    @Override
    public Response execute(List<String> parameter) {
        getApplication().stop();
        return Response.success();
    }
}
