package com.android.mail.browse;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import btz;
import bua;
import bub;
import buj;
import bxp;
import bxr;
import bzy;
import cho;
import java.util.Locale;
import jr;
import mx;
import np;
import nq;

public class SubjectAndFolderView
  extends TextView
  implements cho
{
  public final String a;
  public final int b;
  public final int c;
  public final Drawable d;
  InsetDrawable e;
  InsetDrawable f;
  public final int g;
  final int h;
  final int i;
  final bzy j;
  String k;
  boolean l;
  bxr m;
  private int n;
  private mx o;
  
  public SubjectAndFolderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SubjectAndFolderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = getResources();
    a = paramAttributeSet.getString(buj.h);
    b = paramAttributeSet.getColor(btz.d);
    c = paramAttributeSet.getColor(btz.e);
    d = paramAttributeSet.getDrawable(bub.M);
    d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
    g = paramAttributeSet.getDimensionPixelOffset(bua.L);
    h = paramAttributeSet.getDimensionPixelOffset(bua.w);
    i = paramAttributeSet.getDimensionPixelOffset(bua.v);
    paramAttributeSet = Locale.getDefault();
    int i4;
    int i2;
    int i3;
    label159:
    label163:
    int i5;
    if (np.a.a(paramAttributeSet) == 1)
    {
      i4 = getResources().getDimensionPixelSize(bua.A);
      i2 = getResources().getDimensionPixelSize(bua.B);
      if (i1 == 0) {
        break label299;
      }
      i3 = 0;
      if (i1 == 0) {
        break label306;
      }
      if (i1 == 0) {
        break label312;
      }
      i5 = 0;
      label170:
      if (i1 == 0) {
        break label319;
      }
    }
    for (;;)
    {
      paramAttributeSet = jr.a(paramContext, bub.aI);
      paramContext = jr.a(paramContext, bub.aA);
      e = new InsetDrawable(paramAttributeSet, i3, 0, i4, 0);
      f = new InsetDrawable(paramContext, i5, 0, i2, 0);
      e.setBounds(0, 0, i3 + paramAttributeSet.getIntrinsicWidth() + i4, paramAttributeSet.getIntrinsicHeight());
      f.setBounds(0, 0, paramContext.getIntrinsicWidth() + i5 + i2, paramContext.getIntrinsicHeight());
      l = false;
      j = new bzy(this, getContext());
      return;
      i1 = 0;
      break;
      label299:
      i3 = i4;
      break label159;
      label306:
      i4 = 0;
      break label163;
      label312:
      i5 = i2;
      break label170;
      label319:
      i2 = 0;
    }
  }
  
  public final mx a()
  {
    bxp localbxp;
    if (o == null)
    {
      if (m == null) {
        break label38;
      }
      localbxp = m.f;
      if (localbxp != null) {
        break label43;
      }
    }
    label38:
    label43:
    for (o = mx.a();; o = v)
    {
      return o;
      localbxp = null;
      break;
    }
  }
  
  public final int b()
  {
    return n;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    n = (View.MeasureSpec.getSize(paramInt1) - getTotalPaddingLeft() - getTotalPaddingRight());
    super.onMeasure(paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.SubjectAndFolderView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */