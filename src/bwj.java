import android.net.Uri;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.utils.NotificationActionUtils;
import com.android.mail.utils.NotificationActionUtils.NotificationAction;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class bwj
  implements Runnable
{
  bwj(bwg parambwg) {}
  
  public final void run()
  {
    Object localObject1 = NotificationActionUtils.a;
    Set localSet = NotificationActionUtils.b;
    HashSet localHashSet = hio.a(((oj)localObject1).a());
    int j = 0;
    int i = 0;
    Object localObject2;
    if (j < ((oj)localObject1).a())
    {
      localObject2 = (NotificationActionUtils.NotificationAction)((oj)localObject1).a(((oj)localObject1).e(j));
      Folder localFolder = d;
      if (a == cvw.b) {}
      for (int m = 1;; m = 0)
      {
        int k;
        if (!h.equals(a.p))
        {
          k = i;
          if (m == 0) {}
        }
        else
        {
          k = i;
          if (a.f)
          {
            localObject2 = c;
            localHashSet.add(localObject2);
            k = i;
            if (!a.k.contains(localObject2))
            {
              bwg.b.a(c, a, null);
              a.k.add(localObject2);
              k = 1;
            }
          }
        }
        j += 1;
        i = k;
        break;
      }
    }
    localObject1 = a.k.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Conversation)((Iterator)localObject1).next();
      if (!localHashSet.contains(localObject2))
      {
        if (localSet.contains(localObject2))
        {
          bwm.a(c, a);
          localSet.remove(localObject2);
        }
        ((Iterator)localObject1).remove();
        i = 1;
      }
    }
    if (i != 0) {
      a.j();
    }
  }
}

/* Location:
 * Qualified Name:     bwj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */