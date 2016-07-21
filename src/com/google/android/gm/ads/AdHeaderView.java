package com.google.android.gm.ads;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bvs;
import bvt;
import dfv;
import dfw;
import dfy;
import dgf;

public class AdHeaderView
  extends LinearLayout
  implements View.OnClickListener, bvt
{
  public TextView a;
  public AdWtaTooltipView b;
  private final int c;
  private final int d;
  private ImageView e;
  
  public AdHeaderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AdHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.getResources();
    c = paramContext.getDimensionPixelSize(dfw.g);
    d = paramContext.getDimensionPixelSize(dfw.h);
  }
  
  public final int a()
  {
    return c;
  }
  
  public final float b()
  {
    return d;
  }
  
  public final boolean c()
  {
    return b.a(e);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == dfy.l) {
      c();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    TextView localTextView = (TextView)findViewById(dfy.j);
    SpannableString localSpannableString = new SpannableString(localTextView.getText());
    int i = localSpannableString.length();
    Context localContext = getContext();
    localSpannableString.setSpan(new TextAppearanceSpan(localContext, dgf.a), 0, i, 33);
    localSpannableString.setSpan(new BackgroundColorSpan(localContext.getResources().getColor(dfv.a)), 0, i, 33);
    localSpannableString.setSpan(new bvs(localSpannableString, this), 0, i, 33);
    localTextView.setText(localSpannableString);
    a = ((TextView)findViewById(dfy.m));
    e = ((ImageView)findViewById(dfy.l));
    e.setOnClickListener(this);
    b = ((AdWtaTooltipView)findViewById(dfy.s));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ads.AdHeaderView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */