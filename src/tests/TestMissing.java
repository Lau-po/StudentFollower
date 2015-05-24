package tests;

import static org.junit.Assert.fail;
import notice.Date;
import notice.Missing;

import org.junit.Test;

public class TestMissing {
  
  @Test
  public final void testEquals() {
    Missing m1 = new Missing(new Date(2, 01, 1970));
    Missing m2 = new Missing(new Date(2, 01, 1970));
    
    if (!(m1.equals(m2))) {
      fail("equals() not valid");
    }
  }

}
