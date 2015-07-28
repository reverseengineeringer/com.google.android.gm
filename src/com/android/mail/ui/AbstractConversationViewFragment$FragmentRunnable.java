package com.android.mail.ui;

import com.android.mail.utils.LogUtils;

public abstract class AbstractConversationViewFragment$FragmentRunnable
  implements Runnable
{
  private final String mOpName;
  
  public AbstractConversationViewFragment$FragmentRunnable(AbstractConversationViewFragment paramAbstractConversationViewFragment, String paramString)
  {
    mOpName = paramString;
  }
  
  public abstract void go();
  
  public void run()
  {
    if (!this$0.isAdded())
    {
      LogUtils.i(AbstractConversationViewFragment.access$600(), "Unable to run op='%s' b/c fragment is not attached: %s", new Object[] { mOpName, this$0 });
      return;
    }
    go();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractConversationViewFragment.FragmentRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */