package de.elite.games.cli.command;

import de.elite.games.cli.Command;
import de.elite.games.cli.CommandLineInterface;
import de.elite.games.cli.Response;

import java.util.List;

public class ExitCommand extends Command<CommandLineInterface> {

    public ExitCommand(CommandLineInterface commandLineInterface) {
        super(commandLineInterface, "exit");
    }

    @Override
    public Response execute(List<String> parameter) {
        getApplication().stop();
        return Response.success();
    }
}
