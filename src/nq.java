import java.util.Locale;

public class nq
{
  public int a(Locale paramLocale)
  {
    int j = 1;
    if ((paramLocale != null) && (!paramLocale.equals(np.b)))
    {
      String str = na.a.a(paramLocale);
      int i;
      if (str == null)
      {
        i = j;
        switch (Character.getDirectionality(paramLocale.getDisplayName(paramLocale).charAt(0)))
        {
        default: 
          i = 0;
        }
      }
      do
      {
        do
        {
          return i;
          i = j;
        } while (str.equalsIgnoreCase(np.c));
        i = j;
      } while (str.equalsIgnoreCase(np.d));
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     nq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */