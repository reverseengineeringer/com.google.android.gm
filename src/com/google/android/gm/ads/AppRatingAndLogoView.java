package com.google.android.gm.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cxd;
import dfw;
import dfx;
import dfy;
import java.text.NumberFormat;
import java.util.Locale;
import np;
import nq;
import qa;

public class AppRatingAndLogoView
  extends RelativeLayout
{
  private static Drawable b;
  private static Drawable c;
  private static Drawable d;
  ImageView a;
  private LinearLayout e;
  private ImageView[] f;
  private TextView g;
  private boolean h;
  private float i;
  private int j;
  private boolean k;
  
  public AppRatingAndLogoView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AppRatingAndLogoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AppRatingAndLogoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private final void a(Context paramContext)
  {
    f = new ImageView[5];
    if (b == null)
    {
      paramContext = paramContext.getResources();
      b = paramContext.getDrawable(dfx.J);
      c = paramContext.getDrawable(dfx.K);
      d = paramContext.getDrawable(dfx.I);
    }
  }
  
  public final void a(boolean paramBoolean1, float paramFloat, int paramInt, boolean paramBoolean2)
  {
    h = paramBoolean1;
    i = paramFloat;
    j = paramInt;
    k = paramBoolean2;
    setVisibility(0);
    int i2 = (int)paramFloat;
    int m;
    int n;
    if (paramFloat % 1.0F > 0.0F)
    {
      m = 1;
      n = 0;
      label44:
      if (n >= 5) {
        break label178;
      }
      if (n >= i2) {
        break label85;
      }
      f[n].setImageDrawable(b);
    }
    for (;;)
    {
      n += 1;
      break label44;
      m = 0;
      break;
      label85:
      if ((n == i2) && (m != 0))
      {
        localObject1 = f[n];
        ((ImageView)localObject1).setImageDrawable(c);
        localObject2 = Locale.getDefault();
        int i1;
        if (np.a.a((Locale)localObject2) == 1)
        {
          i1 = 1;
          label134:
          if (i1 == 0) {
            break label157;
          }
        }
        label157:
        for (paramFloat = -1.0F;; paramFloat = 1.0F)
        {
          ((ImageView)localObject1).setScaleX(paramFloat);
          break;
          i1 = 0;
          break label134;
        }
      }
      f[n].setImageDrawable(d);
    }
    label178:
    Object localObject1 = g;
    Object localObject2 = String.valueOf(NumberFormat.getNumberInstance().format(paramInt));
    ((TextView)localObject1).setText(String.valueOf(localObject2).length() + 2 + "(" + (String)localObject2 + ")");
    localObject1 = (RelativeLayout.LayoutParams)e.getLayoutParams();
    localObject2 = (RelativeLayout.LayoutParams)a.getLayoutParams();
    if (paramBoolean1)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, e.getId());
      qa.a((ViewGroup.MarginLayoutParams)localObject2, getResources().getDimensionPixelSize(dfw.j));
      if (cxd.b())
      {
        paramInt = 20;
        ((RelativeLayout.LayoutParams)localObject1).addRule(paramInt);
      }
    }
    for (;;)
    {
      a.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      e.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (!paramBoolean2)
      {
        a.setClickable(false);
        a.setBackgroundResource(0);
      }
      return;
      paramInt = 9;
      break;
      ((RelativeLayout.LayoutParams)localObject2).addRule(10);
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, a.getId());
      ((RelativeLayout.LayoutParams)localObject1).setMargins(leftMargin, getResources().getDimensionPixelSize(dfw.c), rightMargin, bottomMargin);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    e = ((LinearLayout)findViewById(dfy.C));
    f[0] = ((ImageView)e.findViewById(dfy.F));
    f[1] = ((ImageView)e.findViewById(dfy.G));
    f[2] = ((ImageView)e.findViewById(dfy.H));
    f[3] = ((ImageView)e.findViewById(dfy.I));
    f[4] = ((ImageView)e.findViewById(dfy.J));
    g = ((TextView)e.findViewById(dfy.E));
    a = ((ImageView)findViewById(dfy.aX));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ads.AppRatingAndLogoView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */