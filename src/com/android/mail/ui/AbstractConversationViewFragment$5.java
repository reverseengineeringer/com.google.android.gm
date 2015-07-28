package com.android.mail.ui;

class AbstractConversationViewFragment$5
  extends AbstractConversationViewFragment.FragmentRunnable
{
  AbstractConversationViewFragment$5(AbstractConversationViewFragment paramAbstractConversationViewFragment, String paramString)
  {
    super(paramAbstractConversationViewFragment, paramString);
  }
  
  public void go()
  {
    this$0.mActivity.getListHandler().onConversationSelected(null, true);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractConversationViewFragment.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */