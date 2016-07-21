package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import bt;
import bu;
import e;
import f;
import g;
import j;
import rg;
import rt;

public class Snackbar$SnackbarLayout
  extends LinearLayout
{
  public TextView a;
  public Button b;
  public bu c;
  public bt d;
  private int e;
  private int f;
  
  public Snackbar$SnackbarLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Snackbar$SnackbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, j.aE);
    e = paramAttributeSet.getDimensionPixelSize(j.aF, -1);
    f = paramAttributeSet.getDimensionPixelSize(j.aH, -1);
    if (paramAttributeSet.hasValue(j.aG)) {
      rg.f(this, paramAttributeSet.getDimensionPixelSize(j.aG, 0));
    }
    paramAttributeSet.recycle();
    setClickable(true);
    LayoutInflater.from(paramContext).inflate(g.a, this);
    rg.j(this);
    rg.c(this, 1);
  }
  
  private final boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    if (paramInt1 != getOrientation())
    {
      setOrientation(paramInt1);
      bool = true;
    }
    TextView localTextView;
    if ((a.getPaddingTop() != paramInt2) || (a.getPaddingBottom() != paramInt3))
    {
      localTextView = a;
      if (!rg.a.B(localTextView)) {
        break label83;
      }
      rg.a(localTextView, rg.k(localTextView), paramInt2, rg.l(localTextView), paramInt3);
    }
    for (;;)
    {
      bool = true;
      return bool;
      label83:
      localTextView.setPadding(localTextView.getPaddingLeft(), paramInt2, localTextView.getPaddingRight(), paramInt3);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (d != null) {
      d.a();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    a = ((TextView)findViewById(f.d));
    b = ((Button)findViewById(f.c));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (c != null) {
      c.a();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = paramInt1;
    if (e > 0)
    {
      i = paramInt1;
      if (getMeasuredWidth() > e)
      {
        i = View.MeasureSpec.makeMeasureSpec(e, 1073741824);
        super.onMeasure(i, paramInt2);
      }
    }
    int j = getResources().getDimensionPixelSize(e.f);
    int k = getResources().getDimensionPixelSize(e.e);
    if (a.getLayout().getLineCount() > 1)
    {
      paramInt1 = 1;
      if ((paramInt1 == 0) || (f <= 0) || (b.getMeasuredWidth() <= f)) {
        break label142;
      }
      if (!a(1, j, j - k)) {
        break label170;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        super.onMeasure(i, paramInt2);
      }
      return;
      paramInt1 = 0;
      break;
      label142:
      if (paramInt1 != 0) {}
      for (paramInt1 = j;; paramInt1 = k)
      {
        if (!a(0, paramInt1, paramInt1)) {
          break label170;
        }
        paramInt1 = 1;
        break;
      }
      label170:
      paramInt1 = 0;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.Snackbar.SnackbarLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */