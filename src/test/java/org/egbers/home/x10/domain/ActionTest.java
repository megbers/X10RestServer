package org.egbers.home.x10.domain;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ActionTest {
    @Test
    public void shouldReturnCorrectBytes_A1on() {
        Action action = new Action("A", "1", 1);
        byte[] bytes = action.convertToBytes();

        printBytes(bytes);
        Assert.assertThat(bytes[2], CoreMatchers.is((byte) 96));
        Assert.assertThat(bytes[3], CoreMatchers.is((byte) 0));

        //Check Header and Footer
        Assert.assertThat(bytes[0], CoreMatchers.is((byte) 213));
        Assert.assertThat(bytes[1], CoreMatchers.is((byte) 170));
        Assert.assertThat(bytes[4], CoreMatchers.is((byte) 173));
    }

    @Test
    public void shouldReturnCorrectBytes_A1off() {
        Action action = new Action("A", "1", 0);
        byte[] bytes = action.convertToBytes();

        printBytes(bytes);
        Assert.assertThat(bytes[2], CoreMatchers.is((byte) 96));
        Assert.assertThat(bytes[3], CoreMatchers.is((byte) 32));

        //Check Header and Footer
        Assert.assertThat(bytes[0], CoreMatchers.is((byte) 213));
        Assert.assertThat(bytes[1], CoreMatchers.is((byte) 170));
        Assert.assertThat(bytes[4], CoreMatchers.is((byte) 173));
    }

    @Test
    public void shouldReturnCorrectBytes_L10off() {
        Action action = new Action("L", "10", 0);
        byte[] bytes = action.convertToBytes();

        printBytes(bytes);
        Assert.assertThat(bytes[2], CoreMatchers.is((byte) -44));
        Assert.assertThat(bytes[3], CoreMatchers.is((byte) 48));

        //Check Header and Footer
        Assert.assertThat(bytes[0], CoreMatchers.is((byte) 213));
        Assert.assertThat(bytes[1], CoreMatchers.is((byte) 170));
        Assert.assertThat(bytes[4], CoreMatchers.is((byte) 173));
    }

    @Test
    public void shouldReturnCorrectBytes_I10off() {
        Action action = new Action("I", "10", 0);
        byte[] bytes = action.convertToBytes();

        printBytes(bytes);
        Assert.assertThat(bytes[2], CoreMatchers.is((byte) -28));
        Assert.assertThat(bytes[3], CoreMatchers.is((byte) 48));

        //Check Header and Footer
        Assert.assertThat(bytes[0], CoreMatchers.is((byte) 213));
        Assert.assertThat(bytes[1], CoreMatchers.is((byte) 170));
        Assert.assertThat(bytes[4], CoreMatchers.is((byte) 173));
    }

    private void printBytes(byte[] bytes) {
        System.out.println(bytes[2] & 0xFF);
        String s0 = String.format("%8s", Integer.toBinaryString(bytes[2] & 0xFF)).replace(' ', '0');
        System.out.println(s0);

        System.out.println(bytes[3]);
        String s1 = String.format("%8s", Integer.toBinaryString(bytes[3] & 0xFF)).replace(' ', '0');
        System.out.println(s1);

        System.out.println(s0 + "|" + s1);
    }
}
