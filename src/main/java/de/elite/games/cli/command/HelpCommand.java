package de.elite.games.cli.command;

import de.elite.games.cli.Command;
import de.elite.games.cli.CommandLineInterface;
import de.elite.games.cli.Response;

import java.util.List;

public class HelpCommand extends Command<CommandLineInterface> {

    public HelpCommand(CommandLineInterface commandLineInteraction) {
        super(commandLineInteraction, "help");
    }

    @Override
    public Response execute(List<String> parameter) {
        getApplication().showHelp();
        return Response.success();
    }
}
