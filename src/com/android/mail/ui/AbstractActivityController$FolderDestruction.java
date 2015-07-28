package com.android.mail.ui;

import com.android.mail.browse.ConversationCursor;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class AbstractActivityController$FolderDestruction
  implements DestructiveAction
{
  private int mAction;
  private boolean mCompleted;
  private final ArrayList<FolderOperation> mFolderOps = new ArrayList();
  private final boolean mIsDestructive;
  private boolean mIsSelectedSet;
  private boolean mShowUndo;
  private final Collection<Conversation> mTarget;
  
  private AbstractActivityController$FolderDestruction(Collection<Conversation> paramCollection, Collection<FolderOperation> paramCollection1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    mTarget = ImmutableList.copyOf(paramCollection1);
    mFolderOps.addAll(paramBoolean1);
    mIsDestructive = paramBoolean2;
    mIsSelectedSet = paramBoolean3;
    mShowUndo = paramInt;
    int i;
    mAction = i;
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
    //   5: getfield 66	com/android/mail/ui/AbstractActivityController$FolderDestruction:mCompleted	Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 66	com/android/mail/ui/AbstractActivityController$FolderDestruction:mCompleted	Z
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
    //   0	32	0	this	FolderDestruction
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
    if (isPerformed()) {}
    do
    {
      return;
      if ((mIsDestructive) && (mShowUndo))
      {
        localObject1 = new ToastBarOperation(mTarget.size(), mAction, 0, mIsSelectedSet);
        this$0.onUndoAvailable((ToastBarOperation)localObject1);
      }
      Object localObject1 = new ArrayList(mTarget.size());
      Iterator localIterator = mTarget.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Conversation)localIterator.next();
        HashMap localHashMap = Folder.hashMapForFolders(((Conversation)localObject2).getRawFolders());
        if (mIsDestructive) {
          localDeleteOnUpdate = true;
        }
        localObject2 = mFolderOps.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          FolderOperation localFolderOperation = (FolderOperation)((Iterator)localObject2).next();
          if (mAdd) {
            localHashMap.put(mFolder.uri, mFolder);
          } else {
            localHashMap.remove(mFolder.uri);
          }
        }
        ((ArrayList)localObject1).add(Folder.getSerializedFolderString(localHashMap.values()));
      }
      if (this$0.mConversationListCursor != null) {
        this$0.mConversationListCursor.updateStrings(this$0.mContext, mTarget, "rawFolders", (ArrayList)localObject1);
      }
      this$0.refreshConversationList();
    } while (!mIsSelectedSet);
    AbstractActivityController.access$500(this$0).clear();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractActivityController.FolderDestruction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */