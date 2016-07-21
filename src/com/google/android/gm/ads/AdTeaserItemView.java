package com.google.android.gm.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import bvt;
import bzn;
import com.android.mail.providers.Account;
import cqj;
import cqk;
import cqp;
import cxa;
import dfu;
import dfw;
import dfy;
import dge;
import dhc;

public class AdTeaserItemView
  extends CardView
  implements bvt, cqj
{
  boolean g;
  boolean h;
  String i;
  String j;
  public Account k;
  cqp l;
  bzn m;
  dhc n;
  TextView o;
  TextView p;
  TextView q;
  ImageView r;
  ImageView s;
  AppRatingAndLogoView t;
  public AdWtaTooltipView u;
  private int v;
  private ImageView w;
  
  public AdTeaserItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AdTeaserItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AdTeaserItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private final void a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    g = cxa.a(localResources);
    if (!localResources.getBoolean(dfu.a)) {}
    for (boolean bool = true;; bool = false)
    {
      h = bool;
      v = localResources.getDimensionPixelSize(dfw.f);
      i = localResources.getString(dge.d);
      j = paramContext.getString(dge.bD);
      return;
    }
  }
  
  public final int a()
  {
    return m.U;
  }
  
  public final float b()
  {
    return m.V;
  }
  
  public final void c()
  {
    Object localObject2 = w;
    Object localObject1;
    if (n.j)
    {
      localObject1 = m.b;
      ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
      localObject1 = w;
      localObject2 = getContext().getResources();
      if (!n.j) {
        break label76;
      }
    }
    label76:
    for (int i1 = dge.fl;; i1 = dge.bi)
    {
      ((ImageView)localObject1).setContentDescription(((Resources)localObject2).getString(i1));
      return;
      localObject1 = m.a;
      break;
    }
  }
  
  public final boolean h()
  {
    return true;
  }
  
  public final void i() {}
  
  public final cqk l()
  {
    return cqk.a(this);
  }
  
  public final float m()
  {
    return m.J;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    o = ((TextView)findViewById(dfy.bW));
    p = ((TextView)findViewById(dfy.ck));
    q = ((TextView)findViewById(dfy.cg));
    r = ((ImageView)findViewById(dfy.ai));
    w = ((ImageView)findViewById(dfy.ci));
    s = ((ImageView)findViewById(dfy.bi));
    t = ((AppRatingAndLogoView)findViewById(dfy.D));
    u = ((AdWtaTooltipView)findViewById(dfy.s));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = 0;
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = t;
    if (paramInt1 > v)
    {
      paramInt1 = 1;
      localObject = a;
      if (paramInt1 == 0) {
        break label54;
      }
    }
    label54:
    for (paramInt1 = i1;; paramInt1 = 8)
    {
      ((ImageView)localObject).setVisibility(paramInt1);
      return;
      paramInt1 = 0;
      break;
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    w.setOnClickListener(paramOnClickListener);
    s.setOnClickListener(paramOnClickListener);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ads.AdTeaserItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */