package com.google.android.gm.utils;

import android.database.Cursor;
import android.net.Uri;
import com.android.mail.providers.ReplyFromAccount;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CustomFromUtils
{
  public static int ACCOUNT_ADDRESS = 1;
  public static ConcurrentHashMap<Uri, ArrayList<ReplyFromAccount>> ACCOUNT_CUSTOM_FROM = new ConcurrentHashMap();
  public static int ACCOUNT_DISPLAY;
  public static ConcurrentHashMap<Uri, Boolean> ACCOUNT_REPLY_FROM_DEFAULT = new ConcurrentHashMap();
  public static String ADDRESS;
  public static String IS_DEFAULT;
  public static String NAME = "name";
  public static int REAL_ACCOUNT;
  public static String REPLY_FROM_DEFAULT_SETTING;
  public static String REPLY_TO;
  
  static
  {
    ADDRESS = "address";
    REPLY_TO = "reply_to";
    IS_DEFAULT = "is_default";
    REPLY_FROM_DEFAULT_SETTING = "bx_rf";
    REAL_ACCOUNT = 2;
    ACCOUNT_DISPLAY = 0;
  }
  
  public static void clearCustomFrom(String paramString)
  {
    ACCOUNT_CUSTOM_FROM.remove(paramString);
  }
  
  public static List<ReplyFromAccount> getCustomReplyFroms(Uri paramUri)
  {
    if (ACCOUNT_CUSTOM_FROM != null)
    {
      paramUri = (List)ACCOUNT_CUSTOM_FROM.get(paramUri);
      if (paramUri != null) {
        try
        {
          ImmutableList localImmutableList = ImmutableList.copyOf(paramUri);
          return localImmutableList;
        }
        finally {}
      }
    }
    return null;
  }
  
  public static void instantiateCustomFrom(Uri paramUri, Cursor paramCursor)
  {
    try
    {
      if (paramCursor.moveToFirst())
      {
        ArrayList localArrayList = new ArrayList();
        int i = paramCursor.getColumnIndexOrThrow(ADDRESS);
        int j = paramCursor.getColumnIndexOrThrow(NAME);
        int k = paramCursor.getColumnIndexOrThrow(REPLY_TO);
        int m = paramCursor.getColumnIndexOrThrow(IS_DEFAULT);
        do
        {
          localArrayList.add(new ReplyFromAccount(null, paramUri, paramCursor.getString(i), paramCursor.getString(j), paramCursor.getString(k), Boolean.parseBoolean(paramCursor.getString(m)), true));
        } while (paramCursor.moveToNext());
        ACCOUNT_CUSTOM_FROM.put(paramUri, localArrayList);
      }
      return;
    }
    finally
    {
      paramCursor.close();
    }
  }
  
  public static void instantiateReplyFromDefaultAddress(Uri paramUri, Cursor paramCursor)
  {
    try
    {
      if (paramCursor.moveToFirst()) {
        setReplyFromDefaultAddress(paramUri, paramCursor.getString(paramCursor.getColumnIndexOrThrow("value")));
      }
      return;
    }
    finally
    {
      paramCursor.close();
    }
  }
  
  public static void removeCustomFrom(Uri paramUri, String paramString)
  {
    ArrayList localArrayList = (ArrayList)ACCOUNT_CUSTOM_FROM.get(paramUri);
    if (localArrayList != null) {}
    try
    {
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        ReplyFromAccount localReplyFromAccount = (ReplyFromAccount)localIterator.next();
        if (address.equals(paramString)) {
          localArrayList.remove(localReplyFromAccount);
        }
      }
      ACCOUNT_CUSTOM_FROM.put(paramUri, localArrayList);
      return;
    }
    finally {}
  }
  
  public static boolean replyFromDefaultAddress(Uri paramUri)
  {
    if ((ACCOUNT_REPLY_FROM_DEFAULT != null) && (ACCOUNT_REPLY_FROM_DEFAULT.containsKey(paramUri))) {
      return ((Boolean)ACCOUNT_REPLY_FROM_DEFAULT.get(paramUri)).booleanValue();
    }
    return false;
  }
  
  public static void setReplyFromDefaultAddress(Uri paramUri, String paramString)
  {
    boolean bool = true;
    if ((paramString.equals("true")) || (paramString.equals("1"))) {
      bool = false;
    }
    ACCOUNT_REPLY_FROM_DEFAULT.put(paramUri, Boolean.valueOf(bool));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.utils.CustomFromUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */