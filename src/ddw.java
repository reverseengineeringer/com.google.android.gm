import java.util.Arrays;

public final class ddw
{
  private ddv a;
  private final ddt[] b;
  
  ddw(ddt[] paramArrayOfddt)
  {
    Arrays.sort(paramArrayOfddt);
    b = paramArrayOfddt;
  }
  
  public final ddt a(String paramString)
  {
    if (a == null) {
      a = new ddv(b);
    }
    ddt localddt = a.a(paramString);
    paramString = localddt;
    if (localddt == null) {
      paramString = ddt.a;
    }
    return paramString;
  }
}

/* Location:
 * Qualified Name:     ddw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */