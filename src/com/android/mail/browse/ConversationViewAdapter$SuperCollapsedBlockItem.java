package com.android.mail.browse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ConversationViewAdapter$SuperCollapsedBlockItem
  extends ConversationOverlayItem
{
  private int mEnd;
  private final int mStart;
  
  private ConversationViewAdapter$SuperCollapsedBlockItem(ConversationViewAdapter paramConversationViewAdapter, int paramInt1, int paramInt2)
  {
    mStart = paramInt1;
    mEnd = paramInt2;
  }
  
  public void bindView(View paramView, boolean paramBoolean)
  {
    ((SuperCollapsedBlock)paramView).bind(this);
  }
  
  public boolean canPushSnapHeader()
  {
    return true;
  }
  
  public View createView(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramContext = (SuperCollapsedBlock)paramLayoutInflater.inflate(2130968681, paramViewGroup, false);
    paramContext.initialize(ConversationViewAdapter.access$800(this$0));
    return paramContext;
  }
  
  public int getEnd()
  {
    return mEnd;
  }
  
  public int getStart()
  {
    return mStart;
  }
  
  public int getType()
  {
    return 3;
  }
  
  public boolean isContiguous()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationViewAdapter.SuperCollapsedBlockItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */