import java.io.UnsupportedEncodingException;
import java.net.URI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class hzr
  extends hue
{
  private static final long serialVersionUID = 4439949507756383452L;
  private URI c;
  private byte[] d;
  
  public hzr()
  {
    super("ATTACH", hug.a);
  }
  
  public final String a()
  {
    if (c != null) {
      return icq.b(ico.b(c));
    }
    if (d != null) {}
    try
    {
      String str = new String(icl.a.a((hyw)a("ENCODING")).b(d));
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      LogFactory.getLog(hzr.class).error("Error encoding binary data", localUnsupportedEncodingException);
      return null;
    }
    catch (icv localicv)
    {
      for (;;)
      {
        LogFactory.getLog(hzr.class).error("Error encoding binary data", localicv);
      }
    }
  }
  
  public final void b(String paramString)
  {
    if (a("ENCODING") != null) {
      try
      {
        d = ici.a.a((hyw)a("ENCODING")).a(paramString.getBytes());
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        LogFactory.getLog(hzr.class).error("Error encoding binary data", paramString);
        return;
      }
      catch (icu paramString)
      {
        LogFactory.getLog(hzr.class).error("Error decoding binary data", paramString);
        return;
      }
    }
    c = icq.c(paramString);
  }
}

/* Location:
 * Qualified Name:     hzr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */