import com.google.android.gms.appdatasearch.QuerySpecification;
import com.google.android.gms.appdatasearch.Section;
import java.util.ArrayList;
import java.util.List;

public final class eca
{
  public List<String> a;
  private boolean b;
  private List<Section> c;
  private boolean d;
  private int e;
  private int f = 0;
  private boolean g;
  private int h = 0;
  
  public final QuerySpecification a()
  {
    return new QuerySpecification(2, b, a, c, d, e, f, g, h);
  }
  
  public final eca a(Section paramSection)
  {
    if (Section.a(b))
    {
      if (c == null)
      {
        g = true;
        c = new ArrayList();
      }
      while (g)
      {
        c.add(paramSection);
        return this;
      }
      throw new IllegalArgumentException("Cannot mix literal and semantic sections");
    }
    if (c == null)
    {
      g = false;
      c = new ArrayList();
    }
    while (!g)
    {
      c.add(paramSection);
      return this;
    }
    throw new IllegalArgumentException("Cannot mix literal and semantic sections");
  }
}

/* Location:
 * Qualified Name:     eca
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */