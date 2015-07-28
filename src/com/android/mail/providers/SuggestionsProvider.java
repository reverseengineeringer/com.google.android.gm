package com.android.mail.providers;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.text.TextUtils;
import java.util.ArrayList;

public class SuggestionsProvider
  extends SearchRecentSuggestionsProvider
{
  private static final String[] CONTACTS_COLUMNS = { "_id", "suggest_text_1", "suggest_intent_query", "suggest_icon_1" };
  private static final String[] sContract = { "data4", "data1" };
  private ArrayList<String> mFullQueryTerms;
  private final Object mTermsLock = new Object();
  
  private String createQuery(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    int i;
    if (mFullQueryTerms != null)
    {
      localObject = mTermsLock;
      i = 0;
    }
    try
    {
      int j = mFullQueryTerms.size();
      while (i < j)
      {
        localStringBuilder.append((String)mFullQueryTerms.get(i)).append(" ");
        i += 1;
      }
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    finally {}
  }
  
  public boolean onCreate()
  {
    setupSuggestions(getContext().getString(2131492882), 1);
    super.onCreate();
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    ??? = paramArrayOfString2[0];
    paramArrayOfString2 = null;
    synchronized (mTermsLock)
    {
      mFullQueryTerms = null;
      super.setFullQueryTerms(mFullQueryTerms);
      if (??? != null)
      {
        ??? = TextUtils.split((String)???, " ");
        if ((??? == null) || (???.length <= 1)) {
          break label241;
        }
        paramArrayOfString2 = ???[(???.length - 1)];
      }
    }
    for (;;)
    {
      synchronized (mTermsLock)
      {
        mFullQueryTerms = new ArrayList();
        int i = 0;
        int j = ???.length;
        if (i < j - 1)
        {
          mFullQueryTerms.add(???[i]);
          i += 1;
          continue;
          paramUri = finally;
          throw paramUri;
        }
        super.setFullQueryTerms(mFullQueryTerms);
        ??? = new ArrayList();
        ((ArrayList)???).add(super.query(paramUri, paramArrayOfString1, paramString1, new String[] { paramArrayOfString2 }, paramString2));
        if (paramArrayOfString2.length() >= 2) {
          ((ArrayList)???).add(new ContactsCursor().query(paramArrayOfString2));
        }
        paramArrayOfString2 = new MergeCursor((Cursor[])((ArrayList)???).toArray(new Cursor[((ArrayList)???).size()]));
        return paramArrayOfString2;
      }
      label241:
      paramArrayOfString2 = ((String)???).trim();
    }
  }
  
  private final class ContactsCursor
    extends MatrixCursor
  {
    private final Context mContext = getContext();
    
    public ContactsCursor()
    {
      super();
    }
    
    public ContactsCursor query(String paramString)
    {
      paramString = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Email.CONTENT_FILTER_URI, Uri.encode(paramString));
      Cursor localCursor = mContext.getContentResolver().query(paramString, SuggestionsProvider.sContract, null, null, null);
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
            addRow(new Object[] { Integer.valueOf(0), paramString, SuggestionsProvider.this.createQuery(paramString), str });
            break;
            paramString = localCursor.getString(j);
          }
        }
        localCursor.close();
      }
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.SuggestionsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */