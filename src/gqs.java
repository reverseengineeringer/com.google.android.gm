import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class gqs
  implements grq, gsb
{
  static final Logger a = Logger.getLogger(gqs.class.getName());
  private final gqq b;
  private final grq c;
  private final gsb d;
  
  public gqs(gqq paramgqq, grs paramgrs)
  {
    b = ((gqq)hbe.a(paramgqq));
    c = l;
    d = k;
    l = this;
    k = this;
  }
  
  public final boolean a(grs paramgrs, grv paramgrv, boolean paramBoolean)
  {
    if ((d != null) && (d.a(paramgrs, paramgrv, paramBoolean))) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (paramBoolean) && (c / 100 == 5)) {}
      try
      {
        b.a();
        return bool;
      }
      catch (IOException paramgrs)
      {
        a.log(Level.WARNING, "exception thrown while calling server callback", paramgrs);
      }
    }
    return bool;
  }
  
  public final boolean a(grs paramgrs, boolean paramBoolean)
  {
    if ((c != null) && (c.a(paramgrs, paramBoolean))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (paramBoolean) {}
      try
      {
        b.a();
        return paramBoolean;
      }
      catch (IOException paramgrs)
      {
        a.log(Level.WARNING, "exception thrown while calling server callback", paramgrs);
      }
    }
    return paramBoolean;
  }
}

/* Location:
 * Qualified Name:     gqs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */