package org.egbers.home.x10.service;

import org.egbers.home.x10.domain.Action;

import java.io.IOException;

public class ActionExecutorCM17A extends AbstractActionExecutor implements ActionExecutor {

    @Override
    public void execute(Action action) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("cm17a").append(" ")
                .append("1").append(" ")
                .append(action.getHouse().toLowerCase())
                .append(action.getSocket())
                .append(action.getValue() == 1 ? "on" : "off");
        call(builder.toString());
    }
}
