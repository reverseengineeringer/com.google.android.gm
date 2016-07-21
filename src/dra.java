import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObservable;
import android.net.Uri;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class dra
{
  public static Object g = new Object();
  public static Map<Uri, drb> h = new HashMap();
  public static Map<drb, Set<dra>> i = new HashMap();
  public final ArrayList<dqz> a = new ArrayList();
  public final Context b;
  public final String c;
  public Uri d;
  public final boolean e;
  public final DataSetObservable f = new DataSetObservable();
  
  dra(Context paramContext, String paramString, Uri paramUri, boolean paramBoolean)
  {
    b = paramContext;
    c = paramString;
    e = paramBoolean;
    if (paramContext == null) {
      dri.e(dri.a, "Attempt to construct LabelList without context. Uri: %s", new Object[] { paramUri });
    }
    do
    {
      return;
      paramUri = paramContext.getContentResolver().query(paramUri, dpy.t, null, null, null);
    } while (paramUri == null);
    for (;;)
    {
      try
      {
        paramString = new dre(paramContext, paramString, paramUri);
        if (!paramUri.moveToNext()) {
          break;
        }
        paramContext = null;
        if (paramUri != null)
        {
          long l1 = paramUri.getLong(c);
          paramContext = paramUri.getString(d);
          String str1 = paramUri.getString(e);
          int j = paramUri.getInt(f);
          int k = paramUri.getInt(g);
          if (paramUri.getInt(i) != 0)
          {
            paramBoolean = true;
            String str2 = paramUri.getString(h);
            int m = paramUri.getInt(j);
            int n = paramUri.getInt(k);
            long l2 = paramUri.getLong(l);
            paramContext = new dqz(a, b, l1, paramContext, str1, str2, j, k, paramBoolean, m, n, l2, m);
          }
        }
        else
        {
          a.add(paramContext);
          continue;
        }
        paramBoolean = false;
      }
      finally
      {
        paramUri.close();
      }
    }
    paramUri.close();
  }
  
  public final dqz a(int paramInt)
  {
    return (dqz)a.get(paramInt);
  }
  
  public final dqz a(String paramString)
  {
    int k = a.size();
    int j = 0;
    while (j < k)
    {
      dqz localdqz = a(j);
      if (paramString.equals(localdqz.b())) {
        return localdqz;
      }
      j += 1;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     dra
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */