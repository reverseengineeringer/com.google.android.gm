import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

public abstract class dyo
  implements ejc, eje
{
  static final String c = cvl.a;
  private final String a;
  final int d;
  final String e;
  public eiz f = a();
  public boolean g;
  
  public dyo(Bundle paramBundle, int paramInt, String paramString1, String paramString2)
  {
    d = paramInt;
    a = paramString1;
    e = paramString2;
    boolean bool1 = bool2;
    if (paramBundle != null)
    {
      bool1 = bool2;
      if (paramBundle.getBoolean(a, false)) {
        bool1 = true;
      }
    }
    g = bool1;
  }
  
  public static eiz a(Context paramContext, dyo paramdyo)
  {
    fro localfro = new frp().a().b();
    return new eja(paramContext.getApplicationContext()).a(frm.c, localfro).a(fjg.b).a(paramdyo).a(paramdyo).a();
  }
  
  public abstract eiz a();
  
  public void a(int paramInt)
  {
    cvm.c(c, "%s Client connection suspended: %s", new Object[] { e, Integer.valueOf(paramInt) });
  }
  
  public void a(Bundle paramBundle)
  {
    cvm.c(c, "%s Client connected:", new Object[] { e });
  }
  
  public void a(ConnectionResult paramConnectionResult)
  {
    cvm.c(c, "%s Client connection failure: %s", new Object[] { e, paramConnectionResult });
    if (g) {}
    int i;
    do
    {
      return;
      if (paramConnectionResult.a())
      {
        g = true;
        b(paramConnectionResult);
        return;
      }
      i = c;
    } while ((i == 8) || (i == 7));
    b(i);
    g = true;
  }
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt1 == d)
    {
      g = false;
      if ((paramInt2 == -1) && (f != null) && (!f.f()) && (!f.e()))
      {
        f.b();
        b();
      }
      bool = true;
    }
    return bool;
  }
  
  public void b() {}
  
  abstract void b(int paramInt);
  
  public final void b(Bundle paramBundle)
  {
    paramBundle.putBoolean(a, g);
  }
  
  abstract void b(ConnectionResult paramConnectionResult);
  
  public void c() {}
  
  public final void d()
  {
    if ((!g) && (f != null))
    {
      f.b();
      b();
    }
  }
  
  public final void e()
  {
    if (f != null)
    {
      f.d();
      c();
    }
  }
}

/* Location:
 * Qualified Name:     dyo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */