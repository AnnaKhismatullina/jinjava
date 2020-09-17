package com.hubspot.jinjava.lib.filter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import org.junit.Before;
import org.junit.Test;

public class LastFilterTest {
  private LastFilter filter;
  private JinjavaInterpreter interpreter;

  @Before
  public void setup() {
    filter = new LastFilter();
    interpreter = new Jinjava().newInterpreter();
  }

  @Test
  public void lastReturnsNullForEmptyList() {
    assertThat(filter.filter(new ArrayList<String>(), interpreter)).isNull();
  }

  @Test
  public void lastForSingleItemList() {
    assertThat(filter.filter(new Object[] { 1 }, interpreter)).isEqualTo(1);
  }

  @Test
  public void lastForSeq() {
    assertThat(filter.filter(Arrays.asList(1, 2, 3), interpreter)).isEqualTo(3);
  }
}
