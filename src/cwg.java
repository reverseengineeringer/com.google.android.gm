import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

final class cwg
{
  final ConcurrentHashMap<cwf, Pair<Integer, Integer>> a = new ConcurrentHashMap();
  
  public final Pair<Integer, Integer> a(cwf paramcwf)
  {
    return (Pair)a.remove(paramcwf);
  }
  
  public final void a(Context paramContext)
  {
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      Object localObject4;
      try
      {
        Object localObject1 = ad.getStringSet("cache-active-notification-set", null);
        if (localObject1 == null) {
          break label356;
        }
        localObject1 = ((Set)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label356;
        }
        localObject2 = TextUtils.split((String)((Iterator)localObject1).next(), " ");
        if (localObject2.length != 4) {
          continue;
        }
        localObject3 = Uri.parse(localObject2[0]);
        localObject4 = paramContext.getContentResolver().query((Uri)localObject3, chh.c, null, null, null);
        if (localObject4 != null) {
          break label139;
        }
        paramContext = String.valueOf(cvm.a((Uri)localObject3));
        if (paramContext.length() != 0)
        {
          paramContext = "Unable to locate account for uri: ".concat(paramContext);
          throw new IllegalStateException(paramContext);
        }
      }
      finally {}
      paramContext = new String("Unable to locate account for uri: ");
      continue;
      label139:
      Object localObject5;
      for (;;)
      {
        try
        {
          if (((Cursor)localObject4).moveToFirst())
          {
            Account.b();
            localObject3 = cfw.a((Cursor)localObject4);
            ((Cursor)localObject4).close();
            localObject5 = Uri.parse(localObject2[1]);
            localObject4 = paramContext.getContentResolver().query((Uri)localObject5, chh.i, null, null, null);
            if (localObject4 != null) {
              break label262;
            }
            paramContext = String.valueOf(cvm.a((Uri)localObject5));
            if (paramContext.length() != 0)
            {
              paramContext = "Unable to locate folder for uri: ".concat(paramContext);
              throw new IllegalStateException(paramContext);
            }
          }
          else
          {
            ((Cursor)localObject4).close();
          }
        }
        finally
        {
          ((Cursor)localObject4).close();
        }
      }
      label262:
      label356:
      try
      {
        if (((Cursor)localObject4).moveToFirst())
        {
          localObject5 = new Folder((Cursor)localObject4);
          ((Cursor)localObject4).close();
          localObject3 = new cwf((Account)localObject3, (Folder)localObject5);
          localObject4 = Integer.valueOf(localObject2[2]);
          localObject2 = Integer.valueOf(localObject2[3]);
          a((cwf)localObject3, ((Integer)localObject4).intValue(), ((Integer)localObject2).intValue());
        }
        else
        {
          ((Cursor)localObject4).close();
        }
      }
      finally
      {
        ((Cursor)localObject4).close();
      }
    }
  }
  
  public final void a(cwf paramcwf, int paramInt1, int paramInt2)
  {
    Pair localPair = new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    a.put(paramcwf, localPair);
  }
  
  public final Integer b(cwf paramcwf)
  {
    paramcwf = (Pair)a.get(paramcwf);
    if (paramcwf != null) {
      return (Integer)first;
    }
    return null;
  }
  
  public final void b(Context paramContext)
  {
    try
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = a.keySet().iterator();
      while (localIterator.hasNext())
      {
        cwf localcwf = (cwf)localIterator.next();
        Integer localInteger1 = b(localcwf);
        Integer localInteger2 = c(localcwf);
        if ((localInteger1 != null) && (localInteger2 != null)) {
          localHashSet.add(TextUtils.join(" ", new String[] { a.g.toString(), b.c.b.toString(), localInteger1.toString(), localInteger2.toString() }));
        }
      }
      ae.putStringSet("cache-active-notification-set", localHashSet).apply();
    }
    finally {}
  }
  
  public final Integer c(cwf paramcwf)
  {
    paramcwf = (Pair)a.get(paramcwf);
    if (paramcwf != null) {
      return (Integer)second;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     cwg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */