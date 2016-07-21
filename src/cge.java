import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Arrays;

public final class cge
{
  public static int a(cgf paramcgf, long paramLong)
  {
    Cursor localCursor = chb.j(paramcgf.e(), paramLong);
    int i = 0;
    try
    {
      int j = localCursor.getColumnIndex("_id");
      while (localCursor.moveToNext())
      {
        int k = b(paramcgf, localCursor.getLong(j));
        i += k;
      }
      return i;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public static int a(cgf paramcgf, ContentValues paramContentValues)
  {
    int i = 0;
    int j = 0;
    SQLiteDatabase localSQLiteDatabase = paramcgf.e();
    Object localObject = paramContentValues.getAsString("blocking");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return j;
    }
    paramContentValues = paramContentValues.getAsString("placeholder");
    paramcgf.a();
    for (;;)
    {
      long l1;
      int k;
      try
      {
        localObject = chb.a((String)localObject);
        if (localObject == null) {
          return -1;
        }
        l1 = chb.a(localSQLiteDatabase, (long[])localObject);
        if (l1 == -1L) {
          return -1;
        }
        long l2;
        String str;
        if (TextUtils.isEmpty(paramContentValues))
        {
          paramContentValues = null;
          int m = localObject.length;
          j = 0;
          if (j >= m) {
            break label226;
          }
          l2 = localObject[j];
          if ((paramContentValues != null) && (Arrays.binarySearch(paramContentValues, l2) >= 0))
          {
            str = chb.e(localSQLiteDatabase, l2);
            if (TextUtils.isEmpty(str)) {
              chb.a(localSQLiteDatabase, l2, true);
            }
          }
          else
          {
            k = i;
            if (chb.f(localSQLiteDatabase, l2)) {
              break label253;
            }
            k = i + chb.b(localSQLiteDatabase, l2, true);
            break label253;
          }
        }
        else
        {
          paramContentValues = chb.a(paramContentValues);
          if (paramContentValues == null) {
            return -1;
          }
          Arrays.sort(paramContentValues);
          continue;
        }
        a(paramcgf, l1, l2, str);
        continue;
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      label226:
      localSQLiteDatabase.endTransaction();
      j = i;
      if (i != 0) {
        break;
      }
      paramcgf.e(l1);
      return i;
      label253:
      j += 1;
      i = k;
    }
  }
  
  public static int a(cgf paramcgf, Uri paramUri)
  {
    return cgd.a(paramcgf.e(), Long.parseLong(paramUri.getLastPathSegment()));
  }
  
  public static Cursor a(cgf paramcgf)
  {
    return cgd.c(paramcgf.e());
  }
  
  public static Uri a(cgf paramcgf, Uri paramUri, ContentValues paramContentValues)
  {
    Uri localUri = null;
    long l1 = chb.a(paramcgf.e(), paramContentValues);
    if (l1 > 0L)
    {
      long l2 = paramContentValues.getAsLong("messageKey").longValue();
      paramUri = paramcgf.a(paramUri);
      paramcgf.d().notifyChange(cgy.a(paramUri, "/saveTo/message", l2), null);
      localUri = cgy.a(paramUri, "/saveTo/save", l1);
    }
    return localUri;
  }
  
  private static void a(cgf paramcgf, long paramLong1, long paramLong2, String paramString)
  {
    String str = paramcgf.d(paramLong1);
    str = cdv.a(paramcgf.getContext(), str, paramLong2, paramString);
    if (str != null)
    {
      paramcgf.b(paramLong1, str);
      chb.a(paramcgf.e(), paramLong2, false);
      return;
    }
    cvm.d(paramcgf.f(), "Message %d did not update resource ID %s for save %d", new Object[] { Long.valueOf(paramLong1), paramString, Long.valueOf(paramLong2) });
  }
  
  private static int b(cgf paramcgf, long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = paramcgf.e();
    int i = 0;
    if (paramLong > 0L) {
      paramcgf.a();
    }
    try
    {
      i = chb.b(localSQLiteDatabase, paramLong);
      if (i > 0) {
        cgd.b(localSQLiteDatabase, paramLong);
      }
      paramcgf.b();
      return i;
    }
    finally
    {
      paramcgf.c();
    }
  }
  
  public static int b(cgf paramcgf, Uri paramUri)
  {
    long l1 = Long.parseLong(paramUri.getLastPathSegment());
    try
    {
      long l2 = chb.d(paramcgf.e(), l1);
      int i = b(paramcgf, l1);
      if (i > 0) {
        paramcgf.d().notifyChange(cgy.a(paramcgf.a(paramUri), "/saveTo/message", l2), null);
      }
      return i;
    }
    catch (IllegalArgumentException paramcgf) {}
    return 0;
  }
  
  public static Uri b(cgf paramcgf, Uri paramUri, ContentValues paramContentValues)
  {
    if (cgd.a(paramcgf.e(), paramContentValues) > 0L)
    {
      long l = paramContentValues.getAsLong("save").longValue();
      return cgy.a(paramcgf.a(paramUri), "/operation", l);
    }
    return null;
  }
  
  public static int c(cgf paramcgf, Uri paramUri)
  {
    return cgd.b(paramcgf.e(), Long.parseLong(paramUri.getLastPathSegment()));
  }
  
  public static int c(cgf paramcgf, Uri paramUri, ContentValues paramContentValues)
  {
    long l = Long.parseLong(paramUri.getLastPathSegment());
    int i = chb.a(paramcgf.e(), l, paramContentValues);
    if (i > 0)
    {
      paramcgf.d().notifyChange(paramUri, null);
      if (paramContentValues.containsKey("messageKey"))
      {
        l = paramContentValues.getAsLong("messageKey").longValue();
        paramcgf.d().notifyChange(cgy.a(paramcgf.a(paramUri), "/saveTo/message", l), null);
      }
    }
    return i;
  }
  
  public static int d(cgf paramcgf, Uri paramUri, ContentValues paramContentValues)
  {
    SQLiteDatabase localSQLiteDatabase = paramcgf.e();
    long l1 = Long.parseLong(paramUri.getLastPathSegment());
    paramcgf.a();
    long l2 = chb.d(localSQLiteDatabase, l1);
    label269:
    label271:
    label277:
    label282:
    for (;;)
    {
      try
      {
        if (!paramContentValues.containsKey("resourceId")) {
          break label277;
        }
        String str = paramContentValues.getAsString("resourceId");
        if (TextUtils.isEmpty(str)) {
          break label277;
        }
        i = chb.a(localSQLiteDatabase, l1, str);
        if ((i <= 0) || (!chb.g(localSQLiteDatabase, l1))) {
          break label282;
        }
        a(paramcgf, l2, l1, str);
      }
      finally
      {
        int k;
        paramcgf.c();
      }
      if (paramContentValues.containsKey("uploaded"))
      {
        if (paramContentValues.getAsInteger("uploaded").intValue() == 1)
        {
          j = 1;
          if (j == 0) {
            break label271;
          }
          k = chb.a(localSQLiteDatabase, l1);
          j = k;
          if (k > 0)
          {
            j = k;
            if (chb.h(localSQLiteDatabase, l1))
            {
              chb.b(localSQLiteDatabase, l1, false);
              j = k;
              if (!chb.c(localSQLiteDatabase, l2))
              {
                paramcgf.e(l2);
                j = k;
              }
            }
          }
          paramcgf.b();
          paramcgf.c();
          if ((i > 0) || (j > 0))
          {
            i = 1;
            if (i != 0) {
              paramcgf.d().notifyChange(cgy.a(paramcgf.a(paramUri), "/saveTo/message", l2), null);
            }
            if (i == 0) {
              break label269;
            }
            return 1;
          }
        }
        else
        {
          j = 0;
          continue;
        }
        i = 0;
        continue;
        return 0;
      }
      int j = 0;
      continue;
      int i = 0;
    }
  }
  
  public static Cursor d(cgf paramcgf, Uri paramUri)
  {
    Cursor localCursor = chb.j(paramcgf.e(), Long.parseLong(paramUri.getLastPathSegment()));
    localCursor.setNotificationUri(paramcgf.d(), paramUri);
    return localCursor;
  }
  
  public static Cursor e(cgf paramcgf, Uri paramUri)
  {
    return chb.i(paramcgf.e(), Long.parseLong(paramUri.getLastPathSegment()));
  }
  
  public static Cursor f(cgf paramcgf, Uri paramUri)
  {
    return cgd.c(paramcgf.e(), Long.parseLong(paramUri.getLastPathSegment()));
  }
}

/* Location:
 * Qualified Name:     cge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */