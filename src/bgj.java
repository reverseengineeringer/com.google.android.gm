import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.os.Debug;
import android.os.IBinder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public abstract class bgj
{
  static final Map<Class<? extends bgj>, Executor> l = new HashMap();
  private String a = "unnamed";
  private long b;
  private boolean c = false;
  final String e;
  final Context f;
  public final Intent g;
  public bgn h;
  final ServiceConnection i = new bgl(this);
  public int j = 45;
  boolean k = false;
  
  public bgj(Context paramContext, Intent paramIntent)
  {
    f = paramContext;
    g = paramIntent;
    e = getClass().getSimpleName();
    if (Debug.isDebuggerConnected()) {
      j <<= 2;
    }
  }
  
  public static Intent a(Context paramContext, String paramString)
  {
    String str = bdv.E;
    paramString = new Intent(String.valueOf(str).length() + 1 + String.valueOf(paramString).length() + str + "." + paramString);
    paramContext = paramContext.getPackageManager().resolveContentProvider(bdv.F, 0);
    if (paramContext != null)
    {
      paramString.setPackage(packageName);
      return paramString;
    }
    cvm.e(cvm.a, "Could not find the Email Content Provider", new Object[0]);
    return paramString;
  }
  
  public abstract void a(IBinder paramIBinder);
  
  protected final boolean a(bgn parambgn, String paramString)
  {
    if (c) {
      throw new IllegalStateException("Cannot call setTask twice on the same ServiceProxy.");
    }
    c = true;
    a = paramString;
    h = parambgn;
    b = System.currentTimeMillis();
    return f.bindService(g, i, 1);
  }
  
  protected final void c()
  {
    
    synchronized (i)
    {
      System.currentTimeMillis();
    }
    try
    {
      if (!k) {
        i.wait(j * 1000L);
      }
      return;
      localObject = finally;
      throw ((Throwable)localObject);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public final boolean d()
  {
    try
    {
      boolean bool = a(new bgk(this), "test");
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
}

/* Location:
 * Qualified Name:     bgj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */