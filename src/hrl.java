import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class hrl
{
  private static final Charset f = Charset.forName("UTF-8");
  public final hwr a;
  public hsc b;
  public hsj c;
  public hsj d;
  public hue e;
  private final hrn g;
  private final hrw h;
  private List i;
  
  public hrl()
  {
    this(hro.a.a(), new hwl(), new hua(), hws.a.a());
  }
  
  private hrl(hrn paramhrn, hwl paramhwl, hua paramhua, hwr paramhwr)
  {
    g = paramhrn;
    a = paramhwr;
    h = new hrm(this, hsk.a, paramhwl, paramhua);
  }
  
  public hrl(hwr paramhwr)
  {
    this(hro.a.a(), new hwl(), new hua(), paramhwr);
  }
  
  private final void a()
  {
    Iterator localIterator = i.iterator();
    while (localIterator.hasNext())
    {
      hue localhue = (hue)localIterator.next();
      Object localObject = localhue.a("TZID");
      if (localObject != null)
      {
        localObject = a.a(((hsy)localObject).a());
        if (localObject != null)
        {
          String str = localhue.a();
          if ((localhue instanceof iae)) {
            ((iae)localhue).a((hwq)localObject);
          }
          try
          {
            localhue.b(str);
          }
          catch (ParseException localParseException)
          {
            for (;;)
            {
              throw new hsi(localParseException);
              if ((localhue instanceof iad)) {
                ((iad)localhue).a((hwq)localObject);
              }
            }
          }
          catch (URISyntaxException localURISyntaxException)
          {
            throw new hsi(localURISyntaxException);
          }
        }
      }
    }
  }
  
  static void a(hsj paramhsj)
  {
    if (paramhsj == null) {
      throw new hsi("Expected component not initialised");
    }
  }
  
  static void a(hue paramhue)
  {
    if (paramhue == null) {
      throw new hsi("Expected property not initialised");
    }
  }
  
  public hsc a(hrz paramhrz)
  {
    b = null;
    c = null;
    d = null;
    e = null;
    i = new ArrayList();
    g.a(paramhrz, h);
    if ((i.size() > 0) && (a != null)) {
      a();
    }
    return b;
  }
  
  public final hsc a(InputStream paramInputStream)
  {
    return a(new hrz(new InputStreamReader(paramInputStream, f)));
  }
}

/* Location:
 * Qualified Name:     hrl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */