package com.google.android.gm.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.text.TextUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class LabelManager
{
  private static final Set<String> FORCED_INCLUDED_LABELS;
  private static final Set<String> FORCED_INCLUDED_OR_PARTIAL_LABELS;
  private static final Set<String> FORCED_NON_SYNCED_LABELS = ImmutableSet.of("^s", "^b", "^all", "^k");
  private static final Set<String> FORCED_SYNCED_NO_NOTIFY_LABELS;
  private static final Pattern LABEL_SEPARATOR_PATTERN = Pattern.compile("\\^\\*\\*\\^");
  private static final List<String> SORTED_USER_MEANINGFUL_SYSTEM_LABELS = ImmutableList.of("^i", "^iim", "^t", "^io_im", "^b", "^f", "^^out", "^r", "^all", "^s", "^k");
  private static Handler sAsyncLabelFetchHandler = null;
  private static final Map<String, Label> sCachedLabels = new ConcurrentHashMap();
  
  static
  {
    FORCED_INCLUDED_LABELS = ImmutableSet.of("^^out", "^r");
    FORCED_INCLUDED_OR_PARTIAL_LABELS = ImmutableSet.of("^f");
    FORCED_SYNCED_NO_NOTIFY_LABELS = ImmutableSet.of("^^out", "^r", "^f");
  }
  
  public static Set<String> getForcedIncludedLabels()
  {
    return FORCED_INCLUDED_LABELS;
  }
  
  public static Set<String> getForcedIncludedOrPartialLabels()
  {
    return FORCED_INCLUDED_OR_PARTIAL_LABELS;
  }
  
  public static Set<String> getForcedSyncedNoNotifyLabels()
  {
    return FORCED_SYNCED_NO_NOTIFY_LABELS;
  }
  
  public static Label getFreshLabel(Context paramContext, String paramString1, String paramString2)
  {
    return getLabel(paramContext, paramString1, paramString2, false);
  }
  
  public static Label getLabel(Context paramContext, String paramString1, String paramString2)
  {
    return getLabel(paramContext, paramString1, paramString2, true);
  }
  
  public static Label getLabel(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = paramString1 + paramString2;
    Object localObject = null;
    if (paramBoolean)
    {
      Label localLabel = (Label)sCachedLabels.get(str);
      localObject = localLabel;
      if (localLabel != null) {
        return localLabel;
      }
    }
    paramContext = new LabelList(paramContext, paramString1, Uri.withAppendedPath(Uri.withAppendedPath(Gmail.getLabelsUri(paramString1), Uri.encode(paramString2)), "1"), true);
    if (paramContext.size() > 0)
    {
      localObject = paramContext.get(0);
      sCachedLabels.put(str, localObject);
    }
    for (;;)
    {
      return (Label)localObject;
      LogUtils.e("Gmail.LabelManager", "Unable to get label %s for account %s", new Object[] { paramString2, paramString1 });
    }
  }
  
  public static LabelList getLabelList(Context paramContext, String paramString, List<String> paramList, boolean paramBoolean)
  {
    Uri.Builder localBuilder = Gmail.getLabelsUri(paramString).buildUpon();
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localObject = localBuilder.appendEncodedPath((String)localObject);
      if (paramList == null) {
        break;
      }
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        ((Uri.Builder)localObject).appendQueryParameter("canonicalName", (String)paramList.get(i));
        i += 1;
      }
    }
    return new LabelList(paramContext, paramString, ((Uri.Builder)localObject).build(), paramBoolean);
  }
  
  public static LabelList getRecentLabelList(Context paramContext, String paramString, long paramLong, int paramInt)
  {
    return new LabelList(paramContext, paramString, Gmail.getLabelsUri(paramString).buildUpon().appendEncodedPath("0").appendQueryParameter("before", Long.toString(paramLong)).appendQueryParameter("limit", Long.toString(paramInt)).build(), false);
  }
  
  @Deprecated
  public static List<String> getSortedUserMeaningfulSystemLabels()
  {
    return SORTED_USER_MEANINGFUL_SYSTEM_LABELS;
  }
  
  public static Map<String, Label> parseLabelQueryResult(Context paramContext, String paramString)
  {
    LogUtils.d("Gmail.LabelManager", "label query result: %s", new Object[] { paramString });
    HashMap localHashMap = Maps.newHashMap();
    if (paramString != null)
    {
      paramContext = Label.getSystemLabelNameMap(paramContext);
      paramString = TextUtils.split(paramString, LABEL_SEPARATOR_PATTERN);
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Label localLabel = Label.parseJoinedString(paramString[i], paramContext);
        if (localLabel != null) {
          localHashMap.put(localLabel.getCanonicalName(), localLabel);
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  public static Map<String, Label> parseLabelQueryResult(String paramString)
  {
    return parseLabelQueryResult((Context)null, paramString);
  }
  
  public static Map<String, Label> parseLabelQueryResult(String paramString1, String paramString2)
  {
    LogUtils.d("Gmail.LabelManager", "label query result: %s", new Object[] { paramString2 });
    HashMap localHashMap = Maps.newHashMap();
    parseLabelQueryResult(paramString1, paramString2, localHashMap, null);
    return localHashMap;
  }
  
  public static void parseLabelQueryResult(String paramString1, String paramString2, Map<String, Label> paramMap, Map<Long, Label> paramMap1)
  {
    LogUtils.d("Gmail.LabelManager", "label query result: %s", new Object[] { paramString2 });
    paramMap.clear();
    if (paramString2 != null)
    {
      paramString2 = TextUtils.split(paramString2, LABEL_SEPARATOR_PATTERN);
      int j = paramString2.length;
      int i = 0;
      while (i < j)
      {
        Label localLabel = Label.parseJoinedString(paramString1, paramString2[i], null, paramMap1);
        if (localLabel != null) {
          paramMap.put(localLabel.getCanonicalName(), localLabel);
        }
        i += 1;
      }
    }
  }
  
  public static String serialize(Map<String, Label> paramMap)
  {
    paramMap = (Label[])paramMap.values().toArray(new Label[0]);
    int j = paramMap.length;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuilder.append("^**^");
      }
      localStringBuilder.append(paramMap[i].serialize());
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void updateRecentLabels(Context paramContext, String paramString, Map<String, Long> paramMap)
  {
    paramString = Gmail.getLabelsUri(paramString).buildUpon().appendEncodedPath("lastTouched").build();
    ContentValues localContentValues = new ContentValues();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localContentValues.put((String)localEntry.getKey(), (Long)localEntry.getValue());
    }
    paramContext.getContentResolver().update(paramString, localContentValues, null, null);
  }
  
  static class LabelFactory
  {
    final String mAccount;
    final int mCanonicalNameIndex;
    final int mColorIndex;
    final Context mContext;
    final int mHiddenLabelIndex;
    final int mIdIndex;
    final int mLabelCountBehaviorIndex;
    final int mLabelSyncPolicyIndex;
    final int mLastTouchedIndex;
    final int mNameIndex;
    final int mNumConversationsIndex;
    final int mNumUnreadConversationsIndex;
    final Map<String, CharSequence> mSystemLabelNameMap;
    
    LabelFactory(Context paramContext, String paramString, Cursor paramCursor)
    {
      mContext = paramContext;
      mAccount = paramString;
      mIdIndex = paramCursor.getColumnIndexOrThrow("_id");
      mCanonicalNameIndex = paramCursor.getColumnIndexOrThrow("canonicalName");
      mNameIndex = paramCursor.getColumnIndexOrThrow("name");
      mNumConversationsIndex = paramCursor.getColumnIndexOrThrow("numConversations");
      mNumUnreadConversationsIndex = paramCursor.getColumnIndexOrThrow("numUnreadConversations");
      mColorIndex = paramCursor.getColumnIndexOrThrow("color");
      mHiddenLabelIndex = paramCursor.getColumnIndexOrThrow("hidden");
      mLabelCountBehaviorIndex = paramCursor.getColumnIndexOrThrow("labelCountDisplayBehavior");
      mLabelSyncPolicyIndex = paramCursor.getColumnIndexOrThrow("labelSyncPolicy");
      mLastTouchedIndex = paramCursor.getColumnIndexOrThrow("lastTouched");
      mSystemLabelNameMap = Label.getSystemLabelNameMap(paramContext);
    }
    
    Label newLabel(Cursor paramCursor)
    {
      Object localObject = null;
      long l1;
      String str1;
      int i;
      int j;
      if (paramCursor != null)
      {
        l1 = paramCursor.getLong(mIdIndex);
        localObject = paramCursor.getString(mCanonicalNameIndex);
        str1 = paramCursor.getString(mNameIndex);
        i = paramCursor.getInt(mNumConversationsIndex);
        j = paramCursor.getInt(mNumUnreadConversationsIndex);
        if (paramCursor.getInt(mHiddenLabelIndex) == 0) {
          break label171;
        }
      }
      label171:
      for (boolean bool = true;; bool = false)
      {
        String str2 = paramCursor.getString(mColorIndex);
        int k = paramCursor.getInt(mLabelCountBehaviorIndex);
        int m = paramCursor.getInt(mLabelSyncPolicyIndex);
        long l2 = paramCursor.getLong(mLastTouchedIndex);
        localObject = new Label(mContext, mAccount, l1, (String)localObject, str1, str2, i, j, bool, k, m, l2, mSystemLabelNameMap);
        return (Label)localObject;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.LabelManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */