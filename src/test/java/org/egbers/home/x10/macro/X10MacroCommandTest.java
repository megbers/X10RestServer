package org.egbers.home.x10.macro;

import org.egbers.x10.jfirecracker.X10Message;
import org.junit.Assert;
import org.junit.Test;

public class X10MacroCommandTest {
    @Test
    public void shouldReturnTrueWhenCommandIsWait() {
        X10MacroCommand command = new X10MacroCommand(10l);
        Assert.assertTrue(command.isWait());
    }

    @Test
    public void shouldReturnFalseWhenCommandIsMessage() {
        X10MacroCommand command = new X10MacroCommand(new X10Message());
        Assert.assertFalse(command.isWait());
    }

}
