package org.egbers.home.x10.macro;

import org.egbers.x10.jfirecracker.X10Message;

public class X10MacroCommand {
    private X10Message message;
    private X10CommandType type;
    private Long waitTime;

    public X10MacroCommand(X10Message message) {
        this.message = message;
        this.type = X10CommandType.MESSAGE;
    }

    public X10MacroCommand(Long waitTime) {
        this.type = X10CommandType.WAIT;
        this.waitTime = waitTime;
    }

    public X10Message getMessage() {
        return message;
    }

    public void setMessage(X10Message message) {
        this.message = message;
    }

    public X10CommandType getType() {
        return type;
    }

    public void setType(X10CommandType type) {
        this.type = type;
    }

    public Long getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Long waitTime) {
        this.waitTime = waitTime;
    }

    public boolean isWait() {
        return type == X10CommandType.WAIT;
    }
}
