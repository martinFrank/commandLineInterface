package com.github.martinfrank.cli.command;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.Response;
import com.github.martinfrank.cli.TestApp;

import java.util.List;

public class ExitCommand extends Command<TestApp> {

    public ExitCommand(TestApp application) {
        super(application, "exit");
    }

    @Override
    public Response execute(List<String> parameter) {
        getApplication().stopCli();
        return Response.success();
    }
}
