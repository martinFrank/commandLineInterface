package com.github.martinfrank.cli.command;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.Response;
import com.github.martinfrank.cli.TestApp;

import java.util.List;

public class FaultyCommand extends Command<TestApp> {

    public FaultyCommand(TestApp application) {
        super(application, "faulty");
    }

    @Override
    public Response execute(List<String> parameter) {
        return Response.fail("always fails");
    }
}
