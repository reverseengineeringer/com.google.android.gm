import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class bec
{
  public static final String a = "0";
  public static final String b = "1";
  public static final String c = "2";
  public final long d;
  public final String e;
  public long f;
  
  protected bec(long paramLong1, String paramString, long paramLong2)
  {
    d = paramLong1;
    e = paramString;
    f = paramLong2;
  }
  
  protected static int a(ContentResolver paramContentResolver, Uri paramUri, long[] paramArrayOfLong, int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return paramContentResolver.delete(paramUri, a(paramArrayOfLong, paramInt), null);
  }
  
  static int a(ContentResolver paramContentResolver, Uri paramUri, long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("status", Integer.valueOf(paramInt2));
    return paramContentResolver.update(paramUri, localContentValues, a(paramArrayOfLong, paramInt1), null);
  }
  
  protected static Cursor a(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString, long paramLong)
  {
    String str = String.valueOf(paramLong);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = str;
    ContentValues localContentValues = new ContentValues(1);
    arrayOfString[1] = b;
    localContentValues.put("status", Integer.valueOf(2));
    paramContentResolver.update(paramUri, localContentValues, "accountKey=? and status=?", arrayOfString);
    arrayOfString[1] = a;
    localContentValues.put("status", Integer.valueOf(1));
    if (paramContentResolver.update(paramUri, localContentValues, "accountKey=? and status=?", arrayOfString) <= 0) {
      return null;
    }
    return paramContentResolver.query(paramUri, paramArrayOfString, "accountKey=? and status=?", new String[] { str, b }, "_id ASC");
  }
  
  private static String a(long[] paramArrayOfLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("messageKey in (");
    int i = 0;
    while (i < paramInt)
    {
      if (i != 0) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append(paramArrayOfLong[i]);
      i += 1;
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  protected static int b(ContentResolver paramContentResolver, Uri paramUri, long[] paramArrayOfLong, int paramInt)
  {
    return a(paramContentResolver, paramUri, paramArrayOfLong, paramInt, 0);
  }
}

/* Location:
 * Qualified Name:     bec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */