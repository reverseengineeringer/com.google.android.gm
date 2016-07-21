import android.content.Context;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class cpp
{
  private static final Comparator<Folder> e = new cpr();
  final Context a;
  Account b = null;
  final cvn<String, cps> c = new cvn(7);
  final cfx d = new cpq(this);
  
  public cpp(Context paramContext)
  {
    a = paramContext;
  }
  
  public final ArrayList<Folder> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (b == null) {}
    for (Object localObject1 = cus.a;; localObject1 = new cus(Settings.a(b.z)))
    {
      if (!((cus)localObject1).equals(cus.a)) {
        localArrayList.add(localObject1);
      }
      Object localObject2 = new ArrayList();
      ((List)localObject2).addAll(c.values());
      Collections.sort((List)localObject2);
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        cps localcps = (cps)((Iterator)localObject2).next();
        if (!localArrayList.contains(a.c)) {
          ((ArrayList)localObject1).add(a);
        }
      } while (((ArrayList)localObject1).size() != 5);
      Collections.sort((List)localObject1, e);
      return (ArrayList<Folder>)localObject1;
    }
  }
  
  final void a(Account paramAccount)
  {
    if ((b == null) || (!b.b(paramAccount))) {}
    for (int i = 1;; i = 0)
    {
      b = paramAccount;
      if (i != 0) {
        c.clear();
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     cpp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */