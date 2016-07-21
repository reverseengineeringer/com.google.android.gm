import android.content.AsyncTaskLoader;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class bun
  extends AsyncTaskLoader<hel<String, btn>>
{
  private static final String a = cvl.a;
  private static final String[] b = { "_id", "data1", "contact_id", "photo_id" };
  private static final String[] c = { "_id", "data15" };
  private final Set<String> d;
  
  public bun(Context paramContext, Set<String> paramSet)
  {
    super(paramContext);
    d = paramSet;
  }
  
  public static hel<String, btn> a(Context paramContext, Set<String> paramSet, boolean paramBoolean)
  {
    ans.a("load contact photos util");
    Object localObject3;
    StringBuilder localStringBuilder;
    if (cwm.a(paramContext, "android.permission.READ_CONTACTS"))
    {
      bus.a("contacts_notification", "enabled");
      ans.a("build first query");
      localHashMap1 = new HashMap();
      localHashMap2 = new HashMap();
      localObject2 = new ArrayList();
      localObject3 = a(paramSet);
      localStringBuilder = new StringBuilder("mimetype").append("='vnd.android.cursor.item/email_v2' AND data1").append(" IN (");
      cwq.a(localStringBuilder, ((ArrayList)localObject3).size());
      localStringBuilder.append(')');
      ans.a();
      if (!cxd.d()) {
        break label200;
      }
      paramSet = "in_default_directory ASC, _id";
      paramContext = paramContext.getContentResolver();
    }
    label200:
    label212:
    label345:
    label347:
    do
    {
      try
      {
        ans.a("query 1");
        localObject1 = paramContext.query(ContactsContract.Data.CONTENT_URI, b, localStringBuilder.toString(), (String[])hft.a((Iterable)localObject3, String.class), paramSet);
      }
      finally
      {
        for (;;)
        {
          try
          {
            Object localObject1;
            String str;
            long l;
            btn localbtn;
            ans.a();
            if (localObject2 == null)
            {
              ans.a();
              paramSet = hel.a(localHashMap1);
              paramContext = paramSet;
              if (localObject2 == null) {
                continue;
              }
              ((Cursor)localObject2).close();
              return paramSet;
            }
            ans.a("get photo blob");
            int i = -1;
            i += 1;
            if (((Cursor)localObject2).moveToPosition(i))
            {
              paramSet = ((Cursor)localObject2).getBlob(1);
              if (paramSet == null) {
                break label751;
              }
              localObject1 = (Pair)localHashMap2.get(Long.valueOf(((Cursor)localObject2).getLong(0)));
              paramContext = (String)first;
              localObject1 = (btn)second;
              if (paramBoolean)
              {
                ans.a("decode bitmap");
                paramSet = BitmapFactory.decodeByteArray(paramSet, 0, paramSet.length);
                ans.a();
                localHashMap1.put(paramContext, new btn(a, paramSet));
                continue;
              }
              localHashMap1.put(paramContext, new btn(a, paramSet));
              continue;
            }
            ans.a();
            if (localObject2 != null) {
              ((Cursor)localObject2).close();
            }
            ans.a();
            return hel.a(localHashMap1);
          }
          finally
          {
            paramSet = (Set<String>)localObject2;
          }
          paramContext = finally;
          paramSet = null;
          continue;
        }
      }
      try
      {
        ans.a();
        if (localObject1 == null)
        {
          ans.a();
          if (localObject1 != null) {
            ((Cursor)localObject1).close();
          }
          paramContext = null;
          return paramContext;
          cvm.c(a, "READ_CONTACTS permission not granted. Falling back to letter tiles.", new Object[0]);
          bus.a("contacts_photo", "disabled");
          ans.a();
          return null;
          paramSet = null;
          break;
        }
        ans.a("get photo id");
        i = -1;
        i += 1;
        if (!((Cursor)localObject1).moveToPosition(i)) {
          break label347;
        }
        str = ((Cursor)localObject1).getString(1);
        l = ((Cursor)localObject1).getLong(2);
        localbtn = new btn(ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, l));
        if (!((Cursor)localObject1).isNull(3))
        {
          l = ((Cursor)localObject1).getLong(3);
          ((ArrayList)localObject2).add(Long.toString(l));
          localHashMap2.put(Long.valueOf(l), Pair.create(str, localbtn));
        }
        localHashMap1.put(str, localbtn);
        break label212;
        if (paramSet == null) {
          break label345;
        }
      }
      finally
      {
        paramSet = (Set<String>)localObject1;
      }
      paramSet.close();
      throw paramContext;
      ((Cursor)localObject1).close();
      ans.a();
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        str = (String)((Iterator)localObject3).next();
        if (!localHashMap1.containsKey(str)) {
          localHashMap1.put(str, new btn(null));
        }
      }
      if (!((ArrayList)localObject2).isEmpty()) {
        break label452;
      }
      ans.a();
      paramSet = hel.a(localHashMap1);
      paramContext = paramSet;
    } while (localObject1 == null);
    ((Cursor)localObject1).close();
    return paramSet;
    label452:
    ans.a("build second query");
    localObject2 = a((Collection)localObject2);
    localStringBuilder.setLength(0);
    localStringBuilder.append("_id IN (");
    cwq.a(localStringBuilder, ((ArrayList)localObject2).size());
    localStringBuilder.append(')');
    ans.a();
    ans.a("query 2");
    localObject2 = paramContext.query(ContactsContract.Data.CONTENT_URI, c, localStringBuilder.toString(), (String[])hft.a((Iterable)localObject2, String.class), paramSet);
  }
  
  private static ArrayList<String> a(Collection<String> paramCollection)
  {
    int j = Math.min(paramCollection.size(), 75);
    ArrayList localArrayList = new ArrayList(j);
    paramCollection = paramCollection.iterator();
    int i = 0;
    for (;;)
    {
      if (paramCollection.hasNext())
      {
        localArrayList.add((String)paramCollection.next());
        i += 1;
        if (i < j) {}
      }
      else
      {
        return localArrayList;
      }
    }
  }
  
  protected final void onStartLoading()
  {
    forceLoad();
  }
  
  protected final void onStopLoading()
  {
    cancelLoad();
  }
}

/* Location:
 * Qualified Name:     bun
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */