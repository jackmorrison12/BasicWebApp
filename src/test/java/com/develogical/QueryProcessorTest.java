package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsLargestOfTwoNumbers() throws Exception {
        assertThat(queryProcessor.process("123: which of the following numbers is the largest: 2064, 203050"),
                containsString("203050"));
        assertThat(queryProcessor.process("124: which of the following numbers is the largest: 2064, 203050, 12"),
                containsString("203050"));
    }

    @Test
    public void canAddNumbers() throws Exception {
        assertThat(queryProcessor.process("12a3: what is 2 plus 3"), containsString("5"));
    }

    @Test
    public void canMultiplyNumbers() throws Exception {
        assertThat(queryProcessor.process("12a3: what is 2 multiplied by 3"), containsString("6"));
    }
}
