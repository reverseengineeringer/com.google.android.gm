import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class guk
  implements guq
{
  private final guq a;
  private final int b;
  private final Level c;
  private final Logger d;
  
  public guk(guq paramguq, Logger paramLogger, Level paramLevel, int paramInt)
  {
    a = paramguq;
    d = paramLogger;
    c = paramLevel;
    b = paramInt;
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    guj localguj = new guj(paramOutputStream, d, c, b);
    try
    {
      a.a(localguj);
      a.close();
      paramOutputStream.flush();
      return;
    }
    finally
    {
      a.close();
    }
  }
}

/* Location:
 * Qualified Name:     guk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */