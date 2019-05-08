package com.github.martinfrank.cli.example;

import com.github.martinfrank.cli.CommandLineInterpreter;

public class App {

    public static void main(String[] args) {
        ExampleApplication app = new ExampleApplication();
        CommandLineInterpreter commandLineInterface = new CommandLineInterpreter(app, System.in, System.out);
        commandLineInterface.start();
    }
}
