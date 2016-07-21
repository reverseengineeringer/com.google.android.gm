package com.android.mail.ui.toastbar;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import bua;
import buc;
import ctc;
import ctd;
import cte;
import cxe;

public class ActionableToastBar
  extends cte
{
  public boolean a = true;
  public ToastBarOperation b;
  private View g;
  private TextView h;
  private TextView i;
  private View j;
  private TextView k;
  private TextView l;
  private final int m;
  private final int n;
  
  public ActionableToastBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionableToastBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionableToastBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = getResources();
    m = paramContext.getDimensionPixelOffset(bua.V);
    n = paramContext.getDimensionPixelOffset(bua.U);
  }
  
  private final void a(View.OnClickListener paramOnClickListener)
  {
    if (i != null) {
      i.setOnClickListener(paramOnClickListener);
    }
    if (l != null) {
      l.setOnClickListener(paramOnClickListener);
    }
  }
  
  private final void j()
  {
    int i3 = 1;
    int i1;
    if (!TextUtils.isEmpty(i.getText()))
    {
      i1 = 1;
      if (i1 == 0) {
        break label87;
      }
      i1 = 0;
      label23:
      i2 = i3;
      if (j != null) {
        if (h.getLineCount() >= 2) {
          break label93;
        }
      }
    }
    label87:
    label93:
    for (int i2 = i3;; i2 = 0)
    {
      if (i2 == 0) {
        break label98;
      }
      h.setVisibility(0);
      i.setVisibility(i1);
      if (j != null) {
        j.setVisibility(8);
      }
      return;
      i1 = 0;
      break;
      i1 = 8;
      break label23;
    }
    label98:
    h.setVisibility(8);
    i.setVisibility(8);
    j.setVisibility(0);
    l.setVisibility(i1);
  }
  
  protected final void a()
  {
    super.a();
    j();
  }
  
  public final void a(ctd paramctd, CharSequence paramCharSequence, int paramInt, boolean paramBoolean1, boolean paramBoolean2, ToastBarOperation paramToastBarOperation)
  {
    if ((!c) && (!paramBoolean1)) {
      return;
    }
    b = paramToastBarOperation;
    a(new ctc(this, paramToastBarOperation, paramctd));
    h.setText(paramCharSequence);
    if (k != null) {
      k.setText(paramCharSequence);
    }
    cxe.a(this, paramCharSequence);
    if (paramInt == 0)
    {
      i.setText("");
      if (l != null) {
        l.setText("");
      }
    }
    for (;;)
    {
      j();
      super.b(paramBoolean2);
      return;
      i.setText(paramInt);
      if (l != null) {
        l.setText(paramInt);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(null);
    if ((!c) && (!paramBoolean2) && (b != null)) {
      b.b(getContext());
    }
    super.a(paramBoolean1);
  }
  
  protected final void b()
  {
    int i1 = 0;
    while (i1 < getChildCount() - 1)
    {
      getChildAt(i1).setVisibility(0);
      i1 += 1;
    }
  }
  
  protected final void c()
  {
    int i1 = 0;
    while (i1 < getChildCount() - 1)
    {
      getChildAt(i1).setVisibility(4);
      i1 += 1;
    }
  }
  
  protected final float d()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
    int i1 = g.getMeasuredHeight();
    return bottomMargin + i1;
  }
  
  protected final long e()
  {
    long l1 = -1L;
    if (a)
    {
      if ((b != null) && (b.d != -1L)) {
        l1 = b.d;
      }
    }
    else {
      return l1;
    }
    return 500L;
  }
  
  protected final long f()
  {
    long l1 = -1L;
    if (a)
    {
      if ((b != null) && (b.e != -1L)) {
        l1 = b.e;
      }
    }
    else {
      return l1;
    }
    return 8000L;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    g = findViewById(buc.eQ);
    h = ((TextView)g.findViewById(buc.aW));
    i = ((TextView)g.findViewById(buc.k));
    j = findViewById(buc.eR);
    if (j != null)
    {
      k = ((TextView)j.findViewById(buc.cW));
      l = ((TextView)j.findViewById(buc.cV));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((m > 0) && (n > 0))
    {
      if (getMeasuredWidth() >= m) {
        break label46;
      }
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(m, 1073741824), paramInt2);
    }
    label46:
    while (getMeasuredWidth() <= n) {
      return;
    }
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(n, 1073741824), paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.toastbar.ActionableToastBar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */