package com.android.mail.compose;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import buc;
import buj;
import ckk;
import com.android.mail.providers.Attachment;
import com.android.mail.ui.AttachmentTile;
import ctr;

public class ComposeAttachmentTile
  extends AttachmentTile
{
  public View a;
  private TextView b;
  
  public ComposeAttachmentTile(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ComposeAttachmentTile(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(Attachment paramAttachment, ckk paramckk)
  {
    super.a(paramAttachment, paramckk);
    a.setContentDescription(getResources().getString(buj.eb, new Object[] { c }));
    if (d > 0)
    {
      b.setText(ctr.a(getContext(), g.d));
      b.setVisibility(0);
    }
    setContentDescription(c());
  }
  
  protected final String c()
  {
    String str = super.c();
    if (str != null) {
      return getResources().getString(buj.D, new Object[] { str, "", a.getContentDescription() });
    }
    return null;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    b = ((TextView)findViewById(buc.E));
    a = findViewById(buc.B);
    a.setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.ComposeAttachmentTile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */