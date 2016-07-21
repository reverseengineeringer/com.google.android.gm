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
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class ela
  extends Fragment
  implements DialogInterface.OnCancelListener
{
  boolean a;
  boolean b;
  final SparseArray<elb> c = new SparseArray();
  private int d = -1;
  private ConnectionResult e;
  private final Handler f = new Handler(Looper.getMainLooper());
  
  public static ela a(fj paramfj)
  {
    enz.b("Must be called from main thread of process");
    paramfj = paramfj.a_();
    try
    {
      ela localela = (ela)paramfj.a("GmsSupportLifecycleFragment");
      if (localela != null)
      {
        paramfj = localela;
        if (!w) {}
      }
      else
      {
        paramfj = null;
      }
      return paramfj;
    }
    catch (ClassCastException paramfj)
    {
      throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", paramfj);
    }
  }
  
  private final void a(int paramInt, ConnectionResult paramConnectionResult)
  {
    Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
    Object localObject = (elb)c.get(paramInt);
    if (localObject != null)
    {
      elb localelb = (elb)c.get(paramInt);
      c.remove(paramInt);
      if (localelb != null)
      {
        b.b(localelb);
        b.d();
      }
      localObject = c;
      if (localObject != null) {
        ((eje)localObject).a(paramConnectionResult);
      }
    }
    b();
  }
  
  public static ela b(fj paramfj)
  {
    ela localela = a(paramfj);
    fq localfq = paramfj.a_();
    paramfj = localela;
    if (localela == null)
    {
      paramfj = new ela();
      localfq.a().a(paramfj, "GmsSupportLifecycleFragment").c();
      localfq.b();
    }
    return paramfj;
  }
  
  private final void b()
  {
    b = false;
    d = -1;
    e = null;
    int i = 0;
    while (i < c.size())
    {
      c.valueAt(i)).b.b();
      i += 1;
    }
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
      b();
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
    a(d, e);
  }
  
  public final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle != null)
    {
      b = paramBundle.getBoolean("resolving_error", false);
      d = paramBundle.getInt("failed_client_id", -1);
      if (d >= 0) {
        e = new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution"));
      }
    }
  }
  
  public final void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    int i = 0;
    while (i < c.size())
    {
      paramFileDescriptor = (elb)c.valueAt(i);
      paramPrintWriter.append(paramString).append("GoogleApiClient #").print(a);
      paramPrintWriter.println(":");
      b.a(paramString + "  ", paramPrintWriter);
      i += 1;
    }
  }
  
  public final void d()
  {
    super.d();
    a = false;
    int i = 0;
    while (i < c.size())
    {
      c.valueAt(i)).b.d();
      i += 1;
    }
  }
  
  public final void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    paramBundle.putBoolean("resolving_error", b);
    if (d >= 0)
    {
      paramBundle.putInt("failed_client_id", d);
      paramBundle.putInt("failed_status", e.c);
      paramBundle.putParcelable("failed_resolution", e.d);
    }
  }
  
  public final void n_()
  {
    super.n_();
    a = true;
    if (!b)
    {
      int i = 0;
      while (i < c.size())
      {
        c.valueAt(i)).b.b();
        i += 1;
      }
    }
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    a(d, new ConnectionResult(13, null));
  }
}

/* Location:
 * Qualified Name:     ela
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */