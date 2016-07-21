package com.google.android.gm.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.mail.providers.Account;
import cxe;
import dfh;
import dfx;
import dfy;
import dge;
import dhu;
import dhv;

public class AdWtaTooltipView
  extends LinearLayout
  implements View.OnClickListener
{
  public dhv a;
  public Account b;
  private int c;
  private TextView d;
  private String e;
  
  public AdWtaTooltipView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdWtaTooltipView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AdWtaTooltipView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(int paramInt, String paramString)
  {
    c = paramInt;
    TextView localTextView = d;
    switch (paramInt)
    {
    default: 
      paramInt = dge.bg;
    }
    for (;;)
    {
      cxe.a(localTextView, paramInt, new dhu(this, getContext()), new CharSequence[0]);
      e = paramString;
      return;
      paramInt = dge.bf;
      continue;
      paramInt = dge.bh;
    }
  }
  
  public final boolean a(ImageView paramImageView)
  {
    int i;
    boolean bool;
    if (getVisibility() == 0)
    {
      i = 8;
      if (i != 0) {
        break label62;
      }
      bool = true;
      label17:
      if (!bool) {
        break label68;
      }
    }
    label62:
    label68:
    for (int j = dfx.D;; j = dfx.g)
    {
      setVisibility(i);
      paramImageView.setImageResource(j);
      if (a != null) {
        a.a(bool);
      }
      return bool;
      i = 0;
      break;
      bool = false;
      break label17;
    }
  }
  
  public final boolean a(boolean paramBoolean)
  {
    if (getVisibility() == 0) {}
    for (boolean bool = true; paramBoolean != bool; bool = false) {
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == dfy.k)
    {
      if (TextUtils.isEmpty(e)) {
        dfh.a(getContext());
      }
    }
    else {
      return;
    }
    dfh.a(getContext(), Uri.parse(e), false);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    d = ((TextView)findViewById(dfy.t));
    ((TextView)findViewById(dfy.k)).setOnClickListener(this);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ads.AdWtaTooltipView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */