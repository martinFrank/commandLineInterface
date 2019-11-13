package com.github.martinfrank.cli;

import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.Scanner;

public class CliTest {

    @Test
    public void testCommands() throws UnsupportedEncodingException {
        TestApp testApp = new TestApp();
        try (Scanner scanner = new Scanner(Objects.requireNonNull(
                getClass().getClassLoader().getResourceAsStream("commands.txt")))) {
            testApp.getCommandInterpreter().setScanner(scanner);
            testApp.getCommandInterpreter().start();
        }
        Assert.assertFalse(testApp.getCommandInterpreter().isRunning());
    }

}
