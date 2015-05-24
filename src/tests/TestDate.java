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

/**
*
* @author boinc
*/

import java.util.GregorianCalendar;

import notice.Date;

import org.junit.Test;

public class testDate {
  
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
