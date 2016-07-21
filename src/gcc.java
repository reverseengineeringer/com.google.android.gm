import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

public final class gcc
{
  private static final Object a = new Object();
  private static Method b = null;
  
  public static void a(Context arg0)
  {
    enz.a(???, "Context must not be null");
    eik.b(???);
    Context localContext = eik.d(???);
    if (localContext == null)
    {
      Log.e("ProviderInstaller", "Failed to get remote context");
      throw new eii(8);
    }
    synchronized (a)
    {
      try
      {
        if (b == null) {
          b = localContext.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[] { Context.class });
        }
        b.invoke(null, new Object[] { localContext });
        return;
      }
      catch (Exception localException)
      {
        Log.e("ProviderInstaller", "Failed to install provider: " + localException.getMessage());
        throw new eii(8);
      }
    }
  }
}

/* Location:
 * Qualified Name:     gcc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */