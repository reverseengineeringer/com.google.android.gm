package com.android.mail.compose;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import cbj;

public class BodyView
  extends EditText
{
  private cbj a;
  
  public BodyView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BodyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    if (a != null) {
      a.a_(paramInt1, paramInt2);
    }
    super.onSelectionChanged(paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.BodyView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */