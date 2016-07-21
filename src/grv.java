import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

public final class grv
{
  public final String a;
  gse b;
  public final int c;
  public final String d;
  public final grs e;
  private InputStream f;
  private final String g;
  private final grr h;
  private int i;
  private boolean j;
  private boolean k;
  
  grv(grs paramgrs, gse paramgse)
  {
    e = paramgrs;
    i = e;
    j = f;
    b = paramgse;
    g = paramgse.b();
    int n = paramgse.e();
    int m = n;
    if (n < 0) {
      m = 0;
    }
    c = m;
    Object localObject1 = paramgse.f();
    d = ((String)localObject1);
    Logger localLogger = gsa.a;
    StringBuilder localStringBuilder;
    Object localObject3;
    if ((j) && (localLogger.isLoggable(Level.CONFIG)))
    {
      m = 1;
      if (m == 0) {
        break label290;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("-------------- RESPONSE --------------").append(gur.a);
      localObject3 = paramgse.d();
      if (localObject3 == null) {
        break label241;
      }
      localStringBuilder.append((String)localObject3);
      label145:
      localStringBuilder.append(gur.a);
    }
    for (;;)
    {
      localObject3 = c;
      if (m != 0)
      {
        localObject1 = localStringBuilder;
        label168:
        ((grn)localObject3).a(paramgse, (StringBuilder)localObject1);
        localObject1 = paramgse.c();
        paramgse = (gse)localObject1;
        if (localObject1 == null) {
          paramgse = (String)grn.a(c.contentType);
        }
        a = paramgse;
        if (paramgse != null) {
          break label278;
        }
      }
      label241:
      label278:
      for (paramgrs = (grs)localObject2;; paramgrs = new grr(paramgse))
      {
        h = paramgrs;
        if (m != 0) {
          localLogger.config(localStringBuilder.toString());
        }
        return;
        m = 0;
        break;
        localStringBuilder.append(c);
        if (localObject1 == null) {
          break label145;
        }
        localStringBuilder.append(' ').append((String)localObject1);
        break label145;
        localObject1 = null;
        break label168;
      }
      label290:
      localStringBuilder = null;
    }
  }
  
  public final InputStream a()
  {
    Object localObject5;
    if (!k)
    {
      localObject4 = b.a();
      if (localObject4 != null) {
        localObject5 = localObject4;
      }
    }
    try
    {
      localObject6 = g;
      Object localObject1 = localObject4;
      if (localObject6 != null)
      {
        localObject1 = localObject4;
        localObject5 = localObject4;
        if (((String)localObject6).contains("gzip"))
        {
          localObject5 = localObject4;
          localObject1 = new GZIPInputStream((InputStream)localObject4);
        }
      }
      localObject5 = localObject1;
      localObject6 = localObject1;
      Logger localLogger;
      ((InputStream)localObject4).close();
    }
    catch (EOFException localEOFException)
    {
      for (;;)
      {
        try
        {
          localLogger = gsa.a;
          localObject4 = localObject1;
          localObject5 = localObject1;
          localObject6 = localObject1;
          if (j)
          {
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            if (localLogger.isLoggable(Level.CONFIG))
            {
              localObject5 = localObject1;
              localObject6 = localObject1;
              localObject4 = new gui((InputStream)localObject1, localLogger, Level.CONFIG, i);
            }
          }
          localObject5 = localObject4;
          localObject6 = localObject4;
          f = ((InputStream)localObject4);
          k = true;
          return f;
        }
        finally
        {
          Object localObject6;
          localObject4 = localObject6;
          continue;
        }
        localEOFException = localEOFException;
        ((InputStream)localObject5).close();
      }
    }
    finally {}
    throw ((Throwable)localObject2);
  }
  
  public final void b()
  {
    InputStream localInputStream = a();
    if (localInputStream != null) {
      localInputStream.close();
    }
  }
  
  public final void c()
  {
    b();
    b.h();
  }
  
  public final String d()
  {
    InputStream localInputStream = a();
    if (localInputStream == null) {
      return "";
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    gue.a(localInputStream, localByteArrayOutputStream, true);
    return localByteArrayOutputStream.toString(e().name());
  }
  
  public final Charset e()
  {
    if ((h == null) || (h.b() == null)) {
      return gtq.b;
    }
    return h.b();
  }
}

/* Location:
 * Qualified Name:     grv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */