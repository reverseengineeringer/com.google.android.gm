import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.AuthAccountResult;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public final class gcs
  extends emr<gcn>
  implements gdb
{
  private final boolean f;
  private final emc g;
  private final gcd h;
  private Integer i;
  private final ExecutorService j;
  
  public gcs(Context paramContext, Looper paramLooper, boolean paramBoolean, emc paramemc, ejc paramejc, eje parameje, ExecutorService paramExecutorService)
  {
    super(paramContext, paramLooper, 44, paramemc, paramejc, parameje);
    f = paramBoolean;
    g = paramemc;
    h = g;
    i = h;
    j = paramExecutorService;
  }
  
  protected final String a()
  {
    return "com.google.android.gms.signin.service.START";
  }
  
  public final void a(eme parameme, Set<Scope> paramSet, gck paramgck)
  {
    enz.a(paramgck, "Expecting a valid ISignInCallbacks");
    try
    {
      ((gcn)k()).a(new AuthAccountRequest(parameme, paramSet), paramgck);
      return;
    }
    catch (RemoteException parameme)
    {
      Log.w("SignInClientImpl", "Remote service probably died when authAccount is called");
      try
      {
        paramgck.a(new ConnectionResult(8, null), new AuthAccountResult());
        return;
      }
      catch (RemoteException parameme)
      {
        Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.");
      }
    }
  }
  
  public final void a(eme parameme, boolean paramBoolean)
  {
    try
    {
      ((gcn)k()).a(parameme, i.intValue(), paramBoolean);
      return;
    }
    catch (RemoteException parameme)
    {
      Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
    }
  }
  
  public final void a(ent parament)
  {
    enz.a(parament, "Expecting a valid IResolveAccountCallbacks");
    try
    {
      Object localObject = g;
      if (a != null) {}
      for (localObject = a;; localObject = new Account("<<default account>>", "com.google"))
      {
        ((gcn)k()).a(new ResolveAccountRequest((Account)localObject, i.intValue()), parament);
        return;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when resolveAccount is called");
      try
      {
        parament.a(new ResolveAccountResponse());
        return;
      }
      catch (RemoteException parament)
      {
        Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.");
      }
    }
  }
  
  protected final String b()
  {
    return "com.google.android.gms.signin.internal.ISignInService";
  }
  
  public final boolean e()
  {
    return f;
  }
  
  protected final Bundle i()
  {
    Object localObject = h;
    Integer localInteger = g.h;
    ExecutorService localExecutorService = j;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", b);
    localBundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", c);
    localBundle.putString("com.google.android.gms.signin.internal.serverClientId", d);
    if (e != null) {
      localBundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper(new gct((gcd)localObject, localExecutorService).asBinder()));
    }
    if (localInteger != null) {
      localBundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", localInteger.intValue());
    }
    localObject = g.e;
    if (!a.getPackageName().equals(localObject)) {
      localBundle.putString("com.google.android.gms.signin.internal.realClientPackageName", g.e);
    }
    return localBundle;
  }
  
  public final void m()
  {
    try
    {
      ((gcn)k()).a(i.intValue());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
    }
  }
  
  public final void n()
  {
    a(new emx(this));
  }
}

/* Location:
 * Qualified Name:     gcs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */