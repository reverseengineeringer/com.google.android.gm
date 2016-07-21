import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;

public final class ben
  extends bgj
  implements bev
{
  bev a = null;
  Object b;
  
  public ben(Context paramContext)
  {
    super(paramContext, a(paramContext, "ACCOUNT_INTENT"));
  }
  
  public final int a(long paramLong)
  {
    a(new beo(this, paramLong), "getAccountColor");
    c();
    if (b == null) {
      return -16776961;
    }
    return ((Integer)b).intValue();
  }
  
  @Deprecated
  public final Bundle a(String paramString)
  {
    a(new bep(this, paramString), "getConfigurationData");
    c();
    if (b == null) {
      return null;
    }
    return (Bundle)b;
  }
  
  public final String a()
  {
    a(new beq(this), "getDeviceId");
    c();
    if (b == null) {
      return null;
    }
    return (String)b;
  }
  
  public final void a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      paramIBinder = null;
    }
    for (;;)
    {
      a = paramIBinder;
      return;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.android.emailcommon.service.IAccountService");
      if ((localIInterface != null) && ((localIInterface instanceof bev))) {
        paramIBinder = (bev)localIInterface;
      } else {
        paramIBinder = new bex(paramIBinder);
      }
    }
  }
  
  public final IBinder asBinder()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     ben
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */