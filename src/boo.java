import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.ExtendedProperties;
import android.text.TextUtils;
import com.android.emailcommon.provider.Account;
import com.android.exchange.adapter.Parser;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.TimeZone;

public final class boo
  extends Parser
{
  private static final String[] a = { "eventTimezone", "dtstart", "dtend", "allDay", "originalInstanceTime", "originalAllDay", "original_id", "original_sync_id", "lastDate", "rrule", "rdate" };
  private static final String[] b = { "_id" };
  private final Map<String, ContentValues> c;
  private final ArrayList<bnw> d;
  private final Uri e;
  private final Uri f;
  private final Context g;
  
  private boo(Context paramContext, InputStream paramInputStream, Account paramAccount, Map<String, ContentValues> paramMap)
  {
    super(paramInputStream);
    g = paramContext;
    c = paramMap;
    d = new ArrayList();
    e = bnz.a(CalendarContract.Events.CONTENT_URI, d, bnq.c);
    f = bnz.a(CalendarContract.ExtendedProperties.CONTENT_URI, d, bnq.c);
  }
  
  private final bnw a(String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        Cursor localCursor = g.getContentResolver().query(CalendarContract.ExtendedProperties.CONTENT_URI, b, "event_id=? AND name=?", new String[] { String.valueOf(paramLong), "tziString" }, null);
        if (localCursor != null) {
          return new bnw(ContentProviderOperation.newInsert(f).withValue("name", "tziString").withValue("value", paramString).withValue("event_id", Long.valueOf(paramLong)));
        }
      }
      finally
      {
        try
        {
          if (!localCursor.moveToFirst()) {
            break label166;
          }
          l = localCursor.getLong(0);
          if (localCursor != null) {
            localCursor.close();
          }
          if (l < 0L) {
            break label125;
          }
          return new bnw(ContentProviderOperation.newUpdate(ContentUris.withAppendedId(f, l)).withValue("value", paramString));
        }
        finally
        {
          continue;
        }
        paramString = finally;
        localCursor = null;
        if (localCursor != null) {
          localCursor.close();
        }
      }
      label125:
      label166:
      long l = -1L;
    }
  }
  
  public static boolean a(Context paramContext, InputStream paramInputStream, Account paramAccount, Map<String, ContentValues> paramMap)
  {
    boolean bool = false;
    paramInputStream = new boo(paramContext, paramInputStream, paramAccount, paramMap);
    if (paramInputStream.d()) {}
    try
    {
      bnz.a(paramContext.getContentResolver(), "com.android.calendar", d);
      bool = true;
      return bool;
    }
    catch (RemoteException paramContext) {}
    return false;
  }
  
  public final boolean d()
  {
    boolean bool2 = true;
    if (b(0) != 1285) {
      throw new boy(this);
    }
    label61:
    do
    {
      i();
      do
      {
        bool1 = bool2;
        if (b(0) == 1) {
          break;
        }
        if (l != 1293) {
          break label61;
        }
      } while (h() == 1);
      boolean bool1 = false;
      return bool1;
    } while (l != 1294);
    label71:
    label103:
    label479:
    label482:
    label483:
    for (;;)
    {
      Object localObject1;
      Object localObject3;
      Object localObject2;
      int i;
      if (b(1294) != 3) {
        if (l == 1286)
        {
          localObject1 = null;
          localObject3 = null;
          localObject2 = null;
          i = 1;
          if (b(1286) == 3) {
            break label482;
          }
          if (l == 1293)
          {
            i = h();
            if (i == 1) {
              break label479;
            }
          }
        }
      }
      for (;;)
      {
        if ((i != 1) || (TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label483;
        }
        localObject2 = bsx.a((String)localObject2, (String)localObject3);
        localObject3 = (ContentValues)c.get(localObject2);
        if (localObject3 == null) {
          break label71;
        }
        String str1 = bsx.a((String)localObject1).getID();
        if (str1.equals(((ContentValues)localObject3).getAsString("eventTimezone"))) {
          break label71;
        }
        localObject2 = ((ContentValues)localObject3).getAsLong("_id");
        if (localObject2 == null) {
          break label71;
        }
        ContentValues localContentValues = new ContentValues();
        String[] arrayOfString = a;
        int j = arrayOfString.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            String str2 = arrayOfString[i];
            if (((ContentValues)localObject3).containsKey(str2)) {
              localContentValues.put(str2, ((ContentValues)localObject3).getAsString(str2));
            }
            i += 1;
            continue;
            if (l == 18)
            {
              localObject2 = g();
              break;
            }
            if (l == 13)
            {
              localObject3 = g();
              break;
            }
            if (l == 1291)
            {
              localObject1 = null;
              while (b(1291) != 3) {
                switch (l)
                {
                default: 
                  i();
                  break;
                case 261: 
                  localObject1 = g();
                }
              }
              break;
            }
            i();
            break;
          }
        }
        localContentValues.put("eventTimezone", str1);
        localObject3 = new bnw(ContentProviderOperation.newUpdate(ContentUris.withAppendedId(e, ((Long)localObject2).longValue())).withValues(localContentValues));
        d.add(localObject3);
        d.add(a((String)localObject1, ((Long)localObject2).longValue()));
        break label71;
        i();
        break label71;
        break;
        break label103;
      }
    }
  }
}

/* Location:
 * Qualified Name:     boo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */