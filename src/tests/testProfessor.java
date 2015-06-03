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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import user.Professor;

/**
 *
 * @author boinc
 */

public class testProfessor {

  @Test
  public final void testEmail() {
    Professor prof = new Professor(1, "Paul", "Durant");
    Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
    Matcher ma = p.matcher(prof.getEmail().toUpperCase());
    if (!ma.matches()) {
      fail();
    }
  }

  @Test
  public final void testPassword() {
    Professor prof = new Professor(1, "Paul", "Durant");
    if (!prof.getPassword().matches("[a-zA-Z0-9]*")) {
      fail("generatePassword() not valid");
    }
  }

  @Test
  public final void testUserName() {
    Professor prof = new Professor(1, "Paul", "Durant");
    if (!prof.getUserName().matches("[a-z]*")) {
      fail("generateUserName() not valid");
    }
  }

}
