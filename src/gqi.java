import android.accounts.Account;
import android.content.Context;
import java.io.IOException;

public final class gqi
  implements gru
{
  final Context a;
  final String b;
  public final gqh c;
  public String d;
  public Account e;
  private guo f = guo.a;
  private gtk g;
  
  public gqi(Context paramContext, String paramString)
  {
    c = new gqh(paramContext);
    a = paramContext;
    b = paramString;
  }
  
  public final String a()
  {
    if (g != null) {
      g.a();
    }
    try
    {
      String str = ecy.a(a, d, b);
      return str;
    }
    catch (IOException localIOException)
    {
      try
      {
        guo localguo;
        long l;
        int i;
        if (g != null)
        {
          localguo = f;
          l = g.b();
          if (l != -1L) {
            break label77;
          }
          i = 0;
          break label87;
        }
        for (;;)
        {
          throw localIOException;
          label77:
          localguo.a(l);
          i = 1;
          label87:
          if (i != 0) {
            break;
          }
        }
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public final void a(grs paramgrs)
  {
    gqj localgqj = new gqj(this);
    a = localgqj;
    k = localgqj;
  }
}

/* Location:
 * Qualified Name:     gqi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */