package com.android.mail.browse;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import buc;
import buh;
import bxv;
import bzz;
import caa;
import cxe;

public class SuperCollapsedBlock
  extends FrameLayout
  implements View.OnClickListener
{
  public bxv a;
  public caa b;
  public TextView c;
  public View d;
  public int e;
  
  public SuperCollapsedBlock(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SuperCollapsedBlock(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setActivated(false);
    setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    c.setVisibility(8);
    d.setVisibility(0);
    cxe.a(this, getResources().getQuantityString(buh.w, e, new Object[] { Integer.valueOf(e) }));
    if (b != null) {
      post(new bzz(this));
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    c = ((TextView)findViewById(buc.fh));
    d = findViewById(buc.fg);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.SuperCollapsedBlock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */