package org.egbers.home.x10.service;

import org.egbers.home.x10.domain.Action;

import java.io.IOException;

public interface ActionExecutor {
	public void execute(Action action) throws IOException;
}
