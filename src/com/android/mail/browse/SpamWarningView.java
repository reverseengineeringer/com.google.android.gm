package com.android.mail.browse;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import buc;

public class SpamWarningView
  extends CardView
{
  TextView g;
  ImageView h;
  View i;
  
  public SpamWarningView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SpamWarningView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    g = ((TextView)findViewById(buc.fM));
    h = ((ImageView)findViewById(buc.fK));
    i = findViewById(buc.fL);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.SpamWarningView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */