package com.android.mail.browse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;

public class ConversationViewAdapter$ConversationHeaderItem
  extends ConversationOverlayItem
{
  public final Conversation mConversation;
  
  private ConversationViewAdapter$ConversationHeaderItem(ConversationViewAdapter paramConversationViewAdapter, Conversation paramConversation)
  {
    mConversation = paramConversation;
  }
  
  public void bindView(View paramView, boolean paramBoolean)
  {
    ((ConversationViewHeader)paramView).bind(this);
  }
  
  public View createView(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramContext = (ConversationViewHeader)paramLayoutInflater.inflate(2130968628, paramViewGroup, false);
    paramContext.setCallbacks(ConversationViewAdapter.access$000(this$0), ConversationViewAdapter.access$100(this$0));
    paramContext.bind(this);
    paramContext.setSubject(mConversation.subject);
    if (ConversationViewAdapter.access$100(this$0).getAccount().supportsCapability(8192)) {
      paramContext.setFolders(mConversation);
    }
    return paramContext;
  }
  
  public int getType()
  {
    return 0;
  }
  
  public boolean isContiguous()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationViewAdapter.ConversationHeaderItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */