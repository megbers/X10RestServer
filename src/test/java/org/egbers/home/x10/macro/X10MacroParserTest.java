package org.egbers.home.x10.macro;

import org.junit.Test;

import java.util.List;

import static org.egbers.x10.jfirecracker.Action.OFF;
import static org.egbers.x10.jfirecracker.Action.ON;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class X10MacroParserTest {
    @Test
    public void shouldParseSingleLineOnCommand() throws Exception {
        List<X10MacroCommand> messages = X10MacroParser.parse("A 1 ON;");
        assertThat(messages.size(), is(1));
        assertThat(messages.get(0).getType(), is(X10CommandType.MESSAGE));
        assertThat(messages.get(0).getMessage().getHouseCode(), is("A"));
        assertThat(messages.get(0).getMessage().getUnitCode(), is(1));
        assertThat(messages.get(0).getMessage().getAction(), is(ON));
    }

    @Test
    public void shouldParseSingleLineOffCommand() throws Exception {
        List<X10MacroCommand> messages = X10MacroParser.parse("B 10 OFF;");
        assertThat(messages.size(), is(1));
        assertThat(messages.get(0).getType(), is(X10CommandType.MESSAGE));
        assertThat(messages.get(0).getMessage().getHouseCode(), is("B"));
        assertThat(messages.get(0).getMessage().getUnitCode(), is(10));
        assertThat(messages.get(0).getMessage().getAction(), is(OFF));
    }

    @Test
    public void shouldParseMultiLineMixedCommands() throws Exception {
        List<X10MacroCommand> messages = X10MacroParser.parse("A 1 ON;A 2 ON;A 3 OFF;");
        assertThat(messages.size(), is(3));
        assertThat(messages.get(0).getType(), is(X10CommandType.MESSAGE));
        assertThat(messages.get(0).getMessage().getHouseCode(), is("A"));
        assertThat(messages.get(0).getMessage().getUnitCode(), is(1));
        assertThat(messages.get(0).getMessage().getAction(), is(ON));

        assertThat(messages.get(1).getType(), is(X10CommandType.MESSAGE));
        assertThat(messages.get(1).getMessage().getHouseCode(), is("A"));
        assertThat(messages.get(1).getMessage().getUnitCode(), is(2));
        assertThat(messages.get(1).getMessage().getAction(), is(ON));

        assertThat(messages.get(2).getType(), is(X10CommandType.MESSAGE));
        assertThat(messages.get(2).getMessage().getHouseCode(), is("A"));
        assertThat(messages.get(2).getMessage().getUnitCode(), is(3));
        assertThat(messages.get(2).getMessage().getAction(), is(OFF));
    }

    @Test
    public void shouldParseMultiLineWithWait() throws Exception {
        List<X10MacroCommand> messages = X10MacroParser.parse("A 1 ON;WAIT 1000;A 1 OFF;");
        assertThat(messages.size(), is(3));
        assertThat(messages.get(0).getType(), is(X10CommandType.MESSAGE));
        assertFalse(messages.get(0).isWait());
        assertThat(messages.get(0).getMessage().getHouseCode(), is("A"));
        assertThat(messages.get(0).getMessage().getUnitCode(), is(1));
        assertThat(messages.get(0).getMessage().getAction(), is(ON));

        assertThat(messages.get(1).getType(), is(X10CommandType.WAIT));
        assertTrue(messages.get(1).isWait());
        assertThat(messages.get(1).getWaitTime(), is(1000l));

        assertThat(messages.get(2).getType(), is(X10CommandType.MESSAGE));
        assertFalse(messages.get(2).isWait());
        assertThat(messages.get(2).getMessage().getHouseCode(), is("A"));
        assertThat(messages.get(2).getMessage().getUnitCode(), is(1));
        assertThat(messages.get(2).getMessage().getAction(), is(OFF));
    }
}
