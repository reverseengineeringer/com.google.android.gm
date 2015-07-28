package com.android.mail.browse;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.View.DragShadowBuilder;
import com.android.mail.utils.Utils;

class ConversationItemView$ShadowBuilder
  extends View.DragShadowBuilder
{
  private final Drawable mBackground;
  private final String mDragDesc;
  private int mDragDescX;
  private int mDragDescY;
  private final int mTouchX;
  private final int mTouchY;
  private final View mView;
  
  public ConversationItemView$ShadowBuilder(ConversationItemView paramConversationItemView, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramView);
    mView = paramView;
    mBackground = mView.getResources().getDrawable(2130837633);
    mDragDesc = Utils.formatPlural(mView.getContext(), 2131820545, paramInt1);
    mTouchX = paramInt2;
    mTouchY = paramInt3;
  }
  
  public void onDrawShadow(Canvas paramCanvas)
  {
    mBackground.setBounds(0, 0, mView.getWidth(), mView.getHeight());
    mBackground.draw(paramCanvas);
    ConversationItemView.access$400().setTextSize(this$0.mCoordinates.subjectFontSize);
    paramCanvas.drawText(mDragDesc, mDragDescX, mDragDescY, ConversationItemView.access$400());
  }
  
  public void onProvideShadowMetrics(Point paramPoint1, Point paramPoint2)
  {
    int i = mView.getWidth();
    int j = mView.getHeight();
    mDragDescX = this$0.mCoordinates.sendersX;
    mDragDescY = (ConversationItemView.access$100(j, this$0.mCoordinates.subjectFontSize) - this$0.mCoordinates.subjectAscent);
    paramPoint1.set(i, j);
    paramPoint2.set(mTouchX, mTouchY);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationItemView.ShadowBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */