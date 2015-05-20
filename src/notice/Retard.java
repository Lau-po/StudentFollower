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

package notice;

import java.util.GregorianCalendar;

/**
 *
 * @author boinc
 */

public class Retard {
    
  private GregorianCalendar date;
  private int duration;
  
  public Retard(GregorianCalendar date, int duration) {
    this.date = date;
    this.duration = duration;
  }
  
  public GregorianCalendar getDate() {
    return this.date;
  }
  
  public int getDuration() {
    return this.duration;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof Retard))
      return false;
    Retard other = (Retard) obj;
    if (date == null) {
      if (other.date != null)
        return false;
    } else if (!date.equals(other.date))
      return false;
    return duration == other.duration;
  }
}
