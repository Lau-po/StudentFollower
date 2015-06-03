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
import classes.Prom;
import user.Student;

/**
 *
 * @author boinc
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class testProm {
  private List<Student> students = initStudents();
  private Prom prom = new Prom(2015, 'A', students);

  private List<Student> initStudents() {
    List<Student> students = new ArrayList<Student>();
    students.add(new Student("Paul", "Durant"));
    students.add(new Student("Pierre", "Dupond"));
    students.add(new Student("Claire", "Martin"));
    students.add(new Student("Jacques", "Richard"));
    students.add(new Student("Jeanne", "Robin"));
    return students;
  }

  @Test
  public final void testAddStudent() {
    int before = students.size();
    prom.addStudent(students.get(new Random().nextInt(students.size() - 1)));
    int after = students.size();

    if (!(before < after)) {
      fail("addStudent() not valid");
    }
  }

  @Test
  public final void testGetAllStudent() {
    if (!prom.getAllStudents().equals(students)) {
      fail("getAllStudents() not valid");
    }
  }

  @Test
  public final void testGetOnStudent() {
    if (!students
        .contains(prom.getOneStudent(students.get(new Random().nextInt(students.size() - 1))))) {
      fail("getOneStudent() not valid");
    }
  }

  @Test
  public final void testRemoveStudent() {
    int before = students.size();
    prom.removeStudent(students.get(new Random().nextInt(students.size() - 1)));
    int after = students.size();

    if (!(before > after)) {
      fail("removeStudent() not valid");
    }
  }
}
