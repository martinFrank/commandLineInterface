package de.elite.games.cli.command;

import de.elite.games.cli.Command;
import de.elite.games.cli.CommandLineInterpreter;
import de.elite.games.cli.Response;

import java.util.List;

public class HelpCommand extends Command<CommandLineInterpreter> {

    public HelpCommand(CommandLineInterpreter commandLineInterpreter) {
        super(commandLineInterpreter, "help");
    }

    @Override
    public Response execute(List<String> parameter) {
        getApplication().showHelp();
        return Response.success();
    }
}
