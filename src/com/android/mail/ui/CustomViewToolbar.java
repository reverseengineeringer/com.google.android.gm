package com.android.mail.ui;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import buc;
import cfx;
import cgm;
import cjw;
import cmt;
import cmu;
import cmv;
import crb;
import crj;
import crk;
import cxe;

public class CustomViewToolbar
  extends Toolbar
  implements crb, crk
{
  public View A;
  public cjw u;
  public crj v;
  final cfx w = new cmt(this);
  final cgm x = new cmu(this);
  public View y;
  public TextView z;
  
  public CustomViewToolbar(Context paramContext)
  {
    super(paramContext);
  }
  
  public CustomViewToolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    i();
  }
  
  public final void a(Context paramContext, int paramInt)
  {
    z.setTextAppearance(paramContext, paramInt);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    z.setText(paramCharSequence);
  }
  
  public final void b(int paramInt)
  {
    z.setTextColor(paramInt);
  }
  
  public final void c(int paramInt)
  {
    Object localObject = new int[2];
    y.getLocationInWindow((int[])localObject);
    if (cxe.a(this)) {
      paramInt = localObject[0] + y.getWidth() - paramInt;
    }
    for (;;)
    {
      if (y.getWidth() != paramInt)
      {
        localObject = y.getLayoutParams();
        width = paramInt;
        y.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      return;
      paramInt -= localObject[0];
    }
  }
  
  public final void i()
  {
    View localView = A;
    if ((u.X()) && (u.at())) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    y = findViewById(buc.l);
    z = ((TextView)findViewById(buc.n));
    A = findViewById(buc.m);
    A.setOnClickListener(new cmv(this));
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.CustomViewToolbar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */