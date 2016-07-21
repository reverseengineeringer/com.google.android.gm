import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class eja
{
  public Account a;
  public final Set<Scope> b = new HashSet();
  fj c;
  private int d;
  private View e;
  private String f;
  private String g;
  private final Map<eip<?>, emd> h = new fnl();
  private final Context i;
  private final Map<eip<?>, eir> j = new fnl();
  private int k = -1;
  private int l = -1;
  private eje m;
  private Looper n;
  private eih o = eih.b;
  private eiq<? extends gdb, gcd> p = gcx.c;
  private final ArrayList<ejc> q = new ArrayList();
  private final ArrayList<eje> r = new ArrayList();
  private gce s = new gce();
  
  public eja(Context paramContext)
  {
    i = paramContext;
    n = paramContext.getMainLooper();
    f = paramContext.getPackageName();
    g = paramContext.getClass().getName();
  }
  
  private final emc b()
  {
    return new emc(a, b, h, d, e, f, g, s.a());
  }
  
  public final eiz a()
  {
    boolean bool2 = true;
    boolean bool1;
    Object localObject2;
    Object localObject1;
    if (!j.isEmpty())
    {
      bool1 = true;
      enz.b(bool1, "must call addApi() to add at least one API");
      if (k < 0) {
        break label139;
      }
      localObject2 = new ekj(i.getApplicationContext(), n, b(), o, p, j, q, r, k, -1);
      localObject1 = ela.a(c);
      if (localObject1 != null) {
        break label128;
      }
      new Handler(i.getMainLooper()).post(new ejb(this, (eiz)localObject2));
    }
    for (;;)
    {
      return (eiz)localObject2;
      bool1 = false;
      break;
      label128:
      a((ela)localObject1, (eiz)localObject2);
    }
    label139:
    if (l >= 0)
    {
      eld localeld = eld.a(c);
      int i1 = l;
      if (localeld.f() != null)
      {
        localObject1 = localeld.a(i1);
        if (localObject1 != null)
        {
          localObject2 = a;
          label188:
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new ekj(i.getApplicationContext(), n, b(), o, p, j, q, r, -1, l);
          }
          i1 = l;
          localObject2 = m;
          enz.a(localObject1, "GoogleApiClient instance cannot be null");
          if (a.indexOfKey(i1) >= 0) {
            break label361;
          }
        }
      }
      label361:
      for (bool1 = bool2;; bool1 = false)
      {
        enz.a(bool1, "Already managing a GoogleApiClient with id " + i1);
        localObject2 = new elf((eiz)localObject1, (eje)localObject2);
        a.put(i1, localObject2);
        localObject2 = localObject1;
        if (localeld.f() == null) {
          break;
        }
        gq.a = false;
        localeld.j().a(i1, null, localeld);
        return (eiz)localObject1;
        localObject2 = null;
        break label188;
      }
    }
    return new ekj(i, n, b(), o, p, j, q, r, -1, -1);
  }
  
  public final eja a(eip<? extends Object> parameip)
  {
    j.put(parameip, null);
    b.addAll(parameip.a().a());
    return this;
  }
  
  public final <O extends eis> eja a(eip<O> parameip, O paramO)
  {
    enz.a(paramO, "Null options are not permitted for this Api");
    j.put(parameip, paramO);
    b.addAll(parameip.a().a());
    return this;
  }
  
  public final eja a(ejc paramejc)
  {
    q.add(paramejc);
    return this;
  }
  
  public final eja a(eje parameje)
  {
    r.add(parameje);
    return this;
  }
  
  final void a(ela paramela, eiz parameiz)
  {
    int i1 = k;
    Object localObject = m;
    enz.a(parameiz, "GoogleApiClient instance cannot be null");
    if (c.indexOfKey(i1) < 0) {}
    for (boolean bool = true;; bool = false)
    {
      enz.a(bool, "Already managing a GoogleApiClient with id " + i1);
      localObject = new elb(paramela, i1, parameiz, (eje)localObject);
      c.put(i1, localObject);
      if ((a) && (!b)) {
        parameiz.b();
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     eja
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */