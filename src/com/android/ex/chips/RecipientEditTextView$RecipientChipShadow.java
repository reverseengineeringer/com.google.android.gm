package com.android.ex.chips;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View.DragShadowBuilder;

final class RecipientEditTextView$RecipientChipShadow
  extends View.DragShadowBuilder
{
  private final RecipientChip mChip;
  
  public RecipientEditTextView$RecipientChipShadow(RecipientEditTextView paramRecipientEditTextView, RecipientChip paramRecipientChip)
  {
    mChip = paramRecipientChip;
  }
  
  public void onDrawShadow(Canvas paramCanvas)
  {
    mChip.getDrawable().draw(paramCanvas);
  }
  
  public void onProvideShadowMetrics(Point paramPoint1, Point paramPoint2)
  {
    Rect localRect = mChip.getDrawable().getBounds();
    paramPoint1.set(localRect.width(), localRect.height());
    paramPoint2.set(localRect.centerX(), localRect.centerY());
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.RecipientEditTextView.RecipientChipShadow
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */