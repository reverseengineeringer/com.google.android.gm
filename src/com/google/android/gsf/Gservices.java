package com.google.android.gsf;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gservices
{
  public static final Uri CONTENT_PREFIX_URI;
  public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
  public static final Pattern FALSE_PATTERN = Pattern.compile("^(0|false|f|off|no|n)$", 2);
  public static final Pattern TRUE_PATTERN;
  private static HashMap<String, String> sCache;
  private static String[] sPreloadedPrefixes = new String[0];
  private static ContentResolver sResolver;
  private static Object sVersionToken;
  
  static
  {
    CONTENT_PREFIX_URI = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    TRUE_PATTERN = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
  }
  
  public static void bulkCacheByPrefix(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    Map localMap = getStringsByPrefix(paramContentResolver, paramVarArgs);
    try
    {
      ensureCacheInitializedLocked(paramContentResolver);
      sPreloadedPrefixes = paramVarArgs;
      paramContentResolver = localMap.entrySet().iterator();
      while (paramContentResolver.hasNext())
      {
        paramVarArgs = (Map.Entry)paramContentResolver.next();
        sCache.put(paramVarArgs.getKey(), paramVarArgs.getValue());
      }
    }
    finally {}
  }
  
  private static void ensureCacheInitializedLocked(final ContentResolver paramContentResolver)
  {
    if (sCache == null)
    {
      sCache = new HashMap();
      sVersionToken = new Object();
      sResolver = paramContentResolver;
      new Thread("Gservices")
      {
        public void run()
        {
          Looper.prepare();
          paramContentResolver.registerContentObserver(Gservices.CONTENT_URI, true, new ContentObserver(new Handler(Looper.myLooper()))
          {
            public void onChange(boolean paramAnonymous2Boolean)
            {
              try
              {
                Gservices.sCache.clear();
                Gservices.access$102(new Object());
                if (Gservices.sPreloadedPrefixes.length > 0) {
                  Gservices.bulkCacheByPrefix(Gservices.sResolver, Gservices.sPreloadedPrefixes);
                }
                return;
              }
              finally {}
            }
          });
          Looper.loop();
        }
      }.start();
    }
  }
  
  public static boolean getBoolean(ContentResolver paramContentResolver, String paramString, boolean paramBoolean)
  {
    paramContentResolver = getString(paramContentResolver, paramString);
    if ((paramContentResolver == null) || (paramContentResolver.equals(""))) {
      return paramBoolean;
    }
    if (TRUE_PATTERN.matcher(paramContentResolver).matches()) {
      return true;
    }
    if (FALSE_PATTERN.matcher(paramContentResolver).matches()) {
      return false;
    }
    Log.w("Gservices", "attempt to read gservices key " + paramString + " (value \"" + paramContentResolver + "\") as boolean");
    return paramBoolean;
  }
  
  public static int getInt(ContentResolver paramContentResolver, String paramString, int paramInt)
  {
    paramContentResolver = getString(paramContentResolver, paramString);
    if (paramContentResolver != null) {}
    try
    {
      int i = Integer.parseInt(paramContentResolver);
      return i;
    }
    catch (NumberFormatException paramContentResolver) {}
    return paramInt;
    return paramInt;
  }
  
  public static long getLong(ContentResolver paramContentResolver, String paramString, long paramLong)
  {
    paramContentResolver = getString(paramContentResolver, paramString);
    if (paramContentResolver != null) {}
    try
    {
      long l = Long.parseLong(paramContentResolver);
      return l;
    }
    catch (NumberFormatException paramContentResolver) {}
    return paramLong;
    return paramLong;
  }
  
  public static String getString(ContentResolver paramContentResolver, String paramString)
  {
    return getString(paramContentResolver, paramString, null);
  }
  
  public static String getString(ContentResolver paramContentResolver, String paramString1, String paramString2)
  {
    Object localObject;
    try
    {
      ensureCacheInitializedLocked(paramContentResolver);
      localObject = sVersionToken;
      if (sCache.containsKey(paramString1))
      {
        paramContentResolver = (String)sCache.get(paramString1);
        if (paramContentResolver != null) {
          paramString2 = paramContentResolver;
        }
        return paramString2;
      }
      paramContentResolver = sPreloadedPrefixes;
      int j = paramContentResolver.length;
      int i = 0;
      while (i < j)
      {
        if (paramString1.startsWith(paramContentResolver[i])) {
          return paramString2;
        }
        i += 1;
      }
    }
    finally {}
    tmp98_95[0] = paramString1;
    Cursor localCursor = sResolver.query(CONTENT_URI, null, null, tmp98_95, null);
    if (localCursor == null)
    {
      sCache.put(paramString1, null);
      return paramString2;
    }
    try
    {
      localCursor.moveToFirst();
      paramContentResolver = localCursor.getString(1);
      try
      {
        if (localObject == sVersionToken) {
          sCache.put(paramString1, paramContentResolver);
        }
        if (paramContentResolver != null) {
          paramString2 = paramContentResolver;
        }
        return paramString2;
      }
      finally {}
      return paramString2;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public static Map<String, String> getStringsByPrefix(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    paramContentResolver = paramContentResolver.query(CONTENT_PREFIX_URI, null, null, paramVarArgs, null);
    paramVarArgs = new TreeMap();
    if (paramContentResolver == null) {
      return paramVarArgs;
    }
    try
    {
      if (paramContentResolver.moveToNext()) {
        paramVarArgs.put(paramContentResolver.getString(0), paramContentResolver.getString(1));
      }
      return paramVarArgs;
    }
    finally
    {
      paramContentResolver.close();
    }
  }
  
  public static Object getVersionToken(ContentResolver paramContentResolver)
  {
    try
    {
      ensureCacheInitializedLocked(paramContentResolver);
      paramContentResolver = sVersionToken;
      return paramContentResolver;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gsf.Gservices
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */