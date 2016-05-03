package org.egbers.home.x10.macro;

import org.egbers.home.x10.domain.X10Macro;
import org.egbers.x10.jfirecracker.X10Executor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class X10MacroExecutor {
    @Autowired
    private X10Executor executor;

    public void execute(X10Macro macro) throws Exception {
        List<X10MacroCommand> commands = X10MacroParser.parse(macro.getMacroString());
        for(X10MacroCommand command : commands) {
            if(command.isWait()) {
                Thread.sleep(command.getWaitTime());
            } else {
                executor.execute(command.getMessage());
            }
        }
    }

    void setExecutor(X10Executor executor) {
        this.executor = executor;
    }
}
