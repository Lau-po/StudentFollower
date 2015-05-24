package notice;

import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class Date extends GregorianCalendar {
  private GregorianCalendar date;

  public Date(int day, int month, int year) {
    this.setDate(new GregorianCalendar(year, month, day));
  }

  @Override
  public String toString() {
    return "Le : " + date.get(DAY_OF_MONTH) + "/" + date.get(MONTH) + "/" + date.get(YEAR);
  }

  public GregorianCalendar getDate() {
    return date;
  }

  public void setDate(GregorianCalendar date) {
    this.date = date;
  }


}
