package org.egbers.home.x10.macro;

import org.egbers.x10.jfirecracker.Action;
import org.egbers.x10.jfirecracker.X10Message;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class X10MacroParser {
    public static List<X10MacroCommand> parse(String program) {
        List<X10MacroCommand> commands = new ArrayList<>();
        StringTokenizer multiLineTokenizer = new StringTokenizer(program, ";");
        while(multiLineTokenizer.hasMoreTokens()) {
            String line = multiLineTokenizer.nextToken();
            StringTokenizer lineTokenizer = new StringTokenizer(line);

            String firstToken = lineTokenizer.nextToken().toUpperCase().trim();
            if(firstToken.equals("WAIT")) {
                Long waitTime = Long.valueOf(lineTokenizer.nextToken());
                X10MacroCommand command = new X10MacroCommand(waitTime);
                commands.add(command);
            } else {
                String houseCode = firstToken;
                Integer unitCode = Integer.valueOf(lineTokenizer.nextToken().trim());
                String action = lineTokenizer.nextToken().toUpperCase().trim();

                X10Message message = new X10Message(houseCode, unitCode, Action.valueOf(action));
                X10MacroCommand command = new X10MacroCommand(message);
                commands.add(command);
            }

        }

        return commands;
    }
}
