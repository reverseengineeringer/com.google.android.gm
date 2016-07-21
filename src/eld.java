import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;

public final class eld
  extends Fragment
  implements DialogInterface.OnCancelListener, gp<ConnectionResult>
{
  final SparseArray<elf> a = new SparseArray();
  private boolean b;
  private int c = -1;
  private ConnectionResult d;
  private final Handler e = new Handler(Looper.getMainLooper());
  
  public static eld a(fj paramfj)
  {
    enz.b("Must be called from main thread of process");
    fq localfq = paramfj.a_();
    try
    {
      eld localeld = (eld)localfq.a("GmsSupportLoaderLifecycleFragment");
      if (localeld != null)
      {
        paramfj = localeld;
        if (!w) {}
      }
      else
      {
        paramfj = new eld();
        localfq.a().a(paramfj, "GmsSupportLoaderLifecycleFragment").b();
        localfq.b();
      }
      return paramfj;
    }
    catch (ClassCastException paramfj)
    {
      throw new IllegalStateException("Fragment with tag GmsSupportLoaderLifecycleFragment is not a SupportLoaderLifecycleFragment", paramfj);
    }
  }
  
  private final void a(int paramInt, ConnectionResult paramConnectionResult)
  {
    Log.w("GmsSupportLoaderLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
    Object localObject = (elf)a.get(paramInt);
    if (localObject != null)
    {
      a.remove(paramInt);
      j().a(paramInt);
      localObject = b;
      if (localObject != null) {
        ((eje)localObject).a(paramConnectionResult);
      }
    }
    u();
  }
  
  private final void u()
  {
    int i = 0;
    b = false;
    c = -1;
    d = null;
    go localgo = j();
    while (i < a.size())
    {
      int j = a.keyAt(i);
      ele localele = a(j);
      if ((localele != null) && (b))
      {
        localgo.a(j);
        localgo.a(j, null, this);
      }
      i += 1;
    }
  }
  
  final ele a(int paramInt)
  {
    try
    {
      ele localele = (ele)j().b(paramInt);
      return localele;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new IllegalStateException("Unknown loader in SupportLoaderLifecycleFragment", localClassCastException);
    }
  }
  
  public final jy<ConnectionResult> a(int paramInt, Bundle paramBundle)
  {
    return new ele(f(), a.get(paramInt)).a);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    int i = 1;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        break label60;
      }
      u();
      return;
      if (eik.a(f()) != 0) {
        break;
      }
      paramInt1 = i;
      continue;
      if (paramInt2 != -1) {
        break;
      }
      paramInt1 = i;
    }
    label60:
    a(c, d);
  }
  
  public final void a(Activity paramActivity)
  {
    super.a(paramActivity);
    int i = 0;
    if (i < a.size())
    {
      int j = a.keyAt(i);
      paramActivity = a(j);
      if ((paramActivity != null) && (a.valueAt(i)).a != a)) {
        j().a(j, this);
      }
      for (;;)
      {
        i += 1;
        break;
        j().a(j, null, this);
      }
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle != null)
    {
      b = paramBundle.getBoolean("resolving_error", false);
      c = paramBundle.getInt("failed_client_id", -1);
      if (c >= 0) {
        d = new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution"));
      }
    }
  }
  
  public final void b() {}
  
  public final void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    paramBundle.putBoolean("resolving_error", b);
    if (c >= 0)
    {
      paramBundle.putInt("failed_client_id", c);
      paramBundle.putInt("failed_status", d.c);
      paramBundle.putParcelable("failed_resolution", d.d);
    }
  }
  
  public final void n_()
  {
    super.n_();
    if (!b)
    {
      int i = 0;
      while (i < a.size())
      {
        j().a(a.keyAt(i), null, this);
        i += 1;
      }
    }
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    a(c, new ConnectionResult(13, null));
  }
}

/* Location:
 * Qualified Name:     eld
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */