package com.android.mail.ui;

import android.os.Handler;
import com.android.mail.browse.ConversationCursor;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.UIProvider.ConversationColumns;
import com.android.mail.utils.LogUtils;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Iterator;

public class AbstractActivityController$ConversationAction
  implements DestructiveAction
{
  private final int mAction;
  private boolean mCompleted;
  private final boolean mIsSelectedSet;
  private final Collection<Conversation> mTarget;
  
  public AbstractActivityController$ConversationAction(int paramInt, Collection<Conversation> paramCollection, boolean paramBoolean)
  {
    mAction = paramCollection;
    mTarget = ImmutableList.copyOf(paramBoolean);
    boolean bool;
    mIsSelectedSet = bool;
  }
  
  /* Error */
  private boolean isPerformed()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 53	com/android/mail/ui/AbstractActivityController$ConversationAction:mCompleted	Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 53	com/android/mail/ui/AbstractActivityController$ConversationAction:mCompleted	Z
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -11 -> 13
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	ConversationAction
    //   1	23	1	bool1	boolean
    //   8	2	2	bool2	boolean
    //   27	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	27	finally
    //   17	22	27	finally
  }
  
  public void performAction()
  {
    if (isPerformed()) {
      return;
    }
    boolean bool2 = this$0.mAccount.supportsCapability(16384);
    if (LogUtils.isLoggable(AbstractActivityController.LOG_TAG, 3)) {
      LogUtils.d(AbstractActivityController.LOG_TAG, "ConversationAction.performAction():\nmTarget=%s\nCurrent=%s", new Object[] { Conversation.toString(mTarget), this$0.mCurrentConversation });
    }
    if (this$0.mConversationListCursor == null)
    {
      LogUtils.e(AbstractActivityController.LOG_TAG, "null ConversationCursor in ConversationAction.performAction():\nmTarget=%s\nCurrent=%s", new Object[] { Conversation.toString(mTarget), this$0.mCurrentConversation });
      return;
    }
    boolean bool1 = bool2;
    switch (mAction)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if (bool1) {
        this$0.mHandler.postDelayed(new Runnable()
        {
          public void run()
          {
            this$0.onUndoAvailable(new ToastBarOperation(mTarget.size(), mAction, 0, mIsSelectedSet));
          }
        }, AbstractActivityController.access$400(this$0));
      }
      this$0.refreshConversationList();
      if (!mIsSelectedSet) {
        break;
      }
      AbstractActivityController.access$500(this$0).clear();
      return;
      LogUtils.d(AbstractActivityController.LOG_TAG, "Archiving", new Object[0]);
      this$0.mConversationListCursor.archive(this$0.mContext, mTarget);
      bool1 = bool2;
      continue;
      LogUtils.d(AbstractActivityController.LOG_TAG, "Deleting", new Object[0]);
      this$0.mConversationListCursor.delete(this$0.mContext, mTarget);
      bool1 = bool2;
      if (this$0.mFolder.supportsCapability(2048))
      {
        bool1 = false;
        continue;
        LogUtils.d(AbstractActivityController.LOG_TAG, "Muting", new Object[0]);
        Iterator localIterator;
        if (this$0.mFolder.supportsCapability(256))
        {
          localIterator = mTarget.iterator();
          while (localIterator.hasNext()) {
            nextlocalDeleteOnUpdate = true;
          }
        }
        this$0.mConversationListCursor.mute(this$0.mContext, mTarget);
        bool1 = bool2;
        continue;
        LogUtils.d(AbstractActivityController.LOG_TAG, "Reporting spam", new Object[0]);
        this$0.mConversationListCursor.reportSpam(this$0.mContext, mTarget);
        bool1 = bool2;
        continue;
        LogUtils.d(AbstractActivityController.LOG_TAG, "Marking not spam", new Object[0]);
        this$0.mConversationListCursor.reportNotSpam(this$0.mContext, mTarget);
        bool1 = bool2;
        continue;
        LogUtils.d(AbstractActivityController.LOG_TAG, "Reporting phishing", new Object[0]);
        this$0.mConversationListCursor.reportPhishing(this$0.mContext, mTarget);
        bool1 = bool2;
        continue;
        LogUtils.d(AbstractActivityController.LOG_TAG, "Removing star", new Object[0]);
        this$0.mConversationListCursor.updateBoolean(this$0.mContext, mTarget, UIProvider.ConversationColumns.STARRED, false);
        bool1 = bool2;
        continue;
        LogUtils.d(AbstractActivityController.LOG_TAG, "Marking not-important", new Object[0]);
        if ((this$0.mFolder != null) && (this$0.mFolder.isImportantOnly()))
        {
          localIterator = mTarget.iterator();
          while (localIterator.hasNext()) {
            nextlocalDeleteOnUpdate = true;
          }
        }
        this$0.mConversationListCursor.updateInt(this$0.mContext, mTarget, UIProvider.ConversationColumns.PRIORITY, 0);
        bool1 = bool2;
        continue;
        LogUtils.d(AbstractActivityController.LOG_TAG, "Discarding draft messages", new Object[0]);
        if ((this$0.mFolder != null) && (this$0.mFolder.isDraft()))
        {
          localIterator = mTarget.iterator();
          while (localIterator.hasNext()) {
            nextlocalDeleteOnUpdate = true;
          }
        }
        this$0.mConversationListCursor.discardDrafts(this$0.mContext, mTarget);
        bool1 = false;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractActivityController.ConversationAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */