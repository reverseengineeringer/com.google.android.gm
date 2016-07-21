package com.android.mail.browse;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import buc;
import bxf;
import com.android.mail.providers.Folder;

public final class ConversationListFooterView
  extends LinearLayout
  implements View.OnClickListener
{
  public View a;
  public View b;
  public Uri c;
  public bxf d;
  
  public ConversationListFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void onClick(View paramView)
  {
    int i = paramView.getId();
    paramView = (Folder)paramView.getTag();
    if (i == buc.cq) {
      d.a(paramView);
    }
  }
  
  protected final void onFinishInflate()
  {
    super.onFinishInflate();
    a = findViewById(buc.cr);
    b = findViewById(buc.cq);
    b.setOnClickListener(this);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationListFooterView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */