package com.github.martinfrank.cli.command;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.CommandLineInterpreter;
import com.github.martinfrank.cli.Response;

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
