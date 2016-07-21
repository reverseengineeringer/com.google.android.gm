package com.android.setupwizardlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import cxy;

public class StatusBarBackgroundLayout
  extends FrameLayout
{
  private Drawable a;
  private Object b;
  
  public StatusBarBackgroundLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null, 0);
  }
  
  public StatusBarBackgroundLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public StatusBarBackgroundLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private final void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    boolean bool2 = true;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, cxy.aH, paramInt, 0);
    paramAttributeSet = paramContext.getDrawable(cxy.aI);
    a = paramAttributeSet;
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramAttributeSet != null) {
        break label71;
      }
      bool1 = true;
      setWillNotDraw(bool1);
      if (paramAttributeSet == null) {
        break label77;
      }
    }
    label71:
    label77:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      setFitsSystemWindows(bool1);
      invalidate();
      paramContext.recycle();
      return;
      bool1 = false;
      break;
    }
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    b = paramWindowInsets;
    return super.onApplyWindowInsets(paramWindowInsets);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((Build.VERSION.SDK_INT >= 21) && (b == null)) {
      requestApplyInsets();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((Build.VERSION.SDK_INT >= 21) && (b != null))
    {
      int i = ((WindowInsets)b).getSystemWindowInsetTop();
      if (i > 0)
      {
        a.setBounds(0, 0, getWidth(), i);
        a.draw(paramCanvas);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.setupwizardlib.view.StatusBarBackgroundLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */