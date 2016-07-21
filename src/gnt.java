import java.io.Serializable;
import java.util.Locale;

public final class gnt
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public final int a;
  public final boolean b;
  public final Class c;
  
  public gnt(int paramInt)
  {
    this(paramInt, false, gnr.class);
  }
  
  public gnt(int paramInt, boolean paramBoolean, Class paramClass)
  {
    a = paramInt;
    b = paramBoolean;
    c = paramClass;
  }
  
  public final String toString()
  {
    return String.format(Locale.US, "VisualElementTag {id: %d, isRootPage: %b}", new Object[] { Integer.valueOf(a), Boolean.valueOf(b) });
  }
}

/* Location:
 * Qualified Name:     gnt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */