package org.egbers.home.x10.macro;

import org.egbers.home.x10.domain.X10Macro;
import org.egbers.x10.jfirecracker.X10Executor;
import org.egbers.x10.jfirecracker.X10Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class X10MacroExecutorTest {
    @Mock
    private X10Executor executor;
    private X10MacroExecutor macroExecutor;

    @Test
    public void shouldExecuteMessages() throws Exception {
        X10Macro macro = new X10Macro("* * * * *", "a 1 on; wait 1; a 1 off;");
        macroExecutor = new X10MacroExecutor();
        macroExecutor.setExecutor(executor);
        macroExecutor.execute(macro);

        Mockito.verify(executor, Mockito.times(2)).execute(Mockito.any(X10Message.class));
    }
}