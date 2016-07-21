package com.android.mail.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import buc;

public class AccountItemView
  extends LinearLayout
{
  public TextView a;
  public TextView b;
  public ImageView c;
  public ImageView d;
  
  public AccountItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AccountItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AccountItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    a = ((TextView)findViewById(buc.h));
    b = ((TextView)findViewById(buc.g));
    c = ((ImageView)findViewById(buc.H));
    d = ((ImageView)findViewById(buc.af));
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AccountItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */