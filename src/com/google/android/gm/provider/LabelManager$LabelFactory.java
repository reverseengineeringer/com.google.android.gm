package com.google.android.gm.provider;

import android.content.Context;
import android.database.Cursor;
import java.util.Map;

class LabelManager$LabelFactory
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
  
  LabelManager$LabelFactory(Context paramContext, String paramString, Cursor paramCursor)
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

/* Location:
 * Qualified Name:     com.google.android.gm.provider.LabelManager.LabelFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */