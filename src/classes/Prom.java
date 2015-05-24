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

package classes;

import java.util.ArrayList;
import java.util.List;
import user.Student;

/**
 *
 * @author boinc
 */

public class Prom {
    
   private List<Student> students;
   private int year;
   private char id;
   
   public Prom(int year, char id) {
       this.year = year;
       this.id = id;
       this.students = new ArrayList<>();
   }
   
   public Prom(int year, char id, List<Student> students) {
       this(year, id);
       this.students = students;
   }
   
   public List<Student> getAllStudents() {
       return this.students;
   }
   
   public Student getOneStudent(Student s) {
       for (Student student : students) {
           if (s.equals(student)) {
               return student;
           }
       }
       return null;
   }
   
   public void addStudent(Student s) {
       this.students.add(s);
   }
   
   public void removeStudent(Student s) {
       this.students.remove(s);
   }
   
   public int getYear() {
       return this.year;
   }
   
   public char getId() {
       return this.id;
   }
    
}
