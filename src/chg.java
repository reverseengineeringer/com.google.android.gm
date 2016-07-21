import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.text.TextUtils;

final class chg
  extends cvp
{
  public chg(chf paramchf)
  {
    super(chf.d);
  }
  
  public final chg a(String paramString)
  {
    paramString = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Email.CONTENT_FILTER_URI, Uri.encode(paramString));
    Cursor localCursor = a.b.getContentResolver().query(paramString, chf.e, null, null, null);
    paramString = String.valueOf("android.resource://");
    String str = String.valueOf(a.b.getPackageName());
    int i = bub.f;
    str = String.valueOf(paramString).length() + 12 + String.valueOf(str).length() + paramString + str + "/" + i;
    if (localCursor != null)
    {
      i = localCursor.getColumnIndex("data4");
      int j = localCursor.getColumnIndex("data1");
      if (localCursor.moveToNext())
      {
        paramString = localCursor.getString(i);
        if (!TextUtils.isEmpty(paramString)) {}
        for (;;)
        {
          addRow(new Object[] { Integer.valueOf(0), paramString, a.c(paramString), str });
          break;
          paramString = localCursor.getString(j);
        }
      }
      localCursor.close();
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     chg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */