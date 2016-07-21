package com.android.mail.compose;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import buc;
import bue;
import buj;
import car;

public class ProposedTimeView
  extends FrameLayout
{
  public TextView a;
  public TextView b;
  private TextView c;
  
  public ProposedTimeView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProposedTimeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProposedTimeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(bue.i, this);
    a = ((TextView)findViewById(buc.fm));
    b = ((TextView)findViewById(buc.aQ));
    c = ((TextView)findViewById(buc.dF));
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    String str = car.a(getContext(), paramLong1, paramLong2, false, true);
    c.setText(getResources().getString(buj.ap, new Object[] { str }));
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.ProposedTimeView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */