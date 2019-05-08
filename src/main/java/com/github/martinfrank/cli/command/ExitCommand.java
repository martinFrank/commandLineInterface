package com.github.martinfrank.cli.command;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.CommandLineInterpreter;
import com.github.martinfrank.cli.Response;

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
