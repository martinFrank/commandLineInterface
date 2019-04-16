package de.elite.games.cli;

import java.util.List;

public class FaultyApplication implements CommandProvider {

    @Override
    public CommandList getCommands() {
        DefaultCommandList commandList = new DefaultCommandList();
        FaultyCommand faultyCommand = new FaultyCommand(this);
        commandList.add(faultyCommand);
        return commandList;
    }

    private class FaultyCommand extends Command<FaultyApplication> {

        public FaultyCommand(FaultyApplication application) {
            super(application, "exit"); //thats not allowed
        }

        @Override
        public Response execute(List<String> parameter) {
            return Response.success();
        }
    }
}
