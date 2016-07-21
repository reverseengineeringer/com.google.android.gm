package com.android.mail.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;

public class AutoResizeListView
  extends ListView
{
  private final Rect a = new Rect();
  private final int[] b = new int[2];
  
  public AutoResizeListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AutoResizeListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    getWindowVisibleDisplayFrame(a);
    getLocationInWindow(b);
    int j = a.bottom;
    int k = b[1];
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i == 1073741824) {}
    for (;;)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2, i));
      return;
      paramInt2 = Math.min(j - k, paramInt2);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AutoResizeListView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */