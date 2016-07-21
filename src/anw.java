import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.Contacts;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class anw
{
  private static final String a = anw.class.getSimpleName();
  private final ContentResolver b;
  
  public anw(Context paramContext)
  {
    b = paramContext.getContentResolver();
  }
  
  private final boolean a(Collection<Long> paramCollection1, Collection<Long> paramCollection2, String paramString)
  {
    long l = System.currentTimeMillis();
    if (Build.VERSION.SDK_INT >= 14)
    {
      if (paramCollection2.isEmpty())
      {
        if (Log.isLoggable(a, 3)) {
          return false;
        }
      }
      else
      {
        paramCollection1 = anx.a.buildUpon().appendPath(TextUtils.join(",", paramCollection2)).appendQueryParameter("type", paramString).build();
        if (b.update(paramCollection1, new ContentValues(), null, null) > 0) {
          return true;
        }
        if (Log.isLoggable(a, 3))
        {
          paramCollection1 = String.valueOf(paramCollection2);
          new StringBuilder(String.valueOf(paramCollection1).length() + 31).append("update toward data rows ").append(paramCollection1).append(" failed");
        }
        return false;
      }
    }
    else if (paramCollection1.isEmpty())
    {
      if (Log.isLoggable(a, 3)) {
        return false;
      }
    }
    else
    {
      paramCollection2 = new StringBuilder();
      paramString = new ArrayList();
      Object localObject = new String[paramCollection1.size()];
      Iterator localIterator = paramCollection1.iterator();
      while (localIterator.hasNext()) {
        paramString.add(String.valueOf(((Long)localIterator.next()).longValue()));
      }
      Arrays.fill((Object[])localObject, "?");
      paramCollection2.append("_id IN (").append(TextUtils.join(",", (Object[])localObject)).append(")");
      if (Log.isLoggable(a, 3))
      {
        localObject = String.valueOf(paramCollection2.toString());
        if (((String)localObject).length() == 0) {
          break label372;
        }
        "contactId where: ".concat((String)localObject);
      }
      for (;;)
      {
        localObject = String.valueOf(paramString);
        new StringBuilder(String.valueOf(localObject).length() + 21).append("contactId selection: ").append((String)localObject);
        localObject = new ContentValues();
        ((ContentValues)localObject).put("last_time_contacted", Long.valueOf(l));
        if (b.update(ContactsContract.Contacts.CONTENT_URI, (ContentValues)localObject, paramCollection2.toString(), (String[])paramString.toArray(new String[0])) <= 0) {
          break;
        }
        return true;
        label372:
        new String("contactId where: ");
      }
      if (Log.isLoggable(a, 3))
      {
        paramCollection1 = String.valueOf(paramCollection1);
        new StringBuilder(String.valueOf(paramCollection1).length() + 34).append("update toward raw contacts ").append(paramCollection1).append(" failed");
      }
    }
    return false;
  }
  
  public final boolean a(Collection<String> paramCollection)
  {
    if (Log.isLoggable(a, 3))
    {
      localObject1 = String.valueOf(Arrays.toString(paramCollection.toArray()));
      if (((String)localObject1).length() == 0) {
        break label178;
      }
      "updateWithAddress: ".concat((String)localObject1);
    }
    for (;;)
    {
      if ((paramCollection != null) && (!paramCollection.isEmpty()))
      {
        localObject1 = new ArrayList();
        localObject2 = new StringBuilder();
        Object localObject3 = new String[paramCollection.size()];
        ((ArrayList)localObject1).addAll(paramCollection);
        Arrays.fill((Object[])localObject3, "?");
        ((StringBuilder)localObject2).append("data1 IN (").append(TextUtils.join(",", (Object[])localObject3)).append(")");
        paramCollection = b;
        localObject3 = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = (String[])((ArrayList)localObject1).toArray(new String[0]);
        paramCollection = paramCollection.query((Uri)localObject3, new String[] { "contact_id", "_id" }, (String)localObject2, (String[])localObject1, null);
        if (paramCollection != null) {
          break;
        }
        Log.w(a, "Cursor for Email.CONTENT_URI became null.");
      }
      return false;
      label178:
      new String("updateWithAddress: ");
    }
    Object localObject1 = new HashSet(paramCollection.getCount());
    Object localObject2 = new HashSet(paramCollection.getCount());
    try
    {
      paramCollection.move(-1);
      while (paramCollection.moveToNext())
      {
        ((Set)localObject1).add(Long.valueOf(paramCollection.getLong(0)));
        ((Set)localObject2).add(Long.valueOf(paramCollection.getLong(1)));
      }
    }
    finally
    {
      paramCollection.close();
    }
    return a(localCollection, (Collection)localObject2, "long_text");
  }
}

/* Location:
 * Qualified Name:     anw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */