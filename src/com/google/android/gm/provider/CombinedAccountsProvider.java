package com.google.android.gm.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import cgr;
import chh;
import cvl;
import cvm;
import ddy;
import dfx;
import dge;
import dmv;
import dpn;
import dri;
import dub;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CombinedAccountsProvider
  extends ContentProvider
{
  public static final Uri a;
  static final Uri b;
  public static final Uri c;
  public static final Uri d = Uri.withAppendedPath(a, "search");
  public static final Uri e = Uri.withAppendedPath(a, "search-conversations");
  private static final String f = cvl.a;
  private static final UriMatcher g;
  private static final Uri h;
  private static final String[] i = { "unreadCount" };
  private ContentResolver j;
  private ddy k;
  private Uri l;
  
  static
  {
    a = Uri.parse("content://com.google.android.gm.combinedaccounts");
    UriMatcher localUriMatcher = new UriMatcher(-1);
    g = localUriMatcher;
    localUriMatcher.addURI("com.google.android.gm.combinedaccounts", "folder/inbox", 1);
    g.addURI("com.google.android.gm.combinedaccounts", "conversations/inbox", 2);
    g.addURI("com.google.android.gm.combinedaccounts", "refresh", 3);
    g.addURI("com.google.android.gm.combinedaccounts", "search", 4);
    g.addURI("com.google.android.gm.combinedaccounts", "search-conversations", 5);
    b = Uri.withAppendedPath(a, "folder/inbox");
    c = Uri.withAppendedPath(a, "conversations/inbox");
    h = Uri.withAppendedPath(a, "refresh");
  }
  
  private final dpn a(Uri paramUri, String[] paramArrayOfString)
  {
    String str1 = paramUri.getQueryParameter("query");
    String str2 = paramUri.getQueryParameter("query_identifier");
    Object localObject = paramUri.getQueryParameters("inner-uri");
    if (!((List)localObject).isEmpty())
    {
      paramUri = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramUri.add(Uri.parse((String)((Iterator)localObject).next()));
      }
    }
    for (;;)
    {
      localObject = new ArrayList();
      paramUri = paramUri.iterator();
      while (paramUri.hasNext())
      {
        Uri localUri = (Uri)paramUri.next();
        ((List)localObject).add(j.query(localUri, chh.i, null, null, null));
      }
      paramUri = a(str1, str2);
    }
    return new dpn((List)localObject, paramArrayOfString, str1, str2);
  }
  
  private final dub a(Uri paramUri)
  {
    Object localObject = paramUri.getQueryParameters("inner-uri");
    paramUri = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      paramUri.add(j.query(Uri.parse(str), chh.k, null, null, null));
    }
    return new dub(paramUri);
  }
  
  private final List<Cursor> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = k.b(new String[] { "mail" }).iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = dmv.f(getContext(), str1);
      Uri localUri = GmailProvider.b(str1, str2);
      dri.a(f, "Inbox for %s is %s: %s", new Object[] { str1, str2, localUri });
      localArrayList.add(j.query(localUri, chh.k, null, null, null));
    }
    return localArrayList;
  }
  
  private final List<Uri> a(String paramString1, String paramString2)
  {
    localArrayList = new ArrayList();
    Cursor localCursor = j.query(cgr.b(), chh.c, null, null, null);
    if (localCursor != null) {
      try
      {
        if (localCursor.moveToNext()) {
          localArrayList.add(Uri.parse(localCursor.getString(localCursor.getColumnIndex("searchUri"))).buildUpon().appendQueryParameter("query", paramString1).appendQueryParameter("query_identifier", paramString2).build());
        }
        return localArrayList;
      }
      finally
      {
        localCursor.close();
      }
    }
  }
  
  private final Uri b()
  {
    Object localObject2 = null;
    Cursor localCursor = j.query(Uri.withAppendedPath(l, "uifolders/268435456"), chh.i, null, null, null);
    if (localCursor != null) {}
    try
    {
      int m = localCursor.getColumnIndex("type");
      while (localCursor.moveToNext()) {
        if (localCursor.getInt(m) == 0)
        {
          Uri localUri = Uri.parse(localCursor.getString(localCursor.getColumnIndex("conversationListUri")));
          localObject2 = localUri;
          if (localCursor != null)
          {
            localCursor.close();
            localObject2 = localUri;
          }
          return (Uri)localObject2;
        }
      }
      return null;
    }
    finally
    {
      if (localCursor != null) {
        localCursor.close();
      }
    }
  }
  
  private final int c()
  {
    Object localObject1 = j.query(Uri.withAppendedPath(l, "uifolder/1152921504606846976"), i, null, null, null);
    if (localObject1 != null) {}
    for (;;)
    {
      int m;
      try
      {
        if (!((Cursor)localObject1).moveToFirst()) {
          break label243;
        }
        n = ((Cursor)localObject1).getInt(0);
        m = n + 0;
        dri.b(f, "CombinedAccountsProvider count in Email: %d", new Object[] { Integer.valueOf(n) });
        ((Cursor)localObject1).close();
        localObject1 = k.b(new String[] { "mail" }).iterator();
      }
      finally
      {
        try
        {
          String str;
          if (!((Cursor)localObject4).moveToFirst()) {
            break label240;
          }
          int n = ((Cursor)localObject4).getInt(10);
          m += n;
          dri.b(f, "CombinedAccountsProvider count in Gmail %s: %d", new Object[] { dri.a(str), Integer.valueOf(n) });
          ((Cursor)localObject4).close();
          continue;
        }
        finally
        {
          Object localObject4;
          ((Cursor)localObject4).close();
        }
        localObject3 = finally;
        ((Cursor)localObject1).close();
      }
      if (((Iterator)localObject1).hasNext())
      {
        str = (String)((Iterator)localObject1).next();
        localObject4 = dmv.f(getContext(), str);
        localObject4 = j.query(GmailProvider.a(str, (String)localObject4), chh.i, null, null, null);
        if (localObject4 == null) {}
      }
      else
      {
        return m;
        label240:
        continue;
        label243:
        m = 0;
        continue;
        m = 0;
      }
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    Object localObject = getContext();
    j = ((Context)localObject).getContentResolver();
    k = new ddy((Context)localObject);
    localObject = String.valueOf(((Context)localObject).getString(dge.bB));
    if (((String)localObject).length() != 0) {}
    for (localObject = "content://".concat((String)localObject);; localObject = new String("content://"))
    {
      l = Uri.parse((String)localObject);
      return true;
    }
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramString2 = null;
    dri.b(f, "GmailProvider.query: %s(%s, %s)", new Object[] { cvm.a(cvm.a, paramUri), paramString1, Arrays.toString(paramArrayOfString2) });
    switch (g.match(paramUri))
    {
    default: 
      return null;
    case 1: 
      paramUri = new Object[paramArrayOfString1.length];
      int n = 0;
      if (n < paramArrayOfString1.length)
      {
        paramString1 = paramArrayOfString1[n];
        int m = -1;
        switch (paramString1.hashCode())
        {
        default: 
          switch (m)
          {
          }
          break;
        }
        for (;;)
        {
          n += 1;
          break;
          if (!paramString1.equals("_id")) {
            break label200;
          }
          m = 0;
          break label200;
          if (!paramString1.equals("folderUri")) {
            break label200;
          }
          m = 1;
          break label200;
          if (!paramString1.equals("name")) {
            break label200;
          }
          m = 2;
          break label200;
          if (!paramString1.equals("hasChildren")) {
            break label200;
          }
          m = 3;
          break label200;
          if (!paramString1.equals("capabilities")) {
            break label200;
          }
          m = 4;
          break label200;
          if (!paramString1.equals("conversationListUri")) {
            break label200;
          }
          m = 5;
          break label200;
          if (!paramString1.equals("unreadCount")) {
            break label200;
          }
          m = 6;
          break label200;
          if (!paramString1.equals("iconResId")) {
            break label200;
          }
          m = 7;
          break label200;
          if (!paramString1.equals("type")) {
            break label200;
          }
          m = 8;
          break label200;
          if (!paramString1.equals("refreshUri")) {
            break label200;
          }
          m = 9;
          break label200;
          paramUri[n] = Integer.valueOf(Integer.MAX_VALUE);
          continue;
          paramUri[n] = b;
          continue;
          paramUri[n] = getContext().getString(dge.ek);
          continue;
          paramUri[n] = Integer.valueOf(0);
          continue;
          paramUri[n] = Integer.valueOf(67118);
          continue;
          paramUri[n] = c;
          continue;
          paramUri[n] = Integer.valueOf(c());
          continue;
          paramUri[n] = Integer.valueOf(dfx.h);
          continue;
          paramUri[n] = Integer.valueOf(8192);
          continue;
          paramUri[n] = h;
        }
      }
      paramArrayOfString1 = new MatrixCursor(paramArrayOfString1, 1);
      paramArrayOfString1.addRow(paramUri);
      return paramArrayOfString1;
    case 2: 
      paramArrayOfString1 = new ArrayList();
      paramArrayOfString1.addAll(a());
      paramUri = b();
      if (paramUri == null) {}
      for (paramUri = paramString2;; paramUri = j.query(paramUri.buildUpon().appendQueryParameter("enforceUnifiedInboxThreading", "1").build(), chh.k, null, null, null))
      {
        paramArrayOfString1.add(paramUri);
        return new dub(paramArrayOfString1);
      }
    case 3: 
      paramUri = j.query(Uri.withAppendedPath(l, "uirefresh/1152921504606846976"), null, null, null, null);
      if (paramUri != null) {
        paramUri.close();
      }
      paramUri = k.b(new String[] { "mail" }).iterator();
      while (paramUri.hasNext())
      {
        paramArrayOfString2 = (String)paramUri.next();
        paramArrayOfString1 = dmv.f(getContext(), paramArrayOfString2);
        paramString1 = j;
        paramArrayOfString2 = String.valueOf(GmailProvider.g(paramArrayOfString2));
        paramArrayOfString1 = paramString1.query(Uri.parse(String.valueOf(paramArrayOfString2).length() + 1 + String.valueOf(paramArrayOfString1).length() + paramArrayOfString2 + "/" + paramArrayOfString1), null, null, null, null);
        if (paramArrayOfString1 != null) {
          paramArrayOfString1.close();
        }
      }
    case 4: 
      label200:
      return a(paramUri, paramArrayOfString1);
    }
    return a(paramUri);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.CombinedAccountsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */