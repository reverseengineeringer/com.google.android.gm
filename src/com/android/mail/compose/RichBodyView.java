package com.android.mail.compose;

import android.content.Context;
import android.util.AttributeSet;
import buo;
import bur;
import but;
import cbk;
import ccr;
import com.google.android.apps.work.common.richedittext.RichEditText;

public class RichBodyView
  extends RichEditText
{
  public ccr a;
  
  public RichBodyView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RichBodyView(Context paramContext, AttributeSet paramAttributeSet)
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
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknown";
      localObject = getContext();
      if ((localObject == null) || (!(localObject instanceof cbk))) {
        break;
      }
    }
    for (Object localObject = bur.a((Context)localObject, s);; localObject = "unknown")
    {
      buo.a().a("compose_body_actions", str, (String)localObject, 0L);
      return super.onTextContextMenuItem(paramInt);
      str = "copy";
      break;
      str = "cut";
      break;
      str = "paste";
      break;
      str = "select_all";
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.RichBodyView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */