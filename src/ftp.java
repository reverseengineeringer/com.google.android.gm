import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.RawContacts;
import android.text.TextUtils;

public final class ftp
{
  static final String[] a = { "photo_id" };
  static final String[] b = { "data15" };
  private static final String[] c = { "_id" };
  private static final String[] d = { "contact_id" };
  private static final String[] e = { "lookup" };
  
  public static long a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, paramString1, paramString2, d);
  }
  
  private static long a(Context paramContext, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return -1L;
    }
    String str = fxp.b(paramString2);
    if (Build.VERSION.SDK_INT >= 15) {}
    for (paramString2 = "account_name=?1 AND account_type='com.google' AND sourceid=?2 AND data_set IS NULL";; paramString2 = "account_name=?1 AND account_type='com.google' AND sourceid=?2")
    {
      paramContext = paramContext.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, paramArrayOfString, paramString2, fxp.a(paramString1, str), null);
      if (paramContext != null) {
        break;
      }
      fxo.a("PeopleCp2Helper", "Contacts query failed.");
      return -1L;
    }
    try
    {
      if (paramContext.moveToFirst())
      {
        int i = paramContext.getInt(0);
        long l = i;
        return l;
      }
      paramContext.close();
      fxo.a(3);
      return -1L;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  public static Uri a(Context paramContext, long paramLong)
  {
    if (paramLong < 0L) {
      return null;
    }
    Object localObject1 = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, paramLong);
    paramContext = paramContext.getContentResolver().query((Uri)localObject1, e, null, null, null);
    if (paramContext == null)
    {
      fxo.a("PeopleCp2Helper", "Contacts query failed.");
      return null;
    }
    try
    {
      if (paramContext.moveToFirst())
      {
        localObject1 = paramContext.getString(0);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          fxo.a(3);
          return null;
        }
        localObject1 = ContactsContract.Contacts.CONTENT_LOOKUP_URI.buildUpon().appendPath((String)localObject1).appendPath(String.valueOf(paramLong)).build();
        return (Uri)localObject1;
      }
      paramContext.close();
      fxo.a(3);
      return null;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  public static long b(Context paramContext, String paramString1, String paramString2)
  {
    return b(paramContext, paramString1, paramString2, d);
  }
  
  private static long b(Context paramContext, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return -1L;
    }
    if (Build.VERSION.SDK_INT < 15) {
      return -1L;
    }
    paramString2 = fxp.a(paramString2);
    paramContext = paramContext.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, paramArrayOfString, "account_name=?1 AND account_type='com.google' AND sourceid=?2 AND data_set IS 'plus'", fxp.a(paramString1, paramString2), null);
    if (paramContext == null)
    {
      fxo.a("PeopleCp2Helper", "Contacts query failed.");
      return -1L;
    }
    try
    {
      if (paramContext.moveToFirst())
      {
        int i = paramContext.getInt(0);
        long l = i;
        return l;
      }
      paramContext.close();
      fxo.a(3);
      return -1L;
    }
    finally
    {
      paramContext.close();
    }
  }
}

/* Location:
 * Qualified Name:     ftp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */