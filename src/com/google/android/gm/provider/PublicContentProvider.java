package com.google.android.gm.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.net.Uri;
import android.text.TextUtils;
import cvm;
import cvp;
import dip;
import dpy;
import dqc;
import dqz;
import drf;
import dri;
import drp;
import hef;
import hfd;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PublicContentProvider
  extends ContentProvider
{
  private static final UriMatcher a;
  private static final Set<String> b = hfd.a(dip.a);
  private ContentResolver c;
  
  static
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    a = localUriMatcher;
    localUriMatcher.addURI("com.google.android.gm", "*/labels", 1);
    a.addURI("com.google.android.gm", "*/label/#", 2);
    a.addURI("com.google.android.gm", "*/label/*", 3);
  }
  
  private static Cursor a(String paramString, String[] paramArrayOfString, Cursor paramCursor)
  {
    Object localObject;
    if (paramCursor == null)
    {
      dri.b("GmailCP", "null private cursor", new Object[0]);
      localObject = null;
    }
    int i;
    cvp localcvp;
    do
    {
      return (Cursor)localObject;
      if (paramArrayOfString != null)
      {
        j = paramArrayOfString.length;
        i = 0;
        while (i < j)
        {
          localObject = paramArrayOfString[i];
          if (!b.contains(localObject)) {
            throw new IllegalArgumentException("Invalid projection");
          }
          i += 1;
        }
      }
      if (paramArrayOfString == null) {
        break;
      }
      localcvp = new cvp(paramArrayOfString, paramCursor.getCount());
      localObject = localcvp;
    } while (!paramCursor.moveToFirst());
    int j = paramCursor.getColumnIndex("_id");
    int k = paramCursor.getColumnIndex("canonicalName");
    int m = paramCursor.getColumnIndex("name");
    int n = paramCursor.getColumnIndex("numConversations");
    int i1 = paramCursor.getColumnIndex("numUnreadConversations");
    int i2 = paramCursor.getColumnIndex("color");
    label209:
    do
    {
      localObject = localcvp.newRow();
      int i3 = paramCursor.getInt(j);
      String str1 = paramCursor.getString(i2);
      String str2 = paramCursor.getString(k);
      int i4 = paramArrayOfString.length;
      i = 0;
      if (i < i4)
      {
        String str3 = paramArrayOfString[i];
        if (TextUtils.equals(str3, "_id")) {
          ((MatrixCursor.RowBuilder)localObject).add(Integer.valueOf(i3));
        }
        for (;;)
        {
          i += 1;
          break label209;
          paramArrayOfString = dip.a;
          break;
          if (TextUtils.equals(str3, "canonicalName")) {
            ((MatrixCursor.RowBuilder)localObject).add(str2);
          } else if (TextUtils.equals(str3, "name")) {
            ((MatrixCursor.RowBuilder)localObject).add(paramCursor.getString(m));
          } else if (TextUtils.equals(str3, "numConversations")) {
            ((MatrixCursor.RowBuilder)localObject).add(Integer.valueOf(paramCursor.getInt(n)));
          } else if (TextUtils.equals(str3, "numUnreadConversations")) {
            ((MatrixCursor.RowBuilder)localObject).add(Integer.valueOf(paramCursor.getInt(i1)));
          } else if (TextUtils.equals(str3, "labelUri")) {
            ((MatrixCursor.RowBuilder)localObject).add(dip.a(paramString, i3).toString());
          } else if (TextUtils.equals(str3, "background_color")) {
            ((MatrixCursor.RowBuilder)localObject).add(Integer.valueOf(dqz.a(paramString, str2, str1)));
          } else if (TextUtils.equals(str3, "text_color")) {
            ((MatrixCursor.RowBuilder)localObject).add(Integer.valueOf(dqz.b(paramString, str2, str1)));
          }
        }
      }
    } while (paramCursor.moveToNext());
    return localcvp;
  }
  
  private static Cursor a(String[] paramArrayOfString, drp paramdrp, String paramString)
  {
    Cursor localCursor = null;
    if (paramString != null) {
      localCursor = paramdrp.b(paramArrayOfString).a(hef.a(paramString)).a(false).a();
    }
    return localCursor;
  }
  
  public static void a(Context paramContext, String paramString, Set<Long> paramSet)
  {
    paramContext = paramContext.getContentResolver();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      Long localLong = (Long)paramSet.next();
      if (localLong != null) {
        paramContext.notifyChange(dip.a(paramString, localLong.longValue()), null, false);
      }
    }
    paramSet = String.valueOf("content://com.google.android.gm/");
    paramContext.notifyChange(Uri.parse(String.valueOf(paramSet).length() + 7 + String.valueOf(paramString).length() + paramSet + paramString + "/labels"), null, false);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    switch (a.match(paramUri))
    {
    default: 
      return null;
    case 1: 
      return "vnd.android.cursor.dir/vnd.com.google.android.gm.label";
    }
    return "vnd.android.cursor.item/vnd.com.google.android.gm.label";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return paramUri;
  }
  
  public boolean onCreate()
  {
    c = getContext().getContentResolver();
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Object localObject = null;
    if (dri.a("GmailCP", 3)) {
      dri.b("GmailCP", "PublicContentProvider.query: %s(%s, %s)", new Object[] { cvm.a(cvm.a, paramUri), paramString1, Arrays.toString(paramArrayOfString2) });
    }
    if (!TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("sortOrder must be empty");
    }
    int i = a.match(paramUri);
    paramArrayOfString2 = (String)paramUri.getPathSegments().get(0);
    if (TextUtils.isEmpty(paramArrayOfString2)) {
      throw new IllegalArgumentException("account is empty");
    }
    paramString1 = drp.a(getContext(), paramArrayOfString2);
    MailIndexerService.a(paramArrayOfString2);
    switch (i)
    {
    default: 
      if (dri.a("GmailCP", 3)) {
        dri.b("GmailCP", "Unsupported query uri: %s", new Object[] { dri.a(paramUri) });
      }
      i = 1;
    }
    for (paramArrayOfString1 = null;; paramArrayOfString1 = paramString1)
    {
      for (;;)
      {
        if ((paramArrayOfString1 != null) && (i != 0)) {
          paramArrayOfString1.setNotificationUri(c, paramUri);
        }
        return paramArrayOfString1;
        dri.b("GmailCP", "Query for list of labels", new Object[0]);
        paramString1 = paramString1.b(dpy.t).a(false).a();
        try
        {
          paramArrayOfString1 = a(paramArrayOfString2, paramArrayOfString1, paramString1);
          if (paramString1 != null)
          {
            paramString1.close();
            i = 1;
          }
        }
        finally
        {
          if (paramString1 != null) {
            paramString1.close();
          }
        }
        long l = Long.parseLong((String)paramUri.getPathSegments().get(2));
        paramString2 = X.b(l);
        paramString1 = a(dpy.t, paramString1, paramString2);
        try
        {
          paramArrayOfString1 = a(paramArrayOfString2, paramArrayOfString1, paramString1);
          if (paramString1 != null)
          {
            paramString1.close();
            i = 1;
          }
        }
        finally
        {
          if (paramString1 != null) {
            paramString1.close();
          }
        }
        paramString2 = (String)paramUri.getPathSegments().get(2);
        paramString2 = a(dpy.t, paramString1, paramString2);
        try
        {
          paramString1 = a(paramArrayOfString2, paramArrayOfString1, paramString2);
          paramArrayOfString1 = (String[])localObject;
          if (paramString2 != null)
          {
            paramArrayOfString1 = (String[])localObject;
            if (paramString2.getCount() > 0)
            {
              paramArrayOfString1 = (String[])localObject;
              if (paramString2.moveToFirst())
              {
                l = paramString2.getLong(paramString2.getColumnIndex("_id"));
                paramArrayOfString1 = Long.valueOf(l);
              }
            }
          }
          if (paramString2 != null) {
            paramString2.close();
          }
          if ((paramString1 != null) && (paramArrayOfString1 != null))
          {
            paramString1.setNotificationUri(c, dip.a(paramArrayOfString2, paramArrayOfString1.longValue()));
            i = 0;
            paramArrayOfString1 = paramString1;
          }
        }
        finally
        {
          if (paramString2 != null) {
            paramString2.close();
          }
        }
      }
      i = 1;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.PublicContentProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */