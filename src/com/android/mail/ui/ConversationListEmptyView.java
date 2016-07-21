package com.android.mail.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import buc;

public class ConversationListEmptyView
  extends LinearLayout
{
  public ImageView a;
  public TextView b;
  public TextView c;
  
  public ConversationListEmptyView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ConversationListEmptyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    a = ((ImageView)findViewById(buc.bo));
    b = ((TextView)findViewById(buc.bq));
    c = ((TextView)findViewById(buc.dG));
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationListEmptyView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */