package com.android.mail.providers;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.text.TextUtils;

final class SuggestionsProvider$ContactsCursor
  extends MatrixCursor
{
  private final Context mContext;
  
  public SuggestionsProvider$ContactsCursor(SuggestionsProvider paramSuggestionsProvider)
  {
    super(SuggestionsProvider.access$000());
    mContext = paramSuggestionsProvider.getContext();
  }
  
  public ContactsCursor query(String paramString)
  {
    paramString = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Email.CONTENT_FILTER_URI, Uri.encode(paramString));
    Cursor localCursor = mContext.getContentResolver().query(paramString, SuggestionsProvider.access$100(), null, null, null);
    String str = "android.resource://" + mContext.getPackageName() + "/" + 2130837532;
    if (localCursor != null)
    {
      int i = localCursor.getColumnIndex("data4");
      int j = localCursor.getColumnIndex("data1");
      if (localCursor.moveToNext())
      {
        paramString = localCursor.getString(i);
        if (!TextUtils.isEmpty(paramString)) {}
        for (;;)
        {
          addRow(new Object[] { Integer.valueOf(0), paramString, SuggestionsProvider.access$200(this$0, paramString), str });
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
 * Qualified Name:     com.android.mail.providers.SuggestionsProvider.ContactsCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */