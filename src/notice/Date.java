package notice;

import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class Date extends GregorianCalendar {
  private GregorianCalendar date;

  public Date(int day, int month, int year) {
    this.setDate(new GregorianCalendar(year, month, day));
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (!(obj instanceof Date))
      return false;
    Date other = (Date) obj;
    if (date == null) {
      if (other.date != null)
        return false;
    } else if (!date.equals(other.date))
      return false;
    return true;
  }

  public GregorianCalendar getDate() {
    return date;
  }

  public void setDate(GregorianCalendar date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "Le : " + date.get(DAY_OF_MONTH) + "/" + date.get(MONTH) + "/" + date.get(YEAR);
  }


}
