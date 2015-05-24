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

import static org.junit.Assert.fail;
import notice.Date;
import notice.Retard;

import org.junit.Test;

/**
*
* @author boinc
*/

public class testRetard {
  
  @Test
  public final void testEquals() {
    Retard r1 = new Retard(new Date(2, 01, 1970), 20);
    Retard r2 = new Retard(new Date(2, 01, 1970), 20);
    
    if (!(r1.equals(r2))) {
      fail("equals() not valid");
    }
  }

}