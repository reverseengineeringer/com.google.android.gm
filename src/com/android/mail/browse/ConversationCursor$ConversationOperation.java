package com.android.mail.browse;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentValues;
import android.net.Uri;
import android.net.Uri.Builder;
import com.android.mail.providers.Conversation;

public class ConversationCursor$ConversationOperation
{
  private final Conversation mConversation;
  private final boolean mLocalDeleteOnUpdate;
  private final boolean mMostlyDead;
  private boolean mRecalibrateRequired = true;
  private final int mType;
  private final Uri mUri;
  private final ContentValues mValues;
  
  public ConversationCursor$ConversationOperation(ConversationCursor paramConversationCursor, int paramInt, Conversation paramConversation)
  {
    this(paramConversationCursor, paramInt, paramConversation, null);
  }
  
  public ConversationCursor$ConversationOperation(ConversationCursor paramConversationCursor, int paramInt, Conversation paramConversation, ContentValues paramContentValues)
  {
    mType = paramInt;
    mUri = uri;
    mConversation = paramConversation;
    mValues = paramContentValues;
    mLocalDeleteOnUpdate = localDeleteOnUpdate;
    mMostlyDead = paramConversation.isMostlyDead();
  }
  
  private ContentProviderOperation execute(Uri paramUri)
  {
    Uri localUri = paramUri.buildUpon().appendQueryParameter("seq", Integer.toString(ConversationCursor.access$1200())).build();
    switch (mType)
    {
    default: 
      throw new UnsupportedOperationException("No such ConversationOperation type: " + mType);
    case 2: 
      if (mLocalDeleteOnUpdate) {
        ConversationCursor.sProvider.deleteLocal(mUri, this$0);
      }
      while (!mMostlyDead)
      {
        return ContentProviderOperation.newUpdate(localUri).withValues(mValues).build();
        ConversationCursor.sProvider.updateLocal(mUri, mValues, this$0);
        mRecalibrateRequired = false;
      }
      ConversationCursor.sProvider.commitMostlyDead(mConversation, this$0);
      return null;
    case 130: 
      ConversationCursor.sProvider.setMostlyDead(mConversation, this$0);
      return ContentProviderOperation.newUpdate(localUri).withValues(mValues).build();
    case 1: 
      ConversationCursor.ConversationProvider.access$2000(ConversationCursor.sProvider, mUri, mValues);
      return ContentProviderOperation.newInsert(localUri).withValues(mValues).build();
    case 0: 
      ConversationCursor.sProvider.deleteLocal(mUri, this$0);
      if (!mMostlyDead) {
        return ContentProviderOperation.newDelete(localUri).build();
      }
      ConversationCursor.sProvider.commitMostlyDead(mConversation, this$0);
      return null;
    case 128: 
      ConversationCursor.sProvider.setMostlyDead(mConversation, this$0);
      return ContentProviderOperation.newDelete(localUri).build();
    case 3: 
      ConversationCursor.sProvider.deleteLocal(mUri, this$0);
      if (!mMostlyDead) {
        return ContentProviderOperation.newUpdate(localUri).withValue("operation", "archive").build();
      }
      ConversationCursor.sProvider.commitMostlyDead(mConversation, this$0);
      return null;
    case 131: 
      ConversationCursor.sProvider.setMostlyDead(mConversation, this$0);
      return ContentProviderOperation.newUpdate(localUri).withValue("operation", "archive").build();
    case 4: 
      if (mLocalDeleteOnUpdate) {
        ConversationCursor.sProvider.deleteLocal(mUri, this$0);
      }
      return ContentProviderOperation.newUpdate(localUri).withValue("operation", "mute").build();
    case 5: 
    case 6: 
      ConversationCursor.sProvider.deleteLocal(mUri, this$0);
      if (mType == 5) {}
      for (paramUri = "report_spam";; paramUri = "report_not_spam") {
        return ContentProviderOperation.newUpdate(localUri).withValue("operation", paramUri).build();
      }
    case 7: 
      ConversationCursor.sProvider.deleteLocal(mUri, this$0);
      return ContentProviderOperation.newUpdate(localUri).withValue("operation", "report_phishing").build();
    }
    ConversationCursor.sProvider.deleteLocal(mUri, this$0);
    return ContentProviderOperation.newUpdate(localUri).withValue("operation", "discard_drafts").build();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationCursor.ConversationOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */