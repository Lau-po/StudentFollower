/*
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If
 * not, see <http://www.gnu.org/licenses/>.
 */

package tests;

/**
*
* @author boinc
*/

import static org.junit.Assert.fail;
import notice.Date;
import notice.Missing;

import org.junit.Test;

public class testMissing {
  
  @Test
  public final void testEquals() {
    Missing m1 = new Missing(new Date(2, 01, 1970));
    Missing m2 = new Missing(new Date(2, 01, 1970));
    
    if (!(m1.equals(m2))) {
      fail("equals() not valid");
    }
  }

}
