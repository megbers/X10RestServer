package org.egbers.home.x10.service;

import java.io.IOException;

public abstract class AbstractActionExecutor {
    private Runtime runtime;

    public AbstractActionExecutor() {
        runtime = Runtime.getRuntime();
    }

    protected void call(String command) throws IOException {
        runtime.exec(command);
    }

    public void setRuntime(Runtime runtime) {
        this.runtime = runtime;
    }
}
