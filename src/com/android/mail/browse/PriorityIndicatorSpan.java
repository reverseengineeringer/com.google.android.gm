package com.android.mail.browse;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import java.lang.ref.WeakReference;

public class PriorityIndicatorSpan
  extends ReplacementSpan
{
  private final Context mContext;
  private WeakReference<Drawable> mDrawableRef;
  private final int mPaddingH;
  private final int mPaddingV;
  private final int mResId;
  
  public PriorityIndicatorSpan(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    mContext = paramContext;
    mResId = paramInt1;
    mPaddingV = paramInt2;
    mPaddingH = paramInt3;
  }
  
  private Drawable getCachedDrawable()
  {
    Object localObject = mDrawableRef;
    Drawable localDrawable = null;
    if (localObject != null) {
      localDrawable = (Drawable)((WeakReference)localObject).get();
    }
    localObject = localDrawable;
    if (localDrawable == null)
    {
      localObject = getDrawable();
      mDrawableRef = new WeakReference(localObject);
    }
    return (Drawable)localObject;
  }
  
  private Drawable getDrawable()
  {
    Drawable localDrawable = mContext.getResources().getDrawable(mResId);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    return localDrawable;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getCachedDrawable();
    paramCanvas.save();
    paramInt1 = (paramInt3 + paramInt5 - getBoundsbottom) / 2;
    paramCanvas.translate(mPaddingH + paramFloat, paramInt1);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = getCachedDrawable().getBounds();
    if (paramFontMetricsInt != null)
    {
      paramPaint.getFontMetricsInt(paramFontMetricsInt);
      ascent -= mPaddingV;
      top = ascent;
      bottom += mPaddingV;
      descent += mPaddingV;
    }
    return right + mPaddingH * 2;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.PriorityIndicatorSpan
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */