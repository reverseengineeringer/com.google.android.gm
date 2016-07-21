import com.android.exchange.adapter.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public final class bpd
  extends Parser
{
  public int a = -1;
  public final ArrayList<String> b = new ArrayList();
  public int c = -1;
  private int d = -1;
  
  public bpd(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  private final int a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 != -1)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "Response has multiple values for ".concat(paramString);; paramString = new String("Response has multiple values for ")) {
        throw new IOException(paramString);
      }
    }
    paramInt1 = h();
    if ((paramInt1 <= 0) || ((paramInt2 > 0) && (paramInt1 > paramInt2))) {
      throw new IOException(String.valueOf(paramString).length() + 27 + paramString + " out of bounds: " + paramInt1);
    }
    return paramInt1;
  }
  
  private final void a()
  {
    while (b(841) != 3) {
      if (l == 842)
      {
        String str = g();
        b.add(str);
        cvm.c("Exchange", "Changes found in: %s", new Object[] { str });
      }
      else
      {
        i();
      }
    }
  }
  
  public final boolean d()
  {
    if (b(0) != 837) {
      throw new IOException("Ping response does not include a Ping element");
    }
    while (b(0) != 1) {
      if (l == 839)
      {
        a = a("Status", a, 177);
      }
      else if (l == 845)
      {
        d = a("MaxFolders", d, -1);
      }
      else if (l == 841)
      {
        if (!b.isEmpty()) {
          throw new IOException("Response has multiple values for Folders");
        }
        a();
        int i = b.size();
        cvm.b("Exchange", "Folders has %d elements", new Object[] { Integer.valueOf(i) });
        if (i == 0) {
          throw new IOException("Folders was empty");
        }
      }
      else if (l == 840)
      {
        c = a("HeartbeatInterval", c, -1);
      }
      else
      {
        i();
      }
    }
    switch (a)
    {
    }
    do
    {
      do
      {
        do
        {
          return true;
          throw new IOException("No status set in ping response");
        } while (!b.isEmpty());
        throw new IOException("No changes found in ping response");
      } while (c != -1);
      throw new IOException("No value specified for heartbeat out of bounds");
    } while (d != -1);
    throw new IOException("No value specified for too many folders");
  }
}

/* Location:
 * Qualified Name:     bpd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */