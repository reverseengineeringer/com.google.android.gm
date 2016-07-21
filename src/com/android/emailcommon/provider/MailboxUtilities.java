package com.android.emailcommon.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import bbw;
import cvm;

public class MailboxUtilities
{
  private static final String[] a = { "_id", "displayName", "parentKey", "hierarchicalName" };
  
  @Deprecated
  private static void a(Context paramContext, Cursor paramCursor, String paramString)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    ContentValues localContentValues = new ContentValues();
    long l1 = paramCursor.getLong(0);
    int k = paramCursor.getInt(5);
    String str = paramCursor.getString(2);
    if (k <= 64) {}
    for (int j = 72;; j = 0)
    {
      int i;
      if ((k != 1) && (k != 6) && (k != 7))
      {
        i = j;
        if (k != 0) {}
      }
      else
      {
        i = j | 0x10;
      }
      if (str != null)
      {
        paramCursor = Mailbox.a;
        String[] arrayOfString = Mailbox.B;
        paramContext = String.valueOf("parentServerId=? AND ");
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0) {}
        for (paramContext = paramContext.concat(paramString);; paramContext = new String(paramContext))
        {
          paramContext = localContentResolver.query(paramCursor, arrayOfString, paramContext, new String[] { str }, null);
          if (paramContext != null) {
            break;
          }
          return;
        }
      }
      for (;;)
      {
        try
        {
          if (paramContext.moveToNext())
          {
            i |= 0x3;
            paramCursor = new ContentValues();
            paramCursor.put("parentKey", Long.valueOf(l1));
            long l2 = paramContext.getLong(0);
            localContentResolver.update(ContentUris.withAppendedId(Mailbox.a, l2), paramCursor, null, null);
            continue;
          }
        }
        finally
        {
          paramContext.close();
        }
        for (;;)
        {
          localContentValues.put("flags", Integer.valueOf(i));
          localContentResolver.update(ContentUris.withAppendedId(Mailbox.a, l1), localContentValues, null, null);
          return;
          localContentValues.put("parentKey", Long.valueOf(-1L));
          paramContext = bbw.a;
          paramCursor = String.valueOf(paramCursor.getString(1));
          cvm.d(paramContext, String.valueOf(paramCursor).length() + 47 + "Mailbox with null serverId: " + paramCursor + ", type: " + k, new Object[0]);
        }
      }
    }
  }
  
  @Deprecated
  public static void setFlagsAndChildrensParentKey(Context paramContext, String paramString1, String paramString2)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Uri localUri = Mailbox.a;
    String[] arrayOfString = Mailbox.z;
    String str1 = String.valueOf("serverId=? AND ");
    String str2 = String.valueOf(paramString1);
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      paramString2 = localContentResolver.query(localUri, arrayOfString, str1, new String[] { paramString2 }, null);
      if (paramString2 != null) {
        break;
      }
      return;
    }
    try
    {
      if (paramString2.moveToFirst()) {
        a(paramContext, paramString2, paramString1);
      }
      return;
    }
    finally
    {
      paramString2.close();
    }
  }
}

/* Location:
 * Qualified Name:     com.android.emailcommon.provider.MailboxUtilities
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */