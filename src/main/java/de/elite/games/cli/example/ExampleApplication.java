package de.elite.games.cli.example;

import de.elite.games.cli.CommandLineInterpreter;
import de.elite.games.cli.CommandMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ExampleApplication implements CommandLineInterpreter {

    private final ExampleCommandInterpreter commandLineInterpreter;

    ExampleApplication() {
        commandLineInterpreter = new ExampleCommandInterpreter(this);
    }

    public boolean exampleMethod(List<String> parameter) {
        System.out.println("i could do some actual work now if i were not a mere example, parameter " + parameter);
        return true;
    }

    public boolean count(List<String> parameter) {
        List<String> p2 = new ArrayList<>(parameter);
        if (p2.size() == 1) {
            p2.add("0");
        }
        if (p2.size() != 2) {
            return false;
        }

        try {
            int start = Integer.parseInt(p2.get(0));
            int end = Integer.parseInt(p2.get(1));
            if (start > end) {
                int temp = end;
                end = start;
                start = temp;
                System.out.println("correcting start/stop order");
            }
            System.out.println(Arrays.toString(IntStream.rangeClosed(start, end).toArray()));
            return true;
        } catch (NumberFormatException e) {
            System.out.println("error parsing parameter");
            return false;
        }

    }

    @Override
    public CommandMapping getCommands() {
        return commandLineInterpreter.getCommands();
    }

}
