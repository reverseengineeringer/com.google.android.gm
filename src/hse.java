import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.TimeZone;

abstract class hse
  extends DateFormat
{
  private static final TimeZone a = ;
  private static final long serialVersionUID = -4191402739860280205L;
  private final String b;
  private boolean c = true;
  private TimeZone d = a;
  
  public hse(String paramString)
  {
    b = paramString;
  }
  
  public Object clone()
  {
    hse localhse = (hse)hsd.a(b);
    localhse.setTimeZone(getTimeZone());
    localhse.setLenient(isLenient());
    return localhse;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (hse)paramObject;
      if (c != c) {
        return false;
      }
      if (!b.equals(b)) {
        return false;
      }
    } while (d.equals(d));
    return false;
  }
  
  public Calendar getCalendar()
  {
    throw new UnsupportedOperationException();
  }
  
  public NumberFormat getNumberFormat()
  {
    throw new UnsupportedOperationException();
  }
  
  public TimeZone getTimeZone()
  {
    return d;
  }
  
  public int hashCode()
  {
    int j = super.hashCode();
    int k = b.hashCode();
    if (c) {}
    for (int i = 1;; i = 0) {
      return (i + (j * 31 + k) * 31) * 31 + d.hashCode();
    }
  }
  
  public boolean isLenient()
  {
    return c;
  }
  
  public void setCalendar(Calendar paramCalendar)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setLenient(boolean paramBoolean)
  {
    c = paramBoolean;
  }
  
  public void setNumberFormat(NumberFormat paramNumberFormat)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setTimeZone(TimeZone paramTimeZone)
  {
    d = paramTimeZone;
  }
}

/* Location:
 * Qualified Name:     hse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */