import java.util.Calendar;

public final class apb
{
  int a;
  int b;
  int c;
  private Calendar d;
  
  public apb()
  {
    a(System.currentTimeMillis());
  }
  
  public apb(int paramInt1, int paramInt2, int paramInt3)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramInt3;
  }
  
  public apb(long paramLong)
  {
    a(paramLong);
  }
  
  public apb(Calendar paramCalendar)
  {
    a = paramCalendar.get(1);
    b = paramCalendar.get(2);
    c = paramCalendar.get(5);
  }
  
  private final void a(long paramLong)
  {
    if (d == null) {
      d = Calendar.getInstance();
    }
    d.setTimeInMillis(paramLong);
    b = d.get(2);
    a = d.get(1);
    c = d.get(5);
  }
  
  public final void a(apb paramapb)
  {
    a = a;
    b = b;
    c = c;
  }
}

/* Location:
 * Qualified Name:     apb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */