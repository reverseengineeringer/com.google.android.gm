package com.android.mail.browse;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.CharacterStyle;
import android.text.style.ReplacementSpan;

public class FolderSpan
  extends ReplacementSpan
{
  private final FolderSpanDimensions mDims;
  private final Spanned mSpanned;
  private TextPaint mWorkPaint = new TextPaint();
  
  public FolderSpan(Spanned paramSpanned, FolderSpanDimensions paramFolderSpanDimensions)
  {
    mSpanned = paramSpanned;
    mDims = paramFolderSpanDimensions;
  }
  
  private int measureWidth(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = mDims.getPadding();
    int k = mDims.getPaddingExtraWidth();
    int i = mDims.getMaxWidth();
    paramInt2 = (int)paramPaint.measureText(paramCharSequence, paramInt1, paramInt2) + (j + k) * 2;
    paramInt1 = paramInt2;
    if (paramBoolean) {
      paramInt1 = paramInt2 + mDims.getPaddingBefore();
    }
    paramInt2 = paramInt1;
    if (paramInt1 > i) {
      paramInt2 = i;
    }
    return paramInt2;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    int j = mDims.getPadding() + mDims.getPaddingExtraWidth();
    int k = mDims.getPaddingBefore();
    int m = mDims.getMaxWidth();
    mWorkPaint.set(paramPaint);
    paramPaint = (CharacterStyle[])mSpanned.getSpans(paramInt1, paramInt2, CharacterStyle.class);
    int n = paramPaint.length;
    int i = 0;
    while (i < n)
    {
      paramPaint[i].updateDrawState(mWorkPaint);
      i += 1;
    }
    i = measureWidth(mWorkPaint, paramCharSequence, paramInt1, paramInt2, false);
    float f1;
    if (mWorkPaint.bgColor != 0)
    {
      n = mWorkPaint.getColor();
      paramPaint = mWorkPaint.getStyle();
      mWorkPaint.setColor(mWorkPaint.bgColor);
      mWorkPaint.setStyle(Paint.Style.FILL);
      f1 = k;
      float f2 = paramInt3;
      float f3 = i;
      paramCanvas.drawRect(paramFloat + f1, f2, k + (f3 + paramFloat), paramInt5, mWorkPaint);
      mWorkPaint.setColor(n);
      mWorkPaint.setStyle(paramPaint);
    }
    if (i == m)
    {
      paramCharSequence = TextUtils.ellipsize(paramCharSequence.subSequence(paramInt1, paramInt2).toString(), mWorkPaint, i - j * 2, TextUtils.TruncateAt.MIDDLE);
      paramInt1 = 0;
      paramInt2 = paramCharSequence.length();
    }
    for (;;)
    {
      f1 = j;
      paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, k + (f1 + paramFloat), paramInt4, mWorkPaint);
      return;
    }
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (paramFontMetricsInt != null)
    {
      int i = mDims.getPadding();
      paramPaint.getFontMetricsInt(paramFontMetricsInt);
      ascent -= i;
      top = ascent;
      bottom += i;
      descent += i;
    }
    return measureWidth(paramPaint, paramCharSequence, paramInt1, paramInt2, true);
  }
  
  public static abstract interface FolderSpanDimensions
  {
    public abstract int getMaxWidth();
    
    public abstract int getPadding();
    
    public abstract int getPaddingBefore();
    
    public abstract int getPaddingExtraWidth();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.FolderSpan
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */