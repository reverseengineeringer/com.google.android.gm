package com.android.mail.browse;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;

public class FolderSpanTextView
  extends TextView
  implements FolderSpan.FolderSpanDimensions
{
  private final int mFolderPadding;
  private final int mFolderPaddingBefore;
  private final int mFolderPaddingExtraWidth;
  private int mMaxSpanWidth;
  
  public FolderSpanTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FolderSpanTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    mFolderPadding = paramContext.getDimensionPixelOffset(2131427377);
    mFolderPaddingExtraWidth = paramContext.getDimensionPixelOffset(2131427378);
    mFolderPaddingBefore = paramContext.getDimensionPixelOffset(2131427379);
  }
  
  public int getMaxWidth()
  {
    return mMaxSpanWidth;
  }
  
  public int getPadding()
  {
    return mFolderPadding;
  }
  
  public int getPaddingBefore()
  {
    return mFolderPaddingBefore;
  }
  
  public int getPaddingExtraWidth()
  {
    return mFolderPaddingExtraWidth;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    mMaxSpanWidth = (View.MeasureSpec.getSize(paramInt1) - getTotalPaddingLeft() - getTotalPaddingRight());
    super.onMeasure(paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.FolderSpanTextView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */