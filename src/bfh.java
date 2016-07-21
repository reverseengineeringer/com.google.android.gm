import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.android.emailcommon.provider.Policy;

public final class bfh
  extends bgj
  implements bfe
{
  bfe a = null;
  Object b = null;
  
  public bfh(Context paramContext)
  {
    super(paramContext, a(paramContext, "POLICY_INTENT"));
  }
  
  public static void a(Context paramContext, long paramLong, Policy paramPolicy, String paramString)
  {
    a(paramContext, paramLong, paramPolicy, paramString, true);
  }
  
  public static void a(Context paramContext, long paramLong, Policy paramPolicy, String paramString, boolean paramBoolean)
  {
    try
    {
      new bfh(paramContext).a(paramLong, paramPolicy, paramString, paramBoolean);
      return;
    }
    catch (RemoteException paramContext)
    {
      throw new IllegalStateException("PolicyService transaction failed");
    }
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      boolean bool = new bfh(paramContext).b();
      return bool;
    }
    catch (RemoteException paramContext) {}
    return false;
  }
  
  public static boolean a(Context paramContext, Policy paramPolicy)
  {
    try
    {
      boolean bool = new bfh(paramContext).a(paramPolicy);
      return bool;
    }
    catch (RemoteException paramContext)
    {
      cvm.e("PolicyServiceProxy", paramContext, "PolicyServiceProxy.isActive failed", new Object[0]);
    }
    return false;
  }
  
  public final void a()
  {
    a(new bfl(this), "remoteWipe");
  }
  
  public final void a(long paramLong, Policy paramPolicy, String paramString)
  {
    a(paramLong, paramPolicy, paramString, true);
  }
  
  public final void a(long paramLong, Policy paramPolicy, String paramString, boolean paramBoolean)
  {
    if (paramPolicy == null) {
      cvm.d("PolicyServiceProxy", new NullPointerException(), "Null Policy", new Object[0]);
    }
    a(new bfj(this, paramLong, paramPolicy, paramString, paramBoolean), "setAccountPolicy2");
    c();
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    a(new bfm(this, paramLong, paramBoolean), "setAccountHoldFlag");
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
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.android.emailcommon.service.IPolicyService");
      if ((localIInterface != null) && ((localIInterface instanceof bfe))) {
        paramIBinder = (bfe)localIInterface;
      } else {
        paramIBinder = new bfg(paramIBinder);
      }
    }
  }
  
  public final boolean a(Policy paramPolicy)
  {
    a(new bfi(this, paramPolicy), "isActive");
    c();
    if (b == null)
    {
      cvm.e("PolicyServiceProxy", "PolicyService unavailable in isActive; assuming false", new Object[0]);
      return false;
    }
    return ((Boolean)b).booleanValue();
  }
  
  public final IBinder asBinder()
  {
    return null;
  }
  
  public final boolean b()
  {
    a(new bfk(this), "canDisableCamera");
    c();
    if (b == null)
    {
      cvm.e("PolicyServiceProxy", "PolicyService unavailable in canDisableCamera; assuming false", new Object[0]);
      return false;
    }
    return ((Boolean)b).booleanValue();
  }
}

/* Location:
 * Qualified Name:     bfh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */