package org.egbers.home.x10.service;

import org.egbers.home.x10.domain.Action;

import java.io.IOException;

public class ActionExecutorFirecracker32 extends AbstractActionExecutor implements ActionExecutor {

    public ActionExecutorFirecracker32() {
        super();
    }

    @Override
    public void execute(Action action) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("Fireck32").append(" ")
                .append("/c=1").append(" ")
                .append("/h=").append(action.getHouse().toLowerCase()).append(" ")
                .append("/d=").append(action.getSocket()).append(" ")
                .append("/a=").append(action.getValue() == 1 ? "on" : "off");
        call(builder.toString());
    }
}
