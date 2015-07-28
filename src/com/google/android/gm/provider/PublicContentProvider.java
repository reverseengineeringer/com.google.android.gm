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
import com.google.android.gm.contentprovider.GmailAccess;
import com.google.android.gm.contentprovider.PrivateGmailAccess;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PublicContentProvider
  extends ContentProvider
{
  private static final Set<String> VALID_PUBLIC_LABEL_PROJECTION_COLUMNS = ImmutableSet.copyOf(GmailAccess.LABEL_PROJECTION);
  private static final UriMatcher sUrlMatcher = new UriMatcher(-1);
  private ContentResolver mContentResolver;
  
  static
  {
    sUrlMatcher.addURI("com.google.android.gm", "*/labels", 1);
    sUrlMatcher.addURI("com.google.android.gm", "*/label/#", 2);
    sUrlMatcher.addURI("com.google.android.gm", "*/label/*", 3);
  }
  
  static void broadcastLabelNotifications(Context paramContext, String paramString, Set<Long> paramSet)
  {
    paramContext = paramContext.getContentResolver();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      Long localLong = (Long)paramSet.next();
      if (localLong != null) {
        paramContext.notifyChange(PrivateGmailAccess.getLabelUriForId(paramString, localLong.longValue()), null, false);
      }
    }
    paramContext.notifyChange(GmailAccess.getLabelsUri(paramString), null, false);
  }
  
  private Cursor getCursorForLabel(String[] paramArrayOfString, MailEngine paramMailEngine, String paramString)
  {
    Cursor localCursor = null;
    if (paramString != null) {
      localCursor = paramMailEngine.getLabelQueryBuilder(paramArrayOfString).filterCanonicalName(ImmutableList.of(paramString)).showHidden(false).query();
    }
    return localCursor;
  }
  
  private MailEngine getOrMakeMailEngine(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("account is empty");
    }
    return MailEngine.getOrMakeMailEngine(getContext(), paramString);
  }
  
  private Cursor getPublicLabelCursor(String paramString, String[] paramArrayOfString, Cursor paramCursor)
  {
    Object localObject;
    if (paramCursor == null)
    {
      LogUtils.d("GmailCP", "null private cursor", new Object[0]);
      localObject = null;
    }
    MatrixCursor localMatrixCursor;
    do
    {
      return (Cursor)localObject;
      validateQueryProjection(paramArrayOfString);
      if (paramArrayOfString == null) {
        break;
      }
      localMatrixCursor = new MatrixCursor(paramArrayOfString, paramCursor.getCount());
      localObject = localMatrixCursor;
    } while (!paramCursor.moveToFirst());
    int j = paramCursor.getColumnIndex("_id");
    int k = paramCursor.getColumnIndex("canonicalName");
    int m = paramCursor.getColumnIndex("name");
    int n = paramCursor.getColumnIndex("numConversations");
    int i1 = paramCursor.getColumnIndex("numUnreadConversations");
    int i2 = paramCursor.getColumnIndex("color");
    label164:
    do
    {
      localObject = localMatrixCursor.newRow();
      int i3 = paramCursor.getInt(j);
      String str1 = paramCursor.getString(i2);
      String str2 = paramCursor.getString(k);
      int i4 = paramArrayOfString.length;
      int i = 0;
      if (i < i4)
      {
        String str3 = paramArrayOfString[i];
        if (TextUtils.equals(str3, "_id")) {
          ((MatrixCursor.RowBuilder)localObject).add(Integer.valueOf(i3));
        }
        for (;;)
        {
          i += 1;
          break label164;
          paramArrayOfString = GmailAccess.LABEL_PROJECTION;
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
            ((MatrixCursor.RowBuilder)localObject).add(PrivateGmailAccess.getLabelUriForId(paramString, i3).toString());
          } else if (TextUtils.equals(str3, "background_color")) {
            ((MatrixCursor.RowBuilder)localObject).add(Integer.valueOf(Label.getBackgroundColor(paramString, str2, str1)));
          } else if (TextUtils.equals(str3, "text_color")) {
            ((MatrixCursor.RowBuilder)localObject).add(Integer.valueOf(Label.getTextColor(paramString, str2, str1)));
          }
        }
      }
    } while (paramCursor.moveToNext());
    return localMatrixCursor;
  }
  
  private void validateQueryProjection(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (!VALID_PUBLIC_LABEL_PROJECTION_COLUMNS.contains(str)) {
          throw new IllegalArgumentException("Invalid projection");
        }
        i += 1;
      }
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    switch (sUrlMatcher.match(paramUri))
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
    mContentResolver = getContext().getContentResolver();
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (LogUtils.isLoggable("GmailCP", 3)) {
      LogUtils.d("GmailCP", "PublicContentProvider.query: %s(%s, %s)", new Object[] { LogUtils.contentUriToString(paramUri), paramString1, Arrays.toString(paramArrayOfString2) });
    }
    if (!TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("sortOrder must be empty");
    }
    int i = sUrlMatcher.match(paramUri);
    String str = (String)paramUri.getPathSegments().get(0);
    paramString1 = getOrMakeMailEngine(str);
    int j = 1;
    MailIndexerService.onContentProviderAccess(str);
    switch (i)
    {
    default: 
      if (LogUtils.isLoggable("GmailCP", 3)) {
        LogUtils.d("GmailCP", "Unsupported query uri: %s", new Object[] { LogUtils.contentUriToString(paramUri) });
      }
      paramArrayOfString1 = null;
      i = j;
    }
    for (;;)
    {
      if ((paramArrayOfString1 != null) && (i != 0)) {
        paramArrayOfString1.setNotificationUri(mContentResolver, paramUri);
      }
      return paramArrayOfString1;
      LogUtils.d("GmailCP", "Query for list of labels", new Object[0]);
      paramArrayOfString2 = paramString1.getLabelQueryBuilder(Gmail.LABEL_PROJECTION).showHidden(false).query();
      long l;
      try
      {
        paramString1 = getPublicLabelCursor(str, paramArrayOfString1, paramArrayOfString2);
        paramArrayOfString1 = paramString1;
        i = j;
        if (paramArrayOfString2 == null) {
          continue;
        }
        paramArrayOfString2.close();
        paramArrayOfString1 = paramString1;
        i = j;
      }
      finally
      {
        if (paramArrayOfString2 != null) {
          paramArrayOfString2.close();
        }
      }
      paramArrayOfString2 = getCursorForLabel(Gmail.LABEL_PROJECTION, paramString1, paramArrayOfString2);
      try
      {
        paramString1 = getPublicLabelCursor(str, paramArrayOfString1, paramArrayOfString2);
        paramArrayOfString1 = paramString1;
        i = j;
        if (paramArrayOfString2 == null) {
          continue;
        }
        paramArrayOfString2.close();
        paramArrayOfString1 = paramString1;
        i = j;
      }
      finally
      {
        if (paramArrayOfString2 != null) {
          paramArrayOfString2.close();
        }
      }
      Cursor localCursor = getCursorForLabel(Gmail.LABEL_PROJECTION, paramString1, paramString2);
      try
      {
        paramString2 = getPublicLabelCursor(str, paramArrayOfString1, localCursor);
        paramString1 = paramArrayOfString2;
        if (localCursor != null)
        {
          paramString1 = paramArrayOfString2;
          if (localCursor.getCount() > 0)
          {
            paramString1 = paramArrayOfString2;
            if (localCursor.moveToFirst())
            {
              l = localCursor.getLong(localCursor.getColumnIndex("_id"));
              paramString1 = Long.valueOf(l);
            }
          }
        }
        if (localCursor != null) {
          localCursor.close();
        }
        paramArrayOfString1 = paramString2;
        i = j;
        if (paramString2 == null) {
          continue;
        }
        paramArrayOfString1 = paramString2;
        i = j;
        if (paramString1 == null) {
          continue;
        }
        paramString2.setNotificationUri(mContentResolver, PrivateGmailAccess.getLabelUriForId(str, paramString1.longValue()));
        i = 0;
        paramArrayOfString1 = paramString2;
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
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