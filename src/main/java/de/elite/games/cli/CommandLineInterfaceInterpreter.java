package de.elite.games.cli;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommandLineInterfaceInterpreter extends BaseCommandLineInterpreter<ComandLineInteraction> {


    CommandLineInterfaceInterpreter(ComandLineInteraction commandLineInterface) {
        super(commandLineInterface);
    }

    @Override
    public Set<Command> getCommands() {
        Set<Command> cliCommands = new HashSet<>();
        cliCommands.add(new Command<ComandLineInteraction>("exit") {
            @Override
            public Response execute(ComandLineInteraction commandLineInterface, List<String> parameter) {
                commandLineInterface.stop();
                return Response.success();
            }
        });
        cliCommands.add(new Command<ComandLineInteraction>("help") {
            @Override
            public Response execute(ComandLineInteraction commandLineInterface, List<String> parameter) {
                commandLineInterface.showHelp();
                return Response.success();
            }
        });
        return cliCommands;
    }

    @Override
    public Response executeCommand(String identifier, List<String> parameter) {
        return null;
    }

    boolean hasCommandInCommon(CommandLineInterpreter cip) {
        return !Collections.disjoint(cip.getCommands(), getCommands());
    }
}
