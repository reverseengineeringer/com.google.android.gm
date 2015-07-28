package com.android.mail.browse;

import android.database.DataSetObserver;

class ConversationPagerAdapter$ListObserver
  extends DataSetObserver
{
  private ConversationPagerAdapter$ListObserver(ConversationPagerAdapter paramConversationPagerAdapter) {}
  
  public void onChanged()
  {
    this$0.notifyDataSetChanged();
  }
  
  public void onInvalidated() {}
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationPagerAdapter.ListObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */