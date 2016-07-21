import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract.ExtendedProperties;
import java.util.ArrayList;
import java.util.Map;

public final class boa
  extends ArrayList<bnw>
{
  private static final long serialVersionUID = 1L;
  public int a = 0;
  int b = 0;
  final Uri c;
  private final ContentResolver d;
  private final Uri e;
  private final Uri f;
  private final Uri g;
  
  public boa(ContentResolver paramContentResolver, Uri paramUri1, Uri paramUri2, Uri paramUri3, Uri paramUri4)
  {
    d = paramContentResolver;
    e = paramUri1;
    c = paramUri2;
    f = paramUri3;
    g = paramUri4;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    a(new bnw(ContentProviderOperation.newInsert(f).withValue("minutes", Integer.valueOf(paramInt1)).withValue("method", Integer.valueOf(1)), "event_id", paramInt2));
  }
  
  public final void a(long paramLong, String paramString, Map<String, String> paramMap)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramString;
    if (paramMap != null)
    {
      int i = 0;
      while (i < 2)
      {
        paramString = d.query(c, bnz.f, new String[] { "_id=?", "original_sync_id=?" }[i], new String[][] { { String.valueOf(paramLong) }, arrayOfString }[i], null);
        if (paramString != null) {
          try
          {
            int j = paramString.getColumnIndex("_id");
            int k = paramString.getColumnIndex("_sync_id");
            while (paramString.moveToNext()) {
              paramMap.put(paramString.getString(k), paramString.getString(j));
            }
          }
          finally
          {
            paramString.close();
          }
        }
        i += 1;
      }
    }
    a(new bnw(ContentProviderOperation.newDelete(ContentUris.withAppendedId(c, paramLong))));
    a(new bnw(ContentProviderOperation.newDelete(c).withSelection("original_sync_id=?", arrayOfString)));
  }
  
  public final void a(ContentValues paramContentValues)
  {
    a(paramContentValues, b);
  }
  
  public final void a(ContentValues paramContentValues, int paramInt)
  {
    a(new bnw(ContentProviderOperation.newInsert(e).withValues(paramContentValues), "event_id", paramInt));
  }
  
  public final void a(ContentValues paramContentValues, long paramLong)
  {
    paramContentValues.put("event_id", Long.valueOf(paramLong));
    a(new bnw(ContentProviderOperation.newInsert(e).withValues(paramContentValues)));
  }
  
  public final void a(String paramString1, String paramString2)
  {
    a(new bnw(ContentProviderOperation.newInsert(g).withValue("name", paramString1).withValue("value", paramString2), "event_id", b));
  }
  
  public final void a(String paramString1, String paramString2, long paramLong)
  {
    Cursor localCursor = d.query(CalendarContract.ExtendedProperties.CONTENT_URI, bnz.g, "event_id=? AND name=?", new String[] { Long.toString(paramLong), paramString1 }, null);
    paramLong = -1L;
    long l = paramLong;
    if (localCursor != null) {}
    try
    {
      if (localCursor.moveToFirst()) {
        paramLong = localCursor.getLong(0);
      }
      localCursor.close();
      l = paramLong;
      if (l >= 0L)
      {
        a(new bnw(ContentProviderOperation.newUpdate(ContentUris.withAppendedId(g, l)).withValue("value", paramString2)));
        return;
      }
    }
    finally
    {
      localCursor.close();
    }
    a(paramString1, paramString2);
  }
  
  public final boolean a(bnw parambnw)
  {
    super.add(parambnw);
    a += 1;
    return true;
  }
  
  public final int b(bnw parambnw)
  {
    b = a;
    a(parambnw);
    return b;
  }
}

/* Location:
 * Qualified Name:     boa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */