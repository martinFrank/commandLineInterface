package com.github.martinfrank.cli;

import com.github.martinfrank.cli.command.ExitCommand;
import com.github.martinfrank.cli.command.HelpCommand;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CommandLineInterpreterCommandProvider implements CommandProvider {

    private final DefaultCommandList commandList;

    CommandLineInterpreterCommandProvider(CommandLineInterpreter interpreter) {
        super();
        commandList = new DefaultCommandList();
        commandList.add(new HelpCommand(interpreter));
        commandList.add(new ExitCommand(interpreter));

    }

    @Override
    public CommandList getCommands() {
        return commandList;
    }

    boolean hasCommandInCommon(CommandProvider cip) {
        List<String> cipCommands = cip.getCommands().asList().stream().
                map(Command::getIdentifier).collect(Collectors.toList());
        List<String> selfCommands = getCommands().asList().stream().
                map(Command::getIdentifier).collect(Collectors.toList());
        return !Collections.disjoint(selfCommands, cipCommands);
    }

}
