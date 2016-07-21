import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class dwj<T>
{
  final dwp<T> a;
  final String b;
  String c;
  String d;
  int e;
  int f;
  dwn g;
  final Queue<dws> h = new LinkedList();
  String i;
  gvr j;
  long k;
  String l;
  boolean m;
  Runnable n = new dwl(this);
  private final Context o;
  private final String p;
  private final dwo q = new dwo(this);
  private final Handler r = new Handler();
  private final Runnable s = new dwk(this);
  
  dwj(Context paramContext, dwp<T> paramdwp, Bundle paramBundle, String paramString1, String paramString2)
  {
    o = paramContext;
    a = paramdwp;
    b = paramString1;
    p = paramString2;
    if ((paramBundle != null) && (paramBundle.containsKey("asfeQueryController-current-account")))
    {
      i = paramBundle.getString("asfeQueryController-current-account");
      b();
      return;
    }
    a();
  }
  
  private final void b()
  {
    Object localObject2 = o;
    Object localObject1 = Collections.singletonList("https://www.googleapis.com/auth/appssearch");
    boolean bool;
    if ((localObject1 != null) && (((Collection)localObject1).iterator().hasNext()))
    {
      bool = true;
      hbe.a(bool);
      localObject1 = String.valueOf(gufa' 'a.a((Iterable)localObject1));
      if (((String)localObject1).length() == 0) {
        break label184;
      }
      localObject1 = "oauth2: ".concat((String)localObject1);
      label72:
      localObject2 = new gqi((Context)localObject2, (String)localObject1);
      localObject1 = i;
      e = c.a((String)localObject1);
      if (e == null) {
        localObject1 = null;
      }
      d = ((String)localObject1);
      localObject1 = d;
      localObject2 = new dwm(this, (gqi)localObject2);
      localObject2 = new gvs(new gsq(), new gqb(), (gru)localObject2);
      if (localObject1 == null) {
        break label197;
      }
    }
    for (;;)
    {
      j = new gvr(((gvs)localObject2).g((String)localObject1).h(p));
      return;
      bool = false;
      break;
      label184:
      localObject1 = new String("oauth2: ");
      break label72;
      label197:
      localObject1 = "https://www.googleapis.com";
    }
  }
  
  public final void a()
  {
    Account localAccount = a.c();
    if ((localAccount == null) || (TextUtils.equals(name, i))) {
      return;
    }
    i = name;
    b();
  }
  
  public final void a(String paramString)
  {
    h.add(new dws(paramString.hashCode(), SystemClock.elapsedRealtime()));
    b(paramString);
  }
  
  final void b(String paramString)
  {
    long l1 = SystemClock.elapsedRealtime() - k;
    if (l1 < 150L)
    {
      l = paramString;
      if (!m)
      {
        r.postDelayed(s, 150L - l1);
        m = true;
      }
      return;
    }
    l = null;
    q.filter(paramString);
  }
}

/* Location:
 * Qualified Name:     dwj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */