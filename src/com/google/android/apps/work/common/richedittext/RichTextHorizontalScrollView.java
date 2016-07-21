package com.google.android.apps.work.common.richedittext;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import dcg;

public class RichTextHorizontalScrollView
  extends HorizontalScrollView
{
  private Drawable a;
  private int b;
  private int c;
  
  public RichTextHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RichTextHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RichTextHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = getScrollX();
    int i = c - j;
    if (i > 0) {
      if (i >= b) {
        break label68;
      }
    }
    for (;;)
    {
      j += paramCanvas.getWidth();
      a.setBounds(new Rect(j - i, 0, j, paramCanvas.getHeight()));
      a.draw(paramCanvas);
      return;
      label68:
      i = b;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    c = (getChildAt(0).getMeasuredWidth() - getMeasuredWidth());
    if (a == null)
    {
      a = getContext().getResources().getDrawable(dcg.c);
      b = a.getIntrinsicWidth();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.apps.work.common.richedittext.RichTextHorizontalScrollView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */