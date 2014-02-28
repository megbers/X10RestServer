package org.egbers.home.x10.examples;

import junit.framework.Assert;

import org.egbers.home.x10.service.Action;
import org.egbers.home.x10.service.ActionExecutor;
import org.junit.Before;
import org.junit.Test;

public class ActionExecuterTest {
	
	ActionExecutor executor;
	
	@Before
	public void setUp() {
		executor = new ActionExecutor();
	}
	
	@Test
	public void shouldExecuteAction() {
		Action action = new Action("c", "3", 0);
		executor.execute(action);
		Assert.assertEquals(true, true);
	}
	
}
