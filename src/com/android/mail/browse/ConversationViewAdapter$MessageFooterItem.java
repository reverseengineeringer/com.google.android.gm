package com.android.mail.browse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ConversationViewAdapter$MessageFooterItem
  extends ConversationOverlayItem
{
  private final ConversationViewAdapter.MessageHeaderItem headerItem;
  
  private ConversationViewAdapter$MessageFooterItem(ConversationViewAdapter paramConversationViewAdapter, ConversationViewAdapter.MessageHeaderItem paramMessageHeaderItem)
  {
    headerItem = paramMessageHeaderItem;
  }
  
  public void bindView(View paramView, boolean paramBoolean)
  {
    ((MessageFooterView)paramView).bind(headerItem, paramBoolean);
  }
  
  public View createView(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramContext = (MessageFooterView)paramLayoutInflater.inflate(2130968618, paramViewGroup, false);
    paramContext.initialize(ConversationViewAdapter.access$600(this$0), ConversationViewAdapter.access$700(this$0));
    return paramContext;
  }
  
  public int getGravity()
  {
    return 48;
  }
  
  public int getHeight()
  {
    if (!headerItem.isExpanded()) {
      return 0;
    }
    return super.getHeight();
  }
  
  public int getType()
  {
    return 2;
  }
  
  public boolean isContiguous()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationViewAdapter.MessageFooterItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */