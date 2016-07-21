import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;

public class fp<E>
  extends fn
{
  public final Activity b;
  public final Context c;
  final Handler d;
  final int e;
  final fr f = new fr();
  oi<String, go> g;
  public boolean h;
  gq i;
  boolean j;
  boolean k;
  
  private fp(Activity paramActivity, Context paramContext, Handler paramHandler)
  {
    b = paramActivity;
    c = paramContext;
    d = paramHandler;
    e = 0;
  }
  
  fp(fj paramfj)
  {
    this(paramfj, paramfj, a);
  }
  
  public View a(int paramInt)
  {
    return null;
  }
  
  public final gq a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (g == null) {
      g = new oi();
    }
    gq localgq = (gq)g.get(paramString);
    if (localgq == null)
    {
      if (paramBoolean2)
      {
        localgq = new gq(paramString, this, paramBoolean1);
        g.put(paramString, localgq);
      }
      return localgq;
    }
    h = this;
    return localgq;
  }
  
  public void a(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (paramInt != -1) {
      throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }
    c.startActivity(paramIntent);
  }
  
  final void a(String paramString)
  {
    if (g != null)
    {
      gq localgq = (gq)g.get(paramString);
      if ((localgq != null) && (!f))
      {
        localgq.g();
        g.remove(paramString);
      }
    }
  }
  
  public void a(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public boolean a()
  {
    return true;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public LayoutInflater c()
  {
    return (LayoutInflater)c.getSystemService("layout_inflater");
  }
  
  public void d() {}
  
  public boolean e()
  {
    return true;
  }
  
  public int f()
  {
    return e;
  }
  
  final oi<String, go> g()
  {
    int n = 0;
    int i1;
    if (g != null)
    {
      int i2 = g.size();
      gq[] arrayOfgq = new gq[i2];
      int m = i2 - 1;
      while (m >= 0)
      {
        arrayOfgq[m] = ((gq)g.c(m));
        m -= 1;
      }
      m = 0;
      i1 = m;
      if (n < i2)
      {
        gq localgq = arrayOfgq[n];
        if (f) {
          m = 1;
        }
        for (;;)
        {
          n += 1;
          break;
          localgq.g();
          g.remove(d);
        }
      }
    }
    else
    {
      i1 = 0;
    }
    if (i1 != 0) {
      return g;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     fp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */