import java.io.Serializable;
import java.util.Locale;

public class gnr
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public final gnt a;
  
  public gnr(gnt paramgnt)
  {
    a = ((gnt)gol.a(paramgnt));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if (getClass() == paramObject.getClass())
      {
        paramObject = (gnr)paramObject;
        bool1 = bool2;
        if (a.a == a.a) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return a.a + 527;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "VisualElement {tag: %s}", new Object[] { a });
  }
}

/* Location:
 * Qualified Name:     gnr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */