package tests;

import static org.junit.Assert.fail;

import java.util.GregorianCalendar;

import notice.Date;

import org.junit.Test;

public class TestDate {
  
  @Test
  public final void testEquals() {
    Date d1 = new Date(10, 02, 2012);
    Date d2 = new Date(10, 02, 2012);
    
    if(!d1.equals(d2)) {
      fail("Date not equals");
    }
  }
  
  @Test
  public final void testGetDate() {
    Date d = new Date(15, 07, 2014);
    
    if (!(d.getDate() instanceof GregorianCalendar)) {
      fail("getDate() not valid");
    }
  }
  
  @Test
  public final void testToString() {
    Date d = new Date(23, 04, 2015);
    String str = d.toString();
    if (!str.equals("Le : 23/4/2015")) {
      fail("toString() not valid");
    }
  }
}
