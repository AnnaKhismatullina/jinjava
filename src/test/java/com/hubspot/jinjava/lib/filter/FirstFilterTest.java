package com.hubspot.jinjava.lib.filter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

import java.util.Arrays;

import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import org.junit.Before;
import org.junit.Test;

public class FirstFilterTest {
  private FirstFilter filter;
  private JinjavaInterpreter interpreter;

  @Before
  public void setup() {
    filter = new FirstFilter();
    interpreter = new Jinjava().newInterpreter();
  }

  @Test
  public void firstReturnsNullForEmptyList() {
    assertThat(filter.filter(new Object[] {}, interpreter)).isNull();
  }

  @Test
  public void firstForSeq() {
    assertThat(filter.filter(Arrays.asList("foo", "bar"), interpreter)).isEqualTo("foo");
  }
}
