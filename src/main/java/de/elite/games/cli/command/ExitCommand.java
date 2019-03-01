package de.elite.games.cli.command;

import de.elite.games.cli.Command;
import de.elite.games.cli.CommandLineInterpreter;
import de.elite.games.cli.Response;

import java.util.List;

public class ExitCommand extends Command<CommandLineInterpreter> {

    public ExitCommand(CommandLineInterpreter commandLineInterpreter) {
        super(commandLineInterpreter, "exit");
    }

    @Override
    public Response execute(List<String> parameter) {
        getApplication().stop();
        return Response.success();
    }
}
