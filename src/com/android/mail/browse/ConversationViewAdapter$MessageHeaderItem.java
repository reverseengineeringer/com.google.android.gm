package com.android.mail.browse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.base.Objects;

public class ConversationViewAdapter$MessageHeaderItem
  extends ConversationOverlayItem
{
  public boolean detailsExpanded;
  private boolean mExpanded;
  private MessageCursor.ConversationMessage mMessage;
  public CharSequence recipientSummaryText;
  public CharSequence timestampLong;
  public CharSequence timestampShort;
  
  ConversationViewAdapter$MessageHeaderItem(ConversationViewAdapter paramConversationViewAdapter, MessageCursor.ConversationMessage paramConversationMessage, boolean paramBoolean)
  {
    mMessage = paramConversationMessage;
    mExpanded = paramBoolean;
    detailsExpanded = false;
  }
  
  public boolean belongsToMessage(MessageCursor.ConversationMessage paramConversationMessage)
  {
    return Objects.equal(mMessage, paramConversationMessage);
  }
  
  public void bindView(View paramView, boolean paramBoolean)
  {
    ((MessageHeaderView)paramView).bind(this, paramBoolean);
  }
  
  public boolean canBecomeSnapHeader()
  {
    return isExpanded();
  }
  
  public boolean canPushSnapHeader()
  {
    return true;
  }
  
  public View createView(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramContext = (MessageHeaderView)paramLayoutInflater.inflate(2130968619, paramViewGroup, false);
    paramContext.initialize(ConversationViewAdapter.access$200(this$0), ConversationViewAdapter.access$100(this$0), ConversationViewAdapter.access$300(this$0));
    paramContext.setCallbacks(ConversationViewAdapter.access$400(this$0));
    paramContext.setContactInfoSource(ConversationViewAdapter.access$500(this$0));
    return paramContext;
  }
  
  public MessageCursor.ConversationMessage getMessage()
  {
    return mMessage;
  }
  
  public int getType()
  {
    return 1;
  }
  
  public boolean isContiguous()
  {
    return !isExpanded();
  }
  
  public boolean isExpanded()
  {
    return mExpanded;
  }
  
  public void onModelUpdated(View paramView)
  {
    ((MessageHeaderView)paramView).refresh();
  }
  
  public void setExpanded(boolean paramBoolean)
  {
    if (mExpanded != paramBoolean) {
      mExpanded = paramBoolean;
    }
  }
  
  public void setMessage(MessageCursor.ConversationMessage paramConversationMessage)
  {
    mMessage = paramConversationMessage;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationViewAdapter.MessageHeaderItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */