package com.android.mail.ui;

import android.database.Cursor;
import com.android.mail.browse.ConversationCursor;
import com.android.mail.providers.Conversation;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import java.util.Collection;

public class ConversationPositionTracker
{
  protected static final String LOG_TAG = ;
  private final Callbacks mCallbacks;
  private Conversation mConversation;
  private boolean mCursorDirty = false;
  
  public ConversationPositionTracker(Callbacks paramCallbacks)
  {
    mCallbacks = paramCallbacks;
  }
  
  private int calculatePosition()
  {
    int j = -1;
    ConversationCursor localConversationCursor = mCallbacks.getConversationListCursor();
    int i;
    if (!mCursorDirty) {
      i = mConversation.position;
    }
    for (;;)
    {
      return i;
      i = j;
      if (localConversationCursor == null) {
        continue;
      }
      i = j;
      if (mConversation == null) {
        continue;
      }
      mCursorDirty = false;
      int m;
      boolean bool;
      if (localConversationCursor == null)
      {
        m = 0;
        i = j;
        if (!isDataLoaded(localConversationCursor)) {
          continue;
        }
        i = j;
        if (m == 0) {
          continue;
        }
        bool = Utils.disableConversationCursorNetworkAccess(localConversationCursor);
        j = 0;
      }
      try
      {
        for (;;)
        {
          if (!localConversationCursor.moveToPosition(j)) {
            break label173;
          }
          if (Utils.getConversationId(localConversationCursor) == mConversation.id)
          {
            mConversation.position = j;
            if (mConversation.position != j) {}
            for (;;)
            {
              localConversationCursor.moveToPosition(j + 1);
              i = j;
              return j;
              m = localConversationCursor.getCount();
              break;
            }
          }
          j += 1;
        }
        label173:
        int k;
        if (mConversation.position < m)
        {
          k = j;
          if (j < m) {}
        }
        else
        {
          k = localConversationCursor.getCount() - 1;
        }
        if (isDataLoaded(localConversationCursor))
        {
          LogUtils.d(LOG_TAG, "ConversationPositionTracker: Could not find conversation %s in the cursor. Moving to position %d ", new Object[] { mConversation.toString(), Integer.valueOf(k) });
          localConversationCursor.moveToPosition(k);
          mConversation = new Conversation(localConversationCursor);
        }
        i = k;
        return k;
      }
      finally
      {
        if (bool) {
          Utils.enableConversationCursorNetworkAccess(localConversationCursor);
        }
      }
    }
  }
  
  private Conversation conversationAtPosition(int paramInt)
  {
    Object localObject = mCallbacks.getConversationListCursor();
    ((ConversationCursor)localObject).moveToPosition(paramInt);
    localObject = new Conversation((Cursor)localObject);
    position = paramInt;
    return (Conversation)localObject;
  }
  
  private int getCount()
  {
    ConversationCursor localConversationCursor = mCallbacks.getConversationListCursor();
    if (isDataLoaded(localConversationCursor)) {
      return localConversationCursor.getCount();
    }
    return 0;
  }
  
  private Conversation getNewer(Collection<Conversation> paramCollection)
  {
    int i = calculatePosition();
    Object localObject;
    if ((!isDataLoaded()) || (i < 0))
    {
      localObject = null;
      return (Conversation)localObject;
    }
    i -= 1;
    for (;;)
    {
      if (i < 0) {
        break label54;
      }
      Conversation localConversation = conversationAtPosition(i);
      localObject = localConversation;
      if (!Conversation.contains(paramCollection, localConversation)) {
        break;
      }
      i -= 1;
    }
    label54:
    return null;
  }
  
  private Conversation getOlder(Collection<Conversation> paramCollection)
  {
    int i = calculatePosition();
    Object localObject;
    if ((!isDataLoaded()) || (i < 0))
    {
      localObject = null;
      return (Conversation)localObject;
    }
    i += 1;
    for (;;)
    {
      if (i >= getCount()) {
        break label58;
      }
      Conversation localConversation = conversationAtPosition(i);
      localObject = localConversation;
      if (!Conversation.contains(paramCollection, localConversation)) {
        break;
      }
      i += 1;
    }
    label58:
    return null;
  }
  
  private boolean isDataLoaded()
  {
    return isDataLoaded(mCallbacks.getConversationListCursor());
  }
  
  private static boolean isDataLoaded(ConversationCursor paramConversationCursor)
  {
    return (paramConversationCursor != null) && (!paramConversationCursor.isClosed());
  }
  
  public Conversation getNextConversation(int paramInt, Collection<Conversation> paramCollection)
  {
    boolean bool1;
    boolean bool2;
    if (paramInt == 2)
    {
      bool1 = true;
      if (paramInt != 1) {
        break label64;
      }
      bool2 = true;
      label15:
      if (!bool1) {
        break label70;
      }
      paramCollection = getNewer(paramCollection);
    }
    for (;;)
    {
      LogUtils.d(LOG_TAG, "ConversationPositionTracker.getNextConversation: getNewer = %b, getOlder = %b, Next conversation is %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramCollection });
      return paramCollection;
      bool1 = false;
      break;
      label64:
      bool2 = false;
      break label15;
      label70:
      if (bool2) {
        paramCollection = getOlder(paramCollection);
      } else {
        paramCollection = null;
      }
    }
  }
  
  public void initialize(Conversation paramConversation)
  {
    mConversation = paramConversation;
    mCursorDirty = true;
    calculatePosition();
  }
  
  public void onCursorUpdated()
  {
    mCursorDirty = true;
  }
  
  public static abstract interface Callbacks
  {
    public abstract ConversationCursor getConversationListCursor();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationPositionTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */