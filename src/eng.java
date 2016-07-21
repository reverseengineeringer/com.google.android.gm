import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Set;

final class eng
{
  final enh a;
  final Set<ServiceConnection> b;
  int c;
  boolean d;
  IBinder e;
  final enf f;
  ComponentName g;
  
  public eng(ene paramene, enf paramenf)
  {
    f = paramenf;
    a = new enh(this);
    b = new HashSet();
    c = 2;
  }
  
  public final void a(ServiceConnection paramServiceConnection, String paramString)
  {
    ene.c(h).a(ene.b(h), paramServiceConnection, paramString, f.a(), 3);
    b.add(paramServiceConnection);
  }
  
  public final void a(String paramString)
  {
    d = ene.c(h).a(ene.b(h), paramString, f.a(), a, 129);
    if (d)
    {
      c = 3;
      return;
    }
    try
    {
      ene.c(h).a(ene.b(h), a);
      return;
    }
    catch (IllegalArgumentException paramString) {}
  }
  
  public final boolean a()
  {
    return b.isEmpty();
  }
  
  public final boolean a(ServiceConnection paramServiceConnection)
  {
    return b.contains(paramServiceConnection);
  }
}

/* Location:
 * Qualified Name:     eng
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */