import android.content.Context;
import android.os.Bundle;
import com.android.email.provider.EmailProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class dvu
  implements dwd
{
  static final String a = cvl.a;
  private static final List<Integer> b;
  private WeakReference<dvv> c;
  
  static
  {
    Object[] arrayOfObject = hhz.b(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5) }, 6);
    b = hef.b(arrayOfObject, arrayOfObject.length);
  }
  
  public final void a(Context paramContext, Bundle paramBundle)
  {
    int j = 3;
    if (paramBundle == null) {}
    String str1;
    do
    {
      return;
      str1 = paramBundle.getString("email_address");
    } while (str1 == null);
    ArrayList localArrayList = new ArrayList();
    String str2 = paramBundle.getString("default_signature");
    if (str2 != null) {
      localArrayList.add(new dvx(str2));
    }
    int k = paramBundle.getInt("default_exchange_sync_window", -1);
    int i;
    if (b.contains(Integer.valueOf(k)))
    {
      i = j;
      switch (k)
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      localArrayList.add(new dvy(i));
      if (localArrayList.isEmpty()) {
        break;
      }
      if ((c != null) && (c.get() != null)) {
        ((dvv)c.get()).cancel(false);
      }
      paramBundle = new dvv();
      c = new WeakReference(paramBundle);
      a = paramContext.getApplicationContext();
      b = str1;
      c = localArrayList;
      paramBundle.executeOnExecutor(dvv.THREAD_POOL_EXECUTOR, new Void[0]);
      EmailProvider.a(paramContext);
      return;
      i = 6;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 5;
    }
  }
}

/* Location:
 * Qualified Name:     dvu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */