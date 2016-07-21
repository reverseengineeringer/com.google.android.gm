package com.google.android.gm.provider;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import com.google.android.gms.appdatasearch.RegisterCorpusInfo;
import cvm;
import dqh;
import dri;
import dyp;
import ebe;
import java.util.Arrays;

public final class SearchQuery$Provider
  extends ebe
{
  public final Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    long l = Binder.clearCallingIdentity();
    try
    {
      dri.b(SearchQuery.a, "AppDataSearch.Query: %s(%s, %s)", new Object[] { cvm.a(cvm.a, paramUri), paramString1, Arrays.toString(paramArrayOfString2) });
      Account localAccount = RegisterCorpusInfo.a(paramUri);
      if (localAccount == null)
      {
        dri.e(SearchQuery.a, "Unparseable cp uri: %s", new Object[] { dri.a(SearchQuery.a, paramUri.toString()) });
        return null;
      }
      if (dyp.a(localAccount))
      {
        paramUri = dqh.a(name);
        paramUri = getContext().getContentResolver().query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
        return paramUri;
      }
      return null;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
  }
  
  public final String a()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.SearchQuery.Provider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */